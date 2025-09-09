public class Main {
    public static void main(String[] args) {
        Matrix m = new Matrix(3,3, new double[]{1,2,3,4,5,6,7,8,9});
        m.print();
        m.setElement(2,2, 15);
        m.print();
    }
}
