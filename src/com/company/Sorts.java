package com.company;

import com.company.dto.SortInformation;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

public class Sorts {
    public int countPermutation;
    public int countComparison;
    public Comparator comparator;

    public Sorts(Comparator comparator) {
        countComparison = 0;
        countPermutation = 0;
        this.comparator = comparator;
    }

    // осевой элемент - первый (для нахождения худщего случая)
    public List quick(List list) {
        if (list.size() == 2) {
            if (compare(list, 0, 1) < 0) {
                swap(list, 0, 1);
            }
            return list;
        }
        if (list.size() < 2) {
            return list;
        }
        List listLeft = new ArrayList();
        List listRight = new ArrayList();

        int midIndex = 0;
        for (int i = 0; i < list.size(); i++) {
            if(i == midIndex){
                continue;
            }
            if (compare(list, i, midIndex) >= 0) {
                countPermutation++;
                listLeft.add(list.get(i));
            }else{
                countPermutation++;
                listRight.add(list.get(i));
            }
        }
        listLeft = quick(listLeft);
        listRight = quick(listRight);
        insertInMainArr(list, listLeft, listRight, list.get(midIndex));
        return list;
    }

    public List mergers(List list) {
        if (list.size() == 2) {
            if (compare(list, 0, 1) > 0) {
                swap(list, 0, 1);
            }
            return list;
        }
        if (list.size() < 2) {
            return list;
        }
        List listLeft = new ArrayList();
        List listRight = new ArrayList();
        for(int i=0;i< list.size()/2;i++) {
            listLeft.add(list.get(i));
        }
        for(int i=list.size()/2;i< list.size();i++) {
            listRight.add(list.get(i));
        }
        listLeft = mergers(listLeft);
        listRight = mergers(listRight);
        return insertForMerges(listLeft, listRight);
    }

    private void insertInMainArr(List list, List list1, List list2, Object midle) {
        if (list1.size() + list2.size() != list.size() - 1) {
            System.out.println("Ошибка");
            return;
        }
        int i;
        for (i = 0; i < list1.size(); i++) {
            list.set(i, list1.get(i));
        }
        list.set(i, midle);
        i++;
        for (int j = 0; j < list2.size(); j++) {
            list.set(i, list2.get(j));
            i++;
        }
    }

    private List insertForMerges(List list1, List list2) {
        List list = new ArrayList();
        Stack stack1 = new Stack();
        fillStak(list1, stack1);
        Stack stack2 = new Stack();
        fillStak(list2, stack2);

        while (!stack1.isEmpty() || !stack2.isEmpty()){
            if(!stack1.isEmpty() && !stack2.isEmpty()){
                countComparison++;
                if(comparator.compare(stack1.peek(), stack2.peek())<0){
                    list.add(stack1.pop());
                }else{
                    list.add(stack2.pop());
                }
            }else{
                if(stack1.isEmpty()){
                    while(!stack2.isEmpty()){
                        list.add(stack2.pop());
                    }
                }else{
                    while(!stack1.isEmpty()){
                        list.add(stack1.pop());
                    }
                }
            }
        }
        return list;
    }

    private void swap(List list, int i1, int i2) {
        countPermutation++;
        swapWithoutCount(list, i1, i2);
    }

    void fillStak(List list, Stack stack){
        for(int i=list.size()-1;i>-1;i--){
            stack.push(list.get(i));
        }
    }

    private void swapWithoutCount(List list, int i1, int i2) {
        Object tmp = list.get(i1);
        list.set(i1, list.get(i2));
        list.set(i2, tmp);
    }

    private int compare(List list, int a, int b) {
        countComparison++;
        return comparator.compare(list.get(a), list.get(b));
    }

    public int getCountPermutation() {
        int answer = countPermutation;
        countPermutation = 0;
        return answer;
    }

    public int getCountComparison() {
        int answer = countComparison;
        countComparison = 0;
        return answer;
    }
}
