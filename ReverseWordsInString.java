public class ReverseWordsInString {
    private static void reverseWords(char[] str) {


        // Three step to reverse
        // 1, reverse the whole sentence

        reverse(str, 0, str.length - 1);

        // 2, reverse each word
        int start = 0;
        //for (int i = 0; i < str.length; i++) {
        //    if (str[i] == ' ') {
        //        reverse(str, start, i - 1);
        //        start = i + 1;
        //    }
        //}
        System.out.println(str);
        // 3, reverse the last word, if there is only one word this will solve the corner case
        reverse(str, start, str.length - 1);
    }

    private static void reverse(char[] s, int start, int end) {
        while (start < end) {
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;
        }
    }
    public static void main(String[] args) {
        String inputString = "Dheepak Chidambaram";
        reverseWords(inputString.toCharArray());
    }
}
