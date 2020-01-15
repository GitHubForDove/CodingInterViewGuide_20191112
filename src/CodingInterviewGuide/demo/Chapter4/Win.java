package CodingInterviewGuide.demo.Chapter4;


/**
 * 排成一条线的纸牌博弈
 * <p>
 * 题目：
 * 给定一个整数数组 arr, 代表数值不同的纸牌排成一条线。玩家A 和玩家B依次拿走每张纸牌，
 * 规定玩家A先拿走，玩家B后拿，但是每个玩家每次只能拿走最左或最右的纸牌，玩家A和玩家B都决定聪明。
 * 请返回最后获胜者的分数。
 */
public class Win {

    public int win1(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        return Math.max(f(arr, 0, arr.length - 1), s(arr, 0, arr.length - 1));
    }

    private int f(int[] arr, int i, int j) {
        // 只剩最后一张牌 那么肯定是先手的那个人拿
        if (i == j) {
            return arr[j];
        }

        return Math.max(arr[i] + s(arr, i + 1, j), arr[j] + s(arr, i, j - 1));
    }

    private int s(int[] arr, int i, int j) {
        // 只剩最后一张牌 后手的那个人 肯定拿不到
        if (i == j) {
            return 0;
        }
        return Math.min(f(arr, i + 1, j), f(arr, i, j - 1));
    }

    /**
     * 动态规划
     */
    public int win2(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        int[][] f = new int[arr.length][arr.length];
        int[][] s = new int[arr.length][arr.length];
        for (int j = 0; j <arr.length; j++) {
            f[j][j] = arr[j];
            for (int i= j - 1; i >= 0; i--) {
                f[i][j] = Math.max(arr[i] + s[i+1][j], arr[j] + s[i][j-1]);
                s[i][j] = Math.min(f[i+1][j], f[i][j-1]);
            }
        }
        return Math.max(f[0][arr.length - 1], s[0][arr.length - 1]);
    }


    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 100, 4};
        Win w = new Win();
        int res = w.win2(arr);
        System.out.println(res);
    }

}
