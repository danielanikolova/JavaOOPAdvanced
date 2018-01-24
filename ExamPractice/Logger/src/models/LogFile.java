package models;

import interfaces.File;


public class LogFile implements File {


    private int size;

    public LogFile() {
        this.size = 0;
    }

    @Override
    public int getSize() {
        return this.size;
    }

    private void setSize(int size) {
        this.size = size;
    }

    @Override
    public void write(String message) {

        int currentSize= 0;
        char[] chars = message.toCharArray();

        for (Character ch:chars) {
            if (Character.isAlphabetic(ch)){
                currentSize+=ch;
            }
        }

        this.setSize(this.getSize() + currentSize);
    }
}
