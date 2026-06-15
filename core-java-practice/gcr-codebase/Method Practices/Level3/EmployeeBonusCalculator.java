package level3;

import java.util.Scanner;

/**
 * EmployeeBonusCalculator - Calculate employee bonus based on salary and performance
 */
public class EmployeeBonusCalculator {
    
    /**
     * Represents an employee
     */
    static class Employee {
        String name;
        double salary;
        String performanceRating;
        
        Employee(String name, double salary, String performanceRating) {
            this.name = name;
            this.salary = salary;
            this.performanceRating = performanceRating;
        }
    }
    
    /**
     * Calculates bonus percentage based on performance rating
     * @param rating Performance rating (Excellent/Good/Average/Poor)
     * @return Bonus percentage
     */
    public static double getBonusPercentage(String rating) {
        return switch (rating.toLowerCase()) {
            case "excellent" -> 0.15;
            case "good" -> 0.10;
            case "average" -> 0.05;
            case "poor" -> 0.0;
            default -> 0.0;
        };
    }
    
    /**
     * Calculates bonus amount
     * @param employee Employee object
     * @return Bonus amount
     */
    public static double calculateBonus(Employee employee) {
        double percentage = getBonusPercentage(employee.performanceRating);
        return employee.salary * percentage;
    }
    
    /**
     * Calculates total salary with bonus
     * @param employee Employee object
     * @return Total salary with bonus
     */
    public static double getTotalSalary(Employee employee) {
        return employee.salary + calculateBonus(employee);
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter employee name: ");
        String name = sc.nextLine();
        
        System.out.print("Enter salary: ");
        double salary = sc.nextDouble();
        sc.nextLine();
        
        System.out.print("Enter performance rating (Excellent/Good/Average/Poor): ");
        String rating = sc.nextLine();
        
        Employee emp = new Employee(name, salary, rating);
        double bonus = calculateBonus(emp);
        double total = getTotalSalary(emp);
        
        System.out.println("\n--- Employee Bonus Calculation ---");
        System.out.println("Name: " + emp.name);
        System.out.println("Base Salary: " + emp.salary);
        System.out.println("Performance Rating: " + emp.performanceRating);
        System.out.println("Bonus Percentage: " + (getBonusPercentage(emp.performanceRating) * 100) + "%");
        System.out.println("Bonus Amount: " + bonus);
        System.out.println("Total Salary: " + total);
        
        sc.close();
    }
}
