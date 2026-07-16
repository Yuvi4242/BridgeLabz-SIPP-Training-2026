package StringPractice.Level3.lab1;

import java.util.Scanner;

public class CalendarGenerator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter month number (1-12): ");
        int month = scanner.nextInt();
        System.out.print("Enter year: ");
        int year = scanner.nextInt();
        scanner.close();
        String monthName = getMonthName(month);
        int days = getDaysInMonth(month, year);
        int firstDay = getFirstDay(month, year);
        System.out.println("    " + monthName + " " + year);
        System.out.println("Sun Mon Tue Wed Thu Fri Sat");
        int current = 0;
        for (int i = 0; i < firstDay; i++) {
            System.out.print("    ");
            current++;
        }
        for (int day = 1; day <= days; day++) {
            System.out.printf("%3d ", day);
            current++;
            if (current == 7) {
                System.out.println();
                current = 0;
            }
        }
        if (current != 0) {
            System.out.println();
        }
    }

    private static String getMonthName(int month) {
        String[] names = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        if (month < 1 || month > 12) {
            return "Unknown";
        }
        return names[month - 1];
    }

    private static int getDaysInMonth(int month, int year) {
        if (month == 2) {
            return isLeapYear(year) ? 29 : 28;
        }
        if (month == 4 || month == 6 || month == 9 || month == 11) {
            return 30;
        }
        return 31;
    }

    private static boolean isLeapYear(int year) {
        if (year % 400 == 0) {
            return true;
        }
        if (year % 100 == 0) {
            return false;
        }
        return year % 4 == 0;
    }

    private static int getFirstDay(int month, int year) {
        int m = month;
        int y = year;
        if (m < 3) {
            m += 12;
            y -= 1;
        }
        int k = y % 100;
        int j = y / 100;
        int day = (1 + ((13 * (m + 1)) / 5) + k + (k / 4) + (j / 4) + 5 * j) % 7;
        return (day + 6) % 7;
    }
}
