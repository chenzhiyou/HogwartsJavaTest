package learn.ch15_homework.exceptions;

public class StudentSexInputException extends RuntimeException{
    public StudentSexInputException(){
        super("性别输入不正确");
    }
}
