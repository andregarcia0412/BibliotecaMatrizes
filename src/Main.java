public class Main {
    public static void main(String[] args) {

        System.out.println("============ APRESENTAÇÃO DE ALGEBRA LINEAR - PAGERANK ============");
        Matrix matrizAdjascencia = new Matrix(4, 4, new double[]{
                0,0,1,0,
                1,0,0,0,
                1,1,0,0,
                0,1,0,0
        });
        double criterioParada = 0.0001;
        System.out.println("=========== QUESTÃO 5 ===========");
        PageRank.calcularPageRank(matrizAdjascencia, criterioParada).print();

        System.out.println("=========== QUESTÃO 6 ===========");
        matrizAdjascencia = new Matrix(4, 4, new double[]{
                0,1,1,0,
                0,0,1,0,
                1,0,0,1,
                1,0,0,0
        });
        PageRank.calcularPageRank(matrizAdjascencia, criterioParada).print();

        System.out.println("=========== QUESTÃO 7 ===========");
        matrizAdjascencia = new Matrix(5, 5, new double[]{
                0,1,1,1,0,
                1,0,0,0,1,
                0,0,0,0,1,
                0,1,0,0,0,
                0,1,1,0,0
        });
        PageRank.calcularPageRank(matrizAdjascencia, criterioParada).print();

        System.out.println("=========== QUESTÃO 8 ===========");
        matrizAdjascencia = new Matrix(10, 10, new double[]{
                0,1,1,0,1,1,0,0,0,1,
                0,0,1,0,0,0,0,0,0,0,
                0,0,0,0,0,0,0,0,1,0,
                0,1,1,0,0,1,1,0,0,1,
                0,0,0,1,0,0,0,0,0,0,
                0,1,0,0,0,0,0,0,0,0,
                0,0,0,0,0,0,0,0,1,0,
                0,0,0,0,0,1,0,0,0,0,
                0,1,1,0,0,1,0,1,0,1,
                0,0,0,0,0,1,0,0,0,0
        });
        PageRank.calcularPageRank(matrizAdjascencia, 0.0001).print();
    }
}
