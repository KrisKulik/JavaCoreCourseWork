import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Main extends TaskService {
    public static void main(String[] args) {
        TaskService taskService = new TaskService();
        Scanner scanner = new Scanner(System.in);

        getMenu();


        while (scanner.hasNextLine()) {
            String menu = scanner.nextLine();
            switch (menu) {
                case "0":
                    System.out.println("Добавить задачу: ");
                    taskService.addTask(getPeriodicity(getTaskTitle(), getTaskDescription(), getTaskType(), LocalDateTime.now()));
                    break;
                case "1":
                    System.out.println("Получить задачи на день: ");
                    try {
                        taskService.viewTasks(taskService.getCurrentTask());
                    } catch (IncorrectArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "2":
                    System.out.println("Удалить задачу: ");
                    int taskId = scanner.nextInt();
                    try {
                        taskService.deleteTask(taskId);
                    } catch (TaskNotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                    scanner.nextLine();
                    break;
                case "3":
                    System.exit(1);
                default:
                    System.out.println("Введите значение");
            }
        }
        scanner.close();
    }

    public static String getTaskTitle() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Заголовок: ");
        try {
            String argument = scanner.nextLine();
            test(argument);
            return argument;
        } catch (IncorrectArgumentException e) {
            System.out.println(e);
            return getTaskTitle();
        }
    }

    public static String getTaskDescription() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Описание: ");
        try {
            String argument = scanner.nextLine();
            test(argument);
            return argument;
        } catch (IncorrectArgumentException e) {
            System.out.println(e);
            return getTaskDescription();
        }
    }

    public static Type getTaskType() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Тип: ");
        String typeValue = scanner.nextLine();
        try {
            test(typeValue);
        } catch (IncorrectArgumentException e) {
            System.out.println(e);
            return getTaskType();
        }
        switch (typeValue) {
            case "0":
                return Type.WORK;
            case "1":
                return Type.PERSONAL;
            default:
                System.out.println("Ошибка!");
                return getTaskType();
        }
    }
    public static Task getPeriodicity(String title, String description, Type type, LocalDateTime localDateTime) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Повторяемость: Без повтора (0). Ежедневный повтор (1). Еженедельный повтор (2). Ежемесячный повтор (3). Ежегодный повтор (5).");
        String period = scanner.nextLine();
        try {
            test(period);
        } catch (IncorrectArgumentException e) {
            System.out.println(e);
            return getPeriodicity(title, description, type, localDateTime);
        }
        switch (period) {
            case "0":
                System.out.println("Дата в формате: чч.мм.гг чч.мм");
                String date = scanner.nextLine();
                LocalDate localDate = LocalDate.parse(date);
                return new OneTimeTask(title, description, type, LocalDateTime.now());
            case "1":
                return new DailyTask(title, description, type, LocalDateTime.now());
            case "2":
                return new WeeklyTask(title, description, type, LocalDateTime.now());
            case "3":
                return new MonthlyTask(title, description, type, LocalDateTime.now());
            case "4":
                return new YearlyTask(title, description, type, LocalDateTime.now());
            default:
                System.out.println("Введите верное значение");
                return getPeriodicity(title, description, type, localDateTime);
        }
    }
    public static void test (String argument) throws IncorrectArgumentException {
        if (argument.isEmpty() || argument.isBlank()) {
            throw new IncorrectArgumentException(argument);
        }
    }
       public static void getMenu() {
        System.out.println("Меню: Добавить задачу (0). Получить задачи на день (1). Удалить задачу (2).");
    }

}
