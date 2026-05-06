import java.util.*;

public class Problem2 {

    public static long minOperations(int[] arr, int k) {

        int remainder = arr[0] % k;

        for (int num : arr) {
            if (num % k != remainder) {
                return -1;
            }
        }

        int n = arr.length;

        int[] normalized = new int[n];

        for (int i = 0; i < n; i++) {
            normalized[i] = arr[i] / k;
        }

        Arrays.sort(normalized);

        int median = normalized[n / 2];

        long operations = 0;

        for (int num : normalized) {
            operations += Math.abs(num - median);
        }

        return operations;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int k = sc.nextInt();

        System.out.println(minOperations(arr, k));

        sc.close();
    }
}
