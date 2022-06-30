package topAmazonQuestions;

import java.util.*;

//https://leetcode.com/problems/design-an-expression-tree-with-evaluate-function/
public class DesignAnExpressionTreeWithEvaluation {

    /**
     * Your TreeBuilder object will be instantiated and called as such:
     * TreeBuilder obj = new TreeBuilder();
     * Node expTree = obj.buildTree(postfix);
     * int ans = expTree.evaluate();
     */
    public static void main(String[] args) {
        var treeBuilder = new  TreeBuilder();
        String[] postfix = {"4","5","7","2","+","-","*"};
        Node expTree = treeBuilder.buildTree(postfix);
        System.out.println(expTree.evaluate());
    }

    /**
     * This is the TreeBuilder class.
     * You can treat it as the driver code that takes the postinfix input
     * and returns the expression tree represnting it as a Node.
     */
    static class TreeBuilder {
        Set<Character> operators =
                new HashSet<>(Arrays.asList('+', '-', '*', '/'));

        //postfix = ["4","5","7","2","+","-","*"]
        Node buildTree(String[] postfix) {
            Stack<Node> stack = new Stack<>();
            for(String s : postfix) {
                //If operator
                if(operators.contains(s.charAt(0))) {
                    Node op1 = stack.pop();
                    Node op2 = stack.pop();
                    Node op = new NodeImpl(s);
                    op.left = op2;
                    op.right = op1;
                    stack.push(op);
                } else {
                    stack.push(new NodeImpl(s));
                }
            }
            return stack.pop();
        }
    };

    public static class NodeImpl extends Node {
        final String val;
        NodeImpl(String val) {
            this.val = val;
        }
        @Override
        public int evaluate() {
            if(this.left == null && this.right == null) {
                return Integer.parseInt(this.val);
            } else {
                int v1 = this.left.evaluate();
                int v2 = this.right.evaluate();
                switch(this.val) {
                    case "+":
                        return v1 + v2;
                    case "-":
                        return v1 - v2;
                    case "*":
                        return v1 * v2;
                    case "/":
                        return v1 / v2;
                }
            }
            System.out.println("This should not be printed");
            return 0;
        }
    }

    /**
     * This is the interface for the expression tree Node.
     * You should not remove it, and you can define some classes to implement it.
     */
    abstract static class Node {
        public abstract int evaluate();
        // define your fields here
        Node left;
        Node right;
    };
}
