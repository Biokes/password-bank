package africa.semoicolon.Exception;

public class InvalidFieldException extends PasswordBankExceptions{
    public InvalidFieldException(){
        super("input field must not be empty");
    }
}
