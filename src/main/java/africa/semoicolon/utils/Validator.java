package africa.semoicolon.utils;

import africa.semoicolon.Exception.InvalidFieldException;
import africa.semoicolon.dto.request.CreateWebDetailsRequest;
import africa.semoicolon.dto.request.DeleteWebDetails;
import africa.semoicolon.dto.request.UpdatePasswordRequest;
import africa.semoicolon.dto.request.ViewAllRequest;

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

    public static void validateDeleteSite(DeleteWebDetails deleteDetails){
        validate(deleteDetails.getSiteName( ));
        validate(deleteDetails.getPassword( ));
        validate(deleteDetails.getUsername( ));
    }

    public static void validateViewRequest(ViewAllRequest request){
        validate(request.getPassword( ));
        validate(request.getPassword());
    }

    public static void validateUpdate(UpdatePasswordRequest updateRequest){
        validate(updateRequest.getPassword());
        validate(updateRequest.getUsername());
        validate(updateRequest.getSitePassword());
        validate(updateRequest.getSitename());
        validate(updateRequest.getSiteUsername( ));
    }
}
