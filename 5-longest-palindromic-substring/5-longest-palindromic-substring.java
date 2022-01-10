class Solution {
    public String longestPalindrome(String s) {
        char[] chars = s.toCharArray();
        String result = String.copyValueOf(chars, 0, 1);
        int max = 1;
        for (int i=0; i<chars.length; i++) {
            int j=1;
            // for odd palindrome
            while (i-j >=0 && i+j < chars.length) {
                if (chars[i-j] == chars[i+j]) {
                    if (max < 2*j + 1) {
                        result = String.copyValueOf(chars, i-j, 2*j+1);
                        max = 2*j+1;
                    } 
                } else {
                    break;
                }
                j++;
            }
            
            //for even palindrome
            j=0;
            if (i+1 <chars.length && chars[i+1] == chars[i]) {
                while (i-j >= 0 && i + j+1 < chars.length) {
                    if (chars[i-j] == chars[i+j+1]) {
                    if (max < 2*j + 2) {
                        result = String.copyValueOf(chars, i-j, 2*j+2);
                        max = 2*j+2;
                    } 
                } else {
                    break;
                }
                j++;
                }
            }
        }
        
        return result;
        
    }
}