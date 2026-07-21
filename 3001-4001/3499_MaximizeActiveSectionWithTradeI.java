class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        int maxZeroes = 0;
        int oneCount = 0;
        int prevZeroCount = 0;
        int i = 0;
        while(i < s.length()) {
            if(s.charAt(i) == '1'){
                oneCount++;
                i++;
            }else{
                int currZeroCount = 0;
                while(i < s.length() &&  s.charAt(i) == '0'){
                    currZeroCount++;
                    i++;
                }

                if(prevZeroCount != 0){
                    maxZeroes = Math.max(maxZeroes, prevZeroCount + currZeroCount);
                }

                prevZeroCount = currZeroCount;
            }
        }

        return maxZeroes + oneCount;
    }
}