package Factory;

import Models.Container;

/**
 * The type Container factory.
 */
public class ContainerFactory {

    private static final ContainerFactory instance = new ContainerFactory();

    public Container Create(int idContainer, int quantite, int position, int volume, int poidsMax, int containerParent) {
        Container ret = new Container();

        ret.setIdContainer(idContainer);
        ret.setQuantite(quantite);
        ret.setPosition(position);
        ret.setVolume(volume);
        ret.setPoidsMax(poidsMax);
        ret.setIdContainerParent(containerParent);

        return ret;
    }
    public static ContainerFactory GetInstance(){return instance;}
}
