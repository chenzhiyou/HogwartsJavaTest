package learn.ch14_static;

public class ReverseListDemo {
    public static void main(String[] args) {
        ReverseList reverseList = new ReverseList();
        reverseList.show();
        // 静态方法调用格式：类名.方法名
        ReverseList.show1();
        int[] arrays = {1,3, 5, 7,9,11};
        for(int i = 0; i<arrays.length; i++){
            System.out.println(arrays[i]);
        }
    }
}
