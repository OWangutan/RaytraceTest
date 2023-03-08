import java.util.*;

public class Mesh {
    private Scanner scan = new Scanner(System.in);
    private ArrayList<Point3D> verticies;
    private ArrayList<Object3D> faces;
    String meshName;

    public Mesh(String meshName) {
        this.meshName = meshName;
    }

    public void giveObject(Object3D object) {
        faces.add(object);
    }
    public void buildMesh(ArrayList<Point3D> points) {

    }


}
