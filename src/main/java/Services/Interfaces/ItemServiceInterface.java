package Services.Interfaces;

import Models.Item;

public interface ItemServiceInterface {
    public Item FindById(int id);
    public Item FindByName(String name);
    public Item Update(int id);
    public Item Create();
    public Item Delete(int id);
}
