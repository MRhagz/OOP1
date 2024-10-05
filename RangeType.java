package PvZ_LAB;

public enum RangeType {
    SINGLE_LINE(1),
    AREA_OF_EFFECT(2),
    LIMITED_RANGE(3),
    FREE_RANGE(4);

    private final int value;

    RangeType (int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

}
