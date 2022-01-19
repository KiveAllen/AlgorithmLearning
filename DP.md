## 动态规划作业

### 实例代码

```java
package com.KiveAllen.DP;

public class knapsackProblem {

    public static void main(String[] args) {
        int[][] cell = new int[5][7];
        int a, b;
        cell[0][1] = 0;
        cell[0][2] = 0;
        cell[0][3] = 10;
        cell[0][4] = 10;
        cell[0][5] = 10;
        cell[0][6] = 10;
        for (int j = 1; j < 7; j++) {
            for (int i = 1; i < 5; i++) {
                if (i == 1) {
                    a = 3;
                    b = 1;
                } else if (i == 2) {
                    a = 9;
                    b = 2;
                } else if (i == 3) {
                    a = 5;
                    b = 2;
                } else {
                    a = 6;
                    b = 1;
                }
                if (j - b < 0) {
                    cell[i][j] = cell[i - 1][j];
                } else {
                    cell[i][j] = cell[i - 1][j] > (a + cell[i - 1][j - b]) ? cell[i - 1][j] : (a + cell[i - 1][j - b]);
                }
            }
        }
        for (int i = 0; i < 5; i++) {
            for (int j = 1; j < 7; j++) {
                System.out.print(cell[i][j] + " ");
            }
            System.out.println();
        }
    }
}
```

### 画出网格和网格的填充过程

0 0 10 10 10 10 

3 3 10 13 13 13 

3 9 12 13 19 22 

3 9 12 14 19 22 

6 9 15 18 20 25 
