package PvZ_LAB;

public enum KillType {
    INSTANTLY(1),
    CLOSE_CONTACT(2);

    private final int value;

    KillType(int value) {
        this.value = value;
    }

    public int getValue () {
        return value;
    }
}
