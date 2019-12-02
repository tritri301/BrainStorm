package Models;

public class ItemCommande {
    private int idItemCommande;
    private int idCommande;
    private int idItemInfo;
    private String description;
    private int quantite;

    public int getIdItemCommande() {
        return idItemCommande;
    }

    public void setIdItemCommande(int idItemCommande) {
        this.idItemCommande = idItemCommande;
    }

    public int getIdCommande() {
        return idCommande;
    }

    public void setIdCommande(int idCommande) {
        this.idCommande = idCommande;
    }

    public int getIdItemInfo() {
        return idItemInfo;
    }

    public void setIdItemInfo(int idItemInfo) {
        this.idItemInfo = idItemInfo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }
}
