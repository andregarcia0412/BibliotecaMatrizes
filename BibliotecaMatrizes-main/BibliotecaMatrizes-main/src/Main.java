public class Main {
    public static void main(String[] args) {
        Matrix a = new Matrix(3,3, new double[]{2,-1,3,1,0,-2,3,1,1});
        Vector v = new Vector(3, new double[]{-3,3,4}, false);

        Matrix augmented = LinearAlgebra.amp(a, v);
        // Aplica eliminação gaussiana
        Matrix escalonada = LinearAlgebra.gauss(augmented);
        System.out.println("Matriz escalonada:");
        escalonada.print();

        // Resolve o sistema
        Matrix solution = LinearAlgebra.solve(augmented);
        System.out.println("Solução do sistema:");
        solution.print();
    }
}
