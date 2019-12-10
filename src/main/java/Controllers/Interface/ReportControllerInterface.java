package Controllers.Interface;

import Models.ItemInfo;

import java.util.List;

/**
 * The interface Report controller interface.
 */
public interface ReportControllerInterface {
    /**
     * Find all list.
     *
     * @return the list
     */
    public List<ItemInfo> FindAll();
}
