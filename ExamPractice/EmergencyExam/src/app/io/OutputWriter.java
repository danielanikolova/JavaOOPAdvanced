package app.io;

public class OutputWriter implements Writer {

    @Override
    public void write(String text) {
        System.out.println(text);
    }

    @Override
    public void write(String text, Object... params) {
        System.out.println(String.format(text, params));

    }
}
