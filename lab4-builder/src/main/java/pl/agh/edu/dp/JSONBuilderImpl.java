package pl.agh.edu.dp;

import pl.agh.edu.dp.objects.FloatObject;
import pl.agh.edu.dp.objects.IntegerObject;
import pl.agh.edu.dp.objects.JsonObject;
import pl.agh.edu.dp.objects.StringObject;

import java.util.HashSet;
import java.util.Set;

public class JSONBuilderImpl implements JSONBuilder{
    private final Set<StringObject> stringObjects = new HashSet<>();
    private final Set<IntegerObject> integerObjects = new HashSet<>();
    private final Set<FloatObject> floatObjects = new HashSet<>();
    private final Set<JsonObject> jsonObjects = new HashSet<>();

    @Override
    public void add(JsonObject jsonObject) {
        jsonObjects.add(jsonObject);
    }

    @Override
    public void add(FloatObject floatObject) {
        floatObjects.add(floatObject);
    }

    @Override
    public void add(IntegerObject integerObject) {
        integerObjects.add(integerObject);
    }

    @Override
    public void add(StringObject stringObject) {
        stringObjects.add(stringObject);
    }

    @Override
    public JsonObject build() {
        JsonObject json = new JsonObject();

        stringObjects.forEach(json::add);
        floatObjects.forEach(json::add);
        integerObjects.forEach(json::add);
        jsonObjects.forEach(json::add);

        return json;
    }
}
