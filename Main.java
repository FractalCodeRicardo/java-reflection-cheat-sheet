import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) throws Exception {
        
        Foo instance = CheatSheet.getInstance(); 

        Field[] fields = CheatSheet.getFields();
        printArray(fields, f -> f.getName());

        Field field = CheatSheet.getField("bar");
        print(field, f -> f.getName());

        CheatSheet.setValuePrivateField(instance, "bar", "barChanged");
        instance.printBar();

        CheatSheet.setValuePrivateField(instance, "bar", "barChanged2");
        instance.printBar();
        
        var value = CheatSheet.getValuePrivateField(instance, "bar");
        System.out.println(value);

        value = CheatSheet.getValueUsingGet(instance, "bar");
        System.out.println(value);


        value = CheatSheet.callMethodByName(instance, "printBar", "foo");
        instance.printBar();

        var methods = CheatSheet.getMethods();
        printArray(methods, m -> m.getName());

        var method = CheatSheet.methodByName("printBar");
        print(method, m -> m.getName());

    }

    public static <T> void printArray(T[] array, Function<T, String> toString) {
        for (T t : array) {
            String string = toString.apply(t);
            System.out.println(string);
        }
    }

    public static <T> void print(T t, Function<T, String> toString) {
        System.out.println(toString.apply(t));
    }
}
