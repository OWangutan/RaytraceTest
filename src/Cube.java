public class Cube {
    private Point3D[] vertices = new Point3D[8];
    private double x;
    private double y;
    private double z;
    Double size;

    public Cube(double x,double y,double z,double size){
        this.x = x;
        this.y = y;
        this.z = z;
        this.size = size;
        vertices[0] = new Point3D(x - size,y - size,z - size);
        vertices[1] = new Point3D(x + size,y - size,z - size);
        vertices[2] = new Point3D(x + size,y - size,z + size);
        vertices[3] = new Point3D(x - size,y - size,z + size);
        vertices[4] = new Point3D(x - size,y + size,z - size);
        vertices[5] = new Point3D(x + size,y + size,z - size);
        vertices[6] = new Point3D(x + size,y + size,z + size);
        vertices[7] = new Point3D(x - size,y + size,z + size);

    }
}
