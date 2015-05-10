package com.exercise.sort;
/**
 * 
 * @author liuyan
 * 功能：快速排序
 *
 */
public class QuickSortSolution {
	public int partition( int a[], int begin, int end ){
		int pivot = a[begin];
		while( begin < end ){
			while( begin < end && a[end] >= pivot ) end--;
			if( begin < end ) a[begin++] = a[end];
			while( begin < end && a[begin] <= pivot ) begin ++;
			if( begin < end) a[end--] = a[begin];
		}
		a[begin] = pivot;
		return begin;
	}
	public void quickSort( int a[], int begin, int end ){
		int pivotPos;
		if( begin < end ){
			pivotPos = partition(a, begin, end);
			quickSort(a, begin, pivotPos-1);
			quickSort(a, pivotPos+1, end);
		}
	}
	public static void main(String[] args) {
		int a[] = {45,23,1,7,78,5,55};
//		int a[] = {1};
		QuickSortSolution solution = new QuickSortSolution();
		solution.quickSort(a, 0, a.length-1);
		for( int i=0; i<a.length; ++i){
			System.out.print(a[i]+" ");
		}
	}
}

