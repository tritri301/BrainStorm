package Repositories.Interfaces;

import Models.Container;

import java.util.List;

public interface ContainerRepositoryInterface {
    Container FindById(String emplacement) throws Exception;
    List<Container> FindAll() throws Exception;
    void Update(Container containerToAdd) throws Exception;
    void Delete(int id) throws Exception;
    void Create(Container containerToAdd) throws Exception;
}
