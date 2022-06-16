import static org.junit.jupiter.api.Assertions.*;

class StackTests {
    @org.junit.jupiter.api.Test
    void pushPeekTwice() {
        Stack stack1 = new Stack();
        stack1.push("hej");
        assertEquals("hej", stack1.peek());
        stack1.push("co tam");
        assertEquals("co tam", stack1.peek());
    }

    @org.junit.jupiter.api.Test
    void pushPeek100Times(){
        Stack stack2 = new Stack();
        for (int i = 0; i <= 100; i++) {
            String k = String.valueOf(i);
            stack2.push(String.format("siema%s", k));
            assertEquals(String.format("siema%s", k), stack2.peek());
        }
    }

    @org.junit.jupiter.api.Test
    void peekEmpty() {
        Stack stack3 = new Stack();
        assertEquals("isEmpty", stack3.peek());
    }

    @org.junit.jupiter.api.Test
    void peekPushedTwiceAndPopped(){
        Stack stack4 = new Stack();
        stack4.push("superancko");
        stack4.push("dobranoc");
        stack4.pop();
        assertEquals("superancko", stack4.peek());
    }

    @org.junit.jupiter.api.Test
    void peekEmptiedStack(){
        Stack stack5 = new Stack();
        stack5.push("pozdrawiam");
        stack5.pop();
        assertEquals("isEmpty", stack5.peek());
    }

    @org.junit.jupiter.api.Test
    void popEmptyStack(){
        Stack stack6 = new Stack();
        assertEquals("isEmpty", stack6.pop());
    }

    @org.junit.jupiter.api.Test
    void popEmptiedStack() {
        Stack stack7 = new Stack();
        stack7.push("sympatycznie");
        assertEquals("sympatycznie", stack7.pop());
        assertEquals("isEmpty", stack7.pop());
    }

    @org.junit.jupiter.api.Test
    void pop100Times(){
        Stack stack8 = new Stack();
        for (int i = 0; i <= 100; i++) {
            String k = String.valueOf(i);
            stack8.push(String.format("czesc%s", k));
            assertEquals(String.format("czesc%s", k), stack8.pop());
        }
    }
}