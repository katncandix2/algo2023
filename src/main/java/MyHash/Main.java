package MyHash;

import java.util.*;

public class Main {


    // 242.有效的字母异位词
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

    //349. 两个数组的交集
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

    // 1.两数之和
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


    // 454.四数相加II
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        HashMap<Integer, Integer> m1 = new HashMap<>();

        int  res = 0;

        for (int i = 0;i< nums1.length;i++){
            for (int j=0;j<nums2.length;j++){
                int tmpSum = nums1[i] + nums2[j];
                if (m1.containsKey(tmpSum)){
                    Integer cnt = m1.get(tmpSum);
                    cnt++;
                    m1.put(tmpSum,cnt);
                }else{
                    m1.put(tmpSum,1);
                }
            }
        }


        for (int i = 0;i<nums3.length;i++){
            for (int j=0;j<nums4.length;j++){
                int tmpSum = 0 - (nums3[i]+nums4[j]);
                if (m1.containsKey(tmpSum)){
                     res += m1.get(tmpSum);
                }
            }
        }

        return res;
    }


    //15 三数相加
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        if (nums[0] > 0){
            return res;
        }

        for (int i = 0;i<nums.length;i++){
            if (i > 0 && nums[i] == nums[i-1]){
                continue;
            }

            int left = i + 1;
            int right = nums.length-1;

            while (left < right){
                int sum = nums[i]  + nums[left] + nums[right];

                if (sum > 0){
                    right--;
                }else if (sum < 0){
                    left++;
                }else {

                    res.add(Arrays.asList(nums[i],nums[left],nums[right]));

                    while (left < right && nums[right] == nums[right-1]){
                        right--;
                    }

                    while (left < right && nums[left] == nums[left+1]){
                        left--;
                    }

                    right--;
                    left++;
                }
            }
        }

        return res  ;
    }

    public static void main(String[] args) {
        Main main = new Main();
    }
}
