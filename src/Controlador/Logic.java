package Controlador;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author rubenor
 */
public abstract class Logic {
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
