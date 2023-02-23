public class Plane {
    private Point3D point1;
    private Point3D point2;
    private Point3D point3;

    // Plane equation: ax + by + cz + d = 0
    private double a;
    private double b;
    private double c;
    private double d;
    public Plane(Point3D point1, Point3D point2, Point3D point3){
        this.point1 = point1;
        this.point2 = point2;
        this.point3 = point3;
        Vector3D line = new Vector3D(point1, point2);
        Point3D normal = line.crossProduct(point3);
        System.out.println(normal);
        a = normal.getx();
        b = normal.gety();
        c = normal.getz();
        d = -(normal.getx() * point1.getx()) - (normal.gety() * point1.gety()) - (normal.getz() * point1.getz());
    }

    //public Point3D interception(Ray ray){
    //    return
    //}
    public String toString(){
        return "Points: " + point1 + "," + point2 + "," + point3 + "\nequation: " + a + "x+" + b + "y+" + c + "z+" + d + "=0";
    }

}