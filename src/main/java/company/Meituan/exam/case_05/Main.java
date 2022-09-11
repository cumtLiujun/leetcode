    package company.Meituan.exam.case_05;

    import java.util.Scanner;

    public class Main {
        private static int dfs (int[] nums , int root, int n) {
            if (root >= n) {
                return 0;
            }
            return nums[root] + Math.max(dfs(nums,root * 2 +1, n), dfs(nums,root * 2 +2,n));
        }
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            while (scanner.hasNext()) {
                int n = scanner.nextInt();
                int[] nums = new int[n];
                for (int i = 0; i < n; i++) {
                    nums[i] = scanner.nextInt();
                }


                System.out.println(dfs(nums,0,n));
            }
        }
    }
