public class Solution {
    public int MyAtoi(string str) 
    {
        if (string.IsNullOrEmpty(str)||string.IsNullOrWhiteSpace(str)) 
        {
            return 0;
        }
        string[] s = str.Trim().Split(' ');
        string res = "";
        bool isSign = (s[0][0] == '-' || s[0][0] == '+' );
        int counter = 0;
        
        for(int i = 0; i < s[0].Length; i++)
        {
            if(!Char.IsNumber(s[0][i]) && !(i==0 && (s[0][i] == '-' || s[0][i] == '+' )))
            break;
            
            res+=s[0][i];
            counter = i;
            
        }
        
        if(!isSign) 
        
        {
            counter++;
        }
        
        
        int number = 0;
        if(counter <= 0) return 0;
        if(counter < 10) 
        {
            int.TryParse(res, out number);
            return number;
        }
        else if(counter > 10) 
        {
            if(s[0][0] == '-') return int.MinValue;
            else return int.MaxValue;
        }
        else //counter == 10
        {
            long num = 0;
            long.TryParse(res, out num);
            
            if(num > int.MaxValue) return int.MaxValue;
            if(num < int.MinValue) return int.MinValue;
            else return (int)num;
        }
        
    }
    
}