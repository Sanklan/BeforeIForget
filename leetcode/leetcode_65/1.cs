using System.Text.RegularExpressions;
public class Solution {
    public bool IsNumber(string s) {
        //number, dot, e 10^2 - allowed strings
        //s=" s12";
        /*var temp = s.Trim(new Char[]{'0','1','2','3','4','5','6','7','8','9'});
        //temp = temp.Replace(" ",String.Empty);
        //Console.WriteLine(temp);
        if(String.IsNullOrEmpty(temp) == true || (String.IsNullOrWhiteSpace(temp) && s.Length > 1))
            return true;
        else if(temp.Length == 1 && temp == "e" && s.Length > 1)
        {
            string[] temp1 = s.Split('e');
            if(!String.IsNullOrEmpty(temp1[0]) && !String.IsNullOrEmpty(temp1[1]) && temp1.Length == 2)
            return true;
        }
        else if(temp.Length == 1 && temp == "." && s.Length > 1)
            return true;
        
            return false;
          */  
            Regex rgx1 = new Regex(@"^([\s])*([-+])?([0-9])+([e]([-+])?[0-9]+)?([\s])*$");
            Regex rgx2 = new Regex(@"^([\s])*([-+])?([0-9])*[.]([0-9])+([e]([-+])?[0-9]+)?([\s])*$");
            Regex rgx4 = new Regex(@"^([\s])*([-+])?([0-9])+[.]([0-9])*([e]([-+])?[0-9]+)?([\s])*$");
          //  Regex rgx3 = new Regex(@"^([\s])*([-+])*([0-9])+[e]([0-9])+([\s])*$");
          //  Regex rgx5 = new Regex(@"^([\s])*([-+])*([0-9])+[.][e]([0-9])+([\s])*$");
            //Regex rgx3 = new Regex(@"^([\s])*([0-9])+[e]([0-9])+([\s])*$");
            
            
            return (rgx1.IsMatch(s) ||rgx2.IsMatch(s) ||rgx4.IsMatch(s) );
        
    }
}