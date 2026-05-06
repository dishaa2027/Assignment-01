import java.util.*;

public class Problem1 {

    public static int maxCyclicSum(String s) {
        int n = s.length();
        String doubled = s + s;

        Map<Character, Integer> seen = new HashMap<>();

        int left = 0;
        int currentSum = 0;
        int maxSum = 0;

        for (int right = 0; right < doubled.length(); right++) {

            char ch = doubled.charAt(right);

            while (seen.containsKey(ch) && seen.get(ch) >= left) {
                char removeChar = doubled.charAt(left);
                currentSum -= (removeChar - 'a' + 1);
                left++;
            }

            while (right - left + 1 > n) {
                char removeChar = doubled.charAt(left);
                currentSum -= (removeChar - 'a' + 1);
                left++;
            }

            currentSum += (ch - 'a' + 1);
            seen.put(ch, right);

            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        System.out.println(maxCyclicSum(s));

        sc.close();
    }
}
