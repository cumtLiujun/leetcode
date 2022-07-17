class dynamic_programming {


    public static int fab(int n) {

        int mod = 1000000007;
        if (n < 2) return n;
        int f0 = 0,f1 = 1, sum = 0;
        for (int i = 2; i <= n; i++){
            sum = f0 + f1;
            f0 = f1;
            f1 = sum % mod;
        }
        return f1;
    }

// f(n) = f(n - 1) + f(n-2)
    public static int numWays(int n) {
        int mod = 1000000007;
        if(n == 0 ) return 1;
        if(n == 1 ) return 1;
        int fn0 = 1, fn1 = 1, sum = 0;
        for(int i = 2;i<=n; i++){
            sum = fn0 + fn1;
            fn0 = fn1;
            fn1 = sum % mod;
        }

        return fn1;
    }

    public static void main(String[] args) {
        System.out.println(numWays(7));
    }
}


