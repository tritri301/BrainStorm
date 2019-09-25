package Factory;

import Models.Container;

public class ContainerFactory {
    private Container Create(int idContainer, int quantite, int position, int volume, int poidsMax, int containerParent) {
        Container ret = new Container();

        ret.setIdContainer(idContainer);
        ret.setQuantite(quantite);
        ret.setPosition(position);
        ret.setVolume(volume);
        ret.setPoidsMax(poidsMax);
        ret.setIdContainerParent(containerParent);

        return ret;
    }
}
