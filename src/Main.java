import javax.swing.*;
import java.awt.*;
class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(320,240);


        //testing
        Scene scene = new Scene();
        Point3D p1 = new Point3D(100,100,100);
        Point3D p2 = new Point3D(0,100,100);
        Point3D p3 = new Point3D(100,0,100);
        Triangle test = new Triangle(p1,p2,p3);
        scene.add(test);


        Point3D cameraPosition = new Point3D(0,0,0);
        Camera panel = new Camera(cameraPosition,scene);
        frame.add(panel);
        frame.setVisible(true);
    }
}