package kz.homeAppliances.appliances.devices.devicesGenerator;

import kz.homeAppliances.appliances.devices.EuroplugDevice;
import kz.homeAppliances.appliances.devices.IDevice;
import kz.homeAppliances.appliances.devices.ThreepinDevice;
import kz.homeAppliances.appliances.devices.devicesPlug.TypePlug;
import kz.homeAppliances.appliances.devices.devicesType.TypeDevices;

import java.util.List;
import java.util.Random;

/**
 * Генератор приборов.
 *
 */
public class GenerateDevices {
    private List<IDevice> devices;
    private Random random = new Random(47);

    /**
     * Генерирует случайным
     * образом Прибор.
     *
     * @return сгенерированный прибор
     */
    private IDevice getDevice() {
        if (random.nextBoolean())
        return new EuroplugDevice(Enums.random(
                TypeDevices.class), random.nextBoolean(),
                Enums.random(TypePlug.Europlug.class));
        else return new ThreepinDevice(Enums.random(
                TypeDevices.class), random.nextBoolean(),
                Enums.random(TypePlug.Threepin.class));
    }

    /**
     * Конструктор получает пустую
     * коллекцию приборов на вход.
     *
     * @param devices пустая коллекция
     *                приборов
     */
    public GenerateDevices(List<IDevice> devices) {
        this.devices = devices;
    }

    /**
     * Добавление определенного кол-ва
     * приборов.
     *
     * @param countOfDevices количество добавляемых
     *                       приборов
     */
    public void add(int countOfDevices) {
        for (int i = 0; i < countOfDevices; i++) {
            devices.add(getDevice());
        }
    }


    /**
     * Реализация генерации любых
     * перечислений в виде вложенного
     * класса.
     *
     */
    public static class Enums {
        private static Random random = new Random();

        public static <T extends Enum<T>> T random(Class<T> ec) {
            return random(ec.getEnumConstants());
        }

        public static <T> T random(T[] values) {
            return values[random.nextInt(values.length)];
        }
    }

}
