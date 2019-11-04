package Services.Interfaces;

import Models.Container;
import Exception.*;
import java.util.List;

/**
 * The interface Container service interface.
 */
public interface ContainerServiceInterface {


    Container FindById(String emplacement) throws ExceptionCustom;

    /**
     * Find all list.
     *
     * @return the list
     */
    List<Container> FindAll() throws ExceptionCustom;

    //List<Container> FindByName(String name);


    boolean Update(String emplacement, int volume,int volumeMax,int poids, int poidsMax, String emplacementParent) throws ExceptionCustom;


    boolean Create(String emplacement, int volume,int volumeMax,int poids, int poidsMax, String emplacementParent) throws ExceptionCustom;


    boolean Delete(String emplacement) throws ExceptionCustom;
}
