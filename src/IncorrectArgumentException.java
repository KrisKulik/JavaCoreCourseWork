public class IncorrectArgumentException extends Exception {

    private String argument;

    public IncorrectArgumentException(String argument) {
        super();
        this.argument = argument;
    }

    public String getArgument() {
        return argument;
    }

    @Override
    public String toString() {
        return "Неверный ввод! " + argument;
    }
}
