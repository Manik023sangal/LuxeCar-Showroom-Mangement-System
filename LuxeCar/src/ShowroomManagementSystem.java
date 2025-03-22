import java.io.*;
import java.util.*;

public class ShowroomManagementSystem {
    private List<Showroom> showrooms;
    private List<Employee> employees;
    private List<Car> cars;
    private Scanner scanner;

    public ShowroomManagementSystem() {
        showrooms = new ArrayList<>();
        employees = new ArrayList<>();
        cars = new ArrayList<>();
        scanner = new Scanner(System.in);
        loadData();
    }

    public void run() {
        int choice = -1;
        while (choice != 0) {
            displayMainMenu();
            choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline

            switch (choice) {
                case 1: addShowroom(); break;
                case 2: addEmployee(); break;
                case 3: addCar(); break;
                case 4: displayShowrooms(); break;
                case 5: displayEmployees(); break;
                case 6: displayCars(); break;
                case 7: updateShowroom(); break;
                case 8: updateEmployee(); break;
                case 9: updateCar(); break;
                case 10: deleteShowroom(); break;
                case 11: deleteEmployee(); break;
                case 12: deleteCar(); break;
                case 13: searchShowroomByName(); break;
                case 14: searchEmployeeById(); break;
                case 15: searchCarByName(); break;
                case 16: displayTotalCarsInStock(); break;
                case 17: displayShowroomEmployees(); break;
                case 0: System.out.println("Exiting the program..."); break;
                default: System.out.println("Invalid choice. Please try again.");
            }
        }
        saveData();
        scanner.close();
    }

    private void displayMainMenu() {
        System.out.println("\n======================= *** WELCOME TO SHOWROOM MANAGEMENT SYSTEM *** =======================");
        System.out.println("\n=============================== *** ENTER YOUR CHOICE *** ===============================");
        System.out.println("1. ADD SHOWROOM");
        System.out.println("2. ADD EMPLOYEE");
        System.out.println("3. ADD CAR");
        System.out.println("4. DISPLAY SHOWROOMS");
        System.out.println("5. DISPLAY EMPLOYEES");
        System.out.println("6. DISPLAY CARS");
        System.out.println("7. UPDATE SHOWROOM");
        System.out.println("8. UPDATE EMPLOYEE");
        System.out.println("9. UPDATE CAR");
        System.out.println("10. DELETE SHOWROOM");
        System.out.println("11. DELETE EMPLOYEE");
        System.out.println("12. DELETE CAR");
        System.out.println("13. SEARCH SHOWROOM BY NAME");
        System.out.println("14. SEARCH EMPLOYEE BY ID");
        System.out.println("15. SEARCH CAR BY NAME");
        System.out.println("16. DISPLAY TOTAL CARS IN STOCK");
        System.out.println("17. DISPLAY SHOWROOM EMPLOYEES");
        System.out.println("0. EXIT");
        System.out.print("Enter your choice: ");
    }

    private void addShowroom() {
        Showroom showroom = new Showroom();
        showroom.setDetails(scanner);
        showrooms.add(showroom);
        System.out.println("Showroom added successfully!");
    }

    private void addEmployee() {
        Employee employee = new Employee();
        employee.setDetails(scanner);
        employees.add(employee);
        System.out.println("Employee added successfully!");
    }

    private void addCar() {
        Car car = new Car();
        car.setDetails(scanner);
        cars.add(car);
        System.out.println("Car added successfully!");
    }

    private void displayShowrooms() {
        System.out.println("\n======================= *** SHOWROOM DETAILS *** =======================");
        for (Showroom showroom : showrooms) {
            showroom.getDetails();
            System.out.println();
        }
    }

    private void displayEmployees() {
        System.out.println("\n======================= *** EMPLOYEE DETAILS *** =======================");
        for (Employee employee : employees) {
            employee.getDetails();
            System.out.println();
        }
    }

    private void displayCars() {
        System.out.println("\n======================= *** CAR DETAILS *** =======================");
        for (Car car : cars) {
            car.getDetails();
            System.out.println();
        }
    }

    private void saveData() {
        try (BufferedWriter showroomWriter = new BufferedWriter(new FileWriter("showrooms.txt"));
             BufferedWriter employeeWriter = new BufferedWriter(new FileWriter("employees.txt"));
             BufferedWriter carWriter = new BufferedWriter(new FileWriter("cars.txt"))) {

            for (Showroom showroom : showrooms) {
                showroomWriter.write(showroom.toFileFormat());
                showroomWriter.newLine();
            }

            for (Employee employee : employees) {
                employeeWriter.write(employee.toFileFormat());
                employeeWriter.newLine();
            }

            for (Car car : cars) {
                carWriter.write(car.toFileFormat());
                carWriter.newLine();
            }

        } catch (IOException e) {
            System.out.println("Error while saving data: " + e.getMessage());
        }
    }

