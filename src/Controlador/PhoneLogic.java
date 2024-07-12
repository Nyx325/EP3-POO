package Controlador;

import Modelo.Phone;

public class PhoneLogic extends Logic {    
    public void check(Phone p) throws Exception{ 
        boolean error = false;
        String msg = "";
        if(
            p.getTipo().equals("") ||
            p.getLada().equals("") || 
            p.getNumber().equals("") 
        ){
            throw new Exception("Se deben llenar todos los campos");
        }
        
        if(containsNumbers(p.getTipo())){
            System.out.println(p.getTipo());
            error = true;
            msg = msg + "El tipo no puede contener números\n";
        }

        if(
            !p.getLada().startsWith("+") ||
            !isJustNumers(p.getLada().replace("+", "")) ||
            p.getLada().length() > 4
        ){
            error = true;
            msg = msg + "Lada no válida\n";
        }

        if(!isJustNumers(p.getNumber())){
            error = true;
            msg = msg + "El número no puede contener caracteres";
        }
        
        if(p.getNumber().length() != 10){
            error = true;
            msg = msg + "El número debe contener 10 caracteres";
        }

        if(error){
            throw new Exception(msg);
        }
    }
}
