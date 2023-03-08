import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Camera extends JPanel{
    private int test = 0;
    private ArrayList<Object3D> scene;
    private Point3D position;
    private Point3D focus;
    private double pitch;
    private double yaw;
    private double roll;
    //constructers
    public Camera(Point3D position,ArrayList<Object3D> scene){
        this.position = position;
        this.scene = scene;
        updateFov(70);
    }
    // here is the rendering
    private Color[][] render(){
        Color[][] frame = new Color[getWidth()][getHeight()];
        for(int c = 0; c < getHeight(); c++){
            for(int r = 0; r < getWidth(); r++){
                Ray ray = new Ray(focus , new Point3D(position.getx() - getWidth()/2 + r +0.5 , position.gety() - getHeight()/2 + c + 0.5, position.getz()));
                if(scene.get(0).hit(ray) == true) {
                    frame[r][c] = new Color(255, 000, 000);
                }
            }
        }
        return frame;
    }
    public void updateFov(double fov){
        double focusDistance = getWidth()/2 * Math.sin(Math.toRadians(90 - fov/2))/Math.sin(Math.toRadians(fov/2));
        focus = new Point3D(position.getx(), position.gety(), position.getz() - focusDistance);
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
                    g.setColor(new Color(255,220,255));
                    g.drawLine(r,c,r,c);
                }
            }
        }


        try {
            Thread.sleep(1000);
        } catch(Exception e) {
            System.out.println(e);
        }
        //repaint();
    }

}


/* notes
    weighted average: R(t) = (1-t)C + tP

    I = R(t)

    line Equation: Δyx - Δxy + bΔx = 0 == ax +by + c = 0

    panel Equation: ax + by +cz + d = 0
 */