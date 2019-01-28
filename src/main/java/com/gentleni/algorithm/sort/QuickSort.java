package com.gentleni.algorithm.sort;

import java.util.Arrays;

/**
 * Created by GentleNi
 * Date 2019/1/7.
 */
class QuickSort
{

    /**
     * 总算搞明白了。这里的i就代表最后分区中点的位置，相当于占位符，从左到右扫描，i默认先在数组的最左边
     * 占个位，相当于右边都是未排序的。
     * 比如 8 1 5 2 7
     * i一开始在8的左侧，（但其实i就是8的位置）
     * 1：8比7大，不用管，因为i就是在8的左侧，现在是【8(i)】
     * 2：1比7小，那么i就要向右移动一位，因为左边有一个比它小的了，而且1和8交换一下，i+1，
     * 相当于现在排好的是【1，8(i)】
     * 3：5比7小，i+1，并且5和8交换，现在是【1,5,8(i)】
     * 4:【1，5，2，8（i）】
     * 5:【1，5，2，7，8(i)】，最后一步再把7换到它应该在的地方，i相当于一个占位符，先占据了7的位置
     */
    int partition(int arr[], int low, int high)
    {
        int pivot = arr[high];
        int i = (low-1); // index of smaller element
        for (int j=low; j<high; j++)
        {
            // If current element is smaller than or
            // equal to pivot
            if (arr[j] <= pivot)
            {
                i++;

                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // swap arr[i+1] and arr[high] (or pivot)
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;

        return i+1;
    }


    /* The main function that implements QuickSort()
      arr[] --> Array to be sorted,
      low  --> Starting index,
      high  --> Ending index */
    void sort(int arr[], int low, int high)
    {
        if (low < high)
        {
            /* pi is partitioning index, arr[pi] is
              now at right place */
            int pi = partition(arr, low, high);

            System.out.println(Arrays.toString(arr));
            // Recursively sort elements before
            // partition and after partition
            sort(arr, low, pi-1);
            sort(arr, pi+1, high);
        }
    }

    /* A utility function to print array of size n */
    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }

    // Driver program
    public static void main(String args[])
    {
        int arr[] = {8,1,5,2,7};
        int n = arr.length;

        QuickSort ob = new QuickSort();
        ob.sort(arr, 0, n-1);

        System.out.println("sorted array");
        printArray(arr);
    }
}