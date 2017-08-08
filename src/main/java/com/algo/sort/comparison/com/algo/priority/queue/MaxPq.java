package com.algo.sort.comparison.com.algo.priority.queue;

/**
 * Created by tomar on 09/08/17.
 */
public class MaxPq<key extends Comparable<key>> {
    private key[] pq;
    private int N;
    private int size;

    public MaxPq(int capaciity){
        pq = (key[]) new Comparable[capaciity+1];
        size = capaciity;
    }
    
    public void insert(key key){
        if(N == size){
            throw new IllegalStateException("heap overflows");
        }
        pq[++N] = key;
        swim(N);
    }

    public key deleteMax() {
        if (isEmpty()) {
            throw new IllegalStateException("Heap is empty, Nothing to delete");
        }
        key max = pq[1];
        pq[1] = pq[N--];
        pq[N] = null;
        sink(1);
        return max;
    }


    private void sink(int i) {
        while(2*i <= N){
            int max =2*i;

            if(max < N && less(max,max+1) ){
                max = max +1;
            }
            if(!(less(i,max) )){
                break;
            }
            exch(i,max);
            i = max;
        }
    }

    private boolean isEmpty() {
        return  0 == N;
    }

    private void swim(int k) {
        while(k > 1 && less(k/2,k)){
            exch(k,k/2);
            k= k/2;
        }
    }

    private void exch(int i, int j) {
        key temp = pq[i];
        pq[j] =pq[j];
        pq[j]= temp;
    }

    private boolean less(int i, int j){
        return pq[i].compareTo(pq[j]) < 0;
    }



}
