package Repositories.Interfaces;

import Models.Item;

import java.sql.SQLException;
import java.util.List;

public interface ItemRepositoryInterface {
    Item FindById(int id) throws Exception;
    List<Item> FindByName(String name) throws Exception;
    List<Item> FindAll() throws Exception;
    int FindAmountById(int id) throws Exception;
    void Update(Item itemToUpdate) throws Exception;
    void Delete(int id, int quantite) throws Exception;
    void Create(Item itemToAdd) throws Exception;
    Item findSimilar(int idItemInfo,String emplacement,String description) throws SQLException, Exception;
    Item findSimilar(int idItemInfo,String description) throws SQLException;
}
