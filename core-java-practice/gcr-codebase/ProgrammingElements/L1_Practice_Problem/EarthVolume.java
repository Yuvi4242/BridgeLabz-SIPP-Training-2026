import java.util.Scanner;

public class EarthVolume {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        double radius = 6378;
        double pi = 3.14159;
        
        double volumeKm = (4.0 / 3.0) * pi * radius * radius * radius;
        double volumeMiles = volumeKm * 0.239913;
        
        System.out.println("Volume in km³: " + volumeKm);
        System.out.println("Volume in miles³: " + volumeMiles);
        
        sc.close();
    }
}
