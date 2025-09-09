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
    }

    public double getElement(int i, int j) {
        if(i < 0 || i > this.rows - 1 || j < 0 || j >  this.cols - 1) {
            throw new IllegalArgumentException("Índices fora dos limites");
        } else {
            return this.mat[i][j];
        }
    }

    public double setElement(int i, int j, int value) {
        if(i < 0 || i > this.rows - 1 || j < 0 || j >  this.cols - 1) {
            throw new IllegalArgumentException("Índices fora dos limites");
        } else {
            return this.mat[i][j] = value;
        }
    }

    public int getRows(){
        return this.rows;
    }

    public int getCols() {
        return this.cols;
    }

    public void print(){
        for(int i = 0; i < this.rows; i++){
            if (i > 0){
                System.out.print("\n");
            }
            for(int j = 0; j < this.cols; j++){
                System.out.print(this.mat[i][j] + " ");
            }
        }
    }
}