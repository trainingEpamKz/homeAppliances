package kz.homeAppliances.appliances.devices;


import java.util.Comparator;

/**
 * Компаратор для сортировки
 * по мощности(n/n+1).
 *
 */
public class SortByPower implements Comparator<IDevice> {
    @Override
    public int compare(IDevice o1, IDevice o2) {
        if (o1.getPower() > o2.getPower()) {
            return 1;
        } else if (o1.getPower() < o2.getPower()) {
            return -1;
        } else return 0;
    }
}
