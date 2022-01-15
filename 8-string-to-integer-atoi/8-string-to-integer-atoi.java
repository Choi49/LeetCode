// class Solution {
//     public int myAtoi(String s) {
//         char[] chars = s.toCharArray();
//         StringBuilder result = new StringBuilder();
//         int sign = 1;
//         int i=0;
//         //step 1
//         while (i < chars.length) {
//             if(!Character.isWhitespace(chars[i])) break;
//             i++;
//         }
        
//         //step 2
//         if (i >= chars.length) {
//             return 0;
//         }
        
//         if (chars[i] == '+') {
//             i++;
//         } else if (chars[i] == '-') {
//             sign = -1;
//             i++;
//         }
        
//         //step 3
//         while (i < chars.length) {
//             if(!Character.isDigit(chars[i])) {
//                 break;
//             }
//             result.append(chars[i++]);
//         }
        
//         //step 3
//         try{
//             if(result.length()==0) {
//                 return 0;
//             }
//             return sign*Integer.parseInt(result.toString());
//         } catch(NumberFormatException e) {
//             if (sign==1) {return Integer.MAX_VALUE;}
//             else {return Integer.MIN_VALUE;}
//         }

//     }
// }

class Solution {
public int myAtoi(String str) {
    int index = 0, sign = 1, total = 0;
    //1. Empty string
    if(str.length() == 0) return 0;

    //2. Remove Spaces
    while(index < str.length() && str.charAt(index) == ' ')
        index ++;

    //3. Handle signs
    if(index < str.length() && (str.charAt(index) == '+' || str.charAt(index) == '-')){
        sign = str.charAt(index) == '+' ? 1 : -1;
        index ++;
    }
    
    //4. Convert number and avoid overflow
    while(index < str.length()){
        int digit = str.charAt(index) - '0';
        if(digit < 0 || digit > 9) break;

        //check if total will be overflow after 10 times and add digit
        if(Integer.MAX_VALUE/10 < total || Integer.MAX_VALUE/10 == total && Integer.MAX_VALUE %10 < digit)
            return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;

        total = 10 * total + digit;
        index ++;
    }
    return total * sign;
}
}