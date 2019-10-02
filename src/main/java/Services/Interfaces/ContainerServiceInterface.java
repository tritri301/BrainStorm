package Services.Interfaces;

import Models.Container;

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
    public Container FindById(int id);

    public List<Container> FindAll();

    /**
     * Find by name container.
     *
     * @param name the name
     * @return the container
     */
    public List<Container> FindByName(String name);

    /**
     * Update container.
     *
     * @return the container
     */
    public boolean Update(int idContainer, int quantite, int position, int volume, int poidsMax, int containerParent);

    /**
     * Create container.
     *
     * @return the container
     */
    public boolean Create(int idContainer, int quantite, int position, int volume, int poidsMax, int containerParent);

    /**
     * Delete container.
     *
     * @param id the id
     * @return the container
     */
    public boolean Delete(int id);
}
