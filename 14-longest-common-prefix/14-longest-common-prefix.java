class Solution {
    public String longestCommonPrefix(String[] strs) {
        String prf = strs[0];
        
        if (strs.length == 1){
            return prf;
        }
        
        for (int i = 1; i<strs.length ; i++) {
            if (prf.length() == 0){
                break;
            }
            for (int j=0; j<prf.length(); j++) {
                if (j >= strs[i].length()) {
                    prf = prf.substring(0,j);
                        break;
                } else {
                    if (prf.charAt(j) != strs[i].charAt(j)) {
                        prf = prf.substring(0,j);
                        break;
                    }
                }
            }
        }
        
        return prf;
        
    }
}