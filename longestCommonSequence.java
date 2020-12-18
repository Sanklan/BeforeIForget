import java.util.*;

public class Main
{
  public static void main (String[]args)
  {
    System.out.println ("____" + "Hello World".substring (0, 0) + "___");
    int result =
      longestSubSequence ("abcdaf", "acbcf", new HashMap < String,
			  Integer > ());
      System.out.println (" The Result is " + result);
  }

  public static int longestSubSequence (String s1, String s2,
					HashMap < String, Integer > memo)
  {
    String key = s1 + "_" + s2;
    System.out.println(key);
    if (memo.containsKey (key))
      return memo.get (key);
    if (s1.length () == 0 || s2.length () == 0)
      return 0;

    int result = 0;
    if (s1.charAt (s1.length () - 1) == s2.charAt (s2.length () - 1))
      {
	result = 1 + longestSubSequence (s1.substring (0, s1.length () - 1),
				     s2.substring (0, s2.length () - 1), memo);
      }
    else
      {
	int side1 = longestSubSequence (s1.substring (0, s1.length () - 1),
					s2, memo);
	int side2 = longestSubSequence (s1,
					s2.substring (0, s2.length () - 1),
					memo);
	result = Integer.max (side1, side2);
      }
     System.out.println(key + " : "+ result);
    memo.put(key, result);
    return result;
  }
}
