import java.util.Scanner;

class RentalSystem {
    private SimpleArrayList customers;
    private SimpleArrayList videos;
    private SimpleArrayList rentedVideos; // Barcode

    public RentalSystem() {
        this.customers = new SimpleArrayList();
        this.videos = new SimpleArrayList();
        this.rentedVideos = new SimpleArrayList();
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public void addVideo(Video video) {
        videos.add(video);
    }

    public void rentMovie(String phoneNumber, String barcode) {
        if (!isCustomerExist(phoneNumber) || !isVideoExist(barcode) || isVideoRented(barcode)
                || getRentedMoviesCount(phoneNumber) >= 3) {
            System.out.println("Cannot rent the movie. Check customer, video, or rental limit.");
            return;
        }

        rentedVideos.add(barcode);
        System.out.println("Movie rented successfully!");
    }

    public void returnMovie(String phoneNumber, String barcode) {
        if (!isCustomerExist(phoneNumber) || !isVideoExist(barcode) || !isVideoRentedByCustomer(barcode)) {
            System.out.println("Cannot return the movie. Check customer, video, or rental information.");
            return;
        }

        rentedVideos.remove(barcode);
        System.out.println("Movie returned successfully!");
    }

    public void findRenter(String movieTitle) {
        for (int i = 0; i < videos.size(); i++) {
            Video video = (Video) videos.get(i);
            if (video.getTitle().toLowerCase().contains(movieTitle.toLowerCase())) {
                String barcode = video.getBarcode();
                if (rentedVideos.contains(barcode)) {
                    System.out.println("Movie '" + video.getTitle() + "' is rented");
                } else {
                    System.out.println("Movie '" + video.getTitle() + "' is not currently rented.");
                }
            }
        }
    }

    private boolean isCustomerExist(String phoneNumber) {
        for (int i = 0; i < customers.size(); i++) {
            Customer customer = (Customer) customers.get(i);
            if (customer.getPhoneNumber().equals(phoneNumber)) {
                return true;
            }
        }
        return false;
    }

    private boolean isVideoExist(String barcode) {
        for (int i = 0; i < videos.size(); i++) {
            Video video = (Video) videos.get(i);
            if (video.getBarcode().equals(barcode)) {
                return true;
            }
        }
        return false;
    }

    private boolean isVideoRented(String barcode) {
        return rentedVideos.contains(barcode);
    }

    private boolean isVideoRentedByCustomer(String barcode) {
        return rentedVideos.contains(barcode);
    }

    private int getRentedMoviesCount(String phoneNumber) {
        int count = 0;
        for (int i = 0; i < rentedVideos.size(); i++) {
            // Assuming rentedVideos contains only barcodes
            String barcode = (String) rentedVideos.get(i);
            if (isVideoRentedByCustomer(barcode)) {
                count++;
            }
        }
        return count;
    }

    // Add a customer to the system from user input
    public void addCustomerFromInput(Scanner scanner) {
        System.out.print("Enter customer phone number: ");
        String phoneNumber = scanner.next();
        System.out.print("Enter customer first name: ");
        String firstName = scanner.next();
        System.out.print("Enter customer last name: ");
        String lastName = scanner.next();

        Customer customer = new Customer(phoneNumber, firstName, lastName);
        addCustomer(customer);
        System.out.println("Customer added successfully!");
    }

    // Add a video to the system from user input
    public void addVideoFromInput(Scanner scanner) {
        System.out.print("Enter video barcode: ");
        String barcode = scanner.next();
        System.out.print("Enter video title: ");
        String title = scanner.next();

        Video video = new Video(barcode, title);
        addVideo(video);
        System.out.println("Video added successfully!");
    }

    // Rent a movie to a customer from user input
    public void rentMovieFromInput(Scanner scanner) {
        System.out.print("Enter customer phone number: ");
        String phoneNumber = scanner.next();
        System.out.print("Enter video barcode: ");
        String barcode = scanner.next();

        rentMovie(phoneNumber, barcode);
    }

    // Return a movie from a customer from user input
    public void returnMovieFromInput(Scanner scanner) {
        System.out.print("Enter customer phone number: ");
        String phoneNumber = scanner.next();
        System.out.print("Enter video barcode: ");
        String barcode = scanner.next();

        returnMovie(phoneNumber, barcode);
    }

    // Find the renter of a movie by title from user input
    public void findRenterFromInput(Scanner scanner) {
        System.out.print("Enter video title: ");
        String movieTitle = scanner.next();

        findRenter(movieTitle);
    }
}