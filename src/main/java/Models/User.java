package Models;

/**
 * The type User.
 */
public class User {
    private int idUser;
    private String nom;
    private String password;
    private String dateCreation;
    private int acces;

    /**
     * Gets id user.
     *
     * @return the id user
     */
    public int getIdUser() {
        return idUser;
    }

    /**
     * Sets id user.
     *
     * @param idUser the id user
     */
    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    /**
     * Gets nom.
     *
     * @return the nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * Sets nom.
     *
     * @param nom the nom
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Gets password.
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets password.
     *
     * @param password the password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets date creation.
     *
     * @return the date creation
     */
    public String getDateCreation() {
        return dateCreation;
    }

    /**
     * Sets date creation.
     *
     * @param dateCreation the date creation
     */
    public void setDateCreation(String dateCreation) {
        this.dateCreation = dateCreation;
    }

    /**
     * Gets acces.
     *
     * @return the acces
     */
    public int getAcces() {
        return acces;
    }

    /**
     * Sets acces.
     *
     * @param acces the acces
     */
    public void setAcces(int acces) {
        this.acces = acces;
    }
}