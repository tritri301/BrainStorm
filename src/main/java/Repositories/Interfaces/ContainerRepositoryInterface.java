package Repositories.Interfaces;

import Models.Container;

public interface ContainerRepositoryInterface {
    Container FindById(int id);
    Container[] FindAll();
    boolean Update(int id);
    boolean Delete(int id);
    Container Create(Container ContainerToAdd);
}
