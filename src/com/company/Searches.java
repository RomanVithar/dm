package com.company;

import java.util.ArrayList;

public class Searches {
    private int numbIter;

    public Searches() {
        numbIter = 0;
    }

    //бинарный поиск
    public int binary(ArrayList<Integer> list, int key, int low, int high) {
        int index = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (list.get(mid) < key) {
                low = mid + 1;
            } else if (list.get(mid) > key) {
                high = mid - 1;
            } else if (list.get(mid) == key) {
                index = mid;
                break;
            }
            numbIter++;
        }
        return index;
    }

    // линейный поиск
    public int line(int value, ArrayList<Integer> list) {
        numbIter = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == value) {
                numbIter = i + 1;
                return i;
            }
        }
        numbIter = list.size();
        return -1;
    }

    public int getNumbIter() {
        return numbIter;
    }
}
