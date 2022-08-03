import org.junit.Test;
import org.springframework.util.ObjectUtils;

import java.util.Arrays;

public class testArr {

    @Test
    public void test1() {
        Integer[] arr = {31, 41, 59, 26, 41, 58};
//        System.out.println(Arrays.toString(insertSortNoDesc(arr)));
//        System.out.println(Arrays.toString(insertSortNoAsc(arr)));
//        System.out.println(sortlookup1(arr, 58));

    }

    /**
     * 插入排序
     * 符合a(n+1)≥an，则数列是非降序的
     * @param arr
     * @return
     */
    public Integer[] insertSortNoDesc(Integer[] arr) {
        if (ObjectUtils.isEmpty(arr) || arr.length < 2) {
            return arr;
        }

        for (int i = 1; i < arr.length; i++) {
            Integer key = arr[i];
            Integer j = i - 1;
            while (j >= 0 && key < arr[j]) {
                arr[j + 1] = arr[j];
                arr[j] = key;
                j--;
            }
        }
        return arr;
    }

    /**
     * 插入排序
     * 符合a(n+1)≤an，则数列是非升序的
     * @param arr
     * @return
     */
    public Integer[] insertSortNoAsc(Integer[] arr) {
        if (ObjectUtils.isEmpty(arr) || arr.length < 2) {
            return arr;
        }

        for (int i = 1; i < arr.length; i++) {
            Integer key = arr[i];
            Integer j = i - 1;
            while (j >= 0 && key > arr[j]) {
                arr[j + 1] = arr[j];
                arr[j] = key;
                j--;
            }
        }
        return arr;
    }

    /**
     * 线性查找/顺序查找
     * @param arr
     * @return
     */
    public Integer sortlookup(Integer[] arr, Integer v) {
        if (ObjectUtils.isEmpty(arr) || ObjectUtils.isEmpty(v)) {
            return null;
        }
//        Integer i = 0;
//        while (i < arr.length && arr[i] != v) {
//            i++;
//        }
//        return i >= arr.length ? null : arr[i];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == v) {
                return v;
            }
        }
        return null;
    }

    public int[] addBin(int[] a, int[] b) {
        int[] sum = new int[a.length + 1];

        int jinwei = 0;

        for (int i = a.length - 1; i >= 0; i--) {
            if (i == 0) {
                sum[1] = a[0] ^ b[0] ^ jinwei;
                sum[0] = (a[0] + b[0] + jinwei) >> 1;
            } else {
                sum[i + 1] = a[i] ^ b[i] ^ jinwei;
                jinwei = (a[i] + b[i] + jinwei) >> 1;
            }
            System.out.println(jinwei + "---" + a[i] + "---" + b[i] + "---" + Arrays.toString(sum));

        }
        return sum;
    }

    @Test
    public void test2() {
        int[] a = {1, 0, 1, 0, 1};
        int[] b = {0, 1, 0, 1, 1};

        int[] c = addBin(a, b);
        System.out.println(Arrays.toString(c));

    }
}
