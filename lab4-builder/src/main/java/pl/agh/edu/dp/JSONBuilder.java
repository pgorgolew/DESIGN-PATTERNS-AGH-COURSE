package pl.agh.edu.dp;

import pl.agh.edu.dp.objects.JsonObject;
import pl.agh.edu.dp.objects.SimpleJsonObject;

public interface JSONBuilder {
    void addSimpleJsonObject(SimpleJsonObject jsonObject);
    void addJsonObject(JsonObject jsonObject);
}
