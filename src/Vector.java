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

    public boolean isRow() {
        return this.isRow;
    }

    public void setIsRow(boolean isRow) {
        this.isRow = isRow;
    }
}
