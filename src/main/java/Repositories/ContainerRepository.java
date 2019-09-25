package Repositories;

import Repositories.Interfaces.ContainerRepositoryInterface;
import models.Container;

public class ContainerRepository implements ContainerRepositoryInterface
{
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
}
