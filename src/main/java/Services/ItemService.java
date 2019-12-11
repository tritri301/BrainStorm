package Services;

import Exception.ExceptionCustom;
import Factory.ItemFactory;
import Models.ConnectionBD;
import Models.Container;
import Models.Item;
import Models.ItemInfo;
import Repositories.ItemRepository;
import Services.Interfaces.ItemServiceInterface;

import java.util.ArrayList;
import java.util.List;
//

/**
 * The type Item service.
 */
public class ItemService implements ItemServiceInterface {

    private static final ItemService instance = new ItemService();
    private ContainerService containerService = ContainerService.GetInstance();
    private ItemInfoService itemInfoService = ItemInfoService.GetInstance();
    private ItemRepository itemRepository = ItemRepository.GetInstance();
    private ItemFactory itemFactory = ItemFactory.GetInstance();
    private ConnectionBD connectionBD = ConnectionBD.GetInstance();
    private Object connection = this.connectionBD.GetConnectionStatus();
    private VerificationService verificationService = VerificationService.GetInstance();

    /**
     * Get instance item service.
     *
     * @return the item service
     */
    public static ItemService GetInstance() {
        return instance;
    }

    @Override
    public Item FindById(int id) throws ExceptionCustom {
        Item item = null;
        if (this.verificationService.verifier(id)) {
            if (connection == null) {
                try {
                    item = this.itemRepository.FindById(id);
                } catch (Exception e) {
                    throw new ExceptionCustom("l'objet que vous recherché est introuvable");
                }
            } else {
                throw new ExceptionCustom("Erreur de connection a la base de données");
            }
        } else {
            throw new ExceptionCustom("Données de saisies invalide");
        }

        return item;
    }

    @Override
    public int FindAmountById(int id) throws ExceptionCustom {
        int count = 0;
        if (this.verificationService.verifier(id)) {
            if (connection == null) {
                try {
                    count = this.itemRepository.FindAmountById(id);
                    if (count == 0) {
                        throw new ExceptionCustom("Aucun Résultats");
                    }
                } catch (Exception e) {
                    throw new ExceptionCustom("l'objet que vous recherché est introuvable par quantite");
                }
            } else {
                throw new ExceptionCustom("Erreur de connection a la base de données");
            }
        } else {
            throw new ExceptionCustom("Données de saisies invalide");
        }
//yolo
        return count;
    }

    @Override
    public List<Item> FindAll() throws ExceptionCustom {
        List<Item> item = new ArrayList<Item>();
        if (connection == null) {
            try {
                item = this.itemRepository.FindAll();
                if (item == null) {
                    throw new ExceptionCustom("Aucun Résultats");
                }
            } catch (Exception e) {
                throw new ExceptionCustom("Erreur de bd : " + e.toString());
            }
        } else {
            throw new ExceptionCustom("Erreur de connection a la base de données");
        }

        return item;
    }

    @Override
    public List<Item> SortByName() throws ExceptionCustom {
        List<Item> item = new ArrayList<Item>();
        if (connection == null) {
            try {
                item = this.itemRepository.SortByName();
                if (item == null) {
                    throw new ExceptionCustom("Aucun Résultats");
                }
            } catch (Exception e) {
                throw new ExceptionCustom("Erreur de bd : " + e.toString());
            }
        } else {
            throw new ExceptionCustom("Erreur de connection a la base de données");
        }

        return item;
    }

    @Override
    public List<Item> FindByName(String name) throws ExceptionCustom {
        List<Item> item = new ArrayList<Item>();
        if (this.verificationService.verifier(name)) {
            if (connection == null) {
                try {
                    name = verificationService.normalisation(name);
                    item = this.itemRepository.FindByName(name);
                    if (item == null) {
                        throw new ExceptionCustom("Aucun Résultats");
                    }
                } catch (Exception e) {
                    throw new ExceptionCustom("l'objet que vous recherché est introuvable");
                }
            } else {
                throw new ExceptionCustom("Erreur de connection a la base de données");
            }
        } else {
            throw new ExceptionCustom("Données de saisies invalide");
        }

        return item;
    }

