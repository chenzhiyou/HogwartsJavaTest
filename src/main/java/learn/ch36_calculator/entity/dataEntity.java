package learn.ch36_calculator.entity;

public class dataEntity {
    private int a;
    private int b;
    private int result;
    private String message;

    @Override
    public String toString() {
        return "dataEntity{" +
                "a=" + a +
                ", b=" + b +
                ", result=" + result +
                ", message='" + message + '\'' +
                '}';
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
