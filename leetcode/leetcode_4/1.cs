public class Solution {
    public double FindMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = 0;
        int m=0;
        int[] num = new int[(nums1.Length + nums2.Length)];
     for(int k = 0; k < num.Length; k++ )
     {
        if( m >= nums1.Length)  
        {
            num[k] = nums2[n];
            n+=1;
            continue;
        } 
        if( n >= nums2.Length) 
        {
             num[k] = nums1[m];
              m+=1;
            continue;
        }
        
        if(nums1[m] > nums2[n])
        {
            num[k] = nums2[n];
            n+=1;
        }
        else 
        {
            num[k] = nums1[m];
              m+=1;
        }
     }  
     Console.WriteLine(num.Length);
     if(num.Length % 2 == 0)
     {
         Console.WriteLine( num[num.Length/2 ]);
         Console.WriteLine(num[num.Length/2 - 1 ] );
         return  (double)(num[num.Length/2] + num[num.Length/2-1])/2;
     }
     else 
     {
         return num[((num.Length - 1)/2)];
     }
}
}