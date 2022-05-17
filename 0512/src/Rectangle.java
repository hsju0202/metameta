public class Rectangle extends Shape {
    Point startPoint;
    int width;
    int height;

    public Rectangle(String color, int x, int y, int width, int height) {
        super(color);
        this.startPoint = new Point(x,y);
        this.width = width;
        this.height = height;
    }

    @Override
    public void draw() {
        System.out.println("[삼각형:색-" + getColor() +
                ", 시작점:-"+getStartPoint()+
                ", 가로-" + getWidth() +
                ", 세로-" + getHeight() +
                "]");
    }

    public Point getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(Point startPoint) {
        this.startPoint = startPoint;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
