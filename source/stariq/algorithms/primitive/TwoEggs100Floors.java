package stariq.algorithms.primitive;

// Find the floor the egg breaks on and the maximum number of trials required.
public class TwoEggs100Floors {

    public static void main(String[] args) {
        int totalFloors = 100;
        System.out.println("Floor the egg breaks on: \n" + findFloor(totalFloors));
        System.out.println("Iterations required: \n" + maxIterations(totalFloors));
    }

    public static int findFloor(int totalFloors) {
        int low = 0;
        int high = totalFloors;
        while (low < high) {
            int mid = (low+high)/2;
            if (mid >= 49) {
                high = mid;
            } else {
                low = mid+1;
            }
            System.out.println("[low]: " + low + ", [high]: " + high);
        }
        return low;
    }

    public static int maxIterations(int totalFloors){
        return (int)Math.ceil(Math.log(totalFloors)/Math.log(2));
    }
}
