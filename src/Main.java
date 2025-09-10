public class Main {
    public static void main(String[] args) {
        Matrix a = new Matrix(3,3, new double[]{1,2,3,4,5,6,7,8,9});
        Vector v = new Vector(3, new double[]{1,2,3}, true);
        Matrix b = new Matrix(3,3, new double[]{1,1,1,1,1,1,1,1,1});

        LinearAlgebra.transpose(v).print();
    }
}
