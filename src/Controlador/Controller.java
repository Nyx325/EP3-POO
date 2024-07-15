package Controlador;

public abstract class Controller {
    protected boolean isJustNumers(String str){
        for(char c : str.toCharArray()){
            if(!Character.isDigit(c))
                return false;
        }
        
        return true;
    }

    protected boolean containsNumbers(String str){
        for(char c : str.toCharArray()){
            if(Character.isDigit(c)){
                return true;
            }
        }
        
        return false;
    }

}
