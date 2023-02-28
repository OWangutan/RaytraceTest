import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Camera extends JPanel{
    private int test = 0;
    private Scene scene;
    private Point3D position;
    private Point3D focus;
    private double pitch;
    private double yaw;
    private double roll;
    private double fov = 70;
    //constructers
    public Camera(Point3D position,Scene scene){
        setBackground(Color.BLUE);
        this.position = position;
        this.scene = scene;
    }
    // here is the rendering
    private Color[][] render(){
        //make 2D array of pixels
        Color[][] pixels = new Color[getWidth()][getHeight()];
        //finds the distance where the origin have to be so all the rays are one pixel apart at the panel.
        double focusDistance = getWidth()/2 * Math.sin(Math.toRadians(90 - fov/2))/Math.sin(Math.toRadians(fov/2));
        //makes Point of origin
        focus = new Point3D(position.getx(),position.gety(),position.getz() + focusDistance);

        ArrayList<Object3D> objects = scene.get();
        for(int r = 0; r < getWidth(); r++){

            for(int c = 0; c < getHeight(); c++){
                Ray ray = new Ray(focus, new Point3D(position.getx() - getWidth()/2 + c + .5,position.gety() - getHeight()/2 + r + .5,position.getz() - focusDistance));
                //testing
                if(test < 320) {
                    System.out.println(ray.toString());
                    test++;
                }
                for(int i = 0; i < objects.size();i++){
                    if(objects.get(i).hit(ray)){
                        pixels[r][c] = new Color(255,0,0);
                    }

                }
            }

        }
        return pixels;

    }

    //printing
    protected void paintComponent(Graphics g){
        super.paintComponent(g);

        Color[][] pixels = render();
        for(int r = 0; r < getWidth(); r++){
            for(int c = 0; c < getHeight(); c++){
                if(pixels[r][c] != null) {
                    g.setColor(pixels[r][c]);
                    g.drawLine(r,c,r,c);
                } else {
                    g.setColor(new Color(255,240,255));
                    g.drawLine(r,c,r,c);
                }
            }
        }


        try {
            Thread.sleep(10);
        } catch(Exception e) {
            System.out.println(e);
        }
        repaint();
    }

    public Point3D getFocus() {
        return focus;
    }
}


/* notes
    weighted average: R(t) = (1-t)C + tP

    I = R(t)

    line Equation: Δyx - Δxy + bΔx = 0 == ax +by + c = 0

    panel Equation: ax + by +cz + d = 0
 */