package Services.Interfaces;

import Models.Commande;

import java.sql.Date;
import java.util.List;

public interface CommandeServiceInterface {
    Commande FindById(int id) throws Exception;
    Commande FindByIdItem(int id) throws Exception;
    List<Commande> FindAll() throws Exception;
    boolean Update(int idCommande, int etat,String nomPRecu) throws Exception;
    int Create(String nomPEnvoi) throws Exception;
}
