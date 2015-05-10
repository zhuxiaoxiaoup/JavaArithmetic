package com.exercise.sort;

public class HeapSortSolution {
	public void heapAdjust( int a[], int i, int size ){
		int left = 2*i;
		int right = 2*i + 1;
		int max = i;
		if( i <= size/2 ){//如果不是叶子节点就不用调整
			if( left <= size && a[left-1] > a[max-1])
				max = left;
			if( right <= size && a[right-1] > a[max-1])
				max = right;
			if( max != i ){
				int temp = a[i-1];//不能用swap，值传递导致数组内的值不变
				a[i-1] = a[max-1];
				a[max-1] = temp;
				heapAdjust(a, max, size);
			}
		}
	}
	public void heapBuild( int a[], int size ){
		for( int i=size/2; i>=1; --i )
			heapAdjust(a, i, size);
	}
	public void heapSort( int a[], int size ){
		heapBuild(a, size);
		for( int i=size; i>1; --i ){
			int temp = a[0];
			a[0] = a[i-1];
			a[i-1] = temp;
			heapAdjust(a, 1, i-1);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = {45,23,1,7,78,5,55};
//		int a[] = {1};
		HeapSortSolution solution = new HeapSortSolution();
		solution.heapSort(a, a.length);
		for( int i=0; i<a.length; ++i){
			System.out.print(a[i]+" ");
		}
	}
}

