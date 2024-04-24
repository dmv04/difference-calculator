package hexlet.code;

public enum FormatType {
    stylish("stylish"),
    plain("plain"),
    json("json");

    private final String name;

    FormatType(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

}
