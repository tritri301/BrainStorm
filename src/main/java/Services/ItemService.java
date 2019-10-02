package Services;

import Factory.ItemFactory;
import Models.ConnectionBD;
import Repositories.ItemRepository;
import Services.Interfaces.ItemServiceInterface;
import Models.Item;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Item service.
 */
public class ItemService implements ItemServiceInterface {

    private static final ItemService instance = new ItemService();
    private ItemRepository itemRepository = ItemRepository.GetInstance();
    private ItemFactory itemFactory = ItemFactory.GetInstance();
    private ConnectionBD connectionBD = ConnectionBD.GetInstance();

    @Override
    public Item FindById(int id) {
        Item item = null;
        if (connectionBD.GetConnectionStatus() == null)
        {
            try {
                item = this.itemRepository.FindById(id);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else
        {
            //erreur de connection BD
        }
        
        return item;
    }

    @Override
    public List<Item> FindAll() {
        List<Item> item = new ArrayList<Item>();
        if (connectionBD == null)
        {
            try {
                item = this.itemRepository.FindAll();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else
        {
            //erreur de connection BD
        }

        return new ArrayList<>();
    }

    @Override
    public List<Item> FindByName(String name) {
        List<Item> item = new ArrayList<Item>();
        if (connectionBD.GetConnectionStatus() == null)
        {
            try {
               item = this.itemRepository.FindByName(name);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else
        {
            //erreur de connection BD
        }
        return item;
    }

    @Override
    public boolean Update(int idItem, int idItemInfo, int idContainer, String description) {
        boolean valide = true;

        //verification

        Item nouveauItem = FindById(idItem);
        nouveauItem.setIdItemInfo(idItemInfo);
        nouveauItem.setIdContainer(idContainer);
        nouveauItem.setDescription(description);

        if (connectionBD == null)
        {
            try {
                this.itemRepository.Update(nouveauItem);
            } catch (Exception e) {
                valide = false;
                e.printStackTrace();
            }
        }
        else
        {
            //erreur de connection BD
        }
        return valide;
    }

    @Override
    public boolean Create(int idItem, int idItemInfo, int idContainer, String description) {

        boolean valide = true;

        //verification

        if (connectionBD == null)
        {
            try {
                itemRepository.Create(this.itemFactory.Create(idItem,idItemInfo,idContainer,description));
            }catch (Exception e) {
                valide = false;
                e.printStackTrace();
            }
        }
        else
        {
            //erreur de connection BD
        }
        return valide;
    }

    @Override
    public boolean Delete(int id) {

        boolean valide = true;

        if (connectionBD == null)
        {
            try {
                this.itemRepository.Delete(id);
            } catch (Exception e) {
                valide = false;
                e.printStackTrace();
            }
        }
        else
        {
            //erreur de connection BD
        }
        return valide;
    }

    public static ItemService GetInstance()
    {
        return instance;
    }
}
