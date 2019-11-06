package Controllers;

import Controllers.Interface.ReportControllerInterface;
import Exception.*;

//Les controller sert à appeler mes services

public class ReportController implements ReportControllerInterface{

    private static final ReportController instance = new ReportController();

    public static ReportController GetInstance()
    {
        return instance;
    }
}
