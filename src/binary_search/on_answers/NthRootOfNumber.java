package binary_search.on_answers;

import java.math.BigInteger;

public class NthRootOfNumber {
    public static void main(String[] args) {
        int N = 9, M = 512;
        System.out.println(NthRoot(N, M));
        System.out.println(NthRoot1(N, M));
    }

    static int f(int n, int m, int mid) {
//        long ans = 1;
//        for (int i = 1; i <= n; i++) {
//            ans *= mid;
//            if (ans > m) {
//                return 2;
//            }
//        }
//        if (ans == m)
//            return 1;
//        return 0;
        return pow(new BigInteger(String.valueOf(mid)), n, new BigInteger(String.valueOf(m)));
    }

    public static int NthRoot(int N, int M) {
        int low = 1, high = M;
        while (low <= high) {
            int mid = (low + high) / 2;
            int res = f(N, M, mid);
            if (res == 1) {
                return mid;
            } else if (res == 2) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public static int NthRoot1(int N, int M) {
        int low = 1, high = M;
        while (low <= high) {
            int mid = (low + high) / 2;
            int res = f(N, M, mid);
            if (res == 1) {
                return mid;
            } else if (res == 2) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    static int pow(BigInteger x, long y, BigInteger M) {
        BigInteger ans = new BigInteger("1");
        while (y > 0) {
            if ((y & 1) != 0) {
                ans = ans.multiply(x);
                if (ans.compareTo(M) > 0) {
                    return 2;
                }
            }
            y >>= 1;
            x = x.multiply(x);
        }
        if (ans.compareTo(M) == 0)
            return 1;
        return 0;
    }
}
