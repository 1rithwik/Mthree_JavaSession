package main.sep_18;

public class Employee {
    String name;
    String city;
    String country;
    int salary;
    int age;
    String department;
    String designation;
    String company_name;
    static boolean is_employee_of_the_month = true;

    public void printDetails() {
        System.out.println("Name: " + name);
        System.out.println("City: " + city);
        System.out.println("Country: " + country);
        System.out.println("Salary: " + salary);
        System.out.println("Age: " + age);
        System.out.println("Department: " + department);
        System.out.println("Designation: " + designation);
        System.out.println("Company Name: " + company_name);
        System.out.println("Is Employee of the Month: " + is_employee_of_the_month);
    }

    public void setDetails(String name, String city, String country, int salary, int age, String department,
            String designation, String company_name) {
        this.name = name;
        this.city = city;
        this.country = country;
        this.salary = salary;
        this.age = age;
        this.department = department;
        this.designation = designation;
        this.company_name = company_name;
    }

    public void setIsEmployeeOfTheMonth(boolean is_employee_of_the_month) {
        Employee.is_employee_of_the_month = is_employee_of_the_month;
    }

    public Employee(String name, String city, String country, int salary, int age, String department,
            String designation, String company_name) {
        this.name = "John Doe";
        this.city = "New York";
        this.country = "USA";
        this.salary = 10000;
        this.age = 25;
        this.department = "IT";
        this.designation = "Software Engineer";
        this.company_name = "ABC Company";
    }

    public static void main(String[] args) {
        Employee emp1 = new Employee("John Doe", "New York", "USA", 10000, 25, "IT", "Software Engineer",
                "ABC Company");
        emp1.printDetails();
        emp1.setDetails("Diya", "London", "UK", 1000, 27, "Finance", "Manager", "XYZ Company");
        emp1.setIsEmployeeOfTheMonth(false);
        emp1.printDetails();
        System.out.println(is_employee_of_the_month);
    }
}
