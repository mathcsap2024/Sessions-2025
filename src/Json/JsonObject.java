package Json;

import java.util.zip.DataFormatException;

public class JsonObject extends JsonValue{

    private String getKey(String input) throws DataFormatException {
        if(input.charAt(0)!='"') {
            throw new DataFormatException("The object has invalid format.");
        }
        return "";
    }

    public JsonObject(String input) throws DataFormatException {
        input = input.strip();
        if(input.charAt(0)!='{' || input.charAt(input.length()-1)!='}') {
            throw new DataFormatException("The object has invalid format.");
        }
        input=input.substring(1,input.length()-1).strip();

        while(input.length()>=0) {
            String key = getKey(input);
            input = input.substring(key.length()+2).trim();
            if(input.charAt(0)!=':') {
                throw new DataFormatException("The object has invalid format.");
            }
            input= input.substring(1);
            if(input.charAt(0)=='[') {

            }
            else if (input.charAt(0)=='{') {

            }
        }
    }
}
