package Controlador;

import Modelo.Contact;

public class ContactLogic extends Logic{
    public void check(Contact c) throws Exception{
        boolean error = false;
        String msg = "";
        
        if(
            c.getName().equals("") ||
            c.getAge().equals("") ||
            c.getSex().equals("")
          ){
            throw new Exception("Se deben llenar todos los campos");
        }
        
        if(!isJustNumers(c.getAge())){
            error = true;
            msg = msg + "La edad deben ser números\n";
        }
        
        if(this.containsNumbers(c.getSex())){
            error = true;
            msg = msg + "El sexo no puede contener numeros\n";
        }
        
        if(error){
            throw new Exception(msg);
        }
           
    }
}
