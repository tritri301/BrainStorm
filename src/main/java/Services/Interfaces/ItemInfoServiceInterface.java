package Services.Interfaces;

import Models.ItemInfo;

public interface ItemInfoServiceInterface {
    public ItemInfo FindById(int id);
    public ItemInfo FindByName(String name);
    public ItemInfo Update(int id);
    public ItemInfo Create();
    public ItemInfo Delete(int id);
}
