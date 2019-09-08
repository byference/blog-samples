package com.github.byference.algorithm.sort;

import java.util.Arrays;

/**
 * 快排
 *
 * @author byference
 * @since 2019/06/16
 */
public class QuickSort<T extends Comparable<T>> implements Sort<T> {

    @Override
    public void sort(T[] values) {
        int n = values.length;
        int low = 0;
        int high = n - 1;

        sort(values, low, high);
    }


    private void sort(T[] values, int low, int high) {
        if (low < high) {
            int pIndex = partition(values, low, high);
            sort(values, low, pIndex - 1);
            sort(values, pIndex + 1, high);
        }
    }

    /**
     * 获取分区索引
     *
     * @param values 数组对象
     * @param low    低位索引
     * @param high   高位索引
     * @return 分区索引
     */
    int partition(T[] values, int low, int high) {
        T pivot = values[high];
        int i = low;

        for (int j = low; j < high; j++) {
            if (values[j].compareTo(pivot) < 1) {
                T temp = values[i];
                values[i] = values[j];
                values[j] = temp;
                i++;
            }
        }

        T temp = values[i];
        values[i] = values[high];
        values[high] = temp;

        return i;
    }


    public static void main(String[] args) {
        Integer[] values = {2, 8, 4, 9, 3, 6};
        Sort<Integer> sort = new QuickSort<>();
        sort.sort(values);
        System.out.println(Arrays.asList(values));
    }


}