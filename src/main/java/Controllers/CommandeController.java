package Controllers;

import Controllers.Interface.CommandeControllerInterface;
import Models.Commande;

import java.sql.Date;
import java.util.List;
import Exception.*;
import Services.CommandeService;
import View.Browser;

/**
 * The type Commande controller.
 */
public class CommandeController implements CommandeControllerInterface {

    private static final CommandeController instance = new CommandeController();
    private CommandeService commandeService = CommandeService.GetInstance();
    /**
     * The Browser.
     */
    private Browser browser = Browser.GetInstance();

    @Override
    public Commande FindById(int id) {
        Commande commande =  null;
        try {
            commande = commandeService.FindById(id);
        } catch (Exception e) {
            browser.Alert(e.getMessage());
        }
        return commande;
    }

    @Override
    public Commande FindByIdItem(int id) {
        Commande commande =  null;
        try {
            commande = commandeService.FindByIdItem(id);
        } catch (Exception e) {
            browser.Alert(e.getMessage());
        }
        return commande;
    }

    @Override
    public List<Commande> FindAll() {
        List<Commande> commandeList = null;

        try {
            commandeList = commandeService.FindAll();
        } catch (ExceptionCustom e) {
            browser.Alert(e.getMessage());
        }
        catch(Exception e) {
            browser.Alert(e.toString());
        }
        return commandeList;
    }

    @Override
    public boolean Update(int idCommande, int etat, String nomPRecu) {
        boolean update = true;

        try {
            update = commandeService.Update(idCommande,etat, nomPRecu);
        } catch (ExceptionCustom e) {
            browser.Alert(e.getMessage());
            update = false;
        }
        catch(Exception e) {
            update = false;
        }
        return update;
    }

    @Override
    public int Create(String nomPEnvoi) {
        int id = 0;

        try {
            id = commandeService.Create(nomPEnvoi);
        } catch (Exception e) {
            browser.Alert(e.getMessage());
        }

        return id;
    }

    /**
     * Get instance commande controller.
     *
     * @return the commande controller
     */
    public static CommandeController GetInstance()
    {
        return instance;
    }
}
