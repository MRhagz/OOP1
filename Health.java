package PvZ_LAB;

public enum Health {
    DEFAULT(6),
    INFINITE(Integer.MAX_VALUE);

    private final int value;

    Health(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
