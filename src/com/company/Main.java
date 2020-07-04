package com.company;

import java.util.Scanner;
import java.lang.Math;

public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("Enter in a number to square it and create a sodoku puzzle! ");
        int size = scan.nextInt();
        //maybe a square root will help us later
        int sizeSquared = (size * size);
        int sodoku[][] = new int[sizeSquared][sizeSquared];

        //Create array
        System.out.println("Enter in " + sizeSquared + " numbers!");
        for (int i = 0; i < sodoku.length; i++) {
            for (int j = 0; j < sodoku.length; j++) {
                sodoku[i][j] = scan.nextInt();
            }
        }

        //sum of columns and rows
        int sizeSquaredToZero = sizeSquared;
        int sumOfColsAndRows = 0;
       while(sizeSquaredToZero != 0){
           sumOfColsAndRows += sizeSquaredToZero--;
       }

       //sum of whole array
        int sumOfWholeArray = sumOfColsAndRows * sizeSquared;
       System.out.println("Sum of Whole Array: ");
        System.out.println(sumOfWholeArray);

        //All conditions have to be true
        //Break every problem into pieces and then use logical ORs, ANDs, XORs to determine the logic of all the pieces
        //together


        if(sumOfEachRow(sodoku, sumOfColsAndRows) && sumOfEachColumn(sodoku,sumOfColsAndRows) && sumOfEachSquare(sodoku,sizeSquared,size, sumOfColsAndRows)
                && sumOfWholeArray(sodoku, sumOfWholeArray) && columnRepeat(sodoku) && rowRepeat(sodoku) && squareRepeat(sodoku, sizeSquared, size)){
            System.out.println("YES");
        }
        else{
            System.out.println("NO");
        }
    }

    public static boolean sumOfEachRow(int array[][], int sum){

        for(int i = 0; i<array.length; i++){
                int sumRow = 0;
                for(int j = 0; j<array.length; j++){
                    sumRow += array[i][j];

                    if(j == array.length - 1){
                        if(sumRow != sum){
                            return false;
                        }
                    }
                }
        }
        return true;
    }

    public static boolean sumOfEachColumn(int array[][], int sum){

        for(int i = 0; i<array.length; i++){
            int sumColumn = 0;
            for(int j = 0; j<array.length; j++){
                sumColumn += array[j][i];

                if(j == array.length - 1){
                    if(sumColumn != sum){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static boolean sumOfEachSquare(int array[][], int sizeSquared, int size, int sum){

        //Construction of the sub array: outer 2 loops
        for(int i = 0; i < sizeSquared - size + 1; i++ ){
            for(int j= 0; j<sizeSquared - size + 1; j++){
                int sumSquareArray = 0;

                for(int rows = 0; rows < size; rows++){
                   for(int columns = 0; columns < size; columns++){
                       sumSquareArray += array[rows][columns];
                   }
               }
                if(sumSquareArray != sum){
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean sumOfWholeArray(int array[][], int sum){
        int sumOfArray = 0;

        for(int i = 0; i<array.length; i++){
            for(int j = 0; j<array.length; j++){
                sumOfArray += array[i][j];
            }
        }
        if(sumOfArray != sum){
            return false;
        }
        return true;
    }

    public static boolean columnRepeat(int array[][]){

        for(int rows= 0; rows<array.length; rows++){
            for(int columns=0; columns<array.length; columns++){
                int num = array[columns][rows];
                for(int otherRow = rows + 1; otherRow < array.length; otherRow++){
                    if(num == array[columns][otherRow]){
                        return false;
                    }
                }
            }
        }

        return true;
    }

    public static boolean rowRepeat(int array[][]){

        for(int rows= 0; rows<array.length; rows++){
            for(int columns=0; columns <array.length; columns++){
                    int num = array[rows][columns];
                for(int otherColumn = columns + 1; otherColumn < array.length; otherColumn++){
                    if(num == array[rows][otherColumn]){
                        return false;
                    }
                }
            }
        }

        return true;
    }

    //Be sure to check this
    public static boolean squareRepeat(int array[][], int sizeSquared, int size){

        //Construction of the sub array
        for(int i = 0; i < sizeSquared - size + 1; i++ ){
            for(int j= 0; j<sizeSquared - size + 1; j++){
               int num = array[i][j];
               for(int nextElementinBox = j + 1; nextElementinBox < sizeSquared - size + 1; nextElementinBox++){
                   if(num == array[i][nextElementinBox]){
                       return false;
                   }
               }

            }
        }
        return true;

    }
}