    private void loadData() {
        try (BufferedReader showroomReader = new BufferedReader(new FileReader("showrooms.txt"));
             BufferedReader employeeReader = new BufferedReader(new FileReader("employees.txt"));
             BufferedReader carReader = new BufferedReader(new FileReader("cars.txt"))) {

            String line;
            while ((line = showroomReader.readLine()) != null) {
                Showroom showroom = new Showroom();
                showroom.fromFileFormat(line);
                showrooms.add(showroom);
            }

            while ((line = employeeReader.readLine()) != null) {
                Employee employee = new Employee();
                employee.fromFileFormat(line);
                employees.add(employee);
            }

            while ((line = carReader.readLine()) != null) {
                Car car = new Car();
                car.fromFileFormat(line);
                cars.add(car);
            }

        } catch (IOException e) {
            System.out.println("Error while loading data: " + e.getMessage());
        }
    }

    // Update Showroom
    private void updateShowroom() {
        System.out.print("Enter Showroom Name to update: ");
        String name = scanner.nextLine();
        Showroom showroom = findShowroomByName(name);
        if (showroom != null) {
            showroom.setDetails(scanner);
            System.out.println("Showroom updated successfully!");
        } else {
            System.out.println("Showroom not found!");
        }
    }

    // Update Employee
    private void updateEmployee() {
        System.out.print("Enter Employee ID to update: ");
        String empId = scanner.nextLine();
        Employee employee = findEmployeeById(empId);
        if (employee != null) {
            employee.setDetails(scanner);
            System.out.println("Employee updated successfully!");
        } else {
            System.out.println("Employee not found!");
        }
    }

    // Update Car
    private void updateCar() {
        System.out.print("Enter Car Name to update: ");
        String carName = scanner.nextLine();
        Car car = findCarByName(carName);
        if (car != null) {
            car.setDetails(scanner);
            System.out.println("Car updated successfully!");
        } else {
            System.out.println("Car not found!");
        }
    }

    // Delete Showroom
    private void deleteShowroom() {
        System.out.print("Enter Showroom Name to delete: ");
        String name = scanner.nextLine();
        Showroom showroom = findShowroomByName(name);
        if (showroom != null) {
            showrooms.remove(showroom);
            System.out.println("Showroom deleted successfully!");
        } else {
            System.out.println("Showroom not found!");
        }
    }

    // Delete Employee
    private void deleteEmployee() {
        System.out.print("Enter Employee ID to delete: ");
        String empId = scanner.nextLine();
        Employee employee = findEmployeeById(empId);
        if (employee != null) {
            employees.remove(employee);
            System.out.println("Employee deleted successfully!");
        } else {
            System.out.println("Employee not found!");
        }
    }

    // Delete Car
    private void deleteCar() {
        System.out.print("Enter Car Name to delete: ");
        String carName = scanner.nextLine();
        Car car = findCarByName(carName);
        if (car != null) {
            cars.remove(car);
            System.out.println("Car deleted successfully!");
        } else {
            System.out.println("Car not found!");
        }
    }

    // Search Showroom by Name
    private void searchShowroomByName() {
        System.out.print("Enter Showroom Name to search: ");
        String name = scanner.nextLine();
        Showroom showroom = findShowroomByName(name);
        if (showroom != null) {
            showroom.getDetails();
        } else {
            System.out.println("Showroom not found!");
        }
    }

    // Search Employee by ID
    private void searchEmployeeById() {
        System.out.print("Enter Employee ID to search: ");
        String empId = scanner.nextLine();
        Employee employee = findEmployeeById(empId);
        if (employee != null) {
            employee.getDetails();
        } else {
            System.out.println("Employee not found!");
        }
    }

    // Search Car by Name
    private void searchCarByName() {
        System.out.print("Enter Car Name to search: ");
        String carName = scanner.nextLine();
        Car car = findCarByName(carName);
        if (car != null) {
            car.getDetails();
        } else {
            System.out.println("Car not found!");
        }
    }

    // Display Total Cars in Stock
    private void displayTotalCarsInStock() {
        System.out.println("Total cars in stock: " + cars.size());
    }

    // Display Showroom Employees
    private void displayShowroomEmployees() {
        System.out.print("Enter Showroom Name to display employees: ");
        String showroomName = scanner.nextLine();
        System.out.println("Employees at showroom: " + showroomName);
        for (Employee employee : employees) {
            if (employee.getShowroomName().equals(showroomName)) {
                employee.getDetails();
            }
        }
    }

    // Helper Methods to find objects by name or ID
    private Showroom findShowroomByName(String name) {
        for (Showroom showroom : showrooms) {
            if (showroom.getShowroomName().equals(name)) {
                return showroom;
            }
        }
        return null;
    }

    private Employee findEmployeeById(String empId) {
        for (Employee employee : employees) {
            if (employee.getEmpId().equals(empId)) {
                return employee;
            }
        }
        return null;
    }

    private Car findCarByName(String carName) {
        for (Car car : cars) {
            if (car.getCarName().equals(carName)) {
                return car;
            }
        }
        return null;
    }
}
