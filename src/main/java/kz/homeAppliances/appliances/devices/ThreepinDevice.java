package kz.homeAppliances.appliances.devices;

import kz.homeAppliances.appliances.devices.devicesPlug.TypePlug;
import kz.homeAppliances.appliances.devices.devicesType.TypeDevices;

/**
 * Устройство с трех-пиновой
 * розеткой.
 *
 */
public class ThreepinDevice extends Device {
    private TypePlug typePlug;
    public ThreepinDevice(TypeDevices typeOfDevice,
                          boolean stateOfDevice, TypePlug typePlug) {
        super(typeOfDevice, stateOfDevice);
        this.typePlug = typePlug;
    }

    @Override
    public TypePlug getPlug() {
        return typePlug;
    }

    @Override
    public void setPlug(TypePlug typePlug) {
        this.typePlug = typePlug;
    }

}
