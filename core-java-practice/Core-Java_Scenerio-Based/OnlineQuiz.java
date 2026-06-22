public class OnlineQuiz {
    public static void main(String[] args) {
        String[] answers = {"A","B","C","D"};
        String[] student = {"A", null, "C", "X", "A"};
        for (int i = 0; i < student.length; i++) {
            try {
                if (student[i].equals(answers[i])) {
                    System.out.println("Q" + i + ": correct");
                } else {
                    System.out.println("Q" + i + ": wrong");
                }
            } catch (NullPointerException e) {
                System.out.println("Q" + i + ": answer missing, skipping");
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Q" + i + ": no reference answer available");
            }
        }
    }
}
