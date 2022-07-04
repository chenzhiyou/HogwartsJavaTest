package com.hogwarts.ch18_inner;

public class OneTest {
    public static void test(AnonyInterface anonyInterface){
        anonyInterface.show();
    }

    public static void main(String[] args) {
        OneTest.test(new AnonyInterfaceImpl());
        OneTest.test(new AnonyInterface() {
            @Override
            public void show() {
                System.out.println("*******************");
            }
        });

        AnonyInterface anonyInterface = ()-> System.out.println("lambda表达式");
        OneTest.test(anonyInterface);
    }
}
