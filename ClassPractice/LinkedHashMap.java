import java.util.LinkedHashMap;
import java.util.Map;
public class LinkedHashMap {
public static void main(String[] args) {
Map<String, String> capitals = new LinkedHashMap<>();
capitals.put("USA", "Washington D.C.");
capitals.put("UK", "London");
capitals.put("France", "Paris");
System.out.println("Capitals: " + capitals);
capitals.put("Germany", "Berlin");
System.out.println("After adding Germany: " + capitals);
}
}

13

Output:
Capitals: {USA=Washington D.C., UK=London, France=Paris}
After adding Germany: {USA=Washington D.C., UK=London, France=Paris,
Germany=Berlin}