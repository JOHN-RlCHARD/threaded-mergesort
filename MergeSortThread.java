import java.util.Arrays;

public class MergeSortThread extends Thread{
    private final int[] array;
    private final int length;

    MergeSortThread(int[] array, int length){
        this.array = array;
        this.length = length;
        ThreadManager.useProcessor();
        this.start();
    }

    @Override
    public void run() {
        multiThreadedMergeSort(array, length);
    }

    public static void multiThreadedMergeSort(int[] array, int length) {
        if (ThreadManager.getAvailableProcessors() > 1) {
            int middle = length / 2;
            int[] array1 = Arrays.copyOfRange(array, 0, middle);
            int[] array2 = Arrays.copyOfRange(array, middle, length);
            MergeSortThread thread1 = new MergeSortThread(array1, array1.length);
            MergeSortThread thread2 = new MergeSortThread(array2, array2.length);
            try {
                thread1.join();
                thread2.join();
            } catch (Exception e) {
                e.printStackTrace();
            }
            MergeSort.merge(array, thread1.getResult(), thread2.getResult(), middle, length - middle);
        } else {
            MergeSort.mergeSort(array, length);
        }
    }

    public int[] getResult() {
        ThreadManager.releaseProcessor();
        return array;
    }
}
