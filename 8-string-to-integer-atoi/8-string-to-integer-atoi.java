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
    public int myAtoi(String s) {
        char[] chars = s.toCharArray();
        int result = 0;
        int sign = 1;
        int i=0;
        //step 1
        while (i < chars.length) {
            if(!Character.isWhitespace(chars[i])) break;
            i++;
        }
        
        //step 2
        if (i >= chars.length) {
            return 0;
        }
        
        if (chars[i] == '+') {
            i++;
        } else if (chars[i] == '-') {
            sign = -1;
            i++;
        }
        
        //step 3
        while (i < chars.length) {
            int digit = chars[i]-'0';
            if (digit >=10 || digit < 0) {
                break;
            }
            else if (result > Integer.MAX_VALUE/10 || result == Integer.MAX_VALUE/10 && digit >Integer.MAX_VALUE%10 ) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE; 
            }
            result = 10*result + digit;
            i++;
        }
        return sign*result;
    }
}
