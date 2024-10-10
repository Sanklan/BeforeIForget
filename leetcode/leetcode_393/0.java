class Solution {
    public boolean validUtf8(int[] data) {
        int currentNumber = 0;
        int currentNumberOfBytes = 1;
        HashMap<Integer,Integer> values = new HashMap<Integer,Integer>();
        values.put(0, 1);
        values.put(1, 2);
        values.put(2, 4);
        values.put(3, 8);
        values.put(4, 16);
        values.put(5, 32);
        values.put(6, 64);
        values.put(7, 128);
        
        while(currentNumber < data.length) {
            //single byte
            if(data[currentNumber] < 128) {
                currentNumber++;
                continue;
            }
            else {
                //multiple byte
                int countStartingOnces = 0;
                int t = data[currentNumber];
                for(int i = 7; i >= 0; i--) {
                    if(t - values.get(i) >= 0){
                        t = t - values.get(i);
                        countStartingOnces++;                        
                    }
                    else break;
                }
                if (countStartingOnces > 4) {
                    return false;
                                             }
            //    System.out.println("number of ones " + countStartingOnces);
                int startIndex = currentNumber;
                int endIndex = startIndex + countStartingOnces - 1;
                if(endIndex >= data.length) {
                   // System.out.println("Number of integers are less than ones");
                    return false;
                }
                while(startIndex <= endIndex) {
                    if(data[startIndex] < 128 || data[startIndex] >= 192 && startIndex != currentNumber) {
                       // System.out.print("Didn't find number starting with 10XXXXXXX " + data[startIndex]);
                        return false;
                    }
                    if(startIndex == currentNumber && data[startIndex] < 192) {
                       // System.out.println("Starting number is less than 192");
                        return false;
                    }
                    startIndex++;
                }
                currentNumber = endIndex + 1;                
            }
        }
        
        return true;
        
    }
}