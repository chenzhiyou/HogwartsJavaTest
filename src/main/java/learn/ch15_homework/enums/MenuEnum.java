package learn.ch15_homework.enums;

public enum MenuEnum {
    SHOW_FLAG(1),
    ADD_FLAG(2),
    DEL_FLAG(3),
    EXIT_FLAG(4);

    private Integer menuId;

     MenuEnum(Integer menuId){
        this.menuId = menuId;
    }

    public Integer getMenuId() {
        return menuId;
    }
}
