# 基于快速排序的查找

### 作用：`在O(n)的时间复杂度下求得无序数组经排序后的第K位数据`

### QuickSortInternalPractice.java

```java
package com.KiveAllen.排序;

import java.util.*;

public class QuickSortInternalPractice {

    public static int findKth(int[] a, int n, int K) {
        return findKth(a,0,n-1,K);
    }

    public static int findKth(int[] a, int low, int high, int K) {
        int part = partition(a,low,high);
        if (part - low + 1 == K) {
            return a[part];
        } else if (part - low + 1 < K) {
            return findKth(a, part+1, high, K-part+low-1);
        } else {
            return findKth(a, low, part-1, K);
        }
    }

    public static int partition(int[] a, int low, int high) {
        int key = a[low];
        while (low < high) {
            while (low < high && a[high] <= key) {
                high--;
            }
            a[low] = a[high];
            while (low < high && a[low] >= key) {
                low++;
            }
            a[high] = a[low];
        }
        a[low] = key;
        return low;
    }
}

```

Main.java

```java
package com.KiveAllen.排序;

import java.util.Arrays;

public class Main {
    public static void main(String[] args){
        int[] a = {1,1,4,32,12,3,4,1,23,141,3,213,1,4};
        String[] arr = {"askndwiansd","asd","fasdw","ijodifg","113edasf"};

        int b=QuickSortInternalPractice.findKth(a,a.length,5);//查找第五个最大的数
        System.out.println(b);//输出
        
        quickSort.doQuickSort(a,0, a.length-1);//快速排序
        System.out.println(Arrays.toString(a));//打印数组
    }
}

```
### 运行示意图
![在O(n)的时间复杂度下求得无序数组经排序后的第K位数据](https://github.com/KiveAllen/AlgorithmLearning/blob/main/%E5%9B%BE%E7%89%87%E5%92%8C%E8%BF%90%E8%A1%8C%E7%BB%93%E6%9E%9C/%E5%9C%A8O(n)%E7%9A%84%E6%97%B6%E9%97%B4%E5%A4%8D%E6%9D%82%E5%BA%A6%E4%B8%8B%E6%B1%82%E5%BE%97%E6%97%A0%E5%BA%8F%E6%95%B0%E7%BB%84%E7%BB%8F%E6%8E%92%E5%BA%8F%E5%90%8E%E7%9A%84%E7%AC%ACK%E4%BD%8D%E6%95%B0%E6%8D%AE.jpg)
