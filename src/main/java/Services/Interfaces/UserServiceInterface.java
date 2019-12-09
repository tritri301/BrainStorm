package Services.Interfaces;

import Exception.ExceptionCustom;
import Models.User;

import java.util.List;

/**
 * The interface User service interface.
 */
public interface UserServiceInterface {
    /**
     * Find by id user.
     *
     * @param id the id
     * @return the user
     * @throws ExceptionCustom the exception custom
     */
    User FindById(int id) throws ExceptionCustom;

    /**
     * Find all list.
     *
     * @return the list
     * @throws ExceptionCustom the exception custom
     */
    List<User> FindAll() throws ExceptionCustom;

    /**
     * Find by name user.
     *
     * @param email the email
     * @return the user
     * @throws ExceptionCustom the exception custom
     */
    List<User> FindByEmail(String email) throws ExceptionCustom;

    /**
     * Update user.
     *
     * @param userToUpdate the user to update
     * @return the user
     * @throws ExceptionCustom the exception custom
     */
    boolean Update(User userToUpdate) throws ExceptionCustom;

    /**
     * Create user.
     *
     * @param idUser    the id user
     * @param email     the email
     * @param password  the password
     * @param poste     the poste
     * @param lastName  the last name
     * @param firstName the first name
     * @param adresse   the adresse
     * @param idRole    the id role
     * @return the user
     * @throws ExceptionCustom the exception custom
     */
    boolean Create(int idUser, String email, String password, String poste, String lastName, String firstName, String adresse, int idRole) throws ExceptionCustom;

    /**
     * Delete user.
     *
     * @param id the id
     * @return the user
     * @throws ExceptionCustom the exception custom
     */
    boolean Delete(int id) throws ExceptionCustom;
}
