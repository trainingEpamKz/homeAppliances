package kz.homeAppliances.appliances.devices;

import java.util.Comparator;

/**
 * Компаратор для сортировки
 * по состоянию(ON/OFF).
 *
 */
public class SortByState implements Comparator<IDevice> {
    @Override
    public int compare(IDevice o1, IDevice o2) {
        if (!o1.isOn() && o2.isOn()) {
            return 1;
        } else if (o1.isOn() && !o2.isOn()) {
            return -1;
        } else return 0;
    }
}
