public class Ray {
    private Point3D origin;
    private Point3D direction;

    public Ray(Point3D origin, Point3D direction){
        this.origin = origin;
        this.direction = direction;
    }
    public Point3D getOrigin(){
        return origin;
    }
    public Point3D getDirection(){
        return direction;
    }
}
