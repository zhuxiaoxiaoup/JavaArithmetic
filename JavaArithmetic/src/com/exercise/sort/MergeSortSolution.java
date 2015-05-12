package com.exercise.sort;
/**
 * 
 * @author liuyan
 * java实现的归并排序
 *
 */
public class MergeSortSolution {
	public void sort(int []array){
		mergeSort(array, 0, array.length-1);
	}
	public void mergeSort(int []array, int low, int high){
		int middle;
		if( low < high ){
			middle = ( low + high )/2;
			mergeSort(array, low, middle);
			mergeSort(array, middle+1, high);
			merge(array,low,middle,high);
		}
	}
	public void merge(int array[], int low, int middle, int high){
		int []mergeHelper = new int[array.length];
		for( int i=0; i<array.length; ++i )
			mergeHelper[i] = array[i];
		
		int helperLeft = low;
		int helperRight = middle + 1;
		int currentIndexOfArray = low;
		
		while( helperLeft <= middle && helperRight <= high ){
			if( mergeHelper[helperLeft] <= mergeHelper[helperRight] ){
				array[currentIndexOfArray] = mergeHelper[helperLeft];
				++helperLeft;
			}else{
				array[currentIndexOfArray] = mergeHelper[helperRight];
				++helperRight;
			}
			++currentIndexOfArray;
		}
		
		while( helperLeft <= middle )
			array[currentIndexOfArray++] = mergeHelper[helperLeft++];
		while( helperRight <= high )
			array[currentIndexOfArray++] = mergeHelper[helperRight++];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int array[] = {45,23,1,7,78,5,55,99,3};
//		int array[] = {1};
		int array[] = {3,1};
		MergeSortSolution solution = new MergeSortSolution();
		solution.sort(array);
		for( int i=0; i<array.length; ++i){
			System.out.print(array[i]+" ");
		}
	}
}
