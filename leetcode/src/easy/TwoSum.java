package easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class TwoSum {



    public static int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> tempMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            //將陣列中與target的差做為key存在map中,值為index

            if((tempMap.get(nums[i]))!=null){
                int[] ints = new int[2];
                ints[0]=tempMap.get(nums[i]);
                ints[1]=i;
                return ints;
            }
            tempMap.put(target-nums[i],i);
        }

        return null;
    }

    public static void printMap(HashMap<Integer,Integer> map){
       for(Integer key : map.keySet()){
           System.out.println(key+"="+map.get(key));
       }



    }

    public static void main(String[] args) {
        int[] nums = {3,3};
        int target = 6;
//        int[] nums = {3,2,4};
//        int target = 6;


        int[] result = twoSum(nums, target);
        System.out.println(Arrays.toString(result));

    }
}
