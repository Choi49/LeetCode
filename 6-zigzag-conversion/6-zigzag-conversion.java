class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        char[] s_array = s.toCharArray();
        String result = verticesChars(s_array, numRows, 0);
        for (int i=1; i<numRows -1; i++) {
            result += midChars(s_array, numRows, i);
        }
        return result+verticesChars(s_array, numRows, numRows-1);
    }
    
    public String verticesChars(char[] s, int numRows, int start) {
        String result = "";
        while (start < s.length) {
            result += s[start];
            start += 2*numRows-2;
        }
        return result;
    }
    
    public String midChars(char[] s, int numRows, int row) {
        String result = "";
        int i = row;
        while (i < s.length){
            result += s[i];
            i += 2*numRows -2*row-2;
            if (i >= s.length){
                break;
            }
            result += s[i];
            i += 2*row;
        }
        return result;
    }
}