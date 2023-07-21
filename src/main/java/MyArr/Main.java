package MyArr;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    //209. 长度最小的子数组
    //https://leetcode.cn/problems/minimum-size-subarray-sum/
    public int minSubArrayLen(int target, int[] nums) {
        Queue<Integer> queue = new LinkedList<>();
        int sum = 0;
        int minLen = nums.length;
        boolean flag = false;

        for (int i = 0 ;i< nums.length;i++){
            queue.offer(nums[i]);
            sum = sum + nums[i];

            while (sum >=target){
                minLen = Math.min(queue.size(),minLen);

                Integer tmp = queue.poll();
                sum = sum - tmp;

                flag = true;
            }
        }

        if (flag){
            return minLen;
        }

        return 0;
    }

    public void swap(int arr[],int i,int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    //27.移除元素
    //https://leetcode.cn/problems/remove-element/
    public int removeElement(int[] nums, int val) {
        int slow = 0, fast = 0;
        int cnt = nums.length;
        while (fast < nums.length){
            //找到下一个不等于val 的元素塞入 新数组中
            if (nums[fast]!=val){
                nums[slow] = nums[fast];
                slow++;
            }else {
                cnt--;
            }

            fast++;
        }

        for (;slow<nums.length;slow++){
            nums[slow] = 0;
        }

        return cnt;
    }

    //704. 二分查找
    //https://leetcode.cn/problems/binary-search/
    public int search(int[] nums, int target) {
        //左闭右闭
        int left = 0,right = nums.length -1 ;

        while (left <= right){
            int mid = (left + right) / 2;
            if (nums[mid]>target){
                right = mid - 1;
            }

            if (nums[mid] < target){
                left = mid + 1;
            }

            if (nums[mid] == target) {
                return mid;
            }
        }

        return -1;
    }


    //59. 螺旋矩阵 II
    //https://leetcode.cn/problems/spiral-matrix-ii/
    public int[][] generateMatrix(int n) {
        int arr[][] = new int[n][n];
        int startX = 0,startY = 0;
        int offset = 1;
        int cnt = 1;

        int x = 0,y = 0;
        int loop = n / 2;
        while (loop > 0){

            //左----> 右
            for (y = startY;y <n-offset;y++){
                arr[startX][y] = cnt++;
            }

            //上----> 下
            for (x = startX;x < n-offset;x++){
                arr[x][y] = cnt++;
            }

            //右 -----> 左
            for (;y >= offset;y--){
                arr[x][y] = cnt++;
            }

            //左 ------> 右
            for (;x >= offset;x--){
                arr[x][y] = cnt++;
            }

            startX++;
            startY++;
            offset++;
            loop --;
        }

        //解决n 为奇数的情况
        if (n % 2 !=0){
            arr[n/2][n/2] = cnt++;
        }

        return arr;
    }


    //977. 有序数组的平方
    //https://leetcode.cn/problems/squares-of-a-sorted-array/
    public int[] sortedSquares(int[] nums) {

        for (int i = 0;i<nums.length;i++){
            nums[i] = (nums[i] * nums[i]);
        }

        int res[] = new int[nums.length];
        int cur = nums.length-1;
        int left = 0;
        int right = nums.length-1;
        for (;left<=right;){
            if (nums[left]>nums[right]){
                res[cur] = nums[left];
                left++;
            }else {
                res[cur] = nums[right];
                right--;
            }

            cur--;
        }

        return res;
    }


    public static void main(String[] args) {
        int arr[] = {-4,-1,0,3,10};
//        int arr[] = {-5,-3,-2,-1};

        Main main = new Main();
        int[] ints = main.sortedSquares(arr);
        Arrays.stream(ints).forEach(System.out::println);
    }
}
