class Solution {
    public int reverse(int x) {
        char[] chars;
        boolean negative = false;
        if (x<0) {
            chars = String.valueOf(-x).toCharArray();
            negative = true;
        }
        else chars = String.valueOf(x).toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i=chars.length-1;i>=0;i--) {
            sb.append(chars[i]);
        }
        
        try{
        int result = Integer.parseInt(sb.toString());
        if (negative) {
            return -result;
        }
        return result;
        } catch(NumberFormatException e) {
            return 0;
        }
    }
}