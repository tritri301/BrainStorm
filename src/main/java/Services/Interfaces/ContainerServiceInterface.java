package Services.Interfaces;

import Exception.ExceptionCustom;
import Models.Container;

import java.util.List;

/**
 * The interface Container service interface.
 */
public interface ContainerServiceInterface {

    /**
     * Find by id container.
     *
     * @param emplacement the emplacement
     * @return the container
     * @throws ExceptionCustom the exception custom
     */
    Container FindById(String emplacement) throws ExceptionCustom;

    /**
     * Find all list.
     *
     * @return the list
     * @throws ExceptionCustom the exception custom
     */
    List<Container> FindAll() throws ExceptionCustom;

    //List<Container> FindByName(String name);

    /**
     * Update boolean.
     *
     * @param emplacement       the emplacement
     * @param volume            the volume
     * @param volumeMax         the volume max
     * @param poids             the poids
     * @param poidsMax          the poids max
     * @param emplacementParent the emplacement parent
     * @return the boolean
     * @throws ExceptionCustom the exception custom
     */
    boolean Update(String emplacement, int volume, int volumeMax, int poids, int poidsMax, String emplacementParent) throws ExceptionCustom;


    /**
     * Create boolean.
     *
     * @param emplacement       the emplacement
     * @param volume            the volume
     * @param volumeMax         the volume max
     * @param poids             the poids
     * @param poidsMax          the poids max
     * @param emplacementParent the emplacement parent
     * @return the boolean
     * @throws ExceptionCustom the exception custom
     */
    boolean Create(String emplacement, int volume, int volumeMax, int poids, int poidsMax, String emplacementParent) throws ExceptionCustom;


    /**
     * Delete boolean.
     *
     * @param emplacement the emplacement
     * @return the boolean
     * @throws ExceptionCustom the exception custom
     */
    boolean Delete(String emplacement) throws ExceptionCustom;
}
