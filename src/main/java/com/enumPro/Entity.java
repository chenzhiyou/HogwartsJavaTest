package com.enumPro;

public class Entity {
    // 文本， 图像， 音频，视频
//    public static final int TYPE_TEXT = 1;
//    public static final int TYPE_IMAGE = 2;
//    public static final int TYPE_AUDIO = 3;
//    public static final int TYPE_VIDEO = 4;


    private int id;
    // 文件类别
    private TypeEnum type; // 无法让成员变量在有限的几个值之间

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TypeEnum getType() {
        return type;
    }

    public void setType(TypeEnum type) {
        this.type = type;
    }

    //    public int getType() {
//        return type;
//    }
//
//    public void setType(int type) {
//        this.type = type;
//    }
}
