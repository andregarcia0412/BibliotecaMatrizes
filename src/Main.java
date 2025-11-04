public class Main {
    public static void main(String[] args) {
        System.out.println("========== Implementação de Transformações Lineares ==========");
        System.out.println("Usando o vetor V:");
        Vector v = new Vector(2, new double[]{2, 3},false);
        Vector u = new Vector(3, new double[]{1,2,3}, false);
        v.print();

        System.out.println("E o vetor U:");
        u.print();

        System.out.println("======== Translação ========");
        System.out.println("Aplicando uma translação 2D em V com dx = 4 e dy = -1:");
        Transformation.translation2D(v, 4, -1).print();
        System.out.println("Aplicando uma translação 3D em U com dx = -2, dy = 3 e dz = 1:");
        Transformation.translation3D(u, -2, 3, 1).print();

        System.out.println("======== Rotação ========");
        System.out.println("Aplicando uma rotação 2D com um ângulo de 90 graus em V: ");
        Transformation.rotation2D(v, 90).print();
        System.out.println("Aplicando uma rotação 3D no eixo X com um ângulo de 90 graus em U:");
        Transformation.rotation3DX(u, 90).print();
        System.out.println("Aplicando uma rotação 3D no eixo Y com um ângulo de 90 graus em U:");
        Transformation.rotation3DY(u, 90).print();
        System.out.println("Aplicando uma rotação 3D no eixo Z com um ângulo de 90 graus em U:");
        Transformation.rotation3DZ(u, 90).print();

        System.out.println("======== Reflexão ========");
        System.out.println("Aplicando uma reflexão 2D no eixo X em V:");
        Transformation.reflection2DX(v).print();
        System.out.println("Aplicando uma reflexão 2D no eixo Y em V:");
        Transformation.reflection2DY(v).print();
        System.out.println("Aplicando uma reflexão 3D no eixo X em U:");
        Transformation.reflection3DX(u).print();
        System.out.println("Aplicando uma reflexão 3D no eixo Y em U:");
        Transformation.reflection3DY(u).print();
        System.out.println("Aplicando uma reflexão 3D no eixo Z em U:");
        Transformation.reflection3DZ(u).print();

        System.out.println("======== Projeção ========");
        System.out.println("Aplicando uma projeção 2D no eixo X em V:");
        Transformation.projection2DX(v).print();
        System.out.println("Aplicando uma projeção 2D no eixo Y em V:");
        Transformation.projection2DY(v).print();
        System.out.println("Aplicando uma projeção 3D no eixo X em U:");
        Transformation.projection3DX(u).print();
        System.out.println("Aplicando uma projeção 3D no eixo Y em U:");
        Transformation.projection3DY(u).print();
        System.out.println("Aplicando uma projeção 3D no eixo Z em U:");
        Transformation.projection3DZ(u).print();

        System.out.println("======== Cisalhamento ========");
        System.out.println("Aplicando um cisalhamento 2D em V com kx = 1.5 e ky = 2.5:");
        Transformation.shearing(v, 1.5, 2.5).print();

    }
}
