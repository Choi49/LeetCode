class Solution {
    public int romanToInt(String s) {
        char[] chars = s.toCharArray();
        int total = 0;
        
        for(int i=0; i<chars.length ; i++) {
            switch (chars[i]){
                case 'M':
                    total += 1000;
                    break;
                case 'D':
                    total += 500;
                    break;
                case 'L':
                    total += 50;
                    break;
                case 'V':
                    total += 5;
                    break;
                case 'I':
                    if(i < chars.length-1){
                        i++;
                        if(chars[i] == 'V'){
                            total += 4;
                        }else if ( chars[i] == 'X'){
                            total += 9;
                        } else {
                            total += 1;
                            i--;
                        }
                    } else {
                        total += 1;
                    }
                    break;
                case 'X':
                    if(i < chars.length-1){
                        i++;
                        if(chars[i] == 'L'){
                            total += 40;
                        }else if ( chars[i] == 'C'){
                            total += 90;
                        } else {
                            total += 10;
                            i--;
                        }
                    } else {
                        total += 10;
                    }
                    break;
                case 'C':
                    if(i < chars.length-1){
                        i++;
                        if(chars[i] == 'D'){
                            total += 400;
                        }else if ( chars[i] == 'M'){
                            total += 900;
                        } else {
                            total += 100;
                            i--;
                        }
                    } else {
                        total += 100;
                    }
                    
            }
        }
        
        return total;
    }
}