package level2;

import java.util.Scanner;

/**
 * YoungestAndTallestFriend - Find youngest and tallest friend from a group
 */
public class YoungestAndTallestFriend {
    
    /**
     * Represents a friend with name, age, and height
     */
    static class Friend {
        String name;
        int age;
        double height;
        
        Friend(String name, int age, double height) {
            this.name = name;
            this.age = age;
            this.height = height;
        }
    }
    
    /**
     * Finds the youngest friend
     * @param friends Array of friends
     * @return Youngest friend
     */
    public static Friend findYoungest(Friend[] friends) {
        Friend youngest = friends[0];
        for (Friend friend : friends) {
            if (friend.age < youngest.age) {
                youngest = friend;
            }
        }
        return youngest;
    }
    
    /**
     * Finds the tallest friend
     * @param friends Array of friends
     * @return Tallest friend
     */
    public static Friend findTallest(Friend[] friends) {
        Friend tallest = friends[0];
        for (Friend friend : friends) {
            if (friend.height > tallest.height) {
                tallest = friend;
            }
        }
        return tallest;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter number of friends: ");
        int n = sc.nextInt();
        sc.nextLine();
        
        Friend[] friends = new Friend[n];
        
        for (int i = 0; i < n; i++) {
            System.out.print("Enter name of friend " + (i + 1) + ": ");
            String name = sc.nextLine();
            
            System.out.print("Enter age: ");
            int age = sc.nextInt();
            
            System.out.print("Enter height (in cm): ");
            double height = sc.nextDouble();
            sc.nextLine();
            
            friends[i] = new Friend(name, age, height);
        }
        
        Friend youngest = findYoungest(friends);
        Friend tallest = findTallest(friends);
        
        System.out.println("\n--- Results ---");
        System.out.println("Youngest Friend: " + youngest.name + " (Age: " + youngest.age + ")");
        System.out.println("Tallest Friend: " + tallest.name + " (Height: " + tallest.height + " cm)");
        
        sc.close();
    }
}
