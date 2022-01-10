// class Solution {
//     public String longestPalindrome(String s) {
//         char[] chars = s.toCharArray();
//         String result = String.copyValueOf(chars, 0, 1);
//         int max = 1;
//         for (int i=0; i<chars.length; i++) {
//             int j=1;
//             // for odd palindrome
//             while (i-j >=0 && i+j < chars.length) {
//                 if (chars[i-j] == chars[i+j]) {
//                     if (max < 2*j + 1) {
//                         result = String.copyValueOf(chars, i-j, 2*j+1);
//                         max = 2*j+1;
//                     } 
//                 } else {
//                     break;
//                 }
//                 j++;
//             }
            
//             //for even palindrome
//             j=0;
//             if (i+1 <chars.length && chars[i+1] == chars[i]) {
//                 while (i-j >= 0 && i + j+1 < chars.length) {
//                     if (chars[i-j] == chars[i+j+1]) {
//                     if (max < 2*j + 2) {
//                         result = String.copyValueOf(chars, i-j, 2*j+2);
//                         max = 2*j+2;
//                     } 
//                 } else {
//                     break;
//                 }
//                 j++;
//                 }
//             }
//         }
        
//         return result;
        
//     }
// }



class Solution {
    public String longestPalindrome(String s) {
        char[] chars = s.toCharArray();
        String result = String.copyValueOf(chars, 0, 1);
        for (int i=0; i<chars.length; i++) {
            // for odd palindrome
            String oddPalindrome = spreadFromCenter(i,i,chars);
            if (result.length() < oddPalindrome.length()) {
                result = oddPalindrome;
            }
            //for even palindrome
            String evenPalindrome = spreadFromCenter(i,i+1,chars);
            if (result.length() < evenPalindrome.length()) {
                result = evenPalindrome;
            }
        }
        return result;
        
    }
    
    public String spreadFromCenter(int left, int right, char[] chars) {
        int i=0;
        String result = "";
        while (left-i >= 0 && right + i < chars.length) {
            if (chars[left-i] != chars[right + i]) {
                break;
            }
            i++;
        }
        i--;
        return String.copyValueOf(chars, left-i, right-left + 2*i + 1);
    }
}