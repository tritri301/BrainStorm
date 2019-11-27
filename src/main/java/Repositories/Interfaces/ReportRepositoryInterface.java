package Repositories.Interfaces;
import Models.ItemInfo;

import java.util.List;

public interface ReportRepositoryInterface {
    List<ItemInfo> FindAll() throws Exception;
}
