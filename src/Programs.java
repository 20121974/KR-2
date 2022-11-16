import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Programs {
    private static List<Integer> integers = new ArrayList<>();
    public static void start() {
        for (int i = 0; i < integers.size(); i++) {
            System.out.println((i));
        }
    }

    public static void start2() {
        int i = 0;
        while (i < integers.size()) {
            System.out.println((i));
            i++;
        }
    }

    public static void start3() {
        for (Integer integer:integers) {
            System.out.println((integer));
        }
    }
}
