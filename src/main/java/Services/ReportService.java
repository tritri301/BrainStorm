package Services;

import Factory.ItemInfoFactory;
import Models.ConnectionBD;
import Models.ItemInfo;
import Repositories.ItemInfoRepository;
import Repositories.ReportRepository;
import Services.Interfaces.ReportServiceInterface;
import Exception.*;

import java.util.ArrayList;
import java.util.List;

//Connection à la base de données

public class ReportService implements ReportServiceInterface {

    private static final ReportService instance = new ReportService();
    private ReportRepository reportRepository = ReportRepository.GetIstance();
    private ItemInfoRepository itemInfoRepository = ItemInfoRepository.GetInstance();
    private ConnectionBD connectionBD = ConnectionBD.GetInstance();
    private Object connection = this.connectionBD.GetConnectionStatus();
    private VerificationService verificationService = VerificationService.GetInstance();

    public static ReportService GetInstance()
    {
        return instance;
    }

    public List<ItemInfo> FindAll() throws ExceptionCustom {
        List<ItemInfo> itemInfo = new ArrayList<ItemInfo>();
        if (connection == null)
        {
            try {
                itemInfo = this.itemInfoRepository.FindAll();
                if (itemInfo == null)
                {
                    ExceptionCustom exceptionErreurBD = new ExceptionCustom("Aucun Résultats");
                    throw exceptionErreurBD;
                }
            } catch (Exception e) {
                ExceptionCustom exceptionErreurBD = new ExceptionCustom("Erreur de bd : " + e.toString());
                throw exceptionErreurBD;
            }
        }
        else
        {
            ExceptionCustom exceptionErreurBD = new ExceptionCustom("Données de saisies invalide");
            throw exceptionErreurBD;
        }

        return new ArrayList<>();
    }
    public void CreateFile(){}
}
