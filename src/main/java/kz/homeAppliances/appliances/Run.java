package kz.homeAppliances.appliances;

/**
 * Точка входа.
 *
 */
public class Run {
    public static void main(String[] args) {
        Controller controller = new Controller();
        controller.generateDevices(10);
        System.out.println("\nGenerated:");
        System.out.println(controller.getOutput());
        System.out.println("\nsorted by Comparable(State off/on & Power n/n+1):");
        controller.sort();
        System.out.println(controller.getOutput());
        System.out.println("\nsorted by Comparator SortByState():");
        controller.sortByState();
        System.out.println(controller.getOutput());
        System.out.println("\nsorted by Comparator SortByPower():");
        controller.sortByPower();
        System.out.println(controller.getOutput());
        System.out.println("\nFound [300 - 600]:");
        System.out.println(controller.foundByPower(300, 600));
    }
}
