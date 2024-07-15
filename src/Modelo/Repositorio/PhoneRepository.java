package Modelo.Repositorio;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Modelo.Entidad.Contact;
import Modelo.Entidad.Phone;

public class PhoneRepository {
    public Connector conector;

    public PhoneRepository() {
        this.conector = new Connector();
    }

    public void add(Phone p, long contactId) throws Exception {
        conector.getConnection();
        conector.pStmt = conector.conection.prepareStatement("INSERT INTO Phone VALUES (0, ?, ?, ?, ?)");

        conector.pStmt.setString(1, p.number);
        conector.pStmt.setString(2, p.lada);
        conector.pStmt.setString(3, p.type);
        conector.pStmt.setLong(4, contactId);

        conector.pStmt.executeUpdate();
    }

    public void delete(Phone p) throws Exception {
        conector.getConnection();
        conector.pStmt = conector.conection.prepareStatement("DELETE FROM Phone WHERE id = ?");
        conector.pStmt.setLong(1, p.id);
        conector.pStmt.executeUpdate();
    }

    public Phone fromResSet(ResultSet rs) throws Exception {
        return new Phone(
                rs.getLong("id"),
                rs.getString("number"),
                rs.getString("lada"),
                rs.getString("type"),
                rs.getLong("idContact"));
    }

    public Phone searchById(long id) throws Exception {
        conector.getConnection();
        conector.pStmt = conector.conection.prepareStatement("SELECT * FROM Phone WHERE id = ?");
        conector.pStmt.setLong(1, id);
        conector.resSet = conector.pStmt.executeQuery();

        return fromResSet(conector.resSet);
    }

    /**
     * Esta funcion pretende utilizar una instancia de un teléfono existente,
     * donde se sobre escriban en la variable los datos a modificar, por ejemplo
     * que anteriormente obtuvimos un telefono y cambiemos lada y eso, pero que
     * se mantenga el mismo id, a partir de esto actualicemos todo
     */
    public void update(Phone p) throws Exception {
        conector.getConnection();
        conector.pStmt = conector.conection
                .prepareStatement("UPDATE FROM Phone SET number = ?, lada = ?, type = ? WHERE id = ?");

        conector.pStmt.setString(1, p.number);
        conector.pStmt.setString(2, p.lada);
        conector.pStmt.setString(3, p.type);
        conector.pStmt.setLong(4, p.id);

        conector.pStmt.executeUpdate();
    }

    /**
     * Obtener
     */
    public List<Phone> searchByContact(Contact c) throws Exception {
        List<Phone> pList = new ArrayList<>();

        conector.getConnection();
        conector.pStmt = conector.conection.prepareStatement("SELECT * FROM Phone WHERE idContact = ?");
        conector.pStmt.setLong(1, c.id);
        conector.resSet = conector.pStmt.executeQuery();
        /*
         * Vamos a ejecutar una query que va a retornar muchas tuplas, en
         * nuestro resultset tiene un método llamado next() retorna un
         * boleano si es verdadero, actualizará el estado de este mismo
         * result set para pasar al siguiente, por lo cual utilizaremos
         * este método para iterar el resultSet
         */
        while (conector.resSet.next()) {
            Phone p = fromResSet(conector.resSet);
            pList.add(p);
        }

        return pList;
    }
}
