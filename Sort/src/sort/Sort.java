/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sort;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Thanh Hang
 */
public class Sort {

     // ----------- BUBBLE SORT -----------
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = n-1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    // đổi chỗ
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // ----------- SELECTION SORT -----------
    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            if (i != minIndex) {
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
    }

    // ----------- INSERTION SORT -----------
    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int temp = arr[i];
            int j = i - 1;
            while (j>=0 && temp < arr[j]) {
                arr[j + 1] = arr[j];
                arr[j]= temp;
                j--;
            }
        }
//        int n = arr.length;
//    for (int i = 1; i < n; i++) {
//        int temp = arr[i];
//        int j = i - 1;
//
//        while (j >= 0 && temp < arr[j]) {
//            arr[j + 1] = arr[j];
//            j--;
//        }
//        arr[j + 1] = temp;
//    }
    }

    // ----------- MERGE SORT -----------

    public static int[] merge(int[] a1, int[] a2){
        int[] combined = new int[a1.length+a2.length];
        int index =0;
        int i=0;
        int j=0;
        while(i<a1.length && j<a2.length){
            if(a1[i]<a2[j]){
                combined[index]=a1[i];
                index++;
                i++;
            }else{
                combined[index]=a2[j];
                index++;
                j++;
            }
        }
        while(i<a1.length) {
            combined[index]=a1[i];
                index++;
                i++;
        }
        while(j<a2.length) {
            combined[index]=a2[j];
                index++;
                j++;
        }
        return combined;
                
    }
    public static int[] mergeSort(int[] arr) {
        if (arr.length == 1) {
            return arr;
        }
        int minIndex = arr.length / 2;
        int[] left = mergeSort(Arrays.copyOfRange(arr, 0, minIndex));
        int[] right = mergeSort(Arrays.copyOfRange(arr, minIndex, arr.length));
        return merge(left, right);
    }
    
    // ----------- QUICK SORT -----------
    public static void quickSortHelper(int[] arr, int left, int right) {
        if (left < right) {
            int pivotIndex = pivot(arr, left, right); 
            quickSortHelper(arr, left, pivotIndex - 1);
            quickSortHelper(arr, pivotIndex + 1, right);
        }
    }
    public static void quickSort(int[] arr){
        quickSortHelper(arr, 0, arr.length-1);
    }
    private static void swap(int[] arr, int firstIndex, int secondIndex) {
        int temp = arr[firstIndex];
        arr[firstIndex] = arr[secondIndex];
        arr[secondIndex] = temp;
    }
    private static int pivot(int[] arr, int pivotIndex, int endIndex){
        int swapIndex = pivotIndex;
        for(int i = pivotIndex+1; i<=endIndex; i++){
            if(arr[i]<arr[pivotIndex]){
                swapIndex++;
                swap(arr, swapIndex,i);
            }
        }
        swap(arr, pivotIndex, swapIndex);
        return swapIndex;
    }

   

    // ----------- HÀM HIỂN THỊ MẢNG -----------
    public static void printArray(int[] arr) {
        for (int x : arr) System.out.print(x + " ");
        System.out.println();
    }

    // ----------- MAIN -----------
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập số phần tử: ");
        int n = sc.nextInt();
        int[] arr = new int[n];

        System.out.println("Nhập các phần tử:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println("\nChọn thuật toán sắp xếp:");
        System.out.println("1. Bubble Sort");
        System.out.println("2. Selection Sort");
        System.out.println("3. Insertion Sort");
        System.out.println("4. Merge Sort");
        System.out.println("5. Quick Sort");
        System.out.print("Lựa chọn: ");
        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                bubbleSort(arr);
                break;
            case 2:
                selectionSort(arr);
                break;
            case 3:
                insertionSort(arr);
                break;
            case 4:
                mergeSort(arr);
                break;
            case 5:
                quickSort(arr);
                break;
            default:
                System.out.println("Lựa chọn không hợp lệ!");
                return;
        }

        System.out.println("\nMảng sau khi sắp xếp:");
        printArray(arr);
    }
}
