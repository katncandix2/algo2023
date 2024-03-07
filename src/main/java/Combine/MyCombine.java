package Combine;

import java.time.temporal.ValueRange;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class MyCombine {

    //77.组合问题




    public List<List<Integer>> combine(int n, int k) {
        combineHelper(n, k, 1);
        return result;
    }

    /**
     * 每次从集合中选取元素，可选择的范围随着选择的进行而收缩，调整可选择的范围，就是要靠startIndex
     * @param startIndex 用来记录本层递归的中，集合从哪里开始遍历（集合就是[1,...,n] ）。
     */

    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    private void combineHelper(int n, int k, int startIndex){
        //终止条件
        if (path.size() == k){
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = startIndex; i <= n; i++){
            path.add(i);
            combineHelper(n, k, i + 1);

            //这一步没太看懂
            //放在递归出口就出错了
            path.removeLast();
        }
    }

    ArrayList res = new ArrayList<>();

    //51.N皇后
    public List<List<String>> solveNQueens(int n) {

        char[][] chars = new char[n][n];
        for (int i=0;i<n;i++){
            for(int j = 0;j<n;j++){
                chars[i][j] = '.';
            }
        }

        solveNQueens(chars,n,0);
        return res;
    }

    public void solveNQueens(char[][] arr,int n,int row){
        //遍历到第n 行后收集结果
        if (n == row){
            res.add(arr);
            return;
        }

        for (int i=0;i<n;i++){
            if (isValid(i,row,n,arr)){
                arr[row][i] = 'Q';
                solveNQueens(arr,n,row+1);
                arr[row][i] = '.';
            }
        }

    }

    public boolean isValid(int row, int col, int n, char[][] chessboard) {
        // 检查列
        for (int i=0; i<row; ++i) { // 相当于剪枝
            if (chessboard[i][col] == 'Q') {
                return false;
            }
        }

        // 检查45度对角线
        for (int i=row-1, j=col-1; i>=0 && j>=0; i--, j--) {
            if (chessboard[i][j] == 'Q') {
                return false;
            }
        }

        // 检查135度对角线
        for (int i=row-1, j=col+1; i>=0 && j<=n-1; i--, j++) {
            if (chessboard[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }





    public static void main(String[] args) {
        MyCombine myCombine = new MyCombine();

        System.out.println(myCombine.combine(4, 2));
        System.out.println(myCombine.combine(4, 3));
//        System.out.println(myCombine.combine(10, 3));
    }

}
