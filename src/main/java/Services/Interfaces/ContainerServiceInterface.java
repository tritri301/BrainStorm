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
    public Container FindByName(String name);

    /**
     * Update container.
     *
     * @param id the id
     * @return the container
     */
    public Container Update(int id);

    /**
     * Create container.
     *
     * @return the container
     */
    public Container Create();

    /**
     * Delete container.
     *
     * @param id the id
     * @return the container
     */
    public Container Delete(int id);
}
