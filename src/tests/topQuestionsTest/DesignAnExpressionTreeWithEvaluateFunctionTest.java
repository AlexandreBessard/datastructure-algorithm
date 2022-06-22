package tests.topQuestionsTest;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class DesignAnExpressionTreeWithEvaluateFunctionTest {


    /**
     * This is the interface for the expression tree Node.
     * You should not remove it, and you can define some classes to implement it.
     */
    static abstract class Node {
        public abstract int evaluate();
        // define your fields here
        Node left, right;
    };

    static class NodeImpl extends Node {
        String val;
        NodeImpl(String val) {
            this.val = val;
        }
         @Override
        public int evaluate() {
            if(this.left == null && this.right == null) {
                return Integer.parseInt(this.val);
            }
            int valeur1 = this.left.evaluate();
            int valeur2 = this.right.evaluate();
            switch (this.val) {
                case "+":
                    return valeur1 + valeur2;
                case "-":
                    return valeur1 - valeur2;
                case "/":
                    return valeur1 / valeur2;
                case "*":
                    return valeur1 * valeur2;
            }
             return 0;
         }
    }

    /**
     * This is the TreeBuilder class.
     * You can treat it as the driver code that takes the postinfix input
     * and returns the expression tree represnting it as a Node.
     */
    static class TreeBuilder {
        final Set<String> operators =
                new HashSet<>(Arrays.asList("+", "-", "/", "*"));
        Node buildTree(String[] postfix) {
            final Stack<Node> stack = new Stack<>();
            for(String s : postfix) {
                //If it is an operator
                if(operators.contains(s)){
                    Node node = new NodeImpl(s);
                    node.right = stack.pop();
                    node.left = stack.pop();
                    stack.push(node);
                } else {
                    //Not an operator
                    stack.push(new NodeImpl(s));
                }
            }
            return stack.pop();
        }
    };

/**
 * Your TreeBuilder object will be instantiated and called as such:
 * TreeBuilder obj = new TreeBuilder();
 * Node expTree = obj.buildTree(postfix);
 * int ans = expTree.evaluate();
 */
public static void main(String[] args) {
    String[] postfix = {"4","5","2","7","+","-","*"};
    TreeBuilder obj = new TreeBuilder();
    Node node = obj.buildTree(postfix);
    System.out.println(node.evaluate());
    }

}
