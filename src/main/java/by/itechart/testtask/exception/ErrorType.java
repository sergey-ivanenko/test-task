package by.itechart.testtask.exception;

public enum ErrorType {
    ENTITY_NOT_FOUND_BY_ID("Entity not found by id: %s."),
    ENTITY_NOT_FOUND_BY_LOGIN("Entity not found by login: %s."),
    ENTITY_NOT_FOUND_BY_NAME("Entity not found by name: %s."),
    ENTITY_NOT_SAVED("Entity not saved: %s."),
    ENTITY_NOT_UPDATED("Entity not updated: %s."),
    ENTITY_NOT_DELETED("Entity not deleted by id: %s."),
    ENTITIES_NOT_LOADED("Entities not loaded.");

    private String description;

    ErrorType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
