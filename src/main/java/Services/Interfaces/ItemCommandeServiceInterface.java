package Services.Interfaces;

import Models.ItemCommande;

import java.util.List;

public interface ItemCommandeServiceInterface {
    ItemCommande FindById(int id) throws Exception;
    List<ItemCommande> FindByIdCommande(int idCommande) throws Exception;
    List<ItemCommande> FindAll() throws Exception;
    boolean Update(int idItemCommande, int idCommande, int idItemInfo,String description,int quantite) throws Exception;
    boolean Create(int idItemCommande, int idCommande, int idItemInfo,String description,int quantite) throws Exception;
}
