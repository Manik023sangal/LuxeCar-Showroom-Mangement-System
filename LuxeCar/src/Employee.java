import java.util.Scanner;
import java.util.UUID;

public class Employee {
    private String emp_id;
    private String emp_name;
    private int emp_age;
    private String emp_department;
    private String showroom_name;

    public String getEmpId() {
        return emp_id;
    }

    public void getDetails() {
        System.out.println("ID: " + emp_id);
        System.out.println("Name: " + emp_name);
        System.out.println("Age: " + emp_age);
        System.out.println("Department: " + emp_department);
        System.out.println("Showroom Name: " + showroom_name);
    }

    public void setDetails(Scanner sc) {
        UUID uuid = UUID.randomUUID();
        emp_id = String.valueOf(uuid);
        System.out.println("======================= *** ENTER EMPLOYEE DETAILS *** =======================");
        System.out.print("Employee Name: ");
        emp_name = sc.nextLine();
        System.out.print("Employee Age: ");
        emp_age = sc.nextInt();
        sc.nextLine();
        System.out.print("Employee Department: ");
        emp_department = sc.nextLine();
        System.out.print("Showroom Name: ");
        showroom_name = sc.nextLine();
    }

    public String toFileFormat() {
        return emp_id + "," + emp_name + "," + emp_age;
    }

    public void fromFileFormat(String data) {
        String[] fields = data.split(",");
        emp_id = fields[0];
        emp_name = fields[1];
        emp_age = Integer.parseInt(fields[2]);
    }

    public String getShowroomName() {
        return showroom_name;
    }
}
