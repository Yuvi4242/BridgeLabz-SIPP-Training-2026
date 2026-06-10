public class Ravi {

    public static void main(String[] args) {

        String name = "Ravi";
        int age = 24;
        String rank = "Beginner";
        double salary = 50000.0;
        float membershipFee = 999.50f;

        double annualBonus = salary * 12 / 100;

        int bonusInt = (int) annualBonus;

        System.out.println("================================");
        System.out.println("      Welcoming CARD");
        System.out.println("================================");
        System.out.println("Name           : " + name);
        System.out.println("Age            : " + age);
        System.out.println("Rank           : " + rank);
        System.out.println("Salary         : " + salary);
        System.out.println("Membership Fee : " + membershipFee);
        System.out.println("Annual Bonus   : " + bonusInt);
        System.out.println("================================");
        System.out.println("Welcome to the Coding Guild!");
        System.out.println("================================");
    }
}