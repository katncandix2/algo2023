package MyString;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public boolean isAnagram(String s, String t) {
        int[]arr = new int[26];

        for(char tmp : s.toCharArray()){
            int idx = tmp - 'a';
            arr[idx]+=1;
        }

        for(char tmp : t.toCharArray()){
            int idx = tmp - 'a';
            arr[idx]-=1;
        }

        for(int i:arr){
            if (i!=0){
                return false;
            }
        }

        return true;
    }

    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> res = new HashSet<>();
        HashSet<Integer> res1 = new HashSet<>();

        for (int i:nums1){
            res1.add(i);
        }

        for (int i:nums2){
            if (res1.contains(i)){
                res.add(i);
            }
        }

        return res.stream().mapToInt(i -> i).toArray();
    }

    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> m1 = new HashMap<>();
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0;i< nums.length;i++){
            int diff = target - nums[i];
            if (m1.containsKey(diff)){
                return new int[]{i,m1.get(diff)};
            }
            m1.put(nums[i],i);
        }

        return new int[0];
    }

    public static void main(String[] args) {
        Main main = new Main();
    }
}
