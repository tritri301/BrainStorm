package Controllers;

import Controllers.Interface.ReportControllerInterface;
import Exception.ExceptionCustom;
import Models.ItemInfo;
import Services.ItemInfoService;
import Services.ReportService;
import View.Browser;

import java.util.List;

//Les controller sert à appeler mes services

/**
 * @Note
 */
public class ReportController implements ReportControllerInterface{

    private static final ReportController instance = new ReportController();
    private ReportService reportService = ReportService.GetInstance();
    private ItemInfoService itemInfoService = ItemInfoService.GetInstance();
    /**
     * The Browser.
     */
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

    /**
     * Get instance report controller.
     *
     * @return the report controller
     */
    public static ReportController GetInstance()
    {
        return instance;
    }
}
