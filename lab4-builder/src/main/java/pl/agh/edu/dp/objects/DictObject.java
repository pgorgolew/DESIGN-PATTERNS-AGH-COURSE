package pl.agh.edu.dp.objects;

import java.util.HashMap;
import java.util.Map;

public class DictObject implements JsonObject{
    Map<String, StringObject> stringObjects = new HashMap<>();
    Map<String, IntegerObject> integerObjects = new HashMap<>();
    Map<String, FloatObject> floatObjects = new HashMap<>();
    Map<String, JsonObject> jsonObjects = new HashMap<>();
    @Override
    public JsonObject getObject() {
        return null;
    }
}
