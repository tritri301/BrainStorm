package Models;

/**
 * The type User.
 */
public class User {
    private int idUser;
    private String email;
    private String password;
    private String poste;
    private String lastName;
    private String firstName;
    private String adresse;
    private int idRole;

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
     * Gets email.
     *
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets email.
     *
     * @param email the email
     */
    public void setEmail(String email) {
        this.email = email;
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
     * Gets poste.
     *
     * @return the poste
     */
    public String getPoste() {
        return poste;
    }

    /**
     * Sets poste.
     *
     * @param poste the poste
     */
    public void setPoste(String poste) {
        this.poste = poste;
    }

    /**
     * Gets last name.
     *
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets last name.
     *
     * @param lastName the last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets first name.
     *
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets first name.
     *
     * @param firstName the first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets adresse.
     *
     * @return the adresse
     */
    public String getAdresse() {
        return adresse;
    }

    /**
     * Sets adresse.
     *
     * @param adresse the adresse
     */
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    /**
     * Gets id role.
     *
     * @return the id role
     */
    public int getIdRole() {
        return idRole;
    }

    /**
     * Sets id role.
     *
     * @param idRole the id role
     */
    public void setIdRole(int idRole) {
        this.idRole = idRole;
    }
}