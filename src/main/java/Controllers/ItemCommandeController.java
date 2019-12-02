package Controllers;

import Controllers.Interface.ItemCommandControllerInterface;
import Models.ItemCommande;
import Exception.*;
import Services.CommandeService;
import Services.ItemCommandeService;
import View.Browser;

import java.util.List;

/**
 * The type Item commande controller.
 */
public class ItemCommandeController implements ItemCommandControllerInterface {

    private static final ItemCommandeController instance = new ItemCommandeController();

    private ItemCommandeService itemCommandeService = ItemCommandeService.GetInstance();
    /**
     * The Browser.
     */
    private Browser browser = Browser.GetInstance();

    /**
     * Get instance item commande controller.
     *
     * @return the item commande controller
     */
    public static ItemCommandeController GetInstance()
    {
        return instance;
    }

    @Override
    public ItemCommande FindById(int id) {
        ItemCommande itemCommande =  null;
        try {
            itemCommande = itemCommandeService.FindById(id);
        } catch (ExceptionCustom e) {
            browser.Alert(e.getMessage());
        }
        catch(Exception e) {
            browser.Alert(e.toString());
        }
        return itemCommande;
    }

    @Override
    public List<ItemCommande> FindByIdCommande(int idCommande) {
        List<ItemCommande> itemCommandeList = null;

        try {
            itemCommandeList = itemCommandeService.FindByIdCommande(idCommande);
        } catch (ExceptionCustom e) {
            browser.Alert(e.getMessage());
        }
        catch(Exception e) {
            browser.Alert(e.toString());
        }
        return itemCommandeList;
    }

    @Override
    public List<ItemCommande> FindAll(){
        List<ItemCommande> itemCommandeList = null;

        try {
            itemCommandeList = itemCommandeService.FindAll();
        } catch (ExceptionCustom e) {
            browser.Alert(e.getMessage());
        }
        catch(Exception e) {
            browser.Alert(e.toString());
        }
        return itemCommandeList;
    }

    @Override
    public boolean Update(int idItemCommande, int idCommande, int idItemInfo, String description, int quantite){
        return false;
    }

    @Override
    public boolean Create(int idItemCommande, int idCommande, int idItemInfo, String description, int quantite){
        boolean create = true;

        try {
            create = itemCommandeService.Create(idItemCommande,idCommande, idItemInfo, description, quantite);
        } catch (ExceptionCustom e) {
            browser.Alert(e.getMessage());
            create = false;
        }
        catch(Exception e) {
            create = false;
        }

        return create;
    }
}
