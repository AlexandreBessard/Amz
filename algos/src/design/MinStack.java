package design;

import java.util.Stack;

/*
Implement the MinStack class:

MinStack() initializes the stack object.
void push(val) pushes the element val onto the stack.
void pop() removes the element on the top of the stack.
int top() gets the top element of the stack.
int getMin() retrieves the minimum element in the stack.
 */
public class MinStack {

    public static void main(String[] args) {
    }

    Stack<int[]> stack = new Stack<>();

    public void push(int x) {
        if(stack.isEmpty()) {
            stack.push(new int[] {x, x});
            return;
        }
        int min = stack.peek()[1];
        stack.push(new int[] {x, Math.min(min, x)});

    }

    public int top() {
        return stack.peek()[0];
    }

    public void removes() {
        stack.pop();
    }

    public int getMin() {
        return stack.peek()[1];
    }

}
