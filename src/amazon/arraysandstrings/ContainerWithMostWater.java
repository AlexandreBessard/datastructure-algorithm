package amazon.arraysandstrings;

//https://leetcode.com/explore/interview/card/amazon/76/array-and-strings/2963/
public class ContainerWithMostWater {

    public static void main(String[] args) {
        int[] array = {1,8,6,2,5,4,8,3,7};
        //Output 49
        System.out.println(new ContainerWithMostWater().maxArea(array));
    }

    /*
    Time complexity: O(N)
    Space complexity: O(1)
     */
    public int maxArea(int[] height) {
        int max = 0;
        int left = 0;
        int right = height.length - 1;
        while(left < right) {
            int width = right - left;
            max = Math.max(max, Math.min(height[left], height[right]) * width);
            if(height[right] >= height[left]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }
}
