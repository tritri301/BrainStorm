package Services.Interfaces;

import Models.Container;

public interface ContainerServiceInterface {
    public Container FindById(int id);
    public Container FindByName(String name);
    public Container Update(int id);
    public Container Create();
    public Container Delete(int id);
}
