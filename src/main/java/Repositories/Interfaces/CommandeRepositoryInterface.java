package Repositories.Interfaces;

import Models.Commande;

import java.util.List;

public interface CommandeRepositoryInterface {
    Commande FindById(int id) throws Exception;
    Commande FindByIdItem(int id) throws Exception;
    List<Commande> FindAll() throws Exception;
    void Update(Commande commandeToUpdate) throws Exception;
    int Create(Commande commandeToAdd) throws Exception;
}
