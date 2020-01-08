package codingexercises;

public class EggDropTest {

    public static void main(String[] args) {
	    addEggs();
    }

    public static void addEggs(){

        EggDrop binaryEggDrop = new EggDrop();
        int totalFloors = 100;
        int maxFloor = binaryEggDrop.findFloor(totalFloors);
        System.out.println("Floor the egg breaks on: \n" + maxFloor);
        int maxIterations = binaryEggDrop.maxIterations(totalFloors);
        System.out.println("Iterations required: \n" + maxIterations);
    }
}
