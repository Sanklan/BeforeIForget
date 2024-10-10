public class Solution {
    public String reverseWords(String s) {
        //\\s
        String[] sArray = s.trim().split("\\s");
        String ret = "";
        for(int i = sArray.length - 1; i > -1; i--) {
            /*if(sArray[i].length() == 1 && sArray[i].contains("\\s")) {
                continue;
            }*/
            ret = ret.trim();
            ret = ret + " "+ sArray[i].trim();
        }
        return ret.trim();
    }
}