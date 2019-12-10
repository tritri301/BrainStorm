package Repositories.Interfaces;

import Models.ItemInfo;

import java.util.List;

/**
 * The interface Item info repository interface.
 */
public interface ItemInfoRepositoryInterface {
    /**
     * Find by id item info.
     *
     * @param id the id
     * @return the item info
     * @throws Exception the exception
     */
    ItemInfo FindById(int id) throws Exception;

    /**
     * Find by name list.
     *
     * @param name the name
     * @return the list
     * @throws Exception the exception
     */
    List<ItemInfo> FindByName(String name) throws Exception;

    /**
     * Find all list.
     *
     * @return the list
     * @throws Exception the exception
     */
    List<ItemInfo> FindAll() throws Exception;

    /**
     * Sort by name list.
     *
     * @return the list
     * @throws Exception the exception
     */
    List<ItemInfo> SortByName() throws Exception;

    /**
     * Update.
     *
     * @param itemInfoToUpdate the item info to update
     * @throws Exception the exception
     */
    void Update(ItemInfo itemInfoToUpdate) throws Exception;

    /**
     * Delete.
     *
     * @param id the id
     * @throws Exception the exception
     */
    void Delete(int id) throws Exception;

    /**
     * Create.
     *
     * @param itemInfoToAdd the item info to add
     * @throws Exception the exception
     */
    void Create(ItemInfo itemInfoToAdd) throws Exception;
}
