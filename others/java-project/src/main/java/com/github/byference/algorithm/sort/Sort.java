package com.github.byference.algorithm.sort;

/**
 * 排序算法
 *
 * @author byference
 * @since 2019/06/16
 */
public interface Sort<T extends Comparable<T>> {

    /**
     * 排序
     * @param values 待排序数组
     */
    void sort(T[] values);

}
