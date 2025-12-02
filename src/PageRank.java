public abstract class PageRank {

    public static Vector calcularPageRank(Matrix matrizAdjacencia, double criterioParada){

        double somaCentro = 0;
        double[] auxCentro = new double[matrizAdjacencia.getRows()];

        double somaAutoridade = 0;
        double[] auxAutoridade = new double[matrizAdjacencia.getRows()];

        Matrix matrizAdjascenciaTransposta = LinearAlgebra.transpose(matrizAdjacencia);

        //criando os vetores
        for(int i = 0; i < matrizAdjacencia.getRows(); i++){
            for(int j = 0; j < matrizAdjacencia.getCols(); j++){
                somaCentro += matrizAdjacencia.getElement(i,j);
                somaAutoridade += matrizAdjascenciaTransposta.getElement(i,j);
            }
            auxCentro[i] = somaCentro;
            somaCentro = 0;

            auxAutoridade[i] = somaAutoridade;
            somaAutoridade = 0;
        }

        Vector vetorCentro = new Vector(matrizAdjacencia.getRows(), auxCentro, false);
        Vector vetorAutoridade = new Vector(matrizAdjascenciaTransposta.getRows(), auxAutoridade, false);

        int qtdIteracoes = 0;
        Vector anVector = null;
        for(int i = 0; i < 1000; i++){
            Matrix u = LinearAlgebra.dot(matrizAdjacencia, vetorAutoridade);

            double r = Math.sqrt(LinearAlgebra.dot(LinearAlgebra.transpose(u),u).getElement(0,0)); //norma de u
            Matrix hn = LinearAlgebra.times(1/r, u); //normalizando u

            Matrix v = LinearAlgebra.dot(LinearAlgebra.transpose(matrizAdjacencia), hn);

            double s = Math.sqrt(LinearAlgebra.dot(LinearAlgebra.transpose(v), v).getElement(0,0)); //norma de v
            Matrix an = LinearAlgebra.times(1/s, v); //normalizando v

            double[] aux = new double[an.getRows()];
            for(int j = 0; j < an.getRows(); j++){
                aux[j] = an.getElement(j,0);
            }

            anVector = new Vector(aux.length, aux, false);

            //calculo do erro
            Vector erro = absolute(LinearAlgebra.sum(anVector,subtract(vetorAutoridade)));

            if(max(erro) <= criterioParada){
                System.out.println("Quantidade de Iterações: " + qtdIteracoes);
                return anVector;
            } else{
                vetorAutoridade = anVector;
            }
            qtdIteracoes++;

        }
        System.out.println("Quantidade de Iterações: " + qtdIteracoes);
        return anVector;
    }

    private static Vector absolute(Vector v){
        for(int i = 0; i < v.getDim(); i++){
            v.setElement(i, Math.abs(v.getElement(i)));
        }
        return v;
    }

    private static Vector subtract(Vector v){
        for(int i = 0; i < v.getDim(); i++){
            v.setElement(i, -v.getElement(i));
        }
        return v;
    }

    private static double max(Vector v){
        double maior = v.getElement(0);
        for(int i = 0; i < v.getDim(); i++){
            if(v.getElement(i) > maior){
                maior = v.getElement(i);
            }
        }

        return maior;
    }
}
