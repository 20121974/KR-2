package task;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class YearTask extends Task{


    public YearTask(String title, String description, Type type, LocalDateTime taskDateTime) {
        super(title, description, type, taskDateTime);
    }

    @Override
    public boolean isAvailable(LocalDate inputDate) {
        var startDate = getDateTime();
        while (!startDate.isAfter(inputDate)) {
            if (startDate.equals(inputDate)) {
                return true;
            }
            startDate = startDate.plusYears(1);
        }
        return false;
    }
}
