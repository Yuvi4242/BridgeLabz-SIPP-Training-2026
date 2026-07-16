import java.util.Scanner;

public class EmployeeAttendanceRanking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of employees: ");
        int n = scanner.nextInt();

        int[] employeeIds = new int[n];
        int[] attendance = new int[n];

        System.out.println("Enter employee IDs and attendance values:");
        for (int i = 0; i < n; i++) {
            employeeIds[i] = scanner.nextInt();
            attendance[i] = scanner.nextInt();
        }

        System.out.print("Enter top K value: ");
        int k = scanner.nextInt();

        rankEmployees(employeeIds, attendance);

        System.out.println("Top " + k + " employee IDs:");
        for (int i = 0; i < Math.min(k, n); i++) {
            System.out.println(employeeIds[i]);
        }

        scanner.close();
    }

    public static void rankEmployees(int[] employeeIds, int[] attendance) {
        for (int i = 1; i < employeeIds.length; i++) {
            int currentId = employeeIds[i];
            int currentAttendance = attendance[i];
            int j = i - 1;

            while (j >= 0 && isHigherPriority(attendance[j], employeeIds[j], currentAttendance, currentId)) {
                employeeIds[j + 1] = employeeIds[j];
                attendance[j + 1] = attendance[j];
                j--;
            }

            employeeIds[j + 1] = currentId;
            attendance[j + 1] = currentAttendance;
        }
    }

    public static boolean isHigherPriority(int attendance1, int id1, int attendance2, int id2) {
        if (attendance1 == attendance2) {
            return id1 > id2;
        }
        return attendance1 < attendance2;
    }
}

// Time Complexity: O(n^2)
// Space Complexity: O(1)
