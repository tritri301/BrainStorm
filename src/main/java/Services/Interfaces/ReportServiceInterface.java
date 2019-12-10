package Services.Interfaces;

import Exception.ExceptionCustom;
import Models.ItemInfo;

import java.util.List;

/**
 * The interface Report service interface.
 */
public interface ReportServiceInterface {
    /**
     * Create file.
     */
    void CreateFile();

    /**
     * Find all list.
     *
     * @return the list
     * @throws ExceptionCustom the exception custom
     */
    List<ItemInfo> FindAll() throws ExceptionCustom;
}
