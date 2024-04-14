package africa.semoicolon.Exception;


public class UserNotFoundException extends PasswordBankExceptions{
    public UserNotFoundException(){
        super("User ot found");
    }
}
