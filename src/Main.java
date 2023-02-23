import javax.swing.*;
import java.awt.*;
class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(320,240);
        Point3D cameraPosition = new Point3D(0,0,0);
        Camera panel = new Camera(cameraPosition);
        frame.add(panel);
        frame.setVisible(true);


        Point3D p = new Point3D(2,1,4);
        Point3D q = new Point3D(4,-2,7);
        Point3D r = new Point3D(5,3,-2);
        Plane test = new Plane(p,q,r);
        System.out.println(test);
    }
}