package kz.homeAppliances.appliances.devices.devicesPlug;

/**
 * Варианты розеток по типам.
 *
 */
public interface TypePlug {
    enum Europlug implements TypePlug {FLAT, VOLUMETRIC}
    enum Threepin implements TypePlug {BIG, SMALL}
}
