package Services;

import Repositories.ContainerRepository;
import Services.Interfaces.ContainerServiceInterface;
import Models.Container;

/**
 * The type Container service.
 */
public class ContainerService implements ContainerServiceInterface {

    private static final ContainerService instance = new ContainerService();
    private ContainerRepository containerService = ContainerRepository.GetInstance();

    @Override
    public Container FindById(int id) {
        return null;
    }

    @Override
    public Container FindByName(String name) {
        return null;
    }

    @Override
    public Container Update(int id) {
        return null;
    }

    @Override
    public Container Create() {
        return null;
    }

    @Override
    public Container Delete(int id) {
        return null;
    }

    public static ContainerService GetInstance()
    {
        return instance;
    }
}
