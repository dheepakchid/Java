import java.util.HashMap;

public class MaximumSizeSubArraySum {
    private static int maxSubArrayLen(int[] numbs, int k) {
        int sum = 0, max = 0;

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < numbs.length; i++){
            sum = sum + numbs[i];

            if (sum == k)
            {
                max = i + 1;
            }
            else if (map.containsKey(sum - k))
            {
                max = Math.max(max, i - map.get(sum - k));
            }
            if (!map.containsKey(sum))
            {
                map.put(sum,i);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] input = {1, -1, 5, -2, 3};
        int target = 3;
        int result = maxSubArrayLen(input, target);
        System.out.println(result);
    }
}
