import java.util.*;
import java.util.Iterator;
import java.util.NoSuchElementException;

// ============================================================
// OOP SCENARIO-BASED PROBLEMS
// ============================================================

// PROBLEM 1: University System
// Inheritance: Multilevel (Person -> Student -> GradStudent)
class Person {
    protected String name;
    protected int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person [Name=" + name + ", Age=" + age + "]";
    }
}

class Student extends Person {
    protected final int studentId; // final keyword used
    protected double gpa;

    public Student(String name, int age, int studentId, double gpa) {
        super(name, age); // constructor chaining with super()
        this.studentId = studentId;
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return "Student [ID=" + studentId + ", Name=" + name + 
               ", Age=" + age + ", GPA=" + gpa + "]";
    }
}

class GradStudent extends Student {
    private String thesis;

    public GradStudent(String name, int age, int studentId, 
                       double gpa, String thesis) {
        super(name, age, studentId, gpa); // super() with parameters
        this.thesis = thesis;
    }

    @Override
    public String toString() {
        return "GradStudent [ID=" + studentId + ", Name=" + name + 
               ", Age=" + age + ", GPA=" + gpa + ", Thesis=" + thesis + "]";
    }
}

// PROBLEM 2: Library Management
// Inheritance: Single (Book superclass -> Author subclass)
class Book {
    protected String title;
    protected int publicationYear;

    public Book(String title, int publicationYear) {
        this.title = title;
        this.publicationYear = publicationYear;
    }

    public void displayInfo() {
        System.out.println("Title: " + title);
        System.out.println("Publication Year: " + publicationYear);
    }
}

class Author extends Book {
    private String authorName;
    private String bio;

    public Author(String title, int publicationYear, 
                  String authorName, String bio) {
        super(title, publicationYear);
        this.authorName = authorName;
        this.bio = bio;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Author: " + authorName);
        System.out.println("Bio: " + bio);
    }
}

// PROBLEM 3: Online Retail Order Management
// Inheritance: Multilevel (Order -> ShippedOrder -> DeliveredOrder)
class Order {
    protected int orderId;
    protected Date orderDate;

    public Order(int orderId, Date orderDate) {
        this.orderId = orderId;
        this.orderDate = orderDate;
    }

    public String getOrderStatus() {
        return "Order Placed";
    }
}

class ShippedOrder extends Order {
    protected String trackingNumber;

    public ShippedOrder(int orderId, Date orderDate, String trackingNumber) {
        super(orderId, orderDate);
        this.trackingNumber = trackingNumber;
    }

    @Override
    public String getOrderStatus() {
        return "Shipped - Tracking: " + trackingNumber;
    }
}

class DeliveredOrder extends ShippedOrder {
    private Date deliveryDate;

    public DeliveredOrder(int orderId, Date orderDate, 
                          String trackingNumber, Date deliveryDate) {
        super(orderId, orderDate, trackingNumber);
        this.deliveryDate = deliveryDate;
    }

    @Override
    public String getOrderStatus() {
        return "Delivered on " + deliveryDate;
    }
}

// PROBLEM 4: Vehicle Management System with Hybrid Inheritance
// Hierarchy: Vehicle (superclass)
//           -> ElectricVehicle (subclass with charge() method)
//           -> PetrolVehicle (subclass implementing Refuelable interface)
interface Refuelable {
    void refuel(double liters);
}

class Vehicle {
    protected String vehicleId;
    protected String brand;

    public Vehicle(String vehicleId, String brand) {
        this.vehicleId = vehicleId;
        this.brand = brand;
    }

    public void displayInfo() {
        System.out.println("Vehicle ID: " + vehicleId);
        System.out.println("Brand: " + brand);
    }
}

class ElectricVehicle extends Vehicle {
    private double batteryLevel;

    public ElectricVehicle(String vehicleId, String brand, double batteryLevel) {
        super(vehicleId, brand);
        this.batteryLevel = batteryLevel;
    }

    public void charge(double amount) {
        batteryLevel = Math.min(100, batteryLevel + amount);
        System.out.println("Charged. Battery: " + batteryLevel + "%");
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Type: Electric, Battery: " + batteryLevel + "%");
    }
}

class PetrolVehicle extends Vehicle implements Refuelable {
    private double fuelLevel;

    public PetrolVehicle(String vehicleId, String brand, double fuelLevel) {
        super(vehicleId, brand);
        this.fuelLevel = fuelLevel;
    }

    @Override
    public void refuel(double liters) {
        fuelLevel += liters;
        System.out.println("Refueled. Fuel: " + fuelLevel + "L");
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Type: Petrol, Fuel: " + fuelLevel + "L");
    }
}

// PROBLEM 5: Smart Home Devices
// Inheritance: Single (Device -> Thermostat)
class Device {
    protected String deviceId;
    protected boolean status;

    public Device(String deviceId, boolean status) {
        this.deviceId = deviceId;
        this.status = status;
    }

