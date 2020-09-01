package stariq.algorithms;

public class EggDropTest {

    public static void main(String[] args) {
	    addEggs();
    }

    public static void addEggs(){

        int totalFloors = 100;
        int maxFloor = EggDrop.findFloor(totalFloors);
        System.out.println("Floor the egg breaks on: \n" + maxFloor);
        int maxIterations = EggDrop.maxIterations(totalFloors);
        System.out.println("Iterations required: \n" + maxIterations);
    }
}
