public class Vector3D {
    private Point3D origin;
    private Point3D point;

    public Vector3D(Point3D origin, Point3D point){
        this.origin = origin;
        this.point = point;
    }
   // public double getMagnitude(Point3D origin){
    //    return Math.abs(Math.sqrt(x * origin.getx() + y * origin.gety() + x * origin.getz()));
    //}
   public Point3D crossProduct(Point3D point3){
       Point3D a = new Point3D(point.getx() - origin.getx(), point.gety() - origin.gety(), point.getz() - origin.getz());
       Point3D b = new Point3D(point3.getx() - origin.getx(), point3.gety() - origin.gety(), point3.getz() - origin.getz());
       return new Point3D( (a.gety()*b.getz())-(b.gety()*a.getz()),-((a.getx()*b.getz())-(b.getx()*a.getz())), (a.getx()*b.gety())-(b.getx()*a.gety()));
   }
   public Point3D getOrigin(){
        return origin;
   }
}
