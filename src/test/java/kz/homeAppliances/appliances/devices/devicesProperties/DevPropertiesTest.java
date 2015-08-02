package kz.homeAppliances.appliances.devices.devicesProperties;

import kz.homeAppliances.appliances.devices.devicesType.TypeDevices;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static kz.homeAppliances.appliances.devices.devicesProperties.DevProperties.getProperties;
import static org.junit.Assert.*;

/**
 * Test for input from file
 */
public class DevPropertiesTest {

    @Test
    public void testGetProperties() throws Exception {
        Map<TypeDevices, Integer> expectedValues = new HashMap<>();
        expectedValues.put(TypeDevices.KETTLE, 1000);
        expectedValues.put(TypeDevices.COMPUTER, 600);
        expectedValues.put(TypeDevices.TV, 500);
        expectedValues.put(TypeDevices.LAMP, 300);
        expectedValues.put(TypeDevices.COOKER, 2000);
        DevProperties devProperties = new DevProperties();
        Map<TypeDevices, Integer> actualValues = getProperties();
        for (Map.Entry<TypeDevices, Integer> e : expectedValues.entrySet()) {
            assertEquals(e.getValue(), actualValues.get(e.getKey()));
        }
    }
}