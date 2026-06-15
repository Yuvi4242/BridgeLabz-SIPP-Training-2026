package level1;

import java.util.Scanner;

/**
 * WindChillCalculator - Calculate wind chill temperature
 * Formula: WC = 35.74 + 0.6215*T - 35.75*(V^0.16) + 0.4275*T*(V^0.16)
 * Where T is temperature in Fahrenheit, V is wind speed in mph
 */
public class WindChillCalculator {
    
    /**
     * Calculates wind chill temperature
     * @param temperature Temperature in Fahrenheit
     * @param windSpeed Wind speed in miles per hour
     * @return Wind chill temperature in Fahrenheit
     */
    public static double calculateWindChill(double temperature, double windSpeed) {
        if (windSpeed < 0 || temperature > 50) {
            return temperature;
        }
        
        double windPower = Math.pow(windSpeed, 0.16);
        double windChill = 35.74 + 0.6215 * temperature - 35.75 * windPower + 0.4275 * temperature * windPower;
        return windChill;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter temperature (Fahrenheit): ");
        double temperature = sc.nextDouble();
        
        System.out.print("Enter wind speed (mph): ");
        double windSpeed = sc.nextDouble();
        
        double windChill = calculateWindChill(temperature, windSpeed);
        
        System.out.println("\n--- Wind Chill Calculator ---");
        System.out.println("Temperature: " + temperature + "°F");
        System.out.println("Wind Speed: " + windSpeed + " mph");
        System.out.println("Wind Chill: " + String.format("%.2f", windChill) + "°F");
        
        sc.close();
    }
}
