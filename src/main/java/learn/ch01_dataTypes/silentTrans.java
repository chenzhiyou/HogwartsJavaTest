package learn.ch01_dataTypes;

public class silentTrans {
    public static void main(String[] args) {
        //类型转换
        char c1 = 'A';
        int myInt = c1;
        System.out.println(myInt);

        // char参与运算，会自动转换成int类型
        char c2 = 'a';
        myInt = c2 + 2;
        System.out.println(myInt);

        // short类型参与运算
        short sh =6;
        myInt = sh + 8;
        System.out.println(myInt);
    }
}
