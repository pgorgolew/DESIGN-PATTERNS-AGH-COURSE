package pl.agh.edu.dp.objects;

public record FloatObject(String name, Float value) {

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FloatObject that = (FloatObject) o;
        return name.equals(that.name) && value.equals(that.value);
    }

}
