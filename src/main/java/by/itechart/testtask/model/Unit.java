package by.itechart.testtask.model;

public enum Unit {
    G("g"),
    KG("kg"),
    ML("ml"),
    DOZEN_EGGS("a dozen eggs"),
    BYN_PER_HOUR("BYN / h");

    private String unitName;

    Unit(String unitName) {
        this.unitName = unitName;
    }

    public String getUnitName() {
        return unitName;
    }
}
