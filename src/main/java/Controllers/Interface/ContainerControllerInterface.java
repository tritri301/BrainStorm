package Controllers.Interface;

import Models.Container;

import java.util.List;

/**
 * The interface Container controller interface.
 */
public interface ContainerControllerInterface {

    /**
     * Find by id container.
     *
     * @param id the id
     * @return the container
     */
    public Container FindById(int id);

    /**
     * Find all list.
     *
     * @return the list
     */
    List<Container> FindAll();

    /**
     * Find by name container.
     *
     * @param name the name
     * @return the container
     */
    //List<Container> FindByName(String name);

    /**
     * Update container.
     *
     * @param idContainer     the id container
     * @param quantite        the quantite
     * @param position        the position
     * @param volume          the volume
     * @param poidsMax        the poids max
     * @param containerParent the container parent
     * @return the container
     */
    boolean Update(int idContainer, int quantite, int position, int volume, int poidsMax, int containerParent);

    /**
     * Create container.
     *
     * @param idContainer     the id container
     * @param quantite        the quantite
     * @param position        the position
     * @param volume          the volume
     * @param poidsMax        the poids max
     * @param containerParent the container parent
     * @return the container
     */
    boolean Create(int idContainer, int quantite, int position, int volume, int poidsMax, int containerParent);

    /**
     * Delete container.
     *
     * @param id the id
     * @return the container
     */
    boolean Delete(int id);







}
