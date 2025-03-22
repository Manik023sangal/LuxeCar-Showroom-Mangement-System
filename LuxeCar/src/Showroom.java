import java.util.Scanner;

public class Showroom {
    private String showroom_name;
    private String showroom_address;
    private int total_employees;
    private String manager_name;

    public String getShowroomName() {
        return showroom_name;
    }

    public void getDetails() {
        System.out.println("Showroom Name: " + showroom_name);
        System.out.println("Showroom Address: " + showroom_address);
        System.out.println("Manager Name: " + manager_name);
        System.out.println("Total Employees: " + total_employees);
    }

    public void setDetails(Scanner sc) {
        System.out.println("======================= *** ENTER SHOWROOM DETAILS *** =======================");
        System.out.print("Showroom Name: ");
        showroom_name = sc.nextLine();
        System.out.print("Showroom Address: ");
        showroom_address = sc.nextLine();
        System.out.print("Manager Name: ");
        manager_name = sc.nextLine();
        System.out.print("Total Employees: ");
        total_employees = sc.nextInt();
        sc.nextLine();  // Consume the newline character
    }

    public String toFileFormat() {
        return showroom_name + "," + showroom_address + "," + manager_name + "," + total_employees;
    }

    public void fromFileFormat(String data) {
        String[] fields = data.split(",");
        showroom_name = fields[0];
        showroom_address = fields[1];
        manager_name = fields[2];
        total_employees = Integer.parseInt(fields[3]);
    }
}
