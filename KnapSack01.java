import java.util.*;

public class Main
{
  public static void main (String[]args)
  {
    int[] weights = new int[]{ 1, 3, 4, 5 };
    int[] value = new int[]{ 1, 4, 5, 7 };
    boolean[] picked = new boolean[weights.length];
    for (int i = 0; i < weights.length; i++)
        picked[i] = false;
    int total = 7;
    System.out.println (knapsackZeroOne (weights, value, picked,
					   new HashMap < String,
					   Integer > (), total));
  }

  public static int knapsackZeroOne (int[]weights, int[]value,
				     boolean[]picked, HashMap < String,
				     Integer > memo, int remainder)
  {
    if (remainder == 0)
      return 0;
    String key = getKey(picked, remainder);
    if (memo.containsKey (key))
      return memo.get (key);
    int result = 0;
    for (int i = 0; i < weights.length; i++)
      {
	if (!picked[i])
	  {
	    if (remainder - weights[i] >= 0)
	      {
		    picked[i] = true;
		    int res = value[i] + knapsackZeroOne (weights, value, picked, memo,
					   remainder - weights[i]);
		    result = Integer.max(res, result);
		    picked[i] = false;
	      }
	    }
      }
    memo.put (key, result);
    return result;
  }
  
 public static String getKey(boolean[] picked, int remainder) {
    return Arrays.toString(picked) + "_" + remainder;
  }
}// end of main class


