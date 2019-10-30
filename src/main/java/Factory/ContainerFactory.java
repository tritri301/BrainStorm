package Factory;

import Models.Container;

/**
 * The type Container factory.
 */
public class ContainerFactory {

    private static final ContainerFactory instance = new ContainerFactory();

    public Container Create(String emplacement, int volume, int volumeMax, int poids, int poidsMax, String emplacementParent) {
        Container ret = new Container();

        ret.setEmplacement(emplacement);
        ret.setVolumeMax(volumeMax);
        ret.setVolume(volume);
        ret.setPoids(poids);
        ret.setPoidsMax(poidsMax);
        ret.setEmplacementParent(emplacementParent);

        return ret;
    }
    public static ContainerFactory GetInstance(){return instance;}
}
