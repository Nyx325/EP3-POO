package Modelo.Entidad;

public class Phone {
    public long id;
    public String number;
    public String lada;
    public String type;
    public long idContact;

    public Phone(){}

    public Phone(long id, String number, String lada, String type, long idContact) {
        this.id = id;
        this.number = number;
        this.lada = lada;
        this.type = type;
        this.idContact = idContact;
    }
}