    @Override
    public boolean Update(int idItem, int idItemInfo, String emplacement, String description, int quantite) throws ExceptionCustom {
        boolean valide = false;

        if (this.verificationService.verifier(quantite)) {
            if (verificationService.itemInfoExist(idItemInfo)) {
                if (verificationService.emplacementExist(emplacement)) {
                    if (verificationService.verifierDescription(description)) {
                        emplacement = verificationService.normalisation(emplacement);
                        Item nouveauItem = FindById(idItem);
                        nouveauItem.setIdItemInfo(idItemInfo);
                        nouveauItem.setEmplacement(emplacement);
                        nouveauItem.setDescription(description);
                        nouveauItem.setQuantite(quantite);

                        if (connection == null) {
                            try {
                                this.itemRepository.Update(nouveauItem);
                                valide = true;
                            } catch (Exception e) {
                                throw new ExceptionCustom("Erreur de bd : " + e.toString());
                            }
                        } else {
                            throw new ExceptionCustom("Erreur de connection a la base de données");
                        }
                    } else {
                        throw new ExceptionCustom("la description na pas le bon format");
                    }
                } else {
                    throw new ExceptionCustom("l'emplacement est invalide");
                }
            } else {
                throw new ExceptionCustom("le code upc est invalide");
            }
        } else {
            throw new ExceptionCustom("la quantité est invalide");
        }
        return valide;
    }

    @Override
    public boolean Create(int idItemInfo, String emplacement, String description, int quantite) throws ExceptionCustom {

        boolean valide = false;

        if (this.verificationService.verifier(quantite)) {
            if (verificationService.itemInfoExist(idItemInfo)) {
                if (verificationService.emplacementExist(emplacement)) {
                    if (verificationService.verifierDescription(description)) {
                       // emplacement = verificationService.normalisation(emplacement);

                        if (connection == null) {
                            try {

                                Item item = null;
                                item = this.trouverSimilaire(idItemInfo, emplacement, description);

                                Container container = null;
                                container = this.containerService.FindById(emplacement);
                                ItemInfo itemInfo = null;
                                itemInfo = this.itemInfoService.FindById(idItemInfo);
                                int volume = container.getVolume()+(itemInfo.getVolume()*quantite);
                                container.setVolume(volume);
                                int poids = container.getPoids()+(itemInfo.getPoids()*quantite);
                                container.setPoids(poids);

                                if (container.getVolumeMax() < container.getVolume())
                                {
                                    throw new ExceptionCustom("l'objet est trop volumineux");
                                }

                                if (container.getPoidsMax() < container.getPoids())
                                {
                                    throw new ExceptionCustom("l'objet est trop lourd");
                                }

                                if (item != null) {
                                    quantite = quantite + item.getQuantite();
                                    this.Update(item.getIdItem(), idItemInfo, emplacement, description, quantite);
                                } else {
                                    itemRepository.Create(this.itemFactory.Create(0, idItemInfo, emplacement, description, quantite));
                                }

                                containerService.Update(container.getEmplacement(),container.getVolume(),container.getVolumeMax(),container.getPoids(),container.getPoidsMax(),container.getEmplacementParent());

                                valide = true;
                            } catch (Exception e) {
                                throw new ExceptionCustom("Erreur de bd : " + e.toString());
                            }

                        } else {
                            throw new ExceptionCustom("Erreur de connection a la base de données");
                        }
                    } else {
                        throw new ExceptionCustom("la description na pas le bon format");
                    }
                } else {
                    throw new ExceptionCustom("l'emplacement est invalide");
                }
            } else {
                throw new ExceptionCustom("le code upc est invalide");
            }
        } else {
            throw new ExceptionCustom("la quantité est invalide");
        }
        return valide;
    }

