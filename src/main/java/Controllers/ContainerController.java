package Controllers;


import Controllers.Interface.ContainerControllerInterface;
import Models.Container;
import Services.ContainerService;

import java.util.List;
import Exception.*;

public class ContainerController  implements ContainerControllerInterface {

    private static final ContainerController instance = new ContainerController();
    private ContainerService containerService = ContainerService.GetInstance();

    @Override
    public int FindById(int id) {
        int containerID = 0;
        try {
            containerID = containerService.FindById(id);
        } catch(ExceptionCustom e) {

        } catch (Exception e) {

        }
        return containerID;
    }

    @Override
    public List<Container> FindAll() {

        List<Container> container = null;

        try {
            container = containerService.FindAll();
        } catch (ExceptionCustom e) {

        }
        catch(Exception e) {

        }
        return container;
}

    @Override
    public boolean Update(int idContainer, int quantite, int position, int volume, int poidsMax, int containerParent) {

        boolean update = true;

        try {
            update = containerService.Update(idContainer,quantite,position,volume,poidsMax,containerParent);
        } catch (ExceptionCustom e) {

        }
        catch(Exception e) {

        }
        return update;
    }

    @Override
    public boolean Create(int idContainer, int quantite, int position, int volume, int poidsMax, int containerParent) {

        boolean create = true;

        try {
            create = containerService.Create(idContainer,quantite,position,volume,poidsMax,containerParent);
        } catch (ExceptionCustom e) {
            //Alert ;
        }
        catch(Exception e) {

        }

        return create;
    }

    @Override
    public boolean Delete(int id) {
        boolean delete = true;
        try {
            delete = containerService.Delete(id);
        } catch (ExceptionCustom e) {

        }
        catch(Exception e) {

        }

        return delete;

    }

    public static ContainerController GetInstance()
    {
        return instance;
    }
}
