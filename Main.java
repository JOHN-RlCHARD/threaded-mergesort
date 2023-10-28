import java.util.Arrays;
import java.util.Random;

/*
 [ALUNOS]
 Nome: João Ricardo Alvarenga Ensenat   RA: 21980446
 Nome: Tobias Tassinari Dornelles       RA: 17270612
 */

public class Main {
    public static void main(String[] args) {
        //Create array with number from 0 to length
        int length = 20000000;
        int[] intArray = new int[length];
        for (int i=0;i<intArray.length;i++) {
            intArray[i] = i;
        }

        //Multithreaded Merge Sort
        shuffleArray(intArray);
        long tMulti = System.currentTimeMillis(); //get starting time
        MergeSortThread.multiThreadedMergeSort(intArray, intArray.length);
        System.out.println("\n[RESULTS]");
        tMulti = System.currentTimeMillis() - tMulti; //get finish time
        System.out.println("Multithreaded: "+tMulti+" milliseconds.");
        //System.out.println(Arrays.toString(intArray)); //print sorted array

        //Single threaded Merge Sort
        shuffleArray(intArray);
        long tSingle = System.currentTimeMillis(); //get starting time
        MergeSort.mergeSort(intArray, intArray.length);
        tSingle = System.currentTimeMillis() - tSingle; //get finish time
        System.out.println("Single threaded: "+tSingle+" milliseconds.");

        System.out.println("\n[CONCLUSION]");

        if (tMulti > tSingle) System.out.println("Single threaded was "+(tMulti-tSingle)+" milliseconds faster than Multithreaded.");
        else System.out.println("Multithreaded was "+(tSingle-tMulti)+" milliseconds faster than Single threaded.");
    }

    static void shuffleArray(int[] array) {
        Random rand = new Random();

        for (int i = 0; i < array.length; i++) {
            int randomIndexToSwap = rand.nextInt(array.length);
            int temp = array[randomIndexToSwap];
            array[randomIndexToSwap] = array[i];
            array[i] = temp;
        }
    }
}