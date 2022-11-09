import task.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static TaskService taskService = new TaskService();
    private static LocalDate taskDate;
    private static CharSequence date;

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            label:
            while (true) {
                printMenu();
                System.out.print("Выберите пункт меню: ");
                if (scanner.hasNextInt()) {
                    int menu = scanner.nextInt();
                    switch (menu) {
                        case 1:
                            addTask(taskService, scanner);
                            break;
                        case 2:
                            removeTask(taskService, scanner);
                            break;
                        case 3:
                            getTaskByDay(taskService, scanner);
                        case 0:
                            break label;
                    }
                } else {
                    scanner.next();
                    System.out.println("Выберите пункт меню из списка! ");
                }
            }
        }
    }
    private static void addTask(TaskService taskService, Scanner scanner) {
        System.out.println("Введите заголовок задачи: ");
        String name = scanner.nextLine();
        scanner.nextLine();
        System.out.println("Введите описание задачи: ");
        String description = scanner.nextLine();
        System.out.println("Введите время задачи в формате HH:mm: ");
        LocalTime taskTime = LocalTime.parse(date, DateTimeFormatter.ofPattern("HH:mm"));
        scanner.nextLine();
        LocalDateTime resultDate = LocalDateTime.of(taskDate, taskTime);
        System.out.println("Введите тип задачи: Личный (1) или рабочий (2)");
        int type = Integer.parseInt(scanner.nextLine());
        Type taskType = type == 1 ? Type.PERSONAL : Type.WORK;
        System.out.println("Введите повторяемость задачи:");
        System.out.println("0 - Не повторяется");
        System.out.println("1 - Дневная");
        System.out.println("2 - Недельная");
        System.out.println("3 - Месячная");
        System.out.println("4 - Годовая");
        int typeTask = Integer.parseInt(scanner.nextLine());
        switch (typeTask) {
            case 0:
                taskService.add(new Task(name, description, taskType, resultDate));
                break;
            case 1:
                taskService.add(new DailyTask(name, description, taskType, resultDate));
                break;
            case 2:
                taskService.add(new WeeklyTask(name, description, taskType, resultDate));
                break;
            case 3:
                taskService.add(new MonthlyTask(name, description, taskType, resultDate));
                break;
            case 4:
                taskService.add(new YearTask(name, description, taskType, resultDate));
            default:
                    throw new RuntimeException("Нет такого типа задач");
            }
    }


    private static void removeTask(TaskService taskService, Scanner scanner) {
        System.out.println("Введите id задачи которую необходимо удалить: ");
        int id = scanner.nextInt();
        taskService.remove(id);
    }
    private static void getTaskByDay(TaskService taskService, Scanner scanner) {
        System.out.println("Введите дату задачи в формате dd.mm.yyyy: ");
        String date = scanner.nextLine();
        LocalDate taskDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        var allTaskByDay = taskService.getAllByDate(taskDate);
        System.out.println("Список задач этого дня:");
        for (Task task:allTaskByDay) {
            System.out.println(task);
        }
    }
    private static void printMenu() {
    }



}

