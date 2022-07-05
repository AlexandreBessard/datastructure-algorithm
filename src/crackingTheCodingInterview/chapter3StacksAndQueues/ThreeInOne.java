package crackingTheCodingInterview.chapter3StacksAndQueues;

import java.util.EmptyStackException;

//Describe how you could use a single array to implement three stacks
public class ThreeInOne {

    public static void main(String[] args) {

    }


    //TODO: MultiStack

    /*
    Other approach above
    --------------------------------------------------------
    Other approach below
     */

    //Approach with Fixed Division
    static class FixedMultiStack {
        private int numberOfStacks = 3;
        private int stackCapacity;
        private int[] values;
        private int[] sizes;

        public FixedMultiStack(int stackSize) {
            stackCapacity = stackSize;
            values = new int[stackSize * numberOfStacks];
            sizes = new int[numberOfStacks];
        }
        //Return top element
        public int peek(int stackNum) {
            if(isEmpty(stackNum))
                throw new EmptyStackException();
            return values[indexOfTop(stackNum)];
        }
        //Pop item from top stack
        public int pop(int stackNum) {
            if(isEmpty(stackNum))
                throw new EmptyStackException();
            int topIndex = indexOfTop(stackNum);
            int value = values[topIndex]; //Get top
            values[topIndex]  = 0; //Clear
            sizes[stackNum]--; //Shrink
            return value;
         }
        //Push value onto stack
        public void push(int stackNum, int value) throws FullStackException {
            //Check that we have space for the next element
            if(isFull(stackNum)) {
                throw new FullStackException("Stack num : " + stackNum + " is full capacity");
            }
            //Increment stack pointer and then update top value
            sizes[stackNum]++;
            values[indexOfTop(stackNum)] = value;
        }
        //Returns index of the top of the stack
        private int indexOfTop(int stackNum) {
            int offset = stackNum * stackCapacity;
            int size = sizes[stackNum];
            return offset + size - 1;
        }
        //Return if stack is empty
        private boolean isEmpty(int stackNum) {
            return sizes[stackNum] == 0;
        }
        //Return if stack is full
        public boolean isFull(int stackNum) {
            return sizes[stackNum] == stackCapacity;
        }
    }
    //Custom exception class
    static class FullStackException extends Exception {
        public FullStackException(String message){
            super(message);
        }
    }
}
