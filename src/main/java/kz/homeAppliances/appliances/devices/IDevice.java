package kz.homeAppliances.appliances.devices;

import kz.homeAppliances.appliances.devices.devicesPlug.TypePlug;

/**
 * Типизирующий интерфейс.
 *
 */
public interface IDevice extends Comparable <IDevice>{
    /**
     * Включен ли прибор
     * в сеть.
     *
     * @return true если включен,
     * false если нет
     */
    boolean isOn();

    /**
     * Возвращает мощность прибора.
     *
     * @return мощность прибора
     */
    int getPower();

    /**
     * Получить текущую розетку.
     *
     * @return текущую розетку
     */
    TypePlug getPlug();

    /**
     * Установить новую розетку.
     *
     * @param plug новая розетка
     */
    void setPlug(TypePlug plug);

    Device clone() throws CloneNotSupportedException;

    @Override
    int compareTo(IDevice o);
}
