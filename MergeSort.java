public class MergeSort {

    public static void merge(int[] array, int[] new_array_1, int[] new_array_2, int left, int right) {

        int i = 0, j = 0, k = 0;

        while (i < left && j < right) {  // conditions for merging

            if (new_array_1[i] <= new_array_2[j]) {
                array[k++] = new_array_1[i++];
            }
            else {
                array[k++] = new_array_2[j++];
            }
        }

        while (i < left) {
            array[k++] = new_array_1[i++];
        }

        while (j < right) {
            array[k++] = new_array_2[j++];
        }
    }

    public static void mergeSort(int[] array, int length) { /** required parameters */
        if (length < 2) {  //condition for the length of array
            return;
        }

        int middle = length / 2;  // defining new parameter middle

        int [ ] new_array_1 = new int [middle]; /** defining the new first array after division */
        int [ ] new_array_2 = new int [length - middle]; /** defining the new second array */


        for (int i = 0; i < middle; i++) { /**applying condition for sorting of new array 1 */
            new_array_1 [ i ] = array [ i ];
        }

        for (int i = middle; i < length ; i++) { /**applying condition for sorting of new array 2 */
            new_array_2 [ i - middle] = array [ i ];
        }

        mergeSort (new_array_1, middle); /** calling merge sort function for new array 1 */
        mergeSort (new_array_2, length - middle); /** calling merge sort function for new array 2 */

        merge(array, new_array_1, new_array_2, middle, length - middle); /** calling function for merging of new array 1 and new array 2 */
    }
}