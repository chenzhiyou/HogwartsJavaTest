package learn.ch12_interface;

/**
 * 接口
 */
public interface PriSchool {
    public default void study(){
        System.out.println("上课");
    }
}
