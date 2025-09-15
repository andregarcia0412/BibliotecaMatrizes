public abstract class LinearAlgebra {
    private LinearAlgebra(){}

    public static Matrix transpose(Matrix a){
        double[] elements = new double[a.getCols() * a.getRows()];
        int index = 0;
        for(int i = 0; i < a.getCols(); i++){
            for(int j = 0; j < a.getRows(); j++){
                elements[index++] = a.getElement(j,i);
            }
        }
        return new Matrix(a.getCols(), a.getRows(), elements);
    }

    public static Vector transpose(Vector v){
        double[] elements = new double[v.getCols() * v.getRows()];
        int index = 0;
        for(int i = 0; i < v.getCols(); i++){
            for(int j = 0; j < v.getRows(); j++){
                elements[index++] = v.getElement(j,i);
            }
        }
        return new Vector(index, elements, !v.isRow());
    }

    public static Matrix sum(Matrix a, Matrix b){
        double[] elements = new double[a.getCols() * a.getRows()];
        int index = 0;
        if(!(a.getRows() == b.getRows() && a.getCols() == b.getCols())){
            throw new IllegalArgumentException("A quantidade de linhas e colunas de A e B são precisam ser iguais.");
        }
        for(int i = 0; i < a.getRows(); i++){
            for(int j = 0; j < a.getCols(); j++){
                elements[index++] = a.getElement(i,j)+ b.getElement(i,j);
            }
        }
        return new Matrix(a.getRows(), b.getCols(), elements);
    }

    public static Vector sum(Vector a, Vector b){
        double[] elements = new double[a.getCols() * a.getRows()];
        if(!(a.getRows() == b.getRows() && a.getCols() == b.getCols())){
            throw new ArithmeticException("A quantidade de linhas e colunas de A e B são precisam ser iguais.");
        }

        if(a.isRow()){
            for(int i = 0; i < a.getCols(); i++){
                elements[i] = a.getElement(i) + b.getElement(i);
            }
        } else{
            for(int i = 0; i < a.getRows(); i++){
                elements[i] = a.getElement(i) + b.getElement(i);
            }
        }

        return new Vector(a.getCols() * a.getRows(), elements, a.isRow());
    }

    public static Matrix times(double a, Matrix b){
        double[] elements = new double[b.getRows() * b.getCols()];
        int index = 0;
        for(int i = 0; i < b.getRows(); i++){
            for(int j = 0; j < b.getCols(); j++){
                elements[index++] = b.getElement(i,j) * a;
            }
        }
        return new Matrix(b.getRows(), b.getCols(), elements);
    }

    public static Vector times(double a, Vector b){
        double[] elements = new double[b.getRows() * b.getCols()];
        for(int i = 0; i < b.getCols(); i++){
            elements[i] = b.getElement(i) * a;
        }
        return new Vector(b.getCols(), elements, b.isRow());
    }

    public static Matrix dot(Matrix a, Matrix b) {
        double[] elements = new double[a.getRows() * b.getCols()];
        int index = 0;
        for(int i = 0; i < a.getRows() * b.getCols(); i++){
            elements[i] = 0;
        }
        Matrix result = new Matrix(a.getRows(), b.getCols(), elements);

        if (a.getCols() == b.getRows()) {
            for (int i = 0; i < a.getRows(); i++) {
                for (int k = 0; k < b.getCols(); k++) {
                    for (int j = 0; j < a.getCols(); j++) {
                        result.setElement(i,k, result.getElement(i,k) + a.getElement(i,j) * b.getElement(j,k));
                    }
                }
            }
        } else{
            throw new IllegalArgumentException("O número de colunas de A precisa ser igual a quantidade de linhas de B");
        }
        return result;
    }

    public static Matrix amp(Matrix coefficients, Vector results){
        if(results.isRow()){
            throw new IllegalArgumentException("O vetor precisa ser em coluna");
        }

        double[] elements = new double[coefficients.getRows() * coefficients.getCols() + results.getDim()];
        Matrix result = new Matrix(coefficients.getRows(), coefficients.getCols() + 1, elements);

        for(int i = 0; i < coefficients.getRows(); i++){
            for(int j = 0; j < coefficients.getCols(); j++){
                if(j != coefficients.getCols()){
                    result.setElement(i,j, coefficients.getElement(i,j));
                }
            }
        }
        for(int i = 0; i < results.getDim(); i++){
            result.setElement(i, coefficients.getCols(), results.getElement(i));
        }

        return result;
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
                throw new ArithmeticException("Pivô zero.");
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
