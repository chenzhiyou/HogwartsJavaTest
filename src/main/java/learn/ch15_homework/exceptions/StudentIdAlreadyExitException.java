package learn.ch15_homework.exceptions;

public class StudentIdAlreadyExitException extends RuntimeException{
    public StudentIdAlreadyExitException(){
        super("学生ID已存在");
    }
}
