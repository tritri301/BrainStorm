package Repositories.Interfaces;

import Models.ItemCommande;

import java.util.List;

public interface ItemCommandeRepositoryInterface {
    ItemCommande FindById(int id) throws Exception;

    List<ItemCommande> FindByIdCommande(int idCommande) throws Exception;

    List<ItemCommande> FindAll() throws Exception;

    void Update(ItemCommande ItemCommandeToUpdate) throws Exception;

    void Create(ItemCommande ItemCommandeToAdd) throws Exception;
}