    @Override
    public boolean Delete(int id, int quantite) throws ExceptionCustom {
        boolean valide = true;
        boolean valideId = this.verificationService.verifier(id);
        boolean valideQt = this.verificationService.verifier(quantite);
        if (valideQt) {
            if (valideId) {
                if (connection == null) {
                    try {

                        Item item = null;
                        item = this.FindById(id);
                        Container container = null;
                        container = this.containerService.FindById(item.getEmplacement());
                        ItemInfo itemInfo = null;
                        itemInfo = this.itemInfoService.FindById(item.getIdItemInfo());

                        if (quantite > item.getQuantite())
                        {
                            throw new ExceptionCustom("la quantite a retirer est trop grande");
                        }

                        this.itemRepository.Delete(id, quantite);

                        int volume = container.getVolume()-(itemInfo.getVolume()*quantite);
                        container.setVolume(volume);
                        int poids = container.getPoids()-(itemInfo.getPoids()*quantite);
                        container.setPoids(poids);

                        containerService.Update(container.getEmplacement(),container.getVolume(),container.getVolumeMax(),container.getPoids(),container.getPoidsMax(),container.getEmplacementParent());

                    } catch (ExceptionCustom e) {
                        throw e;
                    } catch (Exception e) {
                        valide = false;
                        throw new ExceptionCustom("l'objet que vous recherché est introuvable");
                    }
                } else {
                    valide = false;
                    ExceptionCustom exceptionErreurBD;
                    exceptionErreurBD = new ExceptionCustom("Erreur de connection a la base de données");
                    throw exceptionErreurBD;
                }
            } else {
                valide = false;
                throw new ExceptionCustom("Données de saisies invalide");
            }
        } else {
            valide = false;
            throw new ExceptionCustom("Données de saisies invalide");
        }
        return valide;
    }

    public boolean MoveItem(int id, int quantite, String emplacementNouveau) throws ExceptionCustom {
        boolean valide = true;

        if (verificationService.itemExist(id)) {
            if (verificationService.verifier(quantite)) {
                if (verificationService.verifierQuantiteRestante(id, quantite)) {
                    if (verificationService.emplacementExist(emplacementNouveau)) {
                        Item item = FindById(id);
                        Update(id, item.getIdItemInfo(), item.getEmplacement(), item.getDescription(), item.getQuantite() - quantite);
                        Delete(id, 0);
                        Create(item.getIdItemInfo(), emplacementNouveau, item.getDescription(), quantite);
                    } else {
                        valide = false;
                        throw new ExceptionCustom("le nouvelle emplacement n'est pas valide");
                    }
                } else {
                    valide = false;
                    throw new ExceptionCustom("vous déplacer plus d'object que la quantité en stock");
                }
            } else {
                valide = false;
                throw new ExceptionCustom("format de Quantite invalide");
            }
        } else {
            valide = false;
            throw new ExceptionCustom("Aucun object avec id : " + id);
        }


        return valide;
    }

    @Override
    public boolean ModifyItem(int id, String description) throws ExceptionCustom {
        boolean valide = true;

        if (verificationService.itemExist(id)) {
            if (verificationService.verifierDescription(description)) {
                Item item = FindById(id);
                Update(id, item.getIdItemInfo(), item.getEmplacement(), description, item.getQuantite());
            } else {
                valide = false;
                throw new ExceptionCustom("la description ne possede pas de bon format");
            }

        } else {
            valide = false;
            throw new ExceptionCustom("Aucun object avec id : " + id);
        }

        return valide;
    }

    @Override
    public Item trouverSimilaire(int idItemInfo, String emplacement, String description) {
        Item item = null;
        try {
            item = itemRepository.findSimilar(idItemInfo, emplacement, description);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return item;
    }

    @Override
    public Item trouverSimilaire(int idItemInfo, String description) {

        Item item = null;
        try {
            item = itemRepository.findSimilar(idItemInfo, description);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return item;
    }
}
