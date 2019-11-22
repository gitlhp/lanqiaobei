package lhp.sort;

import java.lang.management.LockInfo;
import java.util.Arrays;

/**
 * @ClassName: InsertSort
 * @Description:排序
 * @Author: 李怀鹏
 * @Company: JD-BJUT
 * @Date： 2019/11/22 15:15
 * @Version： V1.0
 **/
public class Sort {
    /**
     * 插入类排序
     */
    //直接插入排序
    public static int[] InsertSort(int[] arr) {
        int j = 0, key;
        for (int i = 1; i < arr.length; i++) {
            key = arr[i];
            j = i - 1;
            while (j >= 0 && key < arr[j]) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
        return arr;
    }

    //二分折半插入排序0(n2)
    public static int[] halfInsertSort(int[] arr) {
        int low, high, mod, key;
        for (int i = 1; i < arr.length; i++) {
            key = arr[i];
            low = 0;
            high = i - 1;
            while (low <= high) {
                mod = (high + low) / 2;
                if (key == arr[mod]) {
                    break;
                } else if (key < arr[mod]) {
                    high = mod - 1;
                } else {
                    low = mod + 1;
                }
            }
            //移动数据
            for (int i1 = i - 1; i1 >= low; i1--) {
                arr[i1 + 1] = arr[i1];
            }
            arr[low] = key;
        }
        return arr;
    }

    //希尔排序
    public static int[] ShellSort(int[] arr) {
        int len = arr.length;
        for (int gap = len / 2; gap > 0; gap /= 2) {
            //对每个小组进行插入排序
            for (int i = gap; i < len; i++) {
                oneShellSort(arr, gap, i);
            }
        }
        return arr;
    }

    private static void oneShellSort(int[] arr, int index, int i) {
        int x = 0;
        for (int j = i; j < arr.length; j += index) {
            int key = arr[j];
            x = j - index;
            while (x >= 0 && key < arr[x]) {
                arr[x + index] = arr[x];
                x -= index;
            }
            arr[x + index] = key;
        }
    }

    /**
     * 交换类排序
     */
    //冒泡排序
    public static int[] bubbleSort(int[] arr) {
        int temp = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length-i-1; j++) {
                if (arr[j]>arr[j+1]){
                    temp = arr[j+1];
                    arr[j+1]=arr[j];
                    arr[j]=temp;
                }
            }
        }
        return arr;
    }
//快速排序
    public static int[] FastSort(int[] arr,int low,int high){
        if (arr==null||arr.length==0||low>high) {
            return null;
        }
        if (low<high){
            int index = getIndex(arr,low,high);
            FastSort(arr,0,index-1);
            FastSort(arr,index+1,high);
        }

        return arr;
    }
    //计算基准位置
    private static int getIndex(int[] arr,int low, int high){
        int key = arr[low];
        while (low!=high){
            while (low<high&&arr[high]>key){
                high--;
            }
                arr[low]=arr[high];
            while (low<high&&arr[low]<key){
                low++;
            }
                arr[high]=arr[low];
        }
        arr[low]=key;
        return low;
    }
    public static void main(String[] args) {
        int[] array = {6, 9, 3, 4, 2, 1, 8, 0, 22,77,5,11111,66};
        int[] array1 = {1,2,3,4};
        //直接插入排序 0(n)0(n2)
//        Arrays.stream(InsertSort(array)).forEach(item -> System.out.println(item));
        //二分查找排序
//        Arrays.stream(halfInsertSort(array)).forEach(item -> System.out.println(item));
        //希尔排序
//        Arrays.stream(ShellSort(array)).forEach(item-> System.out.println(item));
        //冒泡排序
//        Arrays.stream(bubbleSort(array)).forEach(item-> System.out.println(item));
//        FastSort(array1,0,array1.length-1);
        Arrays.stream(FastSort(array, 0, array.length - 1)).forEach((item-> System.out.println(item)));
    }
}
