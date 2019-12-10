package Services;

import Exception.ExceptionCustom;
import Factory.ItemInfoFactory;
import Models.ConnectionBD;
import Models.ItemInfo;
import Repositories.ItemInfoRepository;
import Services.Interfaces.ItemInfoServiceInterface;

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
    private Object connection = this.connectionBD.GetConnectionStatus();
    private VerificationService verificationService = VerificationService.GetInstance();

    /**
     * Get instance item info service.
     *
     * @return the item info service
     */
    public static ItemInfoService GetInstance() {
        return instance;
    }

    @Override
    public ItemInfo FindById(int id) throws ExceptionCustom {
        ItemInfo itemInfo = null;
        if (this.verificationService.verifier(id)) {
            if (connection == null) {
                try {
                    itemInfo = this.itemInfoRepository.FindById(id);
                    if (itemInfo == null) {
                        throw new ExceptionCustom("Aucun Résultats");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    throw new ExceptionCustom("ce code UPC est introuvable dans le catalogue");
                }
            } else {
                throw new ExceptionCustom("Erreur de connection a la base de données");
            }
        } else {
            throw new ExceptionCustom("Données de saisies invalide");
        }

        return itemInfo;
    }

    @Override
    public List<ItemInfo> FindAll() throws ExceptionCustom {
        List<ItemInfo> itemInfo = new ArrayList<ItemInfo>();
        if (connection == null) {
            try {
                itemInfo = this.itemInfoRepository.FindAll();
                if (itemInfo == null) {
                    throw new ExceptionCustom("Aucun Résultats");
                }
            } catch (Exception e) {
                throw new ExceptionCustom("Erreur de bd : " + e.toString());
            }
        } else {
            throw new ExceptionCustom("Données de saisies invalide");
        }

        return new ArrayList<>();
    }

    public List<ItemInfo> SortByName() throws ExceptionCustom {
        List<ItemInfo> itemInfo = new ArrayList<ItemInfo>();
        if (connection == null) {
            try {
                itemInfo = this.itemInfoRepository.SortByName();
                if (itemInfo == null) {
                    throw new ExceptionCustom("Aucun Résultats");
                }
            } catch (Exception e) {
                throw new ExceptionCustom("Erreur de bd : " + e.toString());
            }
        } else {
            throw new ExceptionCustom("Données de saisies invalide");
        }

        return new ArrayList<>();
    }

    @Override
    public List<ItemInfo> FindByName(String name) throws ExceptionCustom {
        List<ItemInfo> itemInfo = new ArrayList<ItemInfo>();
        if (this.verificationService.verifier(name)) {
            if (connection == null) {
                try {
                    name = verificationService.normalisation(name);
                    itemInfo = this.itemInfoRepository.FindByName(name);
                    if (itemInfo == null) {
                        throw new ExceptionCustom("Aucun Résultats");
                    }
                } catch (Exception e) {
                    throw new ExceptionCustom("ce code UPC est introuvable dans le catalogue");
                }
            } else {
                throw new ExceptionCustom("Erreur de connection a la base de données");
            }
        } else {
            throw new ExceptionCustom("Données de saisies invalide");
        }

        return itemInfo;
    }

    @Override
    public boolean Update(int idItem, String description, String nom, int poids, int volume) throws ExceptionCustom {

        boolean valide = this.verificationService.verifier(idItem, poids, volume);

        if (valide) {
            valide = this.verificationService.verifier(description, nom);
        }

        if (valide) {
            description = verificationService.normalisation(description);
            nom = verificationService.normalisation(nom);
            ItemInfo nouveauItemInfo = FindById(idItem);
            nouveauItemInfo.setDescription(description);
            nouveauItemInfo.setNom(nom);
            nouveauItemInfo.setPoids(poids);
            nouveauItemInfo.setVolume(volume);

            if (connection == null) {
                try {
                    this.itemInfoRepository.Update(nouveauItemInfo);
                } catch (Exception e) {
                    valide = false;
                    throw new ExceptionCustom("Erreur de bd : " + e.toString());
                }
            } else {
                valide = false;
                throw new ExceptionCustom("Erreur de connection a la base de données");
            }
        } else {
            valide = false;
            throw new ExceptionCustom("Données de saisies invalide");
        }

        return valide;
    }

    @Override
    public boolean Create(int idItem, String description, String nom, int poids, int volume) throws ExceptionCustom {

        boolean valide = this.verificationService.verifier(idItem, poids, volume);
        if (valide) {
            valide = this.verificationService.verifier(description, nom);
        }

        if (valide) {
            if (connection == null) {
                try {
                    description = verificationService.normalisation(description);
                    nom = verificationService.normalisation(nom);
                    itemInfoRepository.Create(this.itemInfoFactory.Create(idItem, description, nom, poids, volume));
                } catch (Exception e) {
                    valide = false;
                    throw new ExceptionCustom("Erreur de bd : " + e.toString());
                }
            } else {
                valide = false;
                throw new ExceptionCustom("Erreur de connection a la base de données");
            }
        } else {
            valide = false;
            throw new ExceptionCustom("Données de saisies ou code UPC invalide");
        }

        return valide;
    }

    @Override
    public boolean Delete(int id) throws ExceptionCustom {
        boolean valide = this.verificationService.verifier(id);

        if (valide) {
            if (connection == null) {
                try {
                    this.itemInfoRepository.Delete(id);
                } catch (Exception e) {
                    valide = false;
                    throw new ExceptionCustom("ce code UPC est introuvable dans le catalogue");
                }
            } else {
                valide = false;
                throw new ExceptionCustom("Erreur de connection a la base de données");
            }
        } else {
            valide = false;
            throw new ExceptionCustom("Données de saisies invalide");
        }

        return valide;
    }
}
