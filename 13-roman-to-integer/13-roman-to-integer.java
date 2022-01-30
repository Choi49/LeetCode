// class Solution {
//     public int romanToInt(String s) {
//         char[] chars = s.toCharArray();
//         int total = 0;
        
//         for(int i=0; i<chars.length ; i++) {
//             switch (chars[i]){
//                 case 'M':
//                     total += 1000;
//                     break;
//                 case 'D':
//                     total += 500;
//                     break;
//                 case 'L':
//                     total += 50;
//                     break;
//                 case 'V':
//                     total += 5;
//                     break;
//                 case 'I':
//                     if(i < chars.length-1){
//                         i++;
//                         if(chars[i] == 'V'){
//                             total += 4;
//                         }else if ( chars[i] == 'X'){
//                             total += 9;
//                         } else {
//                             total += 1;
//                             i--;
//                         }
//                     } else {
//                         total += 1;
//                     }
//                     break;
//                 case 'X':
//                     if(i < chars.length-1){
//                         i++;
//                         if(chars[i] == 'L'){
//                             total += 40;
//                         }else if ( chars[i] == 'C'){
//                             total += 90;
//                         } else {
//                             total += 10;
//                             i--;
//                         }
//                     } else {
//                         total += 10;
//                     }
//                     break;
//                 case 'C':
//                     if(i < chars.length-1){
//                         i++;
//                         if(chars[i] == 'D'){
//                             total += 400;
//                         }else if ( chars[i] == 'M'){
//                             total += 900;
//                         } else {
//                             total += 100;
//                             i--;
//                         }
//                     } else {
//                         total += 100;
//                     }
                    
//             }
//         }
        
//         return total;
//     }
// }

class Solution{
    public int romanToInt(String s) {
            Map<Character, Integer> map = new HashMap<>();
            map.put('I', 1);
            map.put('V', 5);
            map.put('X', 10);
            map.put('L', 50);
            map.put('C', 100);
            map.put('D', 500);
            map.put('M', 1000);
            char[] chars = s.toCharArray();
            int result = 0;
            int i = 0, j = 1;
            for(; j < chars.length; i++, j++) {
                if (map.get(chars[i]) >= map.get(chars[j])) {
                    result += map.get(chars[i]);
                } else {
                    result -= map.get(chars[i]);
                }
            }
            result += map.get(chars[i]);
            return result;
    }
}