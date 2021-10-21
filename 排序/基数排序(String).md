# 基数排序(String)

### stringRadixSort.java

```java
package com.KiveAllen.排序;

import java.util.Arrays;

public class stringRadixSort {
    //ascii码的取值范围
    private static final int ASCII_RANGE = 128;

    public static String[]  radixSort(String[] arr) {
        //元素最长位数
        int maxLength = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length() > maxLength){
                maxLength = arr[i].length();
            }
        }
        //排序结果数组
        String[] sortedArr = new String[arr.length];

        //从个位开始比较，一直比较到最高位
        for(int k = maxLength-1;k >= 0;k--) {
            int[] countArr = new int[ASCII_RANGE];
            for(int i = 0;i < arr.length;i++) {
                int index = getCharIndex(arr[i],k);
                countArr[index]++;
            }
            //统计数组变换
            int sum = 0;
            for(int i = 0;i < countArr.length;i++) {
                sum += countArr[i];
                countArr[i] = sum;
            }
            //倒序遍历原始数列，进行排序
            for(int i = arr.length-1;i >= 0;i--) {
                int index = getCharIndex(arr[i],k);
                sortedArr[countArr[index]-1] = arr[i];
                countArr[index]--;
            }
            //把每一轮的结果复制给arr
            arr = sortedArr.clone();
        }
        return arr;
    }
    //获取字符串第k位字符所对应的ascii码序号
    private static int getCharIndex(String str, int k){
        //w位数不足的位置补0
        if(str.length() < k+1){
            return 0;
        }
        return str.charAt(k);
    }

    public static void main(String[] args) {
        String[] arr = {"sd","aaad", "q","iio","ii","ssd", "pq","AAAD","Q"};
        System.out.println(Arrays.toString(radixSort(arr)));
    }
}
```

### Main.java

```java
package com.KiveAllen.排序;

import java.util.Arrays;

public class Main {
    public static void main(String[] args){
        int[] a = {1,1,4,32,12,3,4,1,23,141,3,213,1,4};
        String[] arr = {"askndwiansd","asd","fasdw","ijodifg","113edasf"};
//        insertSort.doInsertSort(a);
//        selectSort.doSelectSort(a);
//        bubbleSort.doBubbleSort(a);
//        quickSort.doQuickSort(a,0, a.length-1);
//        mergeSort.mergesort(a);
//        bucketSort.doBucketSort(a);
//        a=countSort.doCountSort(a);
//        a=optimizeCountSort.doCountSort(a);
//        RadixSort.doRadixSort(a,10,3);
        arr=stringRadixSort.radixSort(arr);


        System.out.println(Arrays.toString(arr));
    }
}

```
### 运行结果示意图
![运行结果示意](https://github.com/KiveAllen/AlgorithmLearning/blob/main/%E5%9B%BE%E7%89%87%E5%92%8C%E8%BF%90%E8%A1%8C%E7%BB%93%E6%9E%9C/%E5%9F%BA%E6%95%B0%E6%8E%92%E5%BA%8F(String)%E7%9A%84%E8%BF%90%E8%A1%8C%E7%BB%93%E6%9E%9C.jpg)


