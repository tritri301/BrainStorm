package Repositories;

import Repositories.Interfaces.ContainerRepositoryInterface;
import Models.Container;

public class ContainerRepository implements ContainerRepositoryInterface
{
    private static final ContainerRepository instance = new ContainerRepository();
    @Override
    public Container FindById(int id) {
        return null;
    }

    @Override
    public Container[] FindAll() {
        return new Container[0];
    }

    @Override
    public boolean Update(int id) {
        return false;
    }

    @Override
    public boolean Delete(int id) {
        return false;
    }

    @Override
    public Container Create(Container ContainerToAdd) {
        return null;
    }
    public static ContainerRepository GetInstance() {
        return instance;
    }
}
