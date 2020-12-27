package stariq.algorithms.array;

// https://leetcode.com/problems/trapping-rain-water/
public class TrappingRainWater {

    public static void main(String[] args) {
        int[] array = new int[] {1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trappingWater(array));
    }

    public static int trappingWater(int[] arr) {
        int volume = 0;
        int left = 0;
        int right = arr.length - 1;
        int higher = 0;
        while(left < right) {
            int lower;
            if(arr[left] < arr[right]) {
                lower = arr[left];
                left++;
            } else {
                lower = arr[right];
                right--;
            }
            higher = Math.max(higher, lower);
            volume += higher - lower;
        }
        return volume;

    }
}
