package Services;

import Repositories.ItemRepository;
import Services.Interfaces.ItemServiceInterface;
import Models.Item;

/**
 * The type Item service.
 */
public class ItemService implements ItemServiceInterface {

    private ItemRepository itemRepository = ItemRepository.GetInstance();

    @Override
    public Item FindById(int id) {
        Item item = null;
        
        try {
            item = this.itemRepository.FindById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return item;
    }

    @Override
    public Item FindByName(String name) {
        return null;
    }

    @Override
    public Item Update(int id) {
        return null;
    }

    @Override
    public Item Create() {
        return null;
    }

    @Override
    public Item Delete(int id) {
        return null;
    }
}
