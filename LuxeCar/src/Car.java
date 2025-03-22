import java.util.Scanner;

public class Car {
    private String car_name;
    private String car_color;
    private String car_fuel_type;
    private int car_price;
    private String car_type;
    private String car_transmission;

    public String getCarName() {
        return car_name;
    }

    public void setCarName(String car_name) {
        this.car_name = car_name;
    }

    public String getCarColor() {
        return car_color;
    }

    public void setCarColor(String car_color) {
        this.car_color = car_color;
    }

    public String getCarFuelType() {
        return car_fuel_type;
    }

    public void setCarFuelType(String car_fuel_type) {
        this.car_fuel_type = car_fuel_type;
    }

    public String getCarTransmission() {
        return car_transmission;
    }

    public void setCarTransmission(String car_transmission) {
        this.car_transmission = car_transmission;
    }

    public String getCarType() {
        return car_type;
    }

    public void setCarType(String car_type) {
        this.car_type = car_type;
    }

    public void getDetails() {
        System.out.println("Car Name: " + car_name);
        System.out.println("Car Color: " + car_color);
        System.out.println("Car Fuel Type: " + car_fuel_type);
        System.out.println("Car Price: " + car_price);
        System.out.println("Car Type: " + car_type);
        System.out.println("Car Transmission: " + car_transmission);
    }

    public void setDetails(Scanner sc) {
        System.out.println("======================= *** ENTER CAR DETAILS *** =======================");
        System.out.print("Car Name: ");
        car_name = sc.nextLine();
        System.out.print("Car Color: ");
        car_color = sc.nextLine();
        System.out.print("Car Fuel Type: ");
        car_fuel_type = sc.nextLine();
        System.out.print("Car Price: ");
        car_price = sc.nextInt();
        sc.nextLine();
        System.out.print("Car Type: ");
        car_type = sc.nextLine();
        System.out.print("Car Transmission: ");
        car_transmission = sc.nextLine();
    }

    public String toFileFormat() {
        return car_name + "," + car_color + "," + car_fuel_type + "," + car_price + "," + car_type + "," + car_transmission;
    }

    public void fromFileFormat(String data) {
        String[] fields = data.split(",");
        car_name = fields[0];
        car_color = fields[1];
        car_fuel_type = fields[2];
        car_price = Integer.parseInt(fields[3]);
        car_type = fields[4];
        car_transmission = fields[5];
    }
}
