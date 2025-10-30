public class Transformation {
    public double[] translation2D(double []vector, double dx, double dy) {
        if(vector.length != 2) {
            throw new IllegalArgumentException("Vetor 2D precisa ter dois elementos");
        }

        //Facilitando os cálculos deixando o vetor homogêneo
        double[] homogeneous = {vector[0], vector[1], 1.0};


        double[] matrixElements = {
                1, 0, dx,
                0, 1, dy,
                0, 0, 1
        };

        Matrix translationMatrix = new Matrix(3,3,matrixElements);

        Vector homogeneousVector = new Vector(3, homogeneous, false);

        Matrix resultMatrix = LinearAlgebra.dot(translationMatrix, homogeneousVector);

        return new double[] {
                resultMatrix.getElement(0,0),
                resultMatrix.getElement(1,0)
        };
    }

    public double[] translation3D(double []vector, double dx, double dy, double dz) {
        if(vector.length != 3) {
            throw new IllegalArgumentException("Vetor 3D precisa ter três elementos");
        }

        double[] homogeneous = {vector[0], vector[1], vector[2], 1.0};

        double[] matrixElements = {
            1, 0, 0, dx,
            0, 1, 0, dy,
            0, 0, 1, dz,
            0, 0, 0, 1
        };

        Matrix translationMatrix = new Matrix(4, 4, matrixElements);

        Vector homogeneousVector = new Vector(4, homogeneous, false);

        Matrix resultMatrix = LinearAlgebra.dot(translationMatrix, homogeneousVector);

        return new double[] {
                resultMatrix.getElement(0,0),
                resultMatrix.getElement(1,0),
                resultMatrix.getElement(2, 0)
        };
    }


}
