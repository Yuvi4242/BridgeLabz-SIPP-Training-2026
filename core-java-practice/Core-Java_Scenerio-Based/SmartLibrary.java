public class SmartLibrary {
    static String[] books = {"Java","Python",null,"C++"};

    public static int getBookLength(int index) {
        try {
            String s = books[index];
            return s.length();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid index");
            return -1;
        } catch (NullPointerException e) {
            System.out.println("Book entry is null");
            return -1;
        }
    }

    public static void main(String[] args) {
        System.out.println(getBookLength(10));
        System.out.println(getBookLength(2));
    }
}
