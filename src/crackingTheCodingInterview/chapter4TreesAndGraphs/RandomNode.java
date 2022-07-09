package crackingTheCodingInterview.chapter4TreesAndGraphs;

import java.util.Random;

/*
Random Node: You are implementing a binary search tree class from scratch, which, in addition
to insert, find, and delete, has a method getRandomNode() which returns a random node
from the tree. All nodes should be equally likely to be chosen. Design and implement an algorithm
for getRandomNode, and explain how you would implement the rest of the methods.
 */
public class RandomNode {
    private static class Tree {
        TreeNode root = null;
        public int size() {
            return this.root == null ? 0 : this.root.size;
        }

        public TreeNode getRandomNode() {
            if(root == null)
                return null;
            Random random = new Random(); // Optimzed approach, one call to this expensive method
            int i = random.nextInt(size());
            return root.getIthNode(i);
        }

        public void insertInOrder(int value) {
            if(this.root == null) {
                this.root = new TreeNode(value);
            } else {
                this.root.insertInOrder(value);
            }
        }

    }
    private static class TreeNode {
        int data;
        TreeNode left, right;
        int size = 0;
        public TreeNode(int d) {
            data = d;
            size = 1;
        }

        public TreeNode getIthNode(int i) {
            int leftSize = left == null ? 0 : left.size;
            if(i < leftSize)
                return left.getIthNode(i);
            else if(i == leftSize) {
                return this;
            } else {
                return right.getIthNode(i - (leftSize + 1));
            }
        }

        /*
        Time complexity: O(log N) in a balanced tree
        OR O(D) where D is the max depth of the tree whether the tree is balanced or not
         */
        public TreeNode getRandomNode() {
            int leftSize = this.left == null ? 0 : this.left.size;
            Random random = new Random(); //Expensive runtime to call, optimized approach above
            int index = random.nextInt(this.size);
            if(index < leftSize) {
                return this.left.getRandomNode();
            } else if(index == leftSize) {
                return this;
            } else {
                return this.right.getRandomNode();
            }
        }

        public TreeNode find(int d) {
            if(this.data == d) {
                return this;
            } else if(d <= data) {
                return this.left != null ? this.left.find(d) : null;
            } else if(d > this.data) {
                return this.right != null ? this.right.find(d) : null;
            }
            return null;
        }

        public void insertInOrder(int d) {
            if(d <= this.data) {
                if(this.left == null) {
                    this.left = new TreeNode(d);
                } else {
                    this.left.insertInOrder(d);
                }
            } else {
                if(this.right == null) {
                    this.right = new TreeNode(d);
                } else {
                    this.right.insertInOrder(d);
                }
            }
            this.size++;
        }
    }

}
