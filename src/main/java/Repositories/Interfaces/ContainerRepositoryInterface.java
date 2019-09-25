package Repositories.Interfaces;

import models.Container;

public interface ContainerRepositoryInterface {
    Container FindById(int id);
    Container[] FindAll();
    boolean Update(int id);
    boolean Delete(int id);
    Container Create(Container ContainerToAdd);
}
