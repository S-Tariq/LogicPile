package stariq.algorithms;

public class EggDrop {

    public static void main(String[] args) {
        int totalFloors = 100;
        int maxFloor = EggDrop.findFloor(totalFloors);
        System.out.println("Floor the egg breaks on: \n" + maxFloor);
        int maxIterations = EggDrop.maxIterations(totalFloors);
        System.out.println("Iterations required: \n" + maxIterations);
    }

    public static boolean eggCracks(int floor) {
        return floor >= 49;
    }

    public static int findFloor(int totalFloors) {
        int low = 0;
        int high = totalFloors;
        while (low < high) {
            int mid = (low+high)/2;
            if (eggCracks(mid)) {
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
