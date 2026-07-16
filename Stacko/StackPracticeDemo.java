public class StackPracticeDemo {
    public static void main(String[] args) {
        UndoBuffer undoBuffer = new UndoBuffer(3);
        undoBuffer.push("A");
        undoBuffer.push("B");
        System.out.println("Undo peek: " + undoBuffer.peek());
        System.out.println("Undo pop: " + undoBuffer.pop());

        CallStack callStack = new CallStack();
        callStack.push("main");
        callStack.push("helper");
        System.out.println("Current call: " + callStack.peek());

        System.out.println("Balanced brackets: " + BalancedBrackets.isValidConfig("{[()]}"));
        System.out.println("Balanced brackets: " + BalancedBrackets.isValidConfig("{[(])}"));

        int[] greater = NextGreaterElement.nextGreaterElement(new int[]{4, 2, 7, 1, 5});
        for (int value : greater) {
            System.out.print(value + " ");
        }
        System.out.println();

        int[] span = StockSpan.loadSpan(new int[]{100, 80, 60, 70, 60, 75, 85});
        for (int value : span) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}
