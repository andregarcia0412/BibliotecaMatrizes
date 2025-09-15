public class Main {
    public static void main(String[] args) {
        Matrix a = new Matrix(3,2, new double[]{3,4,5,3,2,6});
        Matrix b = new Matrix(2,3, new double[]{3,2,4,2,5,3});
        LinearAlgebra.dot(a,b).print();
    }
}
