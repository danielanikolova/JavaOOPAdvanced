package book;


import java.util.Iterator;

public class Library<Book> implements Iterable<Book> {
    private Book[] books;


    Library(Book... books) {
        this.books = books;
    }

    @Override
    public Iterator<Book> iterator() {
        return new LibraryIterator();
    }

    private final class LibraryIterator implements Iterator<Book>{

        private int counter;

        private LibraryIterator() {
            this.setCounter();
        }

        private void setCounter() {
            this.counter = 0;
        }

        @Override
        public boolean hasNext() {
            return this.counter<books.length;
        }

        @Override
        public Book next() {
            return books[this.counter++];
        }
    }
}
