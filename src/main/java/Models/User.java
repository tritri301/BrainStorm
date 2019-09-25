package Models;

public class User
{
    private short idUser;
    private String nom;
    private String password;
    private String dateCreation;
    private short acces;

    public short getIdUser() {
        return idUser;
    }

    public void setIdUser(short idUser) {
        this.idUser = idUser;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(String dateCreation) {
        this.dateCreation = dateCreation;
    }

    public short getAcces() {
        return acces;
    }

    public void setAcces(short acces) {
        this.acces = acces;
    }
}
