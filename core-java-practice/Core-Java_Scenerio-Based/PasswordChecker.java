public class PasswordChecker {
    public static boolean checkPassword(String password) {
        try {
            if (password == null) throw new NullPointerException("Password is null");
            if (password.isEmpty()) { System.out.println("Password cannot be empty"); return false; }
            if (password.length() < 8) { System.out.println("Password too short"); return false; }
            if (!Character.isUpperCase(password.charAt(0))) { System.out.println("First character must be uppercase"); return false; }
            if (!Character.isDigit(password.charAt(password.length()-1))) { System.out.println("Last character must be a digit"); return false; }
            if (!password.matches(".*[@#\\$%&\\*].*")) { System.out.println("Password must contain a special character"); return false; }
            return true;
        } catch (NullPointerException e) {
            System.out.println("Password cannot be null");
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(checkPassword(null));
        System.out.println(checkPassword("Abcdefg1"));
        System.out.println(checkPassword("Abcd@ef1"));
    }
}
