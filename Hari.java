import java.util.Scanner;

public class Hari {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create an employee
        System.out.print("Enter Employee ID: ");
        int employeeId = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        System.out.print("Enter Employee Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Basic Salary: ");
        double basicSalary = scanner.nextDouble();

        Employee employee = new Employee(employeeId, name, basicSalary);

        // Calculate and display salary details
        Salary salary = new Salary(employee);

        System.out.println("\nSalary Details:");
        System.out.println("Employee ID: " + employee.getEmployeeId());
        System.out.println("Employee Name: " + employee.getName());
        System.out.println("Basic Salary: " + employee.getBasicSalary());
        System.out.println("Gross Salary: " + salary.getGrossSalary());
        System.out.println("Net Salary: " + salary.getNetSalary());

        // Calculate and display income tax
        double taxableIncome = salary.getGrossSalary(); // For simplicity, considering gross salary as taxable income
        double incomeTax = TaxCalculator.calculateIncomeTax(taxableIncome);

        System.out.println("\nIncome Tax Details:");
        System.out.println("Taxable Income: " + taxableIncome);
        System.out.println("Income Tax: " + incomeTax);

        scanner.close();
    }
}

class Employee {
    private int employeeId;
    private String name;
    private double basicSalary;

    public Employee(int employeeId, String name, double basicSalary) {
        this.employeeId = employeeId;
        this.name = name;
        this.basicSalary = basicSalary;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public double getBasicSalary() {
        return basicSalary;
    }
}

class Salary {
    private Employee employee;
    private double grossSalary;
    private double netSalary;

    public Salary(Employee employee) {
        this.employee = employee;
        calculateGrossSalary();
        calculateNetSalary();
    }

    private void calculateGrossSalary() {
        // You can define your own formula for calculating gross salary
        // For simplicity, let's assume gross salary is the same as basic salary in this
        // example
        grossSalary = employee.getBasicSalary();
    }

    private void calculateNetSalary() {
        // You can implement more sophisticated logic for net salary calculation
        // For simplicity, let's assume net salary is 90% of the gross salary
        netSalary = 0.9 * grossSalary;
    }

    public double getGrossSalary() {
        return grossSalary;
    }

    public double getNetSalary() {
        return netSalary;
    }
}

class TaxCalculator {
    private static final double INCOME_TAX_RATE = 0.1;

    public static double calculateIncomeTax(double taxableIncome) {
        return taxableIncome * INCOME_TAX_RATE;
    }
}
