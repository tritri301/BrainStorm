package Controllers.Interface;

import Models.Container;

import java.util.List;

public interface ContainerControllerInterface {

    /**
     * Find by id container.
     *
     * @param id the id
     * @return the container
     */
    public Container FindById(String id);

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
    boolean Update(String emplacement, int volume, int volumeMax, int poids, int poidsMax, String emplacementParent);

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
    boolean Create(String emplacement, int volume, int volumeMax, int poids, int poidsMax, String emplacementParent);

    /**
     * Delete container.
     *
     * @param id the id
     * @return the container
     */
    boolean Delete(String id);
}
