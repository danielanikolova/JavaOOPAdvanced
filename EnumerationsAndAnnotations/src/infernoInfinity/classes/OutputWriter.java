package infernoInfinity.classes;

import infernoInfinity.interfaces.Writer;

public class OutputWriter implements Writer{

    OutputWriter() {}

    @Override
    public void print(String s) {
        System.out.println(s);
    }
}
