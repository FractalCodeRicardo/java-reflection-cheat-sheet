public class Foo {

    private String bar;

    public String getBar() {
        return bar;
    }

    public void setBar(String bar) {
        this.bar = bar;
    }

    public void printBar() {
        printBar("");
    }

    public void printBar(String param) {
        System.out.println(bar + param);
    }
}
