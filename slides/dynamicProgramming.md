## Dynamic Programming

#### By: Patrick Malolepszy

#### Slides based on David Valleau's slides 2016/2017

#### November 27, 2017



## What is it?

- Dynamic programming is used for solving problems that have recurring subproblems that we want to avoid solving multiple times
- It is typically used in optimization problems:
    - E.g. Find the minimum path from A to B, Find the minimum number of coins to be used for making change
- The difficulty with these problems is formulating the subproblems and how to save their results



## Top Down Approach

- Also referred to as memorization
- Based on a recursive formulation of the problem:
- If the current problem can be solved using the solutions to its subproblems, and they are overlapping, then the solutions can be memorized and used again rather than solved again.
-We typically store these previous solutions in a key-value store such as a Hashmap.



## Bottom-Up Approach

- In this approach, we begin by solving the smaller subproblems and iterate up towards the problem that is to be solved
- This method is typically harder to reason about
- What I recommend is to first try to formulate the problem from a top-down perspective, and then transform that solution into a bottom-up approach.



## Example 

- Find the Nth term in the fibonacci sequence
- Simple recursive problem : fib(n) = fib(n-1) + fib(n-2)

- However solving it this way requires the repeated computation of small subproblems, which leads to a slow solution O(2n)



### Recursive
```java
int fibRecursive(int n) {
    if (n == 0 || n == 1) {
        return n;
    }
    return fibRecursive(n-1) + fibRecursive(n-2);
}
```



### Top Down
```java
int fibTopDown(int n) {
        int[] dp = new int[n+1];
        return fibTopDown(n, dp);
}

int fibTopDown(int n, int[] dp) {
    if (n == 0 || n == 1) {
        return n;
    }
    if (dp[n] == 0) {
        dp[n] = fibTopDown(n-1, dp) + fibTopDown(n-2, dp);
    }
    return dp[n];
}
```



### Bottom Up
```java
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
```