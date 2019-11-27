package Controllers;

import Controllers.Interface.ReportControllerInterface;
import Exception.ExceptionCustom;
import Models.ItemInfo;
import Services.ItemInfoService;
import Services.ReportService;
import View.Browser;

import java.util.List;

//Les controller sert à appeler mes services

public class ReportController implements ReportControllerInterface{

    private static final ReportController instance = new ReportController();
    private ReportService reportService = ReportService.GetInstance();
    private ItemInfoService itemInfoService = ItemInfoService.GetInstance();
    Browser browser = Browser.GetInstance();

    public List<ItemInfo> FindAll() {
        List<ItemInfo> itemInfoList = null;
        try {
            itemInfoList = itemInfoService.FindAll();
        } catch (ExceptionCustom e) {
            //Alert ;
        }
        catch(Exception e) {

        }
        return itemInfoList;
    }

    public static ReportController GetInstance()
    {
        return instance;
    }
}
