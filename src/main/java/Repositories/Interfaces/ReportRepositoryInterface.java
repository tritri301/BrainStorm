package Repositories.Interfaces;

import Models.ItemInfo;

import java.util.List;

/**
 * The interface Report repository interface.
 */
public interface ReportRepositoryInterface {
    /**
     * Find all list.
     *
     * @return the list
     * @throws Exception the exception
     */
    List<ItemInfo> FindAll() throws Exception;
}
