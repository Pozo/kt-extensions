package kt.extensions;

import java.util.ArrayList;
import java.util.List;

public class ValuesForTest {
    public static final String LIST_ELEMENT = "a";

    public static List<String> listWithOneValue() {
        final ArrayList<String> strings = new ArrayList<>();
        strings.add(LIST_ELEMENT);
        return strings;
    }

    public static List<String> listWithNullValue() {
        final ArrayList<String> strings = new ArrayList<>();
        strings.add(null);
        return strings;
    }

    public static List<String> nullList() {
        final ArrayList<String> strings = null;
        return strings;
    }
}
