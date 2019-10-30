package Services.Interfaces;

import Models.Container;
import Exception.*;
import java.util.List;

/**
 * The interface Container service interface.
 */
public interface ContainerServiceInterface {

    /**
     * Find by id container.
     *
     * @param id the id
     * @return the container
     */
    public Container FindById(String emplacement) throws ExceptionCustom;

    /**
     * Find all list.
     *
     * @return the list
     */
    List<Container> FindAll() throws ExceptionCustom;

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
    boolean Update(String emplacement, int volume,int volumeMax,int poids, int poidsMax, String emplacementParent) throws ExceptionCustom;

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
    boolean Create(String emplacement, int volume,int volumeMax,int poids, int poidsMax, String emplacementParent) throws ExceptionCustom;

    /**
     * Delete container.
     *
     * @param id the id
     * @return the container
     */
    boolean Delete(int id) throws ExceptionCustom;
}
