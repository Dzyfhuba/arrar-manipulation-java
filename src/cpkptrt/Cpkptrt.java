package cpkptrt;

import java.util.Scanner;

/**
 *
 * @author dzyfhuba
 */
public class Cpkptrt {

    // not perfect
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        System.out.println("Make array");
        int[] numbers = new int[7];
        initial(numbers);
        boolean end = false;
        do {            
            System.out.println("Choose one of the following features: ");
            System.out.println("1. Show all array elements\n"
                    + "2. Add new last element of array\n"
                    + "3. Delete last element of array\n"
                    + "4. Calculate the mean\n"
                    + "5. Calculate the median\n"
                    + "6. Calculate the mode\n"
                    + "7. To end program");
            System.out.print("Input: ");
            int choose = scn.nextInt();
            switch (choose) {
                case 1:
                    printArray(numbers);
                    break;
                case 2:
                    numbers = add(numbers, scn);
                    break;
                case 3:
                    numbers = delete(numbers);
                    break;
                case 4:
                    System.out.println("Mean: " + mean(numbers));
                    break;
                case 5:
                    System.out.println("Median: " + median(numbers));
                    break;
                case 6:
                    System.out.println("Mode: " + mode(numbers));
                    break;
                case 7:
                    end = true;
                    break;
                default:
                    System.out.println("Your input invalid");
            }
        } while (!end);

        printArray(numbers);

//        numbers = add(numbers, scn);
//        printArray(numbers);
//        
//        numbers = delete(numbers);
//        printArray(numbers);
        System.out.println("Mean: " + mean(numbers));

        System.out.println("Median: " + median(numbers));

        System.out.println("Mode: " + mode(numbers));
    }

    static int mode(int[] numbers) {
        // calculate mode
        // Weaknesses: when all elements are equal
        int maxV = 0, maxC = 0;
        for (int i = 0; i < numbers.length - 1; i++) {
            int count = 0;
            for (int j = 0; j < numbers.length - 1; j++) {
                if (numbers[i] == numbers[j]) {
                    count++;
                }
            }
            if (count > maxC) {
                maxC = count;
                maxV = numbers[i];
            }
        }
        return maxV;
    }

    static double median(int[] numbers) {
        // calculate median
        int[] sorted = numbers;
        for (int i = 0; i < sorted.length - 1; i++) {
            for (int j = 0; j < sorted.length - i - 1; j++) {
                if (sorted[j] > sorted[j + 1]) {
                    int temp = sorted[j];
                    sorted[j] = sorted[j + 1];
                    sorted[j + 1] = temp;
                }
            }
        }
        double median;
        if (sorted.length % 2 == 0) {
            System.out.println(sorted.length / 2.0);
            median = (sorted[sorted.length / 2 - 1] + sorted[sorted.length / 2]) / 2.0;
        } else {
            System.out.println(sorted.length / 2.0);
            median = sorted[sorted.length / 2 - 1];
        }
        return median;
    }

    static double mean(int[] numbers) {
        // calculate mean
        double total = 0;
        double length = numbers.length;
        for (int number : numbers) {
            total += number;
        }
        double mean = total / length;
        return mean;
    }

    static int[] delete(int[] numbers) {
        // delete last element on array
        int[] temp = numbers;
        numbers = new int[numbers.length - 1];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = temp[i];
        }
        return numbers;
    }

    static int[] add(int[] numbers, Scanner scn) {
        // add new last element on array
        int[] temp = new int[numbers.length + 1];
        for (int i = 0; i < numbers.length; i++) {
            temp[i] = numbers[i];
        }
        System.out.print("Insert the value: ");
        temp[temp.length - 1] = scn.nextInt();
        numbers = new int[temp.length];
        numbers = temp;
        return numbers;
    }

    static void initial(int[] numbers) {
        // initial
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = (int) (Math.random() * 100 % 20);
        }
    }

    static void printArray(int[] numbers) {
        // print array
        System.out.print("Array's content: ");
        for (int number : numbers) {
            System.out.print(number + " ");
        }
        System.out.println("");
    }

}
