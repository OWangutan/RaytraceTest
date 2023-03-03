public class Vector3D {
    private double x;
    private double y;
    private double z;

    public Vector3D(double x, double y, double z){
        this.x = x;
        this.y = y;
        this.z = z;
    }
    public Vector3D(Vector3D vector3D){
      this.x = vector3D.getx();
      this.y = vector3D.gety();
      this.z = vector3D.getz();
    } 
   // public double getMagnitude(Point3D origin){
    //    return Math.abs(Math.sqrt(x * origin.getx() + y * origin.gety() + x * origin.getz()));
    //}
   public Vector3D crossProduct(Vector3D vector){
       return new Vector3D(y*vector.getz() - z*vector.gety(),z*vector.getx() - x * vector.getz(),x*vector.gety() - y*vector.getx());
   }
  public double[] getXYZ() {
        double[] pos = {x,y,z};
        return pos;
    }
    public double getx(){
        return x;
    }
    public double gety(){
        return y;
    }
    public double getz(){
        return z;
    }
    public void setx(double x){
      this.x = x;
    }
    public void sety(double y){
      this.y = y;
    }
    public void setz(double z){
      this.z = z;
    }
    public String toString(){
        return "("+x+","+y+","+z+")";
    }
}
