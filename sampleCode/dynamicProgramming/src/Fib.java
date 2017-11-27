public class Fib {

     int fibRecursive(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        return fibRecursive(n-1) + fibRecursive(n-2);
    }

    int fibTopDown(int n) {
         int[] memorization = new int[n+1];
         return fibTopDown(n, memorization);
    }

    int fibTopDown(int n, int[] memorization) {
        if (n == 0 || n == 1) {
            return n;
        }
        if (memorization[n] == 0) {
            memorization[n] = fibTopDown(n-1, memorization) + fibTopDown(n-2, memorization);
        }
        return memorization[n];
    }

    int fibBottomUp(int n) {
        if (n == 0) {
            return 0;
        }
        int a = 0, b = 1;
        for (int i = 0 ; i < n ; i++) {
            int c = a + b;
            a = b;
            b = c;
        }
        return a + b;
    }

}