    public void displayStatus() {
        System.out.println("Device ID: " + deviceId);
        System.out.println("Status: " + (status ? "ON" : "OFF"));
    }
}

class Thermostat extends Device {
    private double temperatureSetting;

    public Thermostat(String deviceId, boolean status, double temperatureSetting) {
        super(deviceId, status);
        this.temperatureSetting = temperatureSetting;
    }

    @Override
    public void displayStatus() {
        super.displayStatus();
        System.out.println("Temperature Setting: " + temperatureSetting + "C");
    }
}

// PROBLEM 6: Educational Course Hierarchy
// Inheritance: Multilevel (Course -> OnlineCourse -> PaidOnlineCourse)
class Course {
    protected String courseName;
    protected int duration; // in hours

    public Course(String courseName, int duration) {
        this.courseName = courseName;
        this.duration = duration;
    }

    public void displayInfo() {
        System.out.println("Course: " + courseName + ", Duration: " + duration + "h");
    }
}

class OnlineCourse extends Course {
    protected String platform;
    protected boolean isRecorded;

    public OnlineCourse(String courseName, int duration, 
                        String platform, boolean isRecorded) {
        super(courseName, duration);
        this.platform = platform;
        this.isRecorded = isRecorded;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Platform: " + platform + 
                           ", Recorded: " + isRecorded);
    }
}

class PaidOnlineCourse extends OnlineCourse {
    private double fee;
    private double discount;

    public PaidOnlineCourse(String courseName, int duration, 
                            String platform, boolean isRecorded,
                            double fee, double discount) {
        super(courseName, duration, platform, isRecorded);
        this.fee = fee;
        this.discount = discount;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Fee: $" + fee + ", Discount: $" + discount);
        System.out.println("Final Price: $" + (fee - discount));
    }
}

// PROBLEM 7: Restaurant Management with Hybrid Inheritance
// Hierarchy: Person (superclass)
//           -> Chef (subclass)
//           -> Waiter (subclass implementing Worker interface)
// Hybrid = Multilevel + Interface-based
interface Worker {
    void performDuties();
}

class Person2 {
    protected String name;
    protected int employeeId;

    public Person2(String name, int employeeId) {
        this.name = name;
        this.employeeId = employeeId;
    }

    public void basicInfo() {
        System.out.println("Employee: " + name + " (ID: " + employeeId + ")");
    }
}

class Chef extends Person2 {
    private String specialty;

    public Chef(String name, int employeeId, String specialty) {
        super(name, employeeId);
        this.specialty = specialty;
    }

    @Override
    public void performDuties() {
        basicInfo();
        System.out.println("Duty: Cooking " + specialty + " dishes");
    }
}

class Waiter extends Person2 implements Worker {
    private String section;

    public Waiter(String name, int employeeId, String section) {
        super(name, employeeId);
        this.section = section;
    }

    @Override
    public void performDuties() {
        basicInfo();
        System.out.println("Duty: Serving tables in " + section);
    }
}

// ============================================================
// LEETCODE PROBLEMS
// ============================================================

// PROBLEM 1: 173. Binary Search Tree Iterator
// Uses stack for in-order traversal
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class BSTIterator {
    private Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        pushAllLeft(root);
    }

    private void pushAllLeft(TreeNode node) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }

    public int next() {
        TreeNode node = stack.pop();
        pushAllLeft(node.right);
        return node.val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }
}

// PROBLEM 2: 341. Flatten Nested List Iterator
interface NestedInteger {
    public boolean isInteger();
    public Integer getInteger();
    public List<NestedInteger> getList();
}

class NestedIterator implements Iterator<Integer> {
    private List<Integer> flattened;
    private int index;

    public NestedIterator(List<NestedInteger> nestedList) {
        flattened = new ArrayList<>();
        flatten(nestedList);
        index = 0;
    }

    private void flatten(List<NestedInteger> list) {
        for (NestedInteger ni : list) {
            if (ni.isInteger()) {
                flattened.add(ni.getInteger());
            } else {
                flatten(ni.getList());
            }
        }
    }

    @Override
    public Integer next() {
        return flattened.get(index++);
    }

    @Override
    public boolean hasNext() {
        return index < flattened.size();
    }
}

// PROBLEM 3: 200. Number of Islands
class NumberOfIslands {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int rows = grid.length;
        int cols = grid[0].length;
        int islands = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    islands++;
                    dfs(grid, i, j, rows, cols);
                }
            }
        }
        return islands;
    }

    private void dfs(char[][] grid, int i, int j, int rows, int cols) {
        if (i < 0 || i >= rows || j < 0 || j >= cols || grid[i][j] == '0')
            return;
        grid[i][j] = '0'; // mark visited
        dfs(grid, i + 1, j, rows, cols);
        dfs(grid, i - 1, j, rows, cols);
        dfs(grid, i, j + 1, rows, cols);
        dfs(grid, i, j - 1, rows, cols);
    }
}

