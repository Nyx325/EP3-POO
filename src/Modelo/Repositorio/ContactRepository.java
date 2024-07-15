package Modelo.Repositorio;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Modelo.Entidad.Contact;
import Modelo.Entidad.Phone;

public class ContactRepository {
    public Connector conector;
    public PhoneRepository pRep;

    public ContactRepository() {
        this.conector = new Connector();
        this.pRep = new PhoneRepository();
    }

    public void add(Contact c) throws Exception {
        conector.getConnection();
        conector.pStmt = conector.conection.prepareStatement("INSERT INTO Contact VALUES (0, ?, ?, ?)");

        conector.pStmt.setString(1, c.name);
        conector.pStmt.setString(2, c.sex);
        conector.pStmt.setString(3, c.age);

        conector.pStmt.executeUpdate();
    }

    public void delete(Contact c) throws Exception {
        conector.getConnection();
        conector.pStmt = conector.conection.prepareStatement("DELETE FROM Contact WHERE id = ?");
        conector.pStmt.setLong(1, c.id);
        conector.pStmt.executeUpdate();

        // Eliminar los telefonos de este contacto
        for (Phone p : c.phones) {
            pRep.delete(p);
        }
    }

    public Contact fromResSet(ResultSet rs) throws Exception {
        Contact c = new Contact(
                rs.getLong("id"),
                rs.getString("name"),
                rs.getString("sex"),
                rs.getString("age"));

        c.phones = pRep.searchByContact(c);

        return c;
    }

    public Contact seachById(long id) throws Exception {
        conector.getConnection();
        conector.pStmt = conector.conection.prepareStatement("SELECT * FROM Contact WHERE id = ?");
        conector.pStmt.setLong(1, id);
        conector.resSet = conector.pStmt.executeQuery();

        return fromResSet(conector.resSet);
    }

    public void update(Contact c) throws Exception {
        conector.getConnection();
        conector.pStmt = conector.conection
                .prepareStatement("UPDATE Contact SET name = ?, sex = ?, age = ? WHERE id = ?");

        conector.pStmt.setString(1, c.name);
        conector.pStmt.setString(2, c.sex);
        conector.pStmt.setString(3, c.age);
        conector.pStmt.setLong(4, c.id);

        conector.pStmt.executeUpdate();
    }

    public List<Contact> searchBy(String option, String value) throws Exception {
        conector.getConnection();
        conector.pStmt = conector.conection.prepareStatement("SELECT * FROM Contact WHERE " + option + " LIKE ? ORDER BY name");
        conector.pStmt.setString(1, value+"%");
        conector.resSet = conector.pStmt.executeQuery();

        List<Contact> cList = new ArrayList<>();
        while (conector.resSet.next()) {
            Contact c = fromResSet(conector.resSet);
            System.out.println("Creando contacto: "+c);
            cList.add(c);
        }
        return cList;
    }

    public List<Contact> getAllContacts() throws Exception {
        conector.getConnection();
        conector.pStmt = conector.conection.prepareStatement("SELECT * FROM Contact ORDER BY name");
        conector.resSet = conector.pStmt.executeQuery();

        List<Contact> cList = new ArrayList<>();
        while (conector.resSet.next()) {
            Contact c = fromResSet(conector.resSet);
            cList.add(c);
        }
        return cList;
    }
}
