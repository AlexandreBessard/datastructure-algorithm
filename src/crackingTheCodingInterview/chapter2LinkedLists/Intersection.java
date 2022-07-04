package crackingTheCodingInterview.chapter2LinkedLists;

/*
Intersection: Given two (singly) linked lists, determine if the two lists intersect. Return the intersecting
node. Note that the intersection is defined based on reference, not value. That is, if the kth
node of the first linked list is the exact same node (by reference) as the jth node of the second
linked list, then they are intersecting.
 */
public class Intersection {

    public static void main(String[] args) {

    }

    /*
    Time complexity: O(A + B)
    Where A and B are length of the two linkedList.
    Space complexity: O(1)
     */
    LinkedListNode findIntersection(LinkedListNode list1, LinkedListNode list2) {
        if(list1 == null || list2 == null)
            return null;
        //Get tail and sizes
        Result result1 = getTailSize(list1);
        Result result2 = getTailSize(list2);
        //If different tail nodes, then there's no intersection
        if(result1.tail != result2.tail)
            return null;
        //Set pointers to the start of each LinkedList
        LinkedListNode shorter = result1.size < result2.size ? list1 : list2;
        LinkedListNode longer = result1.size < result2.size ? list2 : list1;
        //Advance the pointer for the longer linked list by difference in lengths
        longer = getKthNode(longer, Math.abs(result1.size - result2.size));
        //Move both pointers until you have a collision
        while(shorter != longer) {
            shorter = shorter.next;
            longer = longer.next;
        }
        //Return either one
        return longer;
    }
    private LinkedListNode getKthNode(LinkedListNode head, int k) {
        LinkedListNode current = head;
        while(k > 0 &&  current != null) {
            current = current.next;
            k--;
        }
        return current;
    }
    private Result getTailSize(LinkedListNode list) {
        if(list == null)
            return null;
        int size = 1;
        LinkedListNode current = list;
        while(current.next != null) {
            size++;
            current = current.next;
        }
        return new Result(current, size);
    }

    static class Result {
        LinkedListNode tail;
        int size;
        public Result(LinkedListNode tail, int size) {
            this.tail = tail;
            this.size = size;
        }
    }
}
