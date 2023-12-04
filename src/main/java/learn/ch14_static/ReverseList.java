package learn.ch14_static;

public class ReverseList {
    int num1 = 15;
    static int num2 = 25;

    public void show(){
        // 不能再静态方法中打印非静态的变量
        System.out.println(num1);
        System.out.println(num2);
    }

    public static void show1(){
        // 不能再静态方法中打印非静态的变量
//        System.out.println(num1);
        System.out.println(num2);
    }
    /**
     * 数组反转方法：
     * 方法名：reverse
     * 参数 int[] arrays
     */
    public static int[] reverse(int[] arrays){
        for (int i =0; i < arrays.length/2; i++){
            int temp = arrays[i];
            arrays[i] = arrays[arrays.length-i-1];
            arrays[arrays.length-i-1] = temp;
        }
        return arrays;
    }
}
