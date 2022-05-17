public class ShapeSet {
    static Shape[] shapes = new Shape[10];
    static int shapeCnt;

    public static void drawShapes() {
        for (int i = 0; i < shapeCnt; i++) {
            shapes[i].draw();
        }
    }

    public static void main(String[] args) {
        shapes[shapeCnt++] = new Circle("파랑",5,5,10);
        shapes[shapeCnt++] = new Circle("초록", 15,15,20);
        shapes[shapeCnt++] = new Triangle("빨강",10,10,20,20,30,30);
        shapes[shapeCnt++] = new Triangle("주황",15,15,25,25,35,35);
        shapes[shapeCnt++] = new Rectangle("하늘",30,30,20,10);
        drawShapes();
    }
}
