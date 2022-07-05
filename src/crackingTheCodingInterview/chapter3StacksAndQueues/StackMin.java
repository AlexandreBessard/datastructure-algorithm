package crackingTheCodingInterview.chapter3StacksAndQueues;

import java.util.Stack;

/*
Stack Min: How would you design a stack which, in addition to push and pop, has a function min
which returns the minimum element? Push, pop and min should all operate in 0(1) time
 */
public class StackMin extends Stack<StackMin.NodeWithMin> {

    public static void main(String[] args) {
        Stack<NodeWithMin> s = new StackMin();
    }

    public void push(int value) {
        int newMin = Math.min(value, min());
        super.push(new NodeWithMin(value, newMin));
    }

    public int min() {
        if(this.isEmpty()) {
            return Integer.MAX_VALUE; //Error value
        } else {
            return peek().min;
        }
    }

    static class NodeWithMin {
        int value;
        int min;
        public NodeWithMin(int value, int min) {
            this.value = value;
            this.min = value;
        }
    }

}
/*
Other approach
 */
class StackWithMin2 extends Stack<Integer> {
    Stack<Integer> s2;
    public StackWithMin2() {
        s2 = new Stack<>();
    }

    public void push(int value) {
        if(value <= min()) {
            s2.push(value);
        }
        super.push(value);
    }

    public Integer pop() {
        int value = super.pop();
        if(value == min()) {
            s2.pop();
        }
        return value;
    }

    private int min() {
        if(s2.isEmpty()) {
            return Integer.MAX_VALUE;
        } else {
            return s2.peek();
        }
    }
}
