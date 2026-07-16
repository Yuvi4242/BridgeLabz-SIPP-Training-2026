import java.util.Scanner;
public class volumeofcylinder {
 public static void main(String[] args) {
  Scanner sc=new Scanner(System.in);
   

        System.out.print("Enter radius of cylinder: ");
        double cylRadius = sc.nextDouble();

        System.out.print("Enter height of cylinder: ");
        double height = sc.nextDouble();

        double volume = Math.PI * cylRadius * cylRadius * height;
        System.out.println("Volume of Cylinder = " + volume);
      sc.close();
 }
}
