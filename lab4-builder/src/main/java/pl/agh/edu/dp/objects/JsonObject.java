package pl.agh.edu.dp.objects;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class JsonObject {
    private final Set<StringObject> stringObjects = new HashSet<>();
    private final Set<IntegerObject> integerObjects = new HashSet<>();
    private final Set<FloatObject> floatObjects = new HashSet<>();
    private final Set<JsonObject> jsonObjects = new HashSet<>();

    public Set<StringObject> getStringObjects() {
        return stringObjects;
    }

    public Set<IntegerObject> getIntegerObjects() {
        return integerObjects;
    }

    public Set<FloatObject> getFloatObjects() {
        return floatObjects;
    }

    public Set<JsonObject> getJsonObjects() {
        return jsonObjects;
    }

    public void add(JsonObject jsonObject){
        jsonObjects.add(jsonObject);
    }
    public void add(FloatObject floatObject){
        floatObjects.add(floatObject);
    }
    public void add(IntegerObject integerObject){
        integerObjects.add(integerObject);
    }
    public void add(StringObject stringObject){
        stringObjects.add(stringObject);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JsonObject that = (JsonObject) o;
        return  Objects.equals(stringObjects, that.stringObjects) &&
                Objects.equals(integerObjects, that.integerObjects) &&
                Objects.equals(floatObjects, that.floatObjects) &&
                Objects.equals(jsonObjects, that.jsonObjects);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stringObjects, integerObjects, floatObjects, jsonObjects);
    }
}
