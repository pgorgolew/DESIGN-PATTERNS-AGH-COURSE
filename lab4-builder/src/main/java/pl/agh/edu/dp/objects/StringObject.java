package pl.agh.edu.dp.objects;

public record StringObject(String name, String value) {

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StringObject that = (StringObject) o;
        return name.equals(that.name) && value.equals(that.value);
    }

}