// PROBLEM 4: 204. Count Primes
class CountPrimes {
    public int countPrimes(int n) {
        if (n <= 2) return 0;
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;

        for (int i = 2; i * i < n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) count++;
        }
        return count;
    }
}

// PROBLEM 5: 219. Contains Duplicate II
class ContainsDuplicateII {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]) && i - map.get(nums[i]) <= k) {
                return true;
            }
            map.put(nums[i], i);
        }
        return false;
    }
}

// PROBLEM 6: 221. Maximal Square
class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return 0;
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] dp = new int[rows + 1][cols + 1];
        int maxSide = 0;

        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    dp[i][j] = Math.min(
                        Math.min(dp[i - 1][j], dp[i][j - 1]),
                        dp[i - 1][j - 1]
                    ) + 1;
                    maxSide = Math.max(maxSide, dp[i][j]);
                }
            }
        }
        return maxSide * maxSide;
    }
}

// PROBLEM 7: 223. Rectangle Area
class RectangleArea {
    public int computeArea(int ax1, int ay1, int ax2, int ay2,
                           int bx1, int by1, int bx2, int by2) {
        int areaA = (ax2 - ax1) * (ay2 - ay1);
        int areaB = (bx2 - bx1) * (by2 - by1);

        int overlapWidth = Math.max(0, Math.min(ax2, bx2) - Math.max(ax1, bx1));
        int overlapHeight = Math.max(0, Math.min(ay2, by2) - Math.max(ay1, by1));
        int overlapArea = overlapWidth * overlapHeight;

        return areaA + areaB - overlapArea;
    }
}

// ============================================================
// MAIN TEST CLASS
// ============================================================
public class ComprehensiveJavaPractice {
    public static void main(String[] args) {
        System.out.println("=".repeat(60));
        System.out.println("PROBLEM 1: University System");
        System.out.println("=".repeat(60));
        
        GradStudent gs = new GradStudent("Alice", 24, 1001, 3.9, "AI in Healthcare");
        System.out.println(gs);
        System.out.println("IS-A: GradStudent IS-A Student IS-A Person");
        
        System.out.println("\n" + "=".repeat(60));
        System.out.println("PROBLEM 2: Library Management");
        System.out.println("=".repeat(60));
        
        Book book = new Author("Clean Code", 2008, "Robert Martin", "Software Expert");
        book.displayInfo();
        
        System.out.println("\n" + "=".repeat(60));
        System.out.println("PROBLEM 3: Retail Order Management");
        System.out.println("=".repeat(60));
        
        Date today = new Date();
        DeliveredOrder delivered = new DeliveredOrder(1, today, "TRK789", today);
        System.out.println("Order Status: " + delivered.getOrderStatus());
        
        System.out.println("\n" + "=".repeat(60));
        System.out.println("PROBLEM 4: Vehicle Management");
        System.out.println("=".repeat(60));
        
        ElectricVehicle tesla = new ElectricVehicle("EV001", "Tesla", 75);
        PetrolVehicle honda = new PetrolVehicle("PV001", "Honda", 20);
        tesla.displayInfo();
        tesla.charge(25);
        honda.refuel(15);
        honda.displayInfo();
        
        System.out.println("\n" + "=".repeat(60));
        System.out.println("PROBLEM 5: Smart Home Devices");
        System.out.println("=".repeat(60));
        
        Thermostat nest = new Thermostat("DEV001", true, 22.5);
        nest.displayStatus();
        
        System.out.println("\n" + "=".repeat(60));
        System.out.println("PROBLEM 6: Educational Course Hierarchy");
        System.out.println("=".repeat(60));
        
        PaidOnlineCourse course = new PaidOnlineCourse(
            "Java Mastery", 40, "Udemy", true, 199.99, 50.0
        );
        course.displayInfo();
        
        System.out.println("\n" + "=".repeat(60));
        System.out.println("PROBLEM 7: Restaurant Management");
        System.out.println("=".repeat(60));
        
        Chef chef = new Chef("Gordon", 201, "Italian");
        Waiter waiter = new Waiter("John", 301, "Main Hall");
        chef.performDuties();
        waiter.performDuties();
        
        System.out.println("\n" + "=".repeat(60));
        System.out.println("LEETCODE 1: BST Iterator Example");
        System.out.println("=".repeat(60));
        System.out.println("Dry run: [7,3,15,null,null,9,20]");
        System.out.println("Expected Output: 3, 7, 9, 15, 20");
        
        System.out.println("\n" + "=".repeat(60));
        System.out.println("LEETCODE 4: Count Primes Example");
        System.out.println("=".repeat(60));
        CountPrimes cp = new CountPrimes();
        System.out.println("Count primes < 10: " + cp.countPrimes(10));
        
        System.out.println("\n" + "=".repeat(60));
        System.out.println("LEETCODE 7: Rectangle Area Example");
        System.out.println("=".repeat(60));
        RectangleArea ra = new RectangleArea();
        System.out.println("Area: " + ra.computeArea(-3, 0, 3, 4, 0, -1, 9, 2));
    }
}