public class LongestPalindromicString {
    private static int maxlen,lo;
    private static String longestPalindrome(String s) {
        int len = s.length();

        if(len < 2){
            return s;
        }

        for(int i = 0; i < len - 1; i++){
            extendPalindrome(s, i, i);
            extendPalindrome(s, i, i + 1);
        }
        return s.substring(lo, lo + maxlen);
    }

    private static void extendPalindrome(String s, int j, int k){
        while(j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)){
            j--;
            k++;
        }

        if(maxlen < k - j - 1){
            lo = j + 1;
            maxlen = k - j - 1;
        }
    }

    public static void main(String[] args) {
        String S = "cbbd";
        String result = longestPalindrome(S);
        System.out.println(result);
    }
}
