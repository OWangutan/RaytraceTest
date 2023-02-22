public class Vector3D {
    private double x;
    private double y;
    private double z;

    public Vector3D(double x, double y, double z){
        this.x = x;
        this.y = y;
        this.z = z;
    }
    public double getMagnitude(Point3D origin){
        return Math.abs(Math.sqrt(x * origin.getx() + y * origin.gety() + x * origin.getz()));
    }
    //public Double dot(Vector3D vector){

    //}
}
