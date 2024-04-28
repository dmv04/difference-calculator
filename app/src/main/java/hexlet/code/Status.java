package hexlet.code;

public final class Status {

    public static final String DELETED = "deleted";
    public static final String ADDED = "added";
    public static final String CHANGED = "changed";
    public static final String UNCHANGED = "unchanged";

    private final String statusName;
    private Object oldValue;
    private Object newValue;
    private Object value;


    public Status(String statusName, Object value) {
        this.statusName = statusName;
        this.value = value;
    }

    Status(String statusName, Object oldValue, Object newValue) {
        this.statusName = statusName;
        this.oldValue = oldValue;
        this.newValue = newValue;
    }

    public String getStatusName() {
        return statusName;
    }

    public Object getValue() {
        return value;
    }


    public Object getOldValue() {
        return oldValue;
    }

    public Object getNewValue() {
        return newValue;
    }
}
