package pl.agh.edu.dp;

import pl.agh.edu.dp.objects.FloatObject;
import pl.agh.edu.dp.objects.IntegerObject;
import pl.agh.edu.dp.objects.JsonObject;
import pl.agh.edu.dp.objects.StringObject;

public interface JSONBuilder {
    void add(JsonObject jsonObject);
    void add(FloatObject floatObject);
    void add(IntegerObject integerObject);
    void add(StringObject stringObject);
    JsonObject build();
}
