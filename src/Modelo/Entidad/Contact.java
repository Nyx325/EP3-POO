package Modelo.Entidad;

import java.util.ArrayList;
import java.util.List;

public class Contact {
    public long id;
    public String name;
    public String sex;
    public String age;
    public List<Phone> phones;

    public Contact() {
    }

    public Contact(String name, String sex, String age) {
        this.id = -1;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.phones = new ArrayList<>();
    }

    public Contact(long id, String name, String sex, String age) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.phones = new ArrayList<>();
    }

    public Contact(long id, String name, String sex, String age, List<Phone> phones) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.phones = phones;
    }

    public String toString(){
        return "{id:" + id + ",name:" + name + ",sex:" + sex + ",age:" + age + "}";
    }
}
