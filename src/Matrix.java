public class Matrix {
    private int rows;
    private int cols;
    private double[][] mat; //matriz original


    Matrix(int rows, int cols, double[] elements) {
        this.rows = rows;
        this.cols = cols;
        this.mat = new double[rows][cols];

        int p = 0;

        for(int i = 0; i < this.rows; i++) {
            for(int j = 0; j < this.cols; j++) {
                if(p < elements.length) {
                    this.mat[i][j] = elements[p];
                    p++;
                } else {
                    this.mat[i][j] = 0.0;
                }
            }
        }

        if(!(elements.length == this.rows * this.cols)){
            throw new IllegalArgumentException("A quantidade de elementos da matriz é diferente de i * j.");
        }
    }

    public double getElement(int i, int j) {
        if(i < 0 || i > this.rows - 1 || j < 0 || j >  this.cols - 1) {
            throw new IllegalArgumentException("Índices fora dos limites");
        } else {
            return this.mat[i][j];
        }
    }

    public void setElement(int i, int j, double value) {
        if(i < 0 || i > this.rows - 1 || j < 0 || j >  this.cols - 1) {
            throw new IllegalArgumentException("Índices fora dos limites");
        } else {
            this.mat[i][j] = value;
        }
    }

    public int getRows(){
        return this.rows;
    }

    public int getCols() {
        return this.cols;
    }

    public void print(){
        if (this instanceof Vector){ //vetor sendo linha ou coluna, só muda a forma de imprimir
            if(((Vector) this).isRow()){
                for(int i = 0; i < this.getCols(); i++){
                    System.out.print(this.getElement(0,i) + " ");
                }
                System.out.print("\n");
            } else{
                for(int i = 0; i < this.getRows(); i++){
                    System.out.println(this.getElement(i,0));
                }
            }
        } else{
            for(int i = 0; i < this.rows; i++){
                if (i > 0){
                    System.out.print("\n");
                }
                for(int j = 0; j < this.cols; j++){
                    System.out.print(this.mat[i][j] + " ");
                }
            }
            System.out.print("\n");
        }
    }
    public static Matrix gauss(Matrix a) {
        int rows = a.getRows();
        int cols = a.getCols();

        // Cria uma cópia da matriz
        double[] elements = new double[rows * cols];
        int index = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                elements[index++] = a.getElement(i, j);
            }
        }
        Matrix result = new Matrix(rows, cols, elements);

        for (int pivot = 0; pivot < Math.min(rows, cols); pivot++) {
            double pivotValue = result.getElement(pivot, pivot);

            if (pivotValue == 0) {
                throw new ArithmeticException("Pivô zero encontrado. Não implementado pivotamento parcial.");
            }

            // Normaliza a linha do pivô
            for (int j = pivot; j < cols; j++) {
                result.setElement(pivot, j, result.getElement(pivot, j) / pivotValue);
            }

            // Elimina as linhas abaixo do pivô
            for (int i = pivot + 1; i < rows; i++) {
                double factor = result.getElement(i, pivot);
                for (int j = pivot; j < cols; j++) {
                    double value = result.getElement(i, j) - factor * result.getElement(pivot, j);
                    result.setElement(i, j, value);
                }
            }
        }

        return result;
    }

    public static Matrix solve(Matrix augmented) {
        int rows = augmented.getRows();
        int cols = augmented.getCols();

        // Primeiro aplica gaussiana
        Matrix escalonada = gauss(augmented);

        double[] solution = new double[rows];

        // Substituição regressiva
        for (int i = rows - 1; i >= 0; i--) {
            double sum = 0;
            for (int j = i + 1; j < cols - 1; j++) {
                sum += escalonada.getElement(i, j) * solution[j];
            }
            solution[i] = escalonada.getElement(i, cols - 1) - sum;
        }

        // Converte o vetor solução em matriz coluna
        return new Matrix(rows, 1, solution);
    }

}
