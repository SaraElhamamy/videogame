import java.util.ArrayList;
import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<VideoGame> inventory = new ArrayList<>();

        // populate inventory
        populateInventory(inventory);

        // menu
        int choice;
        do {
            choice = displayMenu(scanner);
            switch (choice) {
                case 1:
                    displayInventory(inventory);
                    break;
                case 2:
                    addGame(inventory, scanner);
                    break;
                case 3:
                    showTotalInventoryValue(inventory);
                    break;
                case 4:
                    System.out.println("Exit Program!");
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        } while (choice != 4);

        scanner.close();
    }
    // Display menu
    public static int displayMenu(Scanner scanner) {
        System.out.println("\nVideo Game Inventory System");
        System.out.println("1) Display Inventory");
        System.out.println("2) Add Game");
        System.out.println("3) Show Total Inventory Value");
        System.out.println("4) Exit");
        System.out.print("Enter Your Choice: ");
        return scanner.nextInt();
    }

    //pre-defined games
    public static void populateInventory(ArrayList<VideoGame> inventory) {
        inventory.add(new VideoGame("The Legend of Zelda", "Switch", 2017, 45.00));
        inventory.add(new VideoGame("Halo Infinite", "Xbox", 2021, 50.00));
        inventory.add(new VideoGame("God of War", "PS4", 2018, 40.00));
        inventory.add(new VideoGame("Minecraft", "PC", 2011, 20.00));
        inventory.add(new VideoGame("Animal Crossing", "Switch", 2020, 45.00));
    }

    // display inventory
    public static void displayInventory(ArrayList<VideoGame> inventory) {
        if (inventory.isEmpty()) {
            System.out.println("No games in inventory.");
            return;
        }

        System.out.println("\nCurrent Video Game Inventory:");
        for (VideoGame game : inventory) {
            System.out.println(game);
        }
    }

    // add a new game
    public static void addGame(ArrayList<VideoGame> inventory, Scanner scanner) {
        scanner.nextLine(); // Consume leftover newline

        System.out.print("Enter game title: ");
        String title = scanner.nextLine();

        System.out.print("Enter platform (e.g., PS4, Xbox, Switch): ");
        String platform = scanner.nextLine();

        System.out.print("Enter release year: ");
        int year = scanner.nextInt();

        System.out.print("Enter wholesale cost: ");
        double wholesaleCost = scanner.nextDouble();

        try {
            inventory.add(new VideoGame(title, platform, year, wholesaleCost));
            System.out.println("New game added to inventory.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    // calculate total inventory value
    public static void showTotalInventoryValue(ArrayList<VideoGame> inventory) {
        double totalWholesale = 0, totalRetail = 0;

        for (VideoGame game : inventory) {
            totalWholesale += game.getWholesaleCost();
            totalRetail += game.getRetailPrice();
        }

        System.out.printf("\nTotal Wholesale Value of Inventory: $%,.2f\n", totalWholesale);
        System.out.printf("Total Retail Value of Inventory: $%,.2f\n", totalRetail);
    }
}
