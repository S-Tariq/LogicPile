package stariq.rough;

public class ArrayList {

    private int[] array;

    public ArrayList(int...array) {
        this.array = array;
    }

    public void addElements(int...newArray){

        int[] largerArray = new int[array.length + newArray.length];

        for(int i = 0; i < array.length; i++){
            largerArray[i] = array[i];
        }

        for(int i = 0; i < newArray.length; i++){
            largerArray[i + array.length] = newArray[i];
        }

        array = largerArray;
    }

    public int getElement(int index){
        if(index >= 0 && index < array.length){
            return array[index];
        } else {
            throw new IllegalArgumentException();
        }
    }

    public int[] getArray() {
        return array;
    }
}
