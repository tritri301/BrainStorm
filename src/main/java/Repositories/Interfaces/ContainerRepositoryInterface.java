package Repositories.Interfaces;

import Models.Container;

import java.util.List;

/**
 * The interface Container repository interface.
 */
public interface ContainerRepositoryInterface {
    /**
     * Find by id container.
     *
     * @param emplacement the emplacement
     * @return the container
     * @throws Exception the exception
     */
    Container FindById(String emplacement) throws Exception;

    /**
     * Find all list.
     *
     * @return the list
     * @throws Exception the exception
     */
    List<Container> FindAll() throws Exception;

    /**
     * Update.
     *
     * @param containerToAdd the container to add
     * @throws Exception the exception
     */
    void Update(Container containerToAdd) throws Exception;

    /**
     * Delete.
     *
     * @param emplacement the emplacement
     * @throws Exception the exception
     */
    void Delete(String emplacement) throws Exception;

    /**
     * Create.
     *
     * @param containerToAdd the container to add
     * @throws Exception the exception
     */
    void Create(Container containerToAdd) throws Exception;
}
