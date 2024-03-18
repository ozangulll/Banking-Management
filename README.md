# Banking Management System

The Banking Management System is a JavaFX application designed to manage customer and account information for a bank. It provides functionalities for managing customers and their associated accounts.

## Features

- **Customer Management:**
  - Fetch customer information by ID
  - Save new customer records
  - Update existing customer records
  - Delete customer records

- **Account Management:**
  - Fetch account information by ID
  - Save new account records
  - Update existing account records
  - Delete account records

## Project Structure

The project consists of the following components:

- **Controller Classes:** 
  - `CustomerController.java`: Handles user interactions and business logic related to customer management.
  - `AccountController.java`: Handles user interactions and business logic related to account management.
  
- **Repository Classes:**
  - `CustomerRepository.java`: Responsible for database operations related to customer data.
  - `AccountRepository.java`: Responsible for database operations related to account data.

- **Main Application Class:**
  - `StartApplication.java`: Initializes the JavaFX application and sets up the user interface.

- **FXML Files:**
  - `account-view.fxml`: Defines the layout and components for the account management view.
  - `customer-view.fxml`: Defines the layout and components for the customer management view.

## Technologies Used

- **JavaFX:** Used for building the graphical user interface.
- **MySQL:** Used as the database management system to store customer and account information.
  
# Contributors
https://github.com/ozangulll

https://github.com/munevvernure
## How to Run

1. Clone the project repository.
2. Set up a MySQL database and configure the connection details in the repository classes (`AccountRepository.java` and `CustomerRepository.java`).
3. Run the `StartApplication.java` file to start the application.

## License

This project is licensed under the Apache License 2.0. See the [LICENSE](LICENSE) file for details.
