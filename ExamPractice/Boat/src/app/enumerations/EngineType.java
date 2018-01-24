package app.enumerations;

public enum EngineType {
    JET, STERNDRIVE;

    @Override
    public String toString() {
        return this.name();
    }
}
