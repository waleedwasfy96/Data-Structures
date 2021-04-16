package com.example.welo;

import java.beans.BeanInfo;

public class FenwickTree {
    final int MAX=100;
    int [] BITree;

    public FenwickTree(){
        BITree=new int[MAX];
    }

    public void constructBITree(int[] arr){
        int l= arr.length;
        for(int i=0;i<=l;i++){
            BITree[i]=0;
        }
        for(int i=0;i<l;i++){
            updateBITree(l,i+1,arr[i]);
        }

    }

    public void updateBITree(int length, int index,int val){
        for(;index<=length;index+=index&(-index)){
            BITree[index]+=val;
        }
    }

    public int getSum(int index,int length){
        int sum=0;
        for(;index>0;index-=index&(-index)){
            sum+=BITree[index];
        }
        return sum;
    }
    public int getRangeSum(int high,int low,int length){
        return getSum(high,length)-getSum(low,length);
    }

    public static void main(String []args){
        int [] x = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};
        FenwickTree tree=new FenwickTree();
        tree.constructBITree(x);
        for(int i=1;i<=x.length;i++){
            System.out.print(tree.BITree[i]+" ");
        }
        System.out.println();
        System.out.println(tree.getSum(3,x.length));
    }


}
