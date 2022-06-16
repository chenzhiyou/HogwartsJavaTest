package com.hogwarts.ch05_array;

/**
 * 二维数组：静态初始化
 */
public class Array2DInitStatic {

    public static void main(String[] args) {
        int[][] array2DA = new int[][]{{1,2,}, {3,4}, {5, 6}};
        int[][] array2DB = {{1,2,}, {3,4}, {5, 6}};

        System.out.println(array2DB[0][1]);

        for (int i=0; i<array2DB.length; i++){
            for (int j= 0; j<array2DB[i].length; j++){
                System.out.print(array2DB[i][j] +"\t");
            }
            System.out.println();
        }
    }
}
