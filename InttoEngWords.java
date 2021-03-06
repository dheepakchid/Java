import java.util.List;

class InttoEngWords{
    private static final String[] LESS_THAN_20 = {" ","One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
    private static final String[] LESS_THAN_100 = {" ","Ten", "Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};
    private static final String[] THOUSAND = {" ","Thousand","Million","Billion"};
    
    private static String numberToWords(int num) {
        if (num == 0) return "Zero";

        int i = 0;
        String words = "";
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            if (num % 1000 != 0)
                sb.delete(0, sb.length());

                sb.append(helper(num % 1000));
                sb.append(THOUSAND[i]);
                sb.append(" ");
                sb.append(words);

                words = sb.toString();
                //words = helper(num % 1000) + THOUSAND[i] + " " + words;
            num /= 1000;
            i++;
        }

        return words.trim();
    }
    
    private static String helper(int num){
        if(num == 0){
            return "";
        } 
        else if(num < 20){
            return LESS_THAN_20[num] + " ";
        } 
        else if(num < 100){
            return LESS_THAN_100[num / 10] + " " + helper(num % 10);
        } 
        else{
            return LESS_THAN_20[num / 100] + " Hundred " + helper(num % 100);
        }
    }

    public static void main(String[] args) {
        int num = 1223234;
        String words = numberToWords(num);
        System.out.println(words);
    }
}