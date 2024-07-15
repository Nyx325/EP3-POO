package Controlador;

import java.util.List;

import Modelo.Entidad.Contact;
import Modelo.Repositorio.ContactRepository;

public class ContactController extends Controller {
    ContactRepository repo;

    public ContactController(){
        repo = new ContactRepository();
    }

    public void validContact(Contact c) throws Exception {
        String msg = "";
        
        if(
            c.name.equals("") ||
            c.age.equals("") ||
            c.sex.equals("")
          ){
            throw new Exception("Se deben llenar todos los campos");
        }
        
        if(!isJustNumers(c.age)){
            msg = msg + "La edad deben ser números\n";
        }
        
        if(this.containsNumbers(c.sex)){
            msg = msg + "El sexo no puede contener numeros\n";
        }
        
        if(msg.length() != 0){
            throw new Exception(msg);
        }
    }

    public void add(Contact c) throws Exception {
        validContact(c);
        repo.add(c);
    }

    public void delete(Contact c) throws Exception {
        repo.delete(c);
    }
    
    public void update(Contact c) throws Exception {
        validContact(c);
        repo.update(c);
    }

    public List<Contact> searchBy(String parameter, String value) throws Exception{
        return repo.searchBy(parameter, value);
    }

    public List<Contact> getAllContacts() throws Exception {
        return repo.getAllContacts();
    }
}
