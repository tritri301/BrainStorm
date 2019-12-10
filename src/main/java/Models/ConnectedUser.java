package Models;

import sun.security.jca.GetInstance;

public class ConnectedUser {
    private static final ConnectedUser instance = new ConnectedUser();

    private int idUser;
    private String email;
    private String password;
    private String poste;
    private String lastName;
    private String firstName;
    private String adresse;
    private String lastConnected;
    private String lastPassChange;
    private int unsuccessfullConnection;
    private int idRole;

    public String getLastConnected() {
        return lastConnected;
    }

    public void setLastConnected(String lastConnected) {
        this.lastConnected = lastConnected;
    }

    public String getLastPassChange() {
        return lastPassChange;
    }

    public void setLastPassChange(String lastPassChange) {
        this.lastPassChange = lastPassChange;
    }

    public int getUnsuccessfullConnection() {
        return unsuccessfullConnection;
    }

    public void setUnsuccessfullConnection(int unsuccessfullConnection) {
        this.unsuccessfullConnection = unsuccessfullConnection;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPoste() {
        return poste;
    }

    public void setPoste(String poste) {
        this.poste = poste;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public int getIdRole() {
        return idRole;
    }

    public void setIdRole(int idRole) {
        this.idRole = idRole;
    }

    public static ConnectedUser GetInstance(){return instance;}
}
