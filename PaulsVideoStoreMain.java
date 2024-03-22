import java.util.Scanner;

public class PaulsVideoStoreMain {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        RentalSystem rentalSystem = new RentalSystem();

        // Test case: Adding a customer
        Customer customer = new Customer("1234567890", "John", "Doe");
        rentalSystem.addCustomer(customer);

        // Test case: Adding a video
        Video video = new Video("086162113031", "Star Wars");
        rentalSystem.addVideo(video);

        // Test case: Renting a movie
        rentalSystem.rentMovie("1234567890", "086162113031");

        // Test case: Returning a movie
        rentalSystem.returnMovie("1234567890", "086162113031");

        // Test case: Finding a renter
        rentalSystem.findRenter("Star Wars");

        System.out.println();

        Customer customer1 = new Customer("0987654321", "Keanu", "Reeves");
        rentalSystem.addCustomer(customer1);

        Video video1 = new Video("012345678901", "John Wick");
        rentalSystem.addVideo(video1);

        rentalSystem.rentMovie("0987654321", "012345678901");

        rentalSystem.findRenter("John Wick");

        System.out.println();

        // Test case: User interaction with the menu
        while (true) {
            System.out.println("1. Add Customer");
            System.out.println("2. Add Video");
            System.out.println("3. Rent Movie");
            System.out.println("4. Return Movie");
            System.out.println("5. Find Renter");
            System.out.println("6. Exit");

            int choice = 0; // Initialize choice to a default value

            while (true) {
                System.out.print("Enter your choice: ");

                if (scanner.hasNextInt()) {
                    choice = scanner.nextInt();
                    break; // Break out of the loop if input is a valid integer
                } else {
                    System.out.println("Invalid input. Please enter a valid integer.");
                    // Consume the invalid input to avoid an infinite loop
                    scanner.nextLine();
                }
            }

            switch (choice) {
                case 1:
                    rentalSystem.addCustomerFromInput(scanner);
                    break;
                case 2:
                    rentalSystem.addVideoFromInput(scanner);
                    break;
                case 3:
                    rentalSystem.rentMovieFromInput(scanner);
                    break;
                case 4:
                    rentalSystem.returnMovieFromInput(scanner);
                    break;
                case 5:
                    rentalSystem.findRenterFromInput(scanner);
                    break;
                case 6:
                    System.out.println("Exiting program. Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 6.");
            }
        }
    }
}