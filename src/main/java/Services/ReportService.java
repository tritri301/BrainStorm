package Services;

import Models.ConnectionBD;
import Repositories.ContainerRepository;
import Services.Interfaces.ReportServiceInterface;
import Exception.*;

//Connection à la base de données

public class ReportService implements ReportServiceInterface {

    private static final ReportService instance = new ReportService();
    private ContainerRepository containerRepository = ContainerRepository.GetInstance();
    private ConnectionBD connectionBD = ConnectionBD.GetInstance();
    private Object connection = this.connectionBD.GetConnectionStatus();
    private VerificationService verificationService = VerificationService.GetInstance();
//aaa
    public static ReportService GetInstance()
    {
        return instance;
    }
}
