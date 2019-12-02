package Factory;

import Models.ItemCommande;

public class ItemCommandeFactory {
    private static final ItemCommandeFactory instance = new ItemCommandeFactory();

    public ItemCommande Create(int idItemCommande, int idCommande, int idItemInfo, String description, int quantite) {
        ItemCommande ret = new ItemCommande();

        ret.setIdItemCommande(idItemCommande);
        ret.setIdCommande(idCommande);
        ret.setIdItemInfo(idItemInfo);
        ret.setDescription(description);
        ret.setQuantite(quantite);

        return ret;
    }
    public static ItemCommandeFactory GetInstance(){return instance;}
}
