package by.itechart.testtask.model;

public enum DayType {
    WORKDAY("WORKDAY"),
    DAY_OFF("DAY OFF"),
    SICK_LIST("STICK LIST"),
    VOCATION("VOCATION");

    private String dayTypeName;

    DayType(String dayTypeName) {
            this.dayTypeName = dayTypeName;
    }

    public String getDayTypeName() {
        return dayTypeName;
    }
}
