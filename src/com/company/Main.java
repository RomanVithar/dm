package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {
//        Sorts sorts = new Sorts(Comparator.comparingInt(o -> (int) o));
//        List<Integer> list = new ArrayList<>(Arrays.asList(2, 3, 1, 4, 5, 7, 10));
//        System.out.println(sorts.mergers(list));
//        System.out.println(sorts.getCountComparison());
//        System.out.println(sorts.getCountPermutation());
//
//        // код для бинарного поиска
//        Searches searches = new Searches();
//        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(2, 4, 5, 3, 234, 4, 34, 3));
//        list.sort(Comparator.comparingInt(o -> o));
//        System.out.println(list);
//        System.out.println(searches.binary(list,4, 0, list.size()-1));
//        System.out.println(searches.getNumbIter());
        // код для обычного поиска
        Searches searches = new Searches();
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(2, 4, 5, 3, 234, 4, 34, 3));
        System.out.println(searches.line(4,list));
        System.out.println(searches.getNumbIter());
    }
}
