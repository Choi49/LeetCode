// class Solution {
//     public int lengthOfLongestSubstring(String s) {
//         int max = 0;
//         char[] chars = s.toCharArray();
//         for (int i=0; i<chars.length;i++) {
//             Set substring = new HashSet<Character> ();
//             substring.add(chars[i]);
//             for (int j=i+1;j<chars.length;j++) {
//                 if (substring.contains(chars[j])) {
//                     break;
//                 }
//                 substring.add(chars[j]);
//             }
//             int temp = substring.size();
//             max = max>temp ? max : temp;
//         }
//         return max;
//     }
// }


class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        int start = 0;
        int end = 0;
        int i = 0;
        char[] chars = s.toCharArray();
        Set<Character> substring = new HashSet<Character> ();
        
        while (end != chars.length) {
            if (substring.contains(chars[end])) {
                substring.remove(chars[start]);
                start += 1;
            } else {
                substring.add(chars[end]);
                end += 1;
                max = max>substring.size() ? max : substring.size();
            }
        }
        return max;
    }
}