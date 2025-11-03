import javax.sound.sampled.Line;

public class Transformation {
    public double[] translation2D(double []vector, double dx, double dy) {
        if(vector.length != 2) {
            throw new IllegalArgumentException("Vetor 2D precisa ter dois elementos");
        }

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


    public double []rotation2D(double[] vector, double angle) {
        if(vector.length != 2) {
            throw new IllegalArgumentException("Vetor 2D precisa ter 2 elementos");
        }

        double radians = Math.toRadians(angle);

        double cos = Math.cos(radians);
        double sen = Math.sin(radians);

        double []homogeneous = {vector[0], vector[1], 1.0};

        double []matrixElements = {
                cos, -sen, 0,
                sen, cos, 0,
                0, 0, 1
        };

        Matrix rotationMatrix = new Matrix(3, 3, matrixElements);
        Vector vectorHomogeneous = new Vector(3, homogeneous, false);

        Matrix resultMatrix = LinearAlgebra.dot(rotationMatrix, vectorHomogeneous);

        return new double[] {
                resultMatrix.getElement(0,0),
                resultMatrix.getElement(1, 0)
        };
    }

    public double []rotation3DX(double []vector, double angle) {
        if(vector.length != 3) {
            throw new IllegalArgumentException("Vetor 3D precisa ter 3 elementos");
        }

        double radians = Math.toRadians(angle);

        double cos = Math.cos(radians);
        double sen = Math.sin(radians);

        double []homogeneous = {vector[0], vector[1], vector[2], 1.0};

        double []matrixElements = {
                1, 0, 0, 0,
                0, cos, -sen, 0,
                0, sen, cos, 0,
                0, 0, 0, 1
        };

        Matrix rotationMatrix = new Matrix(4, 4, matrixElements);
        Vector homogeneousVector = new Vector(4, homogeneous, false);

        Matrix resultMatrix = LinearAlgebra.dot(rotationMatrix, homogeneousVector);

        return new double[] {
                resultMatrix.getElement(0, 0),
                resultMatrix.getElement(1, 0),
                resultMatrix.getElement(2, 0),
        };
    }

    public double []rotation3DY(double []vector, double angle) {
        if(vector.length != 3) {
            throw new IllegalArgumentException("Vetor 3D precisa ter 3 elementos");
        }

        double radians = Math.toRadians(angle);

        double cos = Math.cos(radians);
        double sen = Math.sin(radians);

        double []homogeneous = {vector[0], vector[1], vector[2], 1.0};

        double []matrixElements = {
                cos, 0, sen, 0,
                0, 1, 0, 0,
                -sen, 0, cos, 0,
                0, 0, 0, 1
        };

        Matrix rotationMatrix = new Matrix(4, 4, matrixElements);
        Vector homogeneousVector = new Vector(4, homogeneous, false);

        Matrix resultMatrix = LinearAlgebra.dot(rotationMatrix, homogeneousVector);

        return new double[] {
                resultMatrix.getElement(0, 0),
                resultMatrix.getElement(1, 0),
                resultMatrix.getElement(2, 0),
        };
    }

    public double []rotation3DZ(double []vector, double angle) {
        if(vector.length != 3) {
            throw new IllegalArgumentException("Vetor 3D precisa ter 3 elementos");
        }

        double radians = Math.toRadians(angle);

        double cos = Math.cos(radians);
        double sen = Math.sin(radians);

        double []homogeneous = {vector[0], vector[1], vector[2], 1.0};

        double []matrixElements = {
                cos, -sen, 0, 0,
                sen, cos, 0, 0,
                0, 0, 1, 0,
                0, 0, 0, 1
        };

        Matrix rotationMatrix = new Matrix(4, 4, matrixElements);
        Vector homogeneousVector = new Vector(4, homogeneous, false);

        Matrix resultMatrix = LinearAlgebra.dot(rotationMatrix, homogeneousVector);

        return new double[] {
                resultMatrix.getElement(0, 0),
                resultMatrix.getElement(1, 0),
                resultMatrix.getElement(2, 0),
        };
    }

    public double []horizontalShearing2D(double []vector, double k) {
        if(vector.length != 2) {
            throw new IllegalArgumentException("Vetor 2D precisa ter 2 elementos");
        }

        double []homogeneous = {vector[0], vector[1], 1.0};

        double []matrixElements = {
                1, k, 0,
                0, 1, 0,
                0, 0, 1
        };

        Matrix horizontalShearingMatrix = new Matrix(3, 3, matrixElements);
        Vector homogeneousVector = new Vector(3, homogeneous, false);

        Matrix resultMatrix = LinearAlgebra.dot(horizontalShearingMatrix, homogeneousVector);

        return new double[] {
                resultMatrix.getElement(0, 0),
                resultMatrix.getElement(1, 0)
        };
    }

    public double []verticalShearing2D(double []vector, double k) {
        if(vector.length != 2) {
            throw new IllegalArgumentException("Vetor 2D precisa ter 2 elementos");
        }

        double []homogeneous = {vector[0], vector[1], 1.0};

        double []matrixElements = {
                1, 0, 0,
                k, 1, 0,
                0, 0, 1
        };

        Matrix verticalShearingMatrix = new Matrix(3, 3, matrixElements);
        Vector homogeneousVector = new Vector(3, homogeneous, false);

        Matrix resultMatrix = LinearAlgebra.dot(verticalShearingMatrix, homogeneousVector);

        return new double[] {
                resultMatrix.getElement(0, 0),
                resultMatrix.getElement(1, 0)
        };
    }

    public double []shearing(double []vector, double kx, double ky) {
        if(vector.length != 2) {
            throw new IllegalArgumentException("Vetor 2D precisa ter 2 elementos");
        }

        double []homogeneous = {vector[0], vector[1], 1.0};

        double []matrixElements = {
                1, kx, 0,
                ky, 1, 0,
                0, 0, 1
        };

        Matrix shearingMatrix = new Matrix(3, 3, matrixElements);
        Vector homogeneousVector = new Vector(3, homogeneous, false);

        Matrix resultMatrix = LinearAlgebra.dot(shearingMatrix, homogeneousVector);

        return new double[] {
                resultMatrix.getElement(0, 0),
                resultMatrix.getElement(1, 0)
        };
    }

    public double []projection2DX(double []vector) {
        if(vector.length != 2) {
            throw new IllegalArgumentException("Vetor 2D precisa ter 2 elementos");
        }

        double []homogeneous = {vector[0], vector[1], 1.0};

        double []matrixElements = {
                1, 0, 0,
                0, 0, 0,
                0, 0, 1
        };

        Matrix projectionMatrix = new Matrix(3, 3, matrixElements);
        Vector homogeneousVector = new Vector(3, homogeneous, false);

        Matrix resultMatrix = LinearAlgebra.dot(projectionMatrix, homogeneousVector);

        return new double[] {
                resultMatrix.getElement(0, 0),
                resultMatrix.getElement(1, 0)
        };
    }

    public double []projection2DY(double []vector) {
        if(vector.length != 2) {
            throw new IllegalArgumentException("Vetor 2D precisa ter 2 elementos");
        }

        double []homogeneous = {vector[0], vector[1], 1.0};

        double []matrixElements = {
                0, 0, 0,
                0, 1, 0,
                0, 0, 1
        };

        Matrix projectionMatrix = new Matrix(3, 3, matrixElements);
        Vector homogeneousVector = new Vector(3, homogeneous, false);

        Matrix resultMatrix = LinearAlgebra.dot(projectionMatrix, homogeneousVector);

        return new double[] {
                resultMatrix.getElement(0, 0),
                resultMatrix.getElement(1, 0)
        };
    }

    public double []projection3DX(double []vector) {
        if(vector.length != 3) {
            throw new IllegalArgumentException("Vetor 3D precisa ter 3 elementos");
        }

        double []homogeneous = {vector[0], vector[1], vector[2], 1.0};

        double []matrixElements = {
                1, 0, 0, 0,
                0, 0, 0, 0,
                0, 0, 0, 0,
                0, 0, 0, 1
        };

        Matrix projectionMatrix = new Matrix(4,4,matrixElements);
        Vector homogeneousVector = new Vector(4, homogeneous, false);

        Matrix resultMatrix = LinearAlgebra.dot(projectionMatrix, homogeneousVector);

        return new double[] {
                resultMatrix.getElement(0, 0),
                resultMatrix.getElement(1, 0),
                resultMatrix.getElement(2, 0)
        };
    }

    public double []projection3DY(double []vector) {
        if(vector.length != 3) {
            throw new IllegalArgumentException("Vetor 3D precisa ter 3 elementos");
        }

        double []homogeneous = {vector[0], vector[1], vector[2], 1.0};

        double []matrixElements = {
                0, 0, 0, 0,
                0, 1, 0, 0,
                0, 0, 0, 0,
                0, 0, 0, 1
        };

        Matrix projectionMatrix = new Matrix(4,4,matrixElements);
        Vector homogeneousVector = new Vector(4, homogeneous, false);

        Matrix resultMatrix = LinearAlgebra.dot(projectionMatrix, homogeneousVector);

        return new double[] {
                resultMatrix.getElement(0, 0),
                resultMatrix.getElement(1, 0),
                resultMatrix.getElement(2, 0)
        };
    }

    public double []projection3DZ(double []vector) {
        if(vector.length != 3) {
            throw new IllegalArgumentException("Vetor 3D precisa ter 3 elementos");
        }

        double []homogeneous = {vector[0], vector[1], vector[2], 1.0};

        double []matrixElements = {
                0, 0, 0, 0,
                0, 0, 0, 0,
                0, 0, 1, 0,
                0, 0, 0, 1
        };

        Matrix projectionMatrix = new Matrix(4,4,matrixElements);
        Vector homogeneousVector = new Vector(4, homogeneous, false);

        Matrix resultMatrix = LinearAlgebra.dot(projectionMatrix, homogeneousVector);

        return new double[] {
                resultMatrix.getElement(0, 0),
                resultMatrix.getElement(1, 0),
                resultMatrix.getElement(2, 0)
        };
    }
}
