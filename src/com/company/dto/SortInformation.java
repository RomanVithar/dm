package com.company.dto;

import java.util.Comparator;
import java.util.List;

public class SortInformation {
    public List listForSort;
    public int countPermutation;
    public int countComparison;
    public Comparator comparator;

    public SortInformation(List listForSort, Comparator comparator) {
        this.listForSort = listForSort;
        countComparison = 0;
        countPermutation = 0;
        this.comparator = comparator;
    }
}







/*
    public static void byInsert(SortInformation so) {
        for (int j = 1; j < so.listForSort.size(); j++) {
            int i = j - 1;
            while (i > -1 && compare(so, i, i + 1) > 0) {
                swap(so, i, i + 1);
                i--;
            }
        }
    }

    public static void byInsertWithBinarySearch(SortInformation so) {
        for (int i = 1; i < so.listForSort.size(); i++) {
            int minIndex = 0;
            int maxIndex = i;
            while (minIndex < maxIndex) {
                int mid = minIndex + ((maxIndex - minIndex) / 2);
                if (compare(so, i, mid) < 0) {
                    maxIndex = mid;
                } else {
                    minIndex = mid + 1;
                }
            }
            Object key = so.listForSort.get(i);
            for (int j = i; j >= minIndex + 1; j--) {
                so.listForSort.set(j, so.listForSort.get(j - 1));
                so.countPermutation++;
            }
            so.listForSort.set(minIndex, key);
            so.countPermutation++;
        }
    }

    public static void vail(SortInformation so) {
        for (int i = 0; i < so.listForSort.size(); i++) {
            for (int j = 0; j < so.listForSort.size() - 1; j++) {
                if (compare(so, j, j + 1) > 0) {
                    swap(so, j, j + 1);
                }
            }
        }
    }

    public static void shell(SortInformation so) {
        for (int step = so.listForSort.size() / 2; step > 0; step /= 2) {
            for (int i = step; i < so.listForSort.size(); i++) {
                int j = i - step;
                while (j >= 0 && compare(so, j, j + step) > 0) {
                    swap(so, j, j + step);
                    j -= step;
                }
            }
        }
    }
 */
