package com.enumPro;

public class TestEntity {
    public static void main(String[] args) {
        Entity entity = new Entity();
        entity.setId(1);
//        entity.setType(2); // 无法限制里面的值，可读性也不高
//        entity.setType(Entity.TYPE_TEXT); // 使用常量，可读性要好一些
        entity.setType(TypeEnum.TYPE_TEXT); // 可读性好，同时对值的范围又有限制

        System.out.println(" "+ Sex.MAN.getValue());
    }
}
