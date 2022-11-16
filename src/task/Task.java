package task;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Task implements Repeatable{
    private int id;
    private String title;
    private String description;
    private Type type;
    private LocalDate dateTame;
    private static int idGenerator = 0;

    public Task(String title, String description, Type type, LocalDate taskDateTime) {
        this.id = idGenerator++;
        this.title = title;
        this.type = type;
        this.description = description;
        this.dateTame = taskDateTime;
    }

    public Task(String name, String description, Type taskType, LocalDateTime resultDate) {

    }

    @Override
    public boolean isAvailable(LocalDate inputDate) {
        return inputDate.isEqual(getDateTime());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public LocalDate getDateTime() {
        return dateTame;
    }

    public void setDateTame(LocalDate dateTame) {
        this.dateTame = dateTame;
    }
}
