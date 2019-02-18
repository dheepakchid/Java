public class ReverseWordsPreserveSpaces {
    private static void reverseWords(String inputString) {

        char[] inputStr = inputString.toCharArray();
        char[] reversedString = new char[inputStr.length];


        for (int i = 0; i < inputStr.length; i++) {
            if (inputStr[i] == ' ') {
                reversedString[i] = ' ';
            }
        }
        int strLength = reversedString.length - 1;
      //  for (int i = 0; i < inputStr.length; i++) {

        for(char input : inputStr){
            // Ignore spaces in input string
            if (input != ' ') {

                // ignore spaces in result.
                if (reversedString[strLength] == ' ') {
                    strLength--;
                }
                reversedString[strLength] = input;
                strLength--;
            }
        }
        System.out.println(String.valueOf(reversedString));
    }

    public static void reverse(char[] s, int start, int end) {
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
        reverseWords(inputString);
    }
}
