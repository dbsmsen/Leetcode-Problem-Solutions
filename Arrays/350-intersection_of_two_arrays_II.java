/*
 Given two integer arrays nums1 and nums2, return an array of their intersection. 
 Each element in the result must appear as many times as it shows in both arrays and you may return the result in any order.

Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2,2]

Example 2:

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [4,9]
Explanation: [9,4] is also accepted.
 
Constraints:

1 <= nums1.length, nums2.length <= 1000
0 <= nums1[i], nums2[i] <= 1000
 */

import java.util.Hashtable;
import java.util.ArrayList;

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {

        // Interate through nums1 array, store all of the values and frequencies inside of the hashtable.
        
        // [4,9,5,4] -> Hashtable <4: 2, 9: 1, 5: 1> -> (Key: number, value: frequency)
        //        i

        Hashtable<Integer, Integer> nums1Map = new Hashtable <>();
        ArrayList<Integer> intersectionAL = new ArrayList();

        for(int i = 0; i < nums1.length; i++){
            if(nums1Map.containsKey(nums1[i])){
                nums1Map.put(nums1[i], nums1Map.get(nums1[i])+1);
            }
            else{
                nums1Map.put(nums1[i], 1);
            }
        }

        // iterate through nums2, at each interation, check if the current element exist in our hashtable.
        // if it exist, add this element to our array list, substract 1 from the frequency in the hashtable.

        for(int i = 0; i < nums2.length; i++){
            if(nums1Map.containsKey(nums2[i])){
                intersectionAL.add(nums2[i]);
                nums1Map.put(nums2[i], nums1Map.get(nums2[i]) - 1);
                if(nums1Map.get(nums2[i]) == 0){
                    nums1Map.remove(nums2[i]);
                }
            }
        }

        // nums1 = [4,9,5,4]
        //                i 

        // nums2 = [9,4,9,8,4]
        //                  i

        // Define an array with the size of the arrayList size

        int[] result = new int[intersectionAL.size()];

        for(int i = 0; i < result.length; i++){
            result[i] = intersectionAL.get(i);
        }
        return result;

        // ArrayList: <9, 4, 4>
        // result: [9, 4, 4]

    }
}

/*
    Time Complexity :

    nums1 = [4,9,5,4]
    nums2 = [9,4,9,8,4]

    Given that n is the size of both arrays, our time complexity is going to be 0(3n) --> 0(n)
 */

/*
    Space Complexity :

    Hashtable = n keys
    ArrayList = n values
    result array = n values as well

    Scapce Complexity = 0(3n) --> 0 (n)
 */