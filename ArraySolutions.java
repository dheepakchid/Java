import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ArraySolutions {
    private static int removeDuplicates(int[] A){
        if(A.length == 0) return 0;
        int j=0;

        for(int i = 0;i<A.length;i++){
            if(A[i]!=A[j])
                A[++j]=A[i];
        }
        return ++j;
    }

    private static boolean containsDuplicate(int[] nums) {
        final Set<Integer> distinct = new HashSet<>();
        for(int num : nums) {
            if(distinct.contains(num)) {
                return true;
            }
            distinct.add(num);
        }
        return false;
    }

    private static int[] plusOne(int[] digits){
        int n = digits.length;
        for(int i = n-1; i >= 0;i--){
            if(digits[i] < 9){
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }

        int[] newNumber = new int[n + 1];
        newNumber[0] = 1;

        return newNumber;
    }

    private static int singleNumber(int[] A) {
        int result = 0;
        for (int input : A) {
            result ^= input;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] input = {1,2,2,2,3,3};

        int result = removeDuplicates(input);
        System.out.println(result);

        boolean containsDup = containsDuplicate(input);
        System.out.println(containsDup);

        int[] newNumber = plusOne(input);
        System.out.println(Arrays.toString(newNumber));

        int[] inputSolo = {1,2,2,3,3};
        int soloNum = singleNumber(inputSolo);
        System.out.println(soloNum);
    }
}
