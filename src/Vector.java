public class Vector extends Matrix{
    private int dim;
    private double[] elements;
    private boolean isRow = true;
    // vetor é classe filha de matrix
    Vector(int dim, double[] elements, boolean isRow){
        super(isRow ? 1 : dim, isRow ? dim : 1, elements); //construtor de matrix
        this.isRow = isRow;
        this.dim = dim;
        this.elements = elements;
    }

    public double getElement(int i){
        return this.elements[i];
    }

    public void setElement(int i, double value){
        this.elements[i] = value;
    }

    public int getDim(){
        return this.dim;
    }

    public boolean isRow() {
        return this.isRow;
    }

    public void setIsRow(boolean isRow) {
        this.isRow = isRow;
    }

    @Override
    public void print(){
        double[] ordered = elements;
        for(int i = 0;i < this.dim-1; i++){
            for(int j = 0; j < this.dim - 1 - i; j++){
                if(ordered[j] < ordered[j+1]){
                    double aux = ordered[j];
                    ordered[j] = ordered[j+1];
                    ordered[j+1] = aux;
                }
            }
        }

        for(int i = 0; i < dim; i++){
            System.out.printf("%d° Lugar: %.8f\n", i+1, elements[i]);
        }
    }
}
