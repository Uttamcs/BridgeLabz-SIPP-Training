package LinkedList;

class TextState {
    String content;
    TextState next;
    TextState prev;

    public TextState(String content) {
        this.content = content;
        this.next = null;
        this.prev = null;
    }
}

class TextEditorUndoRedo {
    private TextState current;
    private int maxHistory = 10;
    private int currentSize = 0;

    public TextEditorUndoRedo() {
        current = new TextState("");
        currentSize = 1;
    }

    public void addState(String newContent) {
        TextState newState = new TextState(newContent);
        newState.prev = current;
        current.next = newState;
        current = newState;
        currentSize++;
        
        // Limit history size
        if (currentSize > maxHistory) {
            TextState head = current;
            while (head.prev != null) {
                head = head.prev;
            }
            if (head.next != null) {
                head.next.prev = null;
            }
            currentSize--;
        }
    }

    public boolean undo() {
        if (current.prev != null) {
            current = current.prev;
            return true;
        }
        return false;
    }

    public boolean redo() {
        if (current.next != null) {
            current = current.next;
            return true;
        }
        return false;
    }

    public String getCurrentContent() {
        return current.content;
    }

    public void displayCurrentState() {
        System.out.println("Current text: \"" + current.content + "\"");
    }

    public static void main(String[] args) {
        TextEditorUndoRedo editor = new TextEditorUndoRedo();
        
        editor.displayCurrentState();
        
        editor.addState("Hello");
        editor.displayCurrentState();
        
        editor.addState("Hello World");
        editor.displayCurrentState();
        
        editor.addState("Hello World!");
        editor.displayCurrentState();
        
        System.out.println("\nUndo operations:");
        editor.undo();
        editor.displayCurrentState();
        
        editor.undo();
        editor.displayCurrentState();
        
        System.out.println("\nRedo operations:");
        editor.redo();
        editor.displayCurrentState();
        
        editor.addState("Hello World! How are you?");
        editor.displayCurrentState();
    }
}