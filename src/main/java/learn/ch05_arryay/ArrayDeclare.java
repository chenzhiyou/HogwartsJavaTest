package learn.ch05_arryay;

public class ArrayDeclare {
    public static void main(String[] args) {
        // 数组的声明
        int[] arrayA;
        arrayA = new int[3];
        int arrayB[] = new int[3];
        arrayA[0] = 1;
        arrayA[1] = 2;
        arrayA[2] = 3;
        System.out.println(arrayA.length);
        System.out.println(arrayA[0]);
        int[] arrayC = new int[] {15,25 ,30, 40, 50};
        for (int i =0; i < arrayC.length; i++){
            System.out.println("数组遍历"+ arrayC[i]);
        }
        int[] arrayD = new int[]{10,20,30,40,50};
        int[] arrayN = arrayReverse(arrayD);

        System.out.println("数组反转");
        for (int i =0; i < arrayC.length; i++){
            System.out.println("数组遍历"+ arrayN[i]);
        }

        byte[] byteArray;
        long[] longArray;

        Object[] objectArray;
        String[] stringArray;
    }

    /**
     * 数组反转
     * @param arr
     * @return
     */
    public static int[] arrayReverse(int[] arr){
        int[] newArr = new int[arr.length];
        for (int i =0; i < arr.length;i++ ){
            newArr[i] = arr[arr.length-i-1];
        }
        return newArr;
    }
}
