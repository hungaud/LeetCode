public class IntegerToEnglishWord_273 {

    public static void main(String[] args) {
        int num = 1234;
        System.out.println(numberToWord(num));
    }

    public static String numberToWord(int num) {
        if(num == 0)
            return "Zero";
        String[] lessThanTwenty = new String[] {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
                "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
        String[] moreThanTwenty = new String[] {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
        String[] moreThanThousand = new String[] {"", "Thousand", "Million", "Billion"};

        //StringBuilder sb = new StringBuilder();
        String result = "";
        int count = 0;
        while(num > 0) {
            String temp = "";
            int threeDigit = num % 1000;
            if(threeDigit >= 100) {
                temp += lessThanTwenty[threeDigit / 100] + " Hundred ";
                //sb.append(lessThanTwenty[threeDigit / 100 - 1] + "hundred ");
                threeDigit %= 100;
            }
            if(threeDigit >= 20) {
                temp += moreThanTwenty[threeDigit / 10] + " ";
                threeDigit %= 10;
            }
            if(threeDigit < 20 && threeDigit > 0) {
                temp += lessThanTwenty[threeDigit] + " ";
            }
            if(temp.length() > 0) {
                temp += moreThanThousand[count] + " ";
            }
            result = temp + result;
            num /= 1000;
            count++;
        }
        return result.trim();
    }

}
