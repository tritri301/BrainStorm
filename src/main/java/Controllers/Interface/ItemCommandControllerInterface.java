package Controllers.Interface;

import Models.ItemCommande;

import java.util.List;

public interface ItemCommandControllerInterface {
    ItemCommande FindById(int id) throws Exception;
    List<ItemCommande> FindByIdCommande(int idCommande);
    List<ItemCommande> FindAll();
    boolean Update(int idItemCommande, int idCommande, int idItemInfo,String description,int quantite);
    boolean Create(int idItemCommande, int idCommande, int idItemInfo,String description,int quantite);
}
