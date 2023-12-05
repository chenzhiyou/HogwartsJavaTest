package learn.ch16_inner;

public class AreaInnerDemo {
    private int aid = 2;
    public void show(){
        class AreaInner{
            private int id = 1;
            public AreaInner(){
                System.out.println("局部内部类AreaInner的构造方法");
            }

            public void testArea(){
                System.out.println("局部内部类AreaInner的ID的值： "+ id);
                System.out.println("AreaInnerDemo的aid的值： "+ aid);
            }
        }
        // 声明局部内部类的引用指向局部内部类的对象
        AreaInner areaInner = new AreaInner();
        areaInner.testArea();
    }
}

