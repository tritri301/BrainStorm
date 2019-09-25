package Factory;

public class UserFactory {

    Short idUser;
    String nom;
    String password;
    String dateCreation;
    Short acces;

    public UserFactory(Short idUser, String nom, String password, String dateCreation, Short acces) {
        this.idUser = idUser;
        this.nom = nom;
        this.password = password;
        this.dateCreation = dateCreation;
        this.acces = acces;
    }

    public void setIdUser(Short idUser) {
        this.idUser = idUser;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setDateCreation(String dateCreation) {
        this.dateCreation = dateCreation;
    }

    public void setAcces(Short acces) {
        this.acces = acces;
    }

    public Short getIdUser() {
        return idUser;
    }

    public String getNom() {
        return nom;
    }

    public String getPassword() {
        return password;
    }

    public String getDateCreation() {
        return dateCreation;
    }

    public Short getAcces() {
        return acces;
    }
}
