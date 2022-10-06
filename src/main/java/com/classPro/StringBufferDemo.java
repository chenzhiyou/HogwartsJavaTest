package com.classPro;

public class StringBufferDemo {
    public static void main(String[] args) {
        StringBuffer stringBuffer = new StringBuffer();
        // 追加
        stringBuffer.append(123);
        stringBuffer.append(true);
        stringBuffer.append("woow");
        System.out.println("springBuffer: "+ stringBuffer.toString());

        // 链式调用
        stringBuffer.append(123).append(true).append("woow");
        System.out.println("springBuffer: "+ stringBuffer.toString());
        stringBuffer.insert(2, "hello");
        System.out.println("springBuffer: "+ stringBuffer.toString());
        stringBuffer.delete(2, 7);// 包含前面的位置，不包含后面的位置
        System.out.println("springBuffer: "+ stringBuffer.toString());


    }


}
