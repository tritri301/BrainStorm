package Controllers.Interface;

import Models.Commande;

import java.sql.Date;
import java.util.List;

public interface CommandeControllerInterface {
    Commande FindById(int id);
    Commande FindByIdItem(int id);
    List<Commande> FindAll();
    boolean Update(int idCommande, int etat, String nomPRecu);
    int Create(String nomPEnvoi);

}
