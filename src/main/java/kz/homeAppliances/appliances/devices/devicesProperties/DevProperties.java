package kz.homeAppliances.appliances.devices.devicesProperties;

import kz.homeAppliances.appliances.devices.devicesType.TypeDevices;
import kz.homeAppliances.appliances.exceptions.LoadPropFromFileException;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Подгружаем мощность приборов из файла.
 *
 */
public class DevProperties {
    private static Map<TypeDevices, Integer> priceFromFile = new HashMap<>();

    private void loadProperties() throws LoadPropFromFileException {
        try {
            Properties properties = new Properties();
            FileInputStream fis = new FileInputStream("devices.txt");
            properties.load(fis);
            for (int i = 0; i < TypeDevices.values().length; i++) {
                priceFromFile.put(TypeDevices.values()[i],
                        Integer.valueOf(properties.getProperty(
                                TypeDevices.values()[i].name())));
            }
        } catch (IOException e) {
            throw new LoadPropFromFileException("Error with loading file");
        }
    }

    public DevProperties() throws LoadPropFromFileException {
        loadProperties();
    }

    public static Map<TypeDevices, Integer> getProperties() {
        return priceFromFile;
    }
}
