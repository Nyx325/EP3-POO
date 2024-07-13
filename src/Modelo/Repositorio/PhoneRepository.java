package Modelo.Repositorio;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Modelo.Entidad.Contact;
import Modelo.Entidad.Phone;

public class PhoneRepository {
    public Connector conector;

    public PhoneRepository(){
        this.conector = new Connector();
    }

    public void add(Phone p) throws Exception {
        conector.getConnection();
        conector.pStmt = conector.conection.prepareStatement("INSERT INTO Phone VALUES (0, ?, ?, ?)");

        conector.pStmt.setString(1, p.number);
        conector.pStmt.setString(2, p.lada);
        conector.pStmt.setString(3, p.type);
        
        conector.pStmt.executeQuery();
    }

    public void delete(Phone p) throws Exception {
        conector.getConnection();
        conector.pStmt = conector.conection.prepareStatement("DELETE FROM Phone WHERE id = ?");
        conector.pStmt.setLong(1, p.id);
        conector.pStmt.executeQuery();
    }

    public Phone fromResSet(ResultSet rs) throws Exception {
        return new Phone(
            rs.getLong("id"),
            rs.getString("number"),
            rs.getString("lada"),
            rs.getString("type"),
            rs.getLong("idContact")
        );
    }

    public Phone searchById(long id) throws Exception {
        conector.getConnection();
        conector.pStmt = conector.conection.prepareStatement("DELETE FROM Phone WHERE id = ?");
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
        Phone org = searchById(p.id); // optener el valor original

        conector.getConnection();
        conector.pStmt = conector.conection.prepareStatement("UPDATE FROM Phone SET number = ?, SET lada = ?, SET type = ? WHERE id = ?");

        /*
         * Actualizaremos todos los campos del registro así solo cambie 1, ineficiente 
         * en cuanto a BD? Sí pero así no necesitamos cambiar la query dependiendo de 
         * cuantos cambien o no, estableceremos un ternario donde se condicione lo
         * siguiente, si el campo del nuevo (p) es diferente al original (org) sustituremos
         * el atributo nuevo en la query, de lo contrario dejamos el valor que se tiene
         * originalmente
         */
        conector.pStmt.setString(1, !org.number.equals(p.number) ? p.number : org.number);
        conector.pStmt.setString(2, !org.lada.equals(p.lada) ? p.lada : org.lada);
        conector.pStmt.setString(3, !org.type.equals(p.type) ? p.type : org.type);
        
        conector.pStmt.executeQuery();
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
        while(conector.resSet.next()){
            Phone p = fromResSet(conector.resSet);
            pList.add(p);
        }

        return pList;
    }
}
