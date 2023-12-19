import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class CheatSheet {

    public static Class<Foo> getClazz() {
        Class<Foo> clazz = Foo.class;
        return clazz;
    }

    public static Foo getInstance() {
        try {
            Class<Foo> clazz = Foo.class;
            Foo instance = clazz.getDeclaredConstructor().newInstance();
            return instance;
        } catch (Exception ex) {
            // Handle exceptions
            return null;
        }

    }

    public static Field getField(String name) {

        try {

            Class<Foo> clazz = Foo.class;
            Field field = clazz.getDeclaredField(name);

            return field;
        } catch (Exception ex) {
            // Handle exceptions
            return null;
        }

    }

    public static Field[] getFields() {

        try {

            Class<Foo> clazz = Foo.class;
            Field[] fields = clazz.getDeclaredFields();

            return fields;
        } catch (Exception ex) {
            // Handle exceptions
            return null;
        }

    }

    public static void setValuePrivateField(Foo instance, String name, Object value) {

        try {
            Class<Foo> clazz = Foo.class;
            Field field = clazz.getDeclaredField(name);
            field.setAccessible(true);
            field.set(instance, value);

        } catch (Exception ex) {
            // Handle exceptions
        }

    }

    public static void setValueUsingSet(Foo instance, String name, Object value) {
        try {

            Class<Foo> clazz = Foo.class;
            String fieldName = name.substring(0, 1).toUpperCase() + name.substring(1);
            String setMethod = "set" + fieldName;
            Method method = clazz.getMethod(setMethod);

            method.invoke(instance, value);

        } catch (Exception ex) {
            // Handle exceptions
        }
    }

    public static Object getValuePrivateField(Foo instance, String name) {
        try {

            Class<Foo> clazz = Foo.class;

            Field field = clazz.getDeclaredField(name);
            field.setAccessible(true);

            Object value = field.get(instance);
            return value;
        } catch (Exception ex) {
            return null;
        }
    }

    public static Object getValueUsingGet(Foo instance, String name) {

        try {
            Class<Foo> clazz = Foo.class;

            String fieldName = name.substring(0, 1).toUpperCase() + name.substring(1);
            String getMethod = "get" + fieldName;
            Method method = clazz.getMethod(getMethod);

            Object value = method.invoke(instance);

            return value;
        } catch (Exception ex) {
            return null;
        }

    }

    public static Method[] getMethods() {
        Class<Foo> clazz = Foo.class;
        Method[] methods = clazz.getMethods();

        return methods;
    }

    public static Method methodByName(String name) {
        try {
            Class<Foo> clazz = Foo.class;
            Method method = clazz.getDeclaredMethod(name);

            return method;
        } catch (Exception ex) {
            return null;
        }
    }

    public static Object callMethodByName(Foo instance, String name, String param) {
        try {
            Class<Foo> clazz = Foo.class;
            Method method = clazz.getMethod(name, String.class);

            Object value = method.invoke(instance, param);

            return value;
        } catch (Exception ex) {
            return null;
        }

    }

}
