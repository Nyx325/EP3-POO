package Controlador;

import java.util.List;

import java.sql.ResultSet;

import Modelo.Entidad.Contact;
import Modelo.Entidad.Phone;
import Modelo.Repositorio.PhoneRepository;

public class PhoneController extends Controller {
    PhoneRepository repo;
    
    public PhoneController(){
        this.repo = new PhoneRepository();
    }

    public Phone searchById(long id) throws Exception {
        return repo.searchById(id);
    }

    public List<Phone> searchByContact(Contact c) throws Exception {
        return repo.searchByContact(c);
    }

    public void validPhone(Phone p) throws Exception {
        String msg = "";
        if(
            p.type.equals("") ||
            p.lada.equals("") || 
            p.number.equals("") 
        ){
            throw new Exception("Se deben llenar todos los campos");
        }

        if(containsNumbers(p.type)){
            System.out.println(p.type);
            msg = msg + "El tipo no puede contener números\n";
        }

        if(
            !p.lada.startsWith("+") ||
            !isJustNumers(p.lada.replace("+", "")) ||
            p.lada.length() > 5
        ){
            msg = msg + "Lada no válida\n";
        }

        if(msg.length() != 0){
            throw new Exception(msg);
        }
    }

    public void add(Phone p, long contactId) throws Exception {
        validPhone(p);
        repo.add(p, contactId);
    }

    public void delete(Phone p) throws Exception{
        repo.delete(p);
    }

    public void update(Phone p) throws Exception {
        validPhone(p);
        repo.update(p);
    }

    public ResultSet phonesByCategory() throws Exception {
        return repo.phonesByCategory();
    }
}
