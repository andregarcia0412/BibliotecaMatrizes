public class Main {
    public static void main(String[] args) {
        Matrix a = new Matrix(3,3, new double[]{5,2,-1,3,6,-2,1,-1,3});
        Vector v = new Vector(3, new double[]{6,9,8}, false);
        Matrix b = new Matrix(3,3, new double[]{1,1,1,1,1,1,1,1,1});
        Vector vt = LinearAlgebra.transpose(v);

        Matrix x = new Matrix(3,2, new double[]{3,4,5,3,2,6});
        Matrix y = new Matrix(2,3, new double[]{3,2,4,2,5,3});

        LinearAlgebra.amp(a,v).print();
    }
}
