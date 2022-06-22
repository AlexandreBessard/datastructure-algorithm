package leetcode.datastructure.binarysearch.templateAnalysis;

public class SearchInASortedArrayOfUnknownSize {

    public static void main(String[] args) {
        int[] array = {-1,0,3,5,9,12};
        System.out.println(new SearchInASortedArrayOfUnknownSize().search(e -> e, 9));
    }

    public int search(ArrayReader reader, int target) {
        if(reader.get(0) == target) return target;
        //Search for boundaries:
        int left = 0, right = 1;
        while(reader.get(right) < target) {
            left = right;
            right <<= 1;
        }

        while(left < right) {
            int mid = left + (right - left) / 2;
            int num = reader.get(mid);
            if(num == target) return mid;
            if(num < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

}
interface ArrayReader {
    int get(int index);
}
