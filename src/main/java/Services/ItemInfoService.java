package Services;

import Factory.ItemInfoFactory;
import Models.ConnectionBD;
import Repositories.ItemInfoRepository;
import Services.Interfaces.ItemInfoServiceInterface;
import Models.ItemInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Item info service.
 */
public class ItemInfoService implements ItemInfoServiceInterface {

    private static final ItemInfoService instance = new ItemInfoService();
    private ItemInfoRepository itemInfoRepository = ItemInfoRepository.GetInstance();
    private ItemInfoFactory itemInfoFactory = ItemInfoFactory.GetInstance();
    private ConnectionBD connectionBD = ConnectionBD.GetInstance();

    @Override
    public ItemInfo FindById(int id) {

        //verification

        ItemInfo itemInfo = null;
        if (connectionBD == null)
        {
            try {
                itemInfo = this.itemInfoRepository.FindById(id);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else
        {
            //erreur de connection BD
        }

        return itemInfo;
    }

    @Override
    public List<ItemInfo> FindAll() {
        List<ItemInfo> itemInfo = new ArrayList<ItemInfo>();
        if (connectionBD == null)
        {
            try {
               // itemInfo = this.itemInfoRepository.FindAll();
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
    public List<ItemInfo> FindByName(String name) {

        //verification

        List<ItemInfo> itemInfo = new ArrayList<ItemInfo>();
        if (connectionBD.GetConnectionStatus() == null)
        {
            try {
                itemInfo = this.itemInfoRepository.FindByName(name);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else
        {
            //erreur de connection BD
        }
        return itemInfo;
    }

    @Override
    public boolean Update(int idItem, String description, String nom, int poids, int volume) {
        boolean valide = true;

        //verification

        ItemInfo nouveauItemInfo = FindById(idItem);
        nouveauItemInfo.setDescription(description);
        nouveauItemInfo.setNom(nom);
        nouveauItemInfo.setPoids(poids);
        nouveauItemInfo.setVolume(volume);

        if (connectionBD == null)
        {
            try {
                this.itemInfoRepository.Update(nouveauItemInfo);
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
    public boolean Create(int idItem, String description, String nom, int poids, int volume) {
        boolean valide = true;

        //verification

        if (connectionBD == null)
        {
            try {
                itemInfoRepository.Create(this.itemInfoFactory.Create(idItem,description,nom,poids,volume));
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

        //verification

        if (connectionBD == null)
        {
            try {
                this.itemInfoRepository.Delete(id);
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

    public static ItemInfoService GetInstance()
    {
        return instance;
    }
}
