public class MinSizeSubArraySum {
    private static int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        int i = 0, j = 0, sum = 0, min = Integer.MAX_VALUE;

        while (j < nums.length) {
            sum += nums[j++];

            while (sum >= s) {
                min = Math.min(min, j - i);
                sum -= nums[i++];
            }
        }

        return min == Integer.MAX_VALUE ? 0 : min;
    }

    public static void main(String[] args) {
        int[] input = {2,3,1,2,4,3};
        int positiveInt = 7;
        int result = minSubArrayLen(positiveInt,input);
        System.out.println(result);
    }
}
