package codingexercises;

public class EggDrop {

    public boolean eggCracks(int floor) {
        return floor >= 49;
    }

    public int findFloor(int totalFloors) {
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

    public int maxIterations(int totalFloors){
        return (int)Math.ceil(Math.log(totalFloors)/Math.log(2));
    }
}
