package Controllers;

import Controllers.Interface.ContainerControllerInterface;
import Controllers.Interface.ItemControllerInterface;
import Models.Container;
import Models.Item;
import Services.ContainerService;
import Services.ItemService;
import java.util.List;
import Exception.*;
import View.Browser;


public class ContainerController implements ContainerControllerInterface {

    private static final ContainerController instance = new ContainerController();
    ContainerService containerService = ContainerService.GetInstance();
    Browser browser = Browser.GetInstance();

    @Override
    public Container FindById(String emplacement)
    {
        //test
        Container container =  null;
        try {
            container = containerService.FindById(emplacement);
        } catch (ExceptionCustom e) {
            browser.Alert(e.getMessage());
        }
        catch(Exception e) {

        }
        return container;
    }

    @Override
    public List<Container> FindAll() {
        List<Container> containerList = null;
        try {
            containerList = containerService.FindAll();
        } catch (ExceptionCustom e) {
            browser.Alert(e.getMessage());
        }
        catch(Exception e) {

        }
        return containerList;
    }

    @Override
    public boolean Update(String emplacement, int volume, int volumeMax, int poids, int poidsMax, String emplacementParent) {
        boolean update = true;

        try {
            update = containerService.Update(emplacement,volume,volumeMax,poids,poidsMax,emplacementParent);
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
    public boolean Create(String emplacement, int volume, int volumeMax, int poids, int poidsMax, String emplacementParent) {
        boolean create = true;

        try {
            create = containerService.Create(emplacement,volume,volumeMax,poids,poidsMax,emplacementParent);
        } catch (ExceptionCustom e) {
            browser.Alert(e.getMessage());
            create = false;
        }
        catch(Exception e) {
            create = false;
        }

        return create;
    }

    @Override
    public boolean Delete(String emplacement) {
        boolean delete = true;
        try {
            delete = containerService.Delete(emplacement);
        } catch (ExceptionCustom e) {
            delete = false;
            browser.Alert(e.getMessage());
        }
        catch(Exception e) {
            delete = false;
        }

        return delete;
    }

    public static ContainerController GetInstance()
    {
        return instance;
    }
}
