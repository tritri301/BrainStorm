package Factory;

import Models.ItemCommande;

/**
 * The type Item commande factory.
 */
public class ItemCommandeFactory {
    private static final ItemCommandeFactory instance = new ItemCommandeFactory();

    /**
     * Get instance item commande factory.
     *
     * @return the item commande factory
     */
    public static ItemCommandeFactory GetInstance() {
        return instance;
    }

    /**
     * Create item commande.
     *
     * @param idItemCommande the id item commande
     * @param idCommande     the id commande
     * @param idItemInfo     the id item info
     * @param description    the description
     * @param quantite       the quantite
     * @return the item commande
     */
    public ItemCommande Create(int idItemCommande, int idCommande, int idItemInfo, String description, int quantite) {
        ItemCommande ret = new ItemCommande();

        ret.setIdItemCommande(idItemCommande);
        ret.setIdCommande(idCommande);
        ret.setIdItemInfo(idItemInfo);
        ret.setDescription(description);
        ret.setQuantite(quantite);

        return ret;
    }
}
