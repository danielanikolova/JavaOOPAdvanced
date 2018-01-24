package app.waste_disposal.io;

public class Writer implements OutputWriter {


    @Override
    public void writeLine(String output) {
        System.out.println(output);
    }

    @Override
    public void writeLine(String format, Object... params) {
        System.out.print(format);
    }


}
