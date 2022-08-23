package SortirovkiTask;

public class task9 {
    public static void main(String[] args) {
        int input_array [] = {3, 5, 26, 9, 39, 1};
        task9 answer = new task9();
        for (int i = input_array.length/2-1; i >= 0; i--){
            BuildKucha(input_array, input_array.length, i);
        }
        for (int i = input_array.length; i >= 0; i--){
            int help_help = input_array[0];
            input_array[0] = input_array[i];
            input_array[i] = help_help;
        }
        System.out.println(input_array);
    }
    public static void BuildKucha(int array[], int size, int i){
        int maxvalue = i;
        int leftvalue = 2*i + 1;
        int rightvalue = 2*i + 2;

        if (leftvalue < size && leftvalue > maxvalue){
            maxvalue = leftvalue;
        }
        if (rightvalue < size && rightvalue > maxvalue){
            maxvalue = rightvalue;
        }
        if (maxvalue != i){
            int help = array[maxvalue];
            array[maxvalue] = array[i];
            array[i] = help;
        }

        BuildKucha(array, size, maxvalue);
    }
}
