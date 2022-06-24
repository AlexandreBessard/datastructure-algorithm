package topAmazonQuestions;

import java.util.PriorityQueue;
import java.util.Queue;

//https://leetcode.com/problems/the-kth-factor-of-n/
public class KthFactorOfN {

    public static void main(String[] args) {
        int n = 12;
        int k = 3;
        var obj = new KthFactorOfN();
        System.out.println(obj.kthFactorBrutForce(n, k));
        System.out.println(obj.kthFactor(n, k));
        System.out.println(obj);

    }

    /*
    Approach 1 Brut Force
     */
    //n = 12, k = 3;
    public int kthFactorBrutForce(int n, int k) {
        for(int x = 1; x < n / 2; x++) {
            if(n % x == 0) {
                k--;
                if(k == 0) return x;
            }
        }
        return k == 1 ? n : -1;
    }

    /*
    Approach 2 Heap
     */
    final Queue<Integer> heap =
            new PriorityQueue<>((o1, o2) -> o2 - o1);
    public void heappushK(int x, int k) {
        // push into heap
        // by limiting size of heap to k
            heap.add(x);
            if (heap.size() > k) {
                heap.remove();
            }
        }

        public int kthFactor(int n, int k) {
            int sqrtN = (int) Math.sqrt(n);
            for (int x = 1; x < sqrtN + 1; ++x) {
                if (n % x == 0) {
                    heappushK(x, k);
                    if (x != n / x) {
                        heappushK(n / x, k);
                    }
                }
            }

            return k == heap.size() ? heap.poll() : -1;
        }
    }

    /*
    Approach 3 Math
     */


