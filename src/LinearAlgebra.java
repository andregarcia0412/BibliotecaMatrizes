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
}
