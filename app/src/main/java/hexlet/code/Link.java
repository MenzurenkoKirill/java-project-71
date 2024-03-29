package hexlet.code;

public class Link {
    private final String typeOfChange;
    private final String key;
    private final Object oldValue;
    private final Object newValue;
    public Link(String type, String thisKey, Object oldV, Object newV) {
        this.typeOfChange = type;
        this.key = thisKey;
        this.oldValue = oldV;
        this.newValue = newV;
    }

    public final String getTypeOfChange() {
        return typeOfChange;
    }
    public final String getKey() {
        return key;
    }
    public final Object getOldValue() {
        return oldValue;
    }
    public final Object getNewValue() {
        return newValue;
    }
}
