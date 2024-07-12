package Controlador;

import Modelo.Contact;
import Modelo.Phone;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Agenda {
    private ArrayList<Contact> contacts;

    public Agenda() {
        this.contacts = new ArrayList<>();
        Contact c;
        ArrayList<Phone> phones;
    
        c = new Contact("Malcus Praderas", "Hombre", "21");
        phones = new ArrayList<>();
        phones.add(new Phone("7771234567", "+52", "Fijo"));
        c.setPhones(phones);
        this.contacts.add(c);
    
        c = new Contact("Omicron Ramon", "Hombre", "20");
        phones = new ArrayList<>();
        phones.add(new Phone("6669876543", "+52", "Celular"));
        phones.add(new Phone("6661234567", "+52", "Trabajo"));
        c.setPhones(phones);
        this.contacts.add(c);
    
        c = new Contact("Mazapan Toledo", "Mujer", "19");
        phones = new ArrayList<>();
        phones.add(new Phone("5552345678", "+52", "Trabajo"));
        c.setPhones(phones);
        this.contacts.add(c);
    
        c = new Contact("Luna Martinez", "Mujer", "22");
        phones = new ArrayList<>();
        phones.add(new Phone("4448765432", "+52", "Celular"));
        c.setPhones(phones);
        this.contacts.add(c);
    
        c = new Contact("Jairo Nuñez", "Hombre", "23");
        phones = new ArrayList<>();
        phones.add(new Phone("3337654321", "+52", "Casa"));
        phones.add(new Phone("3331234567", "+52", "Celular"));
        phones.add(new Phone("3339876543", "+52", "Trabajo"));
        c.setPhones(phones);
        this.contacts.add(c);
    
        c = new Contact("Camila Ortiz", "Mujer", "24");
        phones = new ArrayList<>();
        phones.add(new Phone("2226543210", "+52", "Celular"));
        c.setPhones(phones);
        this.contacts.add(c);
    
        c = new Contact("Dario Gomez", "Hombre", "25");
        phones = new ArrayList<>();
        phones.add(new Phone("1112345678", "+52", "Casa"));
        phones.add(new Phone("1118765432", "+52", "Celular"));
        c.setPhones(phones);
        this.contacts.add(c);
    
        c = new Contact("Nina Rosales", "Mujer", "20");
        phones = new ArrayList<>();
        phones.add(new Phone("9999876543", "+52", "Celular"));
        c.setPhones(phones);
        this.contacts.add(c);
    
        c = new Contact("Ignacio Flores", "Hombre", "21");
        phones = new ArrayList<>();
        phones.add(new Phone("8882345678", "+52", "Casa"));
        c.setPhones(phones);
        this.contacts.add(c);
    
        c = new Contact("Emilia Vega", "Mujer", "22");
        phones = new ArrayList<>();
        phones.add(new Phone("7778765432", "+52", "Celular"));
        phones.add(new Phone("7776543210", "+52", "Trabajo"));
        c.setPhones(phones);
        this.contacts.add(c);
    
        c = new Contact("Oscar Salinas", "Hombre", "23");
        phones = new ArrayList<>();
        phones.add(new Phone("6667654321", "+52", "Casa"));
        c.setPhones(phones);
        this.contacts.add(c);
    
        c = new Contact("Valeria Campos", "Mujer", "24");
        phones = new ArrayList<>();
        phones.add(new Phone("5553456789", "+52", "Celular"));
        c.setPhones(phones);
        this.contacts.add(c);
    
        c = new Contact("Pablo Santos", "Hombre", "25");
        phones = new ArrayList<>();
        phones.add(new Phone("4444567890", "+52", "Casa"));
        phones.add(new Phone("4442345678", "+52", "Celular"));
        c.setPhones(phones);
        this.contacts.add(c);
    
        c = new Contact("Lucia Marquez", "Mujer", "19");
        phones = new ArrayList<>();
        phones.add(new Phone("3335678901", "+52", "Celular"));
        c.setPhones(phones);
        this.contacts.add(c);
    }

    public void insert(Contact c) {
        this.contacts.add(c);
    }

    public void kill(Contact c) {
        this.contacts.remove(c);
    }

    public void modify(Contact org, Contact modf) {

    }

    public ArrayList<Contact> getContacts() {
        return this.contacts;
    }

    public Contact get(int index){
        return this.contacts.get(index);
    }
    
    public ArrayList<Contact> searchName(String nombre){
        ArrayList<Contact> res = new ArrayList<>();
        
        for(Contact c : this.contacts){
            if(c.getName().toUpperCase().contains(nombre.toUpperCase()))
                res.add(c);
        }
        
        return res;
    }
    
    public ArrayList<Contact> searchSex(String sexo){
        ArrayList<Contact> res = new ArrayList<>();
        
        for(Contact c : this.contacts){
            if(c.getSex().toUpperCase().contains(sexo.toUpperCase()))
                res.add(c);
        }
        
        return res;
    }
    
    public ArrayList<Contact> searchAge(String age){
        ArrayList<Contact> res = new ArrayList<>();
        
        for(Contact c : this.contacts){
            if(c.getAge().contains(age))
                res.add(c);
        }
        
        return res;
    }
    
    public void sortContacts() {
        Collections.sort(this.contacts, new Comparator<Contact>() {
            public int compare(Contact c1, Contact c2) {
                return c1.getName().compareToIgnoreCase(c2.getName());
            }
        });
    }
}
