public class UndoBuffer {
    private final String[] data;
    private int top;

    public UndoBuffer(int maxDepth) {
        if (maxDepth <= 0) {
            throw new IllegalArgumentException("maxDepth must be positive");
        }
        this.data = new String[maxDepth];
        this.top = -1;
    }

    public boolean push(String edit) {
        if (isFull()) {
            return false;
        }
        data[++top] = edit;
        return true;
    }

    public String pop() {
        if (isEmpty()) {
            throw new RuntimeException("Nothing to undo");
        }
        return data[top--];
    }

    public String peek() {
        if (isEmpty()) {
            throw new RuntimeException("Nothing to peek");
        }
        return data[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == data.length - 1;
    }
}
