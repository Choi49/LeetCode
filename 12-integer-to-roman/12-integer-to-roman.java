class Solution {
    
    char romans[] = new char[] {'I','V','X','L','C','D','M'};
    int values[] = new int[] {1,5,10,50,100,500,1000};
    
    public String intToRoman(int num) {
        StringBuilder result = new StringBuilder();
        
        for (int i = 6; i >= 0; i--){
            num = intToRomanChar(i, num, result);
            if (num == 0) {
                break;
            }
        }
        
        return result.toString();
    }
    
    public int intToRomanChar(int i, int num, StringBuilder result) {
        int symbol_value = values[i];
        char c = romans[i];
        char pre_c = '\0';
        int pre_symbol_value = 0;
        
        int count = 0;
        
        if(i >= 1) {
            int pre = (i + i%2)-2;
            pre_c = romans[pre];
            pre_symbol_value = values[pre];
        }
        
        if (num < symbol_value - pre_symbol_value) return num;
        
        
        int quote = num / symbol_value;
        for (int j = 0; j < quote ; j++) {
            result.append(c);
        }
        
        num = num % symbol_value;
        if (num >= symbol_value - pre_symbol_value) {
            num -= symbol_value - pre_symbol_value;
            result.append(pre_c);
            result.append(c);
        }
        
        return num;
    }
}