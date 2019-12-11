package Factory;

import Models.Container;

/**
 * The type Container factory.
 */
public class ContainerFactory {

    private static final ContainerFactory instance = new ContainerFactory();

    /**
     * Get instance container factory.
     *
     * @return the container factory
     */
    public static ContainerFactory GetInstance() {
        return instance;
    }

    /**
     * Create container.
     *
     * @param emplacement       the emplacement
     * @param volume            the volume
     * @param volumeMax         the volume max
     * @param poids             the poids
     * @param poidsMax          the poids max
     * @param emplacementParent the emplacement parent
     * @return the container
     */
    public Container Create(String emplacement, int volume, int volumeMax, int poids, int poidsMax, String emplacementParent) {
        Container ret = new Container();

        ret.setEmplacement(emplacement);
        ret.setVolume(volume);
        ret.setVolumeMax(volumeMax);
        ret.setPoids(poids);
        ret.setPoidsMax(poidsMax);
        ret.setEmplacementParent(emplacementParent);

        return ret;
    }
}
