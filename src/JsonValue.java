import java.util.ArrayList;
import java.util.TreeMap;

public abstract class JsonValue {
    abstract int getValuesCount();
}

class JsonLiteral extends JsonValue {
    Object value;

    @Override
    int getValuesCount() {
        return 1;
    }
}

class JsonArray extends JsonValue {
    ArrayList<JsonValue> list=null;

    @Override
    int getValuesCount() {
        int result=0;
        for(JsonValue value:list) {
            result+=value.getValuesCount();
        }
        return result+1;
    }
}

class JsonObject extends JsonValue{
    TreeMap<String,JsonValue> dict=null;

    @Override
    int getValuesCount() {
        int result=0;
        for(JsonValue value:dict.values()) {
            result+=value.getValuesCount();
        }
        return result+1;
    }
}