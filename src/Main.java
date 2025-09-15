public class Main {
    public static void main(String[] args) {
        Matrix a = new Matrix(4,4, new double[]{1,2,3,4,2,1,1,3,3,4,1,2,1,1,1,1});
        Matrix b = new Matrix(4,4, new double[]{16,15,14,13,12,11,10,9,8,7,6,5,4,3,2,1});
        Vector v = new Vector(4, new double[]{10,9,10,4}, false);

        System.out.println("==== APRESENTAÇÃO BIBLIOTECA DE ALGEBRA LINEAR ====\n");

        System.out.println("Utilizando a matriz A:\n");
        a.print();
        System.out.println();

        System.out.println("Sua transposta é:\n");
        LinearAlgebra.transpose(a).print();
        System.out.println();

        System.out.println("Usando a matriz B:\n");
        b.print();
        System.out.println();

        System.out.println("E somando com A:\n");
        LinearAlgebra.sum(a,b).print();
        System.out.println();

        System.out.println("Multiplicando a matriz A por 2:\n");
        LinearAlgebra.times(2,a).print();
        System.out.println();

        System.out.println("Multiplicando A por B:\n");
        LinearAlgebra.dot(a,b).print();
        System.out.println();

        System.out.println("Usando o vetor V como as respostas para matriz ampliada temos:\n");
        v.print();
        System.out.println();

        System.out.println("Matriz ampliada de A com V:\n");
        Matrix augmented = LinearAlgebra.amp(a, v);
        augmented.print();
        System.out.println();

        System.out.println("Aplicando o método gauss nessa matriz ampliada, obtemos a matriz em forma escada:\n");
        Matrix escalonada = LinearAlgebra.gauss(augmented);
        escalonada.print();
        System.out.println();

        System.out.println("E aplicando o método solve, obtemos a resolução do sistema linear:\n");
        Matrix solution = LinearAlgebra.solve(augmented);
        solution.print();
        System.out.println();

        System.out.println("===================================================\n");
    }
}
