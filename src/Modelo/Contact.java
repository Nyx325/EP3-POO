/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author rubenor
 */
public class Contact {
    String name;
    String sex;
    String age;
    ArrayList<Phone> phones;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAge() {
       return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public ArrayList<Phone> getPhones() {
        return phones;
    }

    public void setPhones(ArrayList<Phone> phones) {
        this.phones = phones;
    }

    public Contact(String name, String sex, String age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.phones = new ArrayList<>();
    }

    public Contact() {
        this.name = null;
        this.sex = null;
        this.age = null;
        this.phones = new ArrayList<>();
    }

    
}
