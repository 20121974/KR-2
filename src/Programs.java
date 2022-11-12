import java.util.ArrayList;
import java.util.List;

public class Programs {

    private static List<Integer> integers = new ArrayList<>(List.of(1, 2, 3));

    public static void start() {
        for (int i = 0; i < integers.size(); i++) {
            System.out.println(i);
        }
    }
    public static Object start1() {
        int i = 0;
        while (i < integers.size()) {
            System.out.println();
        }
        return start1();
    }
    public static void start2() {
        for (Integer integer:integers) {
            System.out.println(integers);
        }
    }
}
