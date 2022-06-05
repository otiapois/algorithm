package com.fouo.tx.day07;


import java.util.*;

/*
 * T一定要是非基础类型，有基础类型需求包一层
 */
public class FouoHeapGreater<T> {
    private ArrayList<T> heap;
    private int heapSize;
    private Map<T, Integer> indexMap;
    private Comparator<? super T> comp;

    public FouoHeapGreater(Comparator<T> c) {
        this.heap = new ArrayList<>();
        this.heapSize = 0;
        this.indexMap = new HashMap<>();
        this.comp = c;
    }

    public boolean isEmpty() {
        return heapSize == 0;
    }

    public int size() {
        return heapSize;
    }

    public boolean contains(T obj) {
        return indexMap.containsKey(obj);
    }

    public T peek() {
        return heap.get(0);
    }

    public void push(T obj) {
        heap.add(obj);
        indexMap.put(obj, heapSize);
        heapInsert(heapSize++);
    }

    public T pop() {
        T ans = heap.get(0);
        swap(0, heapSize - 1);
        heap.remove(--heapSize);
        indexMap.remove(ans);
        heapify(0);
        return ans;
    }

    public void remove(T obj) {
        //获取需要替换的obj
        T replace = heap.get(heapSize - 1);
        //获取当前对象对应的index
        Integer index = indexMap.get(obj);
        heap.remove(--heapSize);
        indexMap.remove(obj);
        if (replace != obj) {
            heap.set(index, replace);
            indexMap.put(replace, index);
            resign(replace);
        }
    }

    public void resign(T obj) {
        heapify(indexMap.get(obj));
        heapInsert(indexMap.get(obj));
    }

    // 请返回堆上的所有元素
    public List<T> getAllElements() {
        List<T> ans = new ArrayList<>();
        for (T t : heap) {
            ans.add(t);
        }
        return ans;
    }

    private void heapInsert(int index) {
        while (comp.compare(heap.get(index), heap.get((index-1)/2)) < 0) {
            swap(index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    private void heapify(int index) {
        int left = index * 2 + 1;
        while (left < heapSize) {
            int largest = left + 1 < heapSize && comp.compare(heap.get(left + 1), heap.get(left)) < 0 ? left + 1 : left;
            largest = comp.compare(heap.get(largest), heap.get(index)) < 0 ? largest : index;
            if(index == largest){
                break;
            }
            swap(index,largest);
            index = largest;
            left = index*2+1;
        }
    }

    private void swap(int i, int j) {
        T o1 = heap.get(i);
        T o2 = heap.get(j);
        heap.set(i, o2);
        heap.set(j, o1);
        indexMap.put(o1, j);
        indexMap.put(o2, i);
    }
}
