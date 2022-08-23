package SortirovkiTask;

import java.lang.reflect.Array;
import java.util.Arrays;

public class task6 {
    public static void main(String[] args) {
        int input_array []= {5, 25, 1, 13, 53, 2};
        System.out.println("Было => " + Arrays.toString(input_array));
        System.out.println("Стало => " + Arrays.toString(SortedArray(input_array, 0, input_array.length-1)));
    }
    public static int[] SortedArray(int[] array, int left, int right){
        if (left == right){
            return new int[] {array[left]};
        }
        int seredina = (right - left)/2;
        int[] part1 = SortedArray(array, left, seredina);
        int[] part2 = SortedArray(array, seredina+1, right);
        int[] answer_array = MergedArray(part1, part2);
        return answer_array;
    }
    public static int[] MergedArray(int [] leftPart, int [] rightPart){
        int [] final_array = new int [leftPart.length + rightPart.length];
        int indexLeft = 0;
        int indexRight = 0;
        int indexFin = 0;
        while (indexLeft < leftPart.length && indexRight < rightPart.length){
            if (leftPart[indexLeft] > rightPart[indexRight]){
                final_array[indexFin] = leftPart[indexLeft];
                indexLeft++;
                indexFin++;
            }
            else{
                final_array[indexFin] = rightPart[indexRight];
                indexRight++;
                indexFin++;
            }
        }
        while (indexLeft < leftPart.length){
            final_array[indexFin] = leftPart[indexLeft];
            indexLeft++;
            indexFin++;
        }
        while (indexRight < rightPart.length){
            final_array[indexFin] = rightPart[indexRight];
            indexRight++;
            indexFin++;
        }
        return final_array;
    }
}
