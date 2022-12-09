package pl.agh.edu.dp.objects;

public record IntegerObject(String name, Integer value) {

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IntegerObject that = (IntegerObject) o;
        return name.equals(that.name) && value.equals(that.value);
    }

}
