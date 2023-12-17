package learn.ch15_homework.enums;

/**
 * 枚举类
 */
public enum SexEnum {
    man("男"),
    female("女");
    private String chinese;

    SexEnum(String chinese){
        this.chinese = chinese;
    }
    public String getChineseName(){
        return chinese;
    }
}
