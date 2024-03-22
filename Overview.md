# Video Rental System

## Overview

This project implements a video rental system for a store called "Paul's Video Store". The system allows users to manage customers, videos, and rentals. It's built in Java without using built-in data structures such as ArrayList or LinkedList, adhering to specific requirements.

### Files:

1. `Customer.java`: 
   - **Purpose**: Represents a customer in the video rental system. Encapsulates customer information including phone number, first name, and last name.
   - **Attributes**:
     - `phoneNumber`: String representing the customer's phone number.
     - `firstName`: String representing the customer's first name.
     - `lastName`: String representing the customer's last name.
   - **Methods**:
     - `getPhoneNumber()`: Returns the phone number of the customer.
     - `getFirstName()`: Returns the first name of the customer.
     - `getLastName()`: Returns the last name of the customer.
     - `getFullName()`: Returns the full name of the customer (concatenation of first name and last name).

2. `PaulsVideoStoreMain.java`: 
   - **Purpose**: Main class of the application providing a text-based user interface for interacting with the video rental system.
   - **Methods**:
     - User input handling methods for adding customers, adding videos, renting movies, returning movies, finding renters of a movie, and exiting the program.

3. `RentalSystem.java`: 
   - **Purpose**: Implements the core logic of the video rental system. Manages customers, videos, and rentals using custom data structures (`SimpleArrayList`).
   - **Attributes**:
     - `customers`: Custom ArrayList storing customers.
     - `videos`: Custom ArrayList storing videos.
     - `rentedVideos`: Custom ArrayList storing rented videos.
   - **Methods**:
     - Methods for adding customers and videos, renting and returning movies, finding renters of a movie, and other operations related to the rental system.

4. `SimpleArrayList.java`: 
   - **Purpose**: Custom implementation of an ArrayList data structure.
   - **Attributes**:
     - `elements`: Array to store elements.
     - `size`: Current number of elements in the array.
   - **Methods**:
     - `add(T element)`: Adds an element to the ArrayList.
     - `get(int index)`: Retrieves the element at the specified index.
     - `size()`: Returns the number of elements in the ArrayList.

5. `Video.java`: 
   - **Purpose**: Represents a video available for rental in the video rental system.
   - **Attributes**:
     - `barcode`: String representing the barcode of the video.
     - `title`: String representing the title of the video.
   - **Methods**:
     - `getBarcode()`: Returns the barcode of the video.
     - `getTitle()`: Returns the title of the video.

## How to Run:

To run the application, compile all Java files and execute the `PaulsVideoStoreMain` class. Follow the on-screen instructions to interact with the video rental system.
