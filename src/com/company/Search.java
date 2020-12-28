package com.company;

import java.util.ArrayList;
import java.util.Comparator;

public class Search {
    private int numbIter;

    public Search() {
        numbIter = 0;
    }

    public int binary(int value, ArrayList<Integer> list){
        numbIter = 1;
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        System.out.println(list);
        int sz = list.size() - 1;
        sz/=2;
        int mid = Math.round(sz);
        while(value!=list.get(mid)){
            sz /=2;
            if(sz<1){
                return -1;
            }
            if(list.get(mid) > value){
                mid+=sz;
            }else{
                mid-=sz;
            }
            numbIter++;
        }
        if(value==list.get(mid)) {
            return mid;
        }else {
            return -1;
        }
    }

    public int line(int value, ArrayList<Integer> list){
        numbIter = 0;
        for(int i=0;i<list.size();i++){
            if(list.get(i)==value){
                numbIter = i+1;
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
