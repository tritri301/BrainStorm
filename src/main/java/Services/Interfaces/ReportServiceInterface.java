package Services.Interfaces;

import Exception.*;
import Models.ItemInfo;

import java.util.List;

public interface ReportServiceInterface {
    public void CreateFile();
    public List<ItemInfo> FindAll() throws ExceptionCustom;
}
