public enum Type {
    WORK ("Рабочая задача"),
    PERSONAL ("Личная задача");
    private final String valueOf;

    Type(String valueOf) {
        this.valueOf = valueOf;
    }

    public String getValueOf() {
        return valueOf;
    }
}
