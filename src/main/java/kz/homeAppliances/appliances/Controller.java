package kz.homeAppliances.appliances;

import kz.homeAppliances.appliances.devices.IDevice;
import kz.homeAppliances.appliances.devices.SortByPower;
import kz.homeAppliances.appliances.devices.SortByState;
import kz.homeAppliances.appliances.devices.devicesGenerator.GenerateDevices;
import kz.homeAppliances.appliances.devices.devicesProperties.DevProperties;
import kz.homeAppliances.appliances.exceptions.LoadPropFromFileException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Общий контроллер
 *
 */
public class Controller {
    private List<IDevice> devices;
    private GenerateDevices generate;

    /**
     * Возвращает определенным образом
     * отформатированную для вывода
     * строку со списком устройств.
     *
     * @param devices список устройств
     * @return строка со списком устройств
     */
    private String getOutput(List<IDevice> devices) {
        StringBuilder sb = new StringBuilder();
        int totalOnPower = 0;
        int countOnPower = 0;
        for (IDevice device : devices) {
            sb.append(device).append("\n");
            if (device.isOn()) {
                totalOnPower += device.getPower();
                countOnPower++;
            }
        }
        sb.append("\nTotal ON count: ").append(countOnPower)
                .append("\nTotal ON power: ").append(totalOnPower);
        return sb.toString();
    }

    /**
     * Выполняется инициализация
     * списка для устройств, генератора
     * устройств и подгрузчика данных
     * из файла.
     *
     */
    public Controller() {
        try {
            DevProperties devProperties = new DevProperties();
        } catch (LoadPropFromFileException e) {
            System.out.println(e.getMessage());
            System.exit(0);
        }
        this.devices = new ArrayList<>();
        generate = new GenerateDevices(devices);
    }

    /**
     * Генерирует заданное количество устройств
     *
     * @param countOfDevices задонное кол-во
     *                       устройств
     */
    public void generateDevices(int countOfDevices) {
        if (countOfDevices > 0) generate.add(countOfDevices);
        else System.out.println("Cant generate " + countOfDevices + " devices");
    }

    /**
     * Сортировка по состоянию
     * и мощности.
     *
     */
    public void sort() {
        Collections.sort(devices);
    }

    /**
     * Сортировка по мощности.
     *
     */
    public void sortByPower() {
        Collections.sort(devices, new SortByPower());
    }

    /**
     * Сортировка по состонию.
     *
     */
    public void sortByState() {
        Collections.sort(devices, new SortByState());
    }

    /**
     * Форматирование входящей коллекции
     * к определенному виду, с подсчетом
     * количества включенных приборов и
     * их совокупной мощности.
     *
     * @return строка определенного вида
     */
    public String getOutput() {
        return getOutput(devices);
    }

    /**
     * Поиск приборов входящих
     * в заданный диапазон мошности, включительно,
     * и клонирование их в коллекцию найденных
     *
     * @param startPower начальное значение
     *                   мощности
     * @param endPower конечное значение
     *                 мощности
     * @return возвращает коллекцию найденных приборов
     * отформатированную методом getOutput()
     */
    public String foundByPower(int startPower, int endPower) {
        List<IDevice> foundDevices = new ArrayList<>();
        for (IDevice device : devices) {
            if (device.getPower() >= startPower
                    && device.getPower() <= endPower) try {
                foundDevices.add(device.clone());
            } catch (CloneNotSupportedException e) {
                    System.out.println("Cloning error");
            }
        }
        return getOutput(foundDevices);
    }

}
