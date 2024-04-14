package africa.semoicolon.utils;

import africa.semoicolon.Exception.InvalidFieldException;
import africa.semoicolon.dto.CreateWebDetailsRequest;

import java.util.Optional;

public class Validator{
    public static void validate(String input){
        Optional<String> given = Optional.ofNullable(input);
        if(given.isEmpty())
            throw new InvalidFieldException();
        input = input.strip();
    }
    public static void validateCreateWebRequest(CreateWebDetailsRequest webDetails){
        validate(webDetails.getSiteName( ));
        validate(webDetails.getUsername( ));
        validate(webDetails.getSitePassword( ));
        validate(webDetails.getSiteUsername());
    }
}
