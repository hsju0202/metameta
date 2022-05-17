public class Shape {

    String color;

    public Shape() {
        this("흰색");
    }

    public Shape(String color) {
        this.color = color;
    }

    public void draw(){}


    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
