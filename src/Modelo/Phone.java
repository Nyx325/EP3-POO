/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author rubenor
 */
public class Phone {
    String number;
    String lada;
    String tipo;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getLada() {
        return lada;
    }

    public void setLada(String lada) {
        this.lada = lada;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Phone(String number, String lada, String tipo) {
        this.number = number;
        this.lada = lada;
        this.tipo = tipo;
    }

    public Phone() {
    }
    
    public boolean equals(Phone p){
        return this.lada.equals(p.lada) && this.tipo.equals(p.tipo) && this.number.equals(p.number);
    }   
}
