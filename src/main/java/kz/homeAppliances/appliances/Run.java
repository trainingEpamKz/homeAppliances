package kz.homeAppliances.appliances;

import kz.homeAppliances.appliances.devices.IDevice;
import kz.homeAppliances.appliances.devices.SortByPower;
import kz.homeAppliances.appliances.devices.SortByState;
import kz.homeAppliances.appliances.devices.devicesGenerator.GenerateDevices;
import kz.homeAppliances.appliances.devices.devicesProperties.DevProperties;
import kz.homeAppliances.appliances.exceptions.LoadPropFromFileException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Точка входа.
 *
 */
public class Run {

    /**
     * Форматирование входящей коллекции
     * к определенному виду, с подсчетом
     * количества включенных приборов и
     * их совокупной мощности.
     *
     * @param devices входящая коллекция
     *                приборов
     * @return строка определенного вида
     */
    private static String getArrayAsString(List<IDevice> devices) {
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
     * Сортировка входящего массива
     * по мощности, возрастающей.
     *
     * @param devices входящая коллекция
     *                приборов
     */
    private static void sort(List<IDevice> devices) {
        for (int i = 0; i < devices.size() - 1; i++) {
            for (int j = 0; j < devices.size() - 1; j++) {
                if (devices.get(j).getPower()
                        > devices.get(j + 1).getPower())
                    swap(j, j + 1, devices);
            }
        }
    }

    /**
     * Вспомогательный метод сортировки.
     *
     * @param j индекс большего
     * @param i индекс меньшего
     * @param devices коллекция приборов
     */
    private static void swap(int j, int i, List<IDevice> devices) {
        IDevice swap = devices.get(j);
        devices.set(j, devices.get(i));
        devices.set(i, swap);
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
     * @param devices входящая коллеция приборов
     * @return возвращает коллекцию найденных приборов
     * отформатированную методом getArrayAsString()
     */
    private static String foundByPower(int startPower, int endPower,
                                       List<IDevice> devices) {
        List<IDevice> foundDevices = new ArrayList<>();
        for (IDevice device : devices) {
            if (device.getPower() >= startPower
                    && device.getPower() <= endPower) try {
                foundDevices.add(device.clone());
            } catch (CloneNotSupportedException e) {
                System.out.println("Cloning error");
            }
        }
        return getArrayAsString(foundDevices);
    }

    public static void main(String[] args) {
        List<IDevice> devices = new ArrayList<>();
        try {
            DevProperties devProperties = new DevProperties();
        } catch (LoadPropFromFileException e) {
            System.out.println(e.getMessage());
            System.exit(0);
        }
        GenerateDevices generate = new GenerateDevices(devices);
        generate.add(10);
        System.out.println("\nGenerated:");
        System.out.println(getArrayAsString(devices));
        sort(devices);
        System.out.println("\nSorted by static method:");
        System.out.println(getArrayAsString(devices));
        System.out.println("\nsorted by Comparator SortByPower():");
        Collections.shuffle(devices);
        devices.sort(new SortByPower());
        System.out.println(getArrayAsString(devices));
        System.out.println("\nsorted by Comparator SortByState():");
        Collections.shuffle(devices);
        devices.sort(new SortByState());
        System.out.println(getArrayAsString(devices));
        System.out.println("\nsorted by Comparable(State off/on & Power n/n+1):");
        Collections.shuffle(devices);
        Collections.sort(devices);
        System.out.println(getArrayAsString(devices));
        System.out.println("\nFound [300 - 600]:");
        System.out.println(foundByPower(300, 600, devices));
    }
}
