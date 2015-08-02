package kz.homeAppliances.appliances.devices;

import kz.homeAppliances.appliances.devices.devicesPlug.TypePlug;
import kz.homeAppliances.appliances.devices.devicesType.TypeDevices;

/**
 * Устройство с евро розеткой
 */
public class EuroplugDevice extends Device {
    private TypePlug typePlug;

    public EuroplugDevice(TypeDevices typeOfDevice,
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
