package classes.enums;

public enum Faculty {
    CHEMICAL,
    BIOLOGICAL,
    MATHEMATICAL,
    LINGUISTIC,
    ECONOMICAL;

    @Override
    public String toString() {
        return this.name();
    }
}
