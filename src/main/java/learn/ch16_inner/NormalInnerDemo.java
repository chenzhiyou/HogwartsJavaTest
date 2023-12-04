package learn.ch16_inner;

public class NormalInnerDemo {
    private int id = 1;

    //定义普通内部类
    public class NormalInner{
        private String name = "inner";
        private int id = 4;

        public NormalInner(String name){
            this.name = name;
            System.out.println("普通内部类NormalInner的有参构造方法");
        }

        public NormalInner(){
            System.out.println("普通内部类NormalInner的无参构造方法");
        }

        public void show(){
            // 可以直接访问外部类的私有化的成员变量
            System.out.println("外部类NormalInnerDemo的成员变量ID值是： "+ id);
            System.out.println("普通内部类NormalInner的成员变量name值是： "+ name);
        }

        public void show2(int id){
            System.out.println("id:" + id);
            System.out.println("外部类ID： " + NormalInnerDemo.this.id);
            System.out.println("内部类ID： " + this.id);
        }
    }
}
