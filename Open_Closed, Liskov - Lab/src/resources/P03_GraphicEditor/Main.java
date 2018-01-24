package resources.P03_GraphicEditor;

public class Main {
    public static void main(String[] args) {

        Shape shape = new Circle();

        GraphicEditor editor = new GraphicEditor();
         editor.drawShape(shape);

         Shape rectangle = new Rectangle();
         editor.drawShape(rectangle);

    }
}
