package learn.ch15_homework.exceptions;

public class StudentIdNotExitException extends RuntimeException{
    public StudentIdNotExitException(){
        super("学生不存在");
    }
}
