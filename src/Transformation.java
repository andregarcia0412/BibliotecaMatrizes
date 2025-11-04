import javax.sound.sampled.Line;

public abstract class Transformation {
    public static Vector translation2D(Vector vector, double dx, double dy) {
        if(vector.getDim() != 2) {
            throw new IllegalArgumentException("Vetor 2D precisa ter dois elementos");
        }

        double[] homogeneous = {vector.getElement(0), vector.getElement(1), 1.0};


        double[] matrixElements = {
                1, 0, dx,
                0, 1, dy,
                0, 0, 1
        };

        Matrix translationMatrix = new Matrix(3,3,matrixElements);

        Vector homogeneousVector = new Vector(3, homogeneous, false);

        Matrix resultMatrix = LinearAlgebra.dot(translationMatrix, homogeneousVector);

        double[] result = new double[] {
                resultMatrix.getElement(0,0),
                resultMatrix.getElement(1,0)
        };
        return new Vector(2, result, false);
    }

    public static Vector translation3D(Vector vector, double dx, double dy, double dz) {
        if(vector.getDim() != 3) {
            throw new IllegalArgumentException("Vetor 3D precisa ter três elementos");
        }

        double[] homogeneous = {vector.getElement(0), vector.getElement(1), vector.getElement(2), 1.0};

        double[] matrixElements = {
            1, 0, 0, dx,
            0, 1, 0, dy,
            0, 0, 1, dz,
            0, 0, 0, 1
        };

        Matrix translationMatrix = new Matrix(4, 4, matrixElements);

        Vector homogeneousVector = new Vector(4, homogeneous, false);

        Matrix resultMatrix = LinearAlgebra.dot(translationMatrix, homogeneousVector);

        double[] result = new double[] {
                resultMatrix.getElement(0,0),
                resultMatrix.getElement(1,0),
                resultMatrix.getElement(2, 0)
        };

        return new Vector(3, result, false);
    }


    public static Vector rotation2D(Vector vector, double angle) {
        if(vector.getDim() != 2) {
            throw new IllegalArgumentException("Vetor 2D precisa ter 2 elementos");
        }

        double radians = Math.toRadians(angle);

        double cos = Math.cos(radians);
        double sen = Math.sin(radians);

        double []homogeneous = {vector.getElement(0), vector.getElement(1), 1.0};

        double []matrixElements = {
                cos, -sen, 0,
                sen, cos, 0,
                0, 0, 1
        };

        Matrix rotationMatrix = new Matrix(3, 3, matrixElements);
        Vector vectorHomogeneous = new Vector(3, homogeneous, false);

        Matrix resultMatrix = LinearAlgebra.dot(rotationMatrix, vectorHomogeneous);

        double[] result = new double[] {
                resultMatrix.getElement(0,0),
                resultMatrix.getElement(1, 0)
        };
        return new Vector(2, result, false);
    }

    public static Vector rotation3DX(Vector vector, double angle) {
        if(vector.getDim() != 3) {
            throw new IllegalArgumentException("Vetor 3D precisa ter 3 elementos");
        }

        double radians = Math.toRadians(angle);

        double cos = Math.cos(radians);
        double sen = Math.sin(radians);

        double []homogeneous = {vector.getElement(0), vector.getElement(1), vector.getElement(2), 1.0};

        double []matrixElements = {
                1, 0, 0, 0,
                0, cos, -sen, 0,
                0, sen, cos, 0,
                0, 0, 0, 1
        };

        Matrix rotationMatrix = new Matrix(4, 4, matrixElements);
        Vector homogeneousVector = new Vector(4, homogeneous, false);

        Matrix resultMatrix = LinearAlgebra.dot(rotationMatrix, homogeneousVector);

        double[] result = new double[] {
                resultMatrix.getElement(0, 0),
                resultMatrix.getElement(1, 0),
                resultMatrix.getElement(2, 0),
        };
        return new Vector(3, result, false);
    }

    public static Vector rotation3DY(Vector vector, double angle) {
        if(vector.getDim() != 3) {
            throw new IllegalArgumentException("Vetor 3D precisa ter 3 elementos");
        }

        double radians = Math.toRadians(angle);

        double cos = Math.cos(radians);
        double sen = Math.sin(radians);

        double []homogeneous = {vector.getElement(0), vector.getElement(1), vector.getElement(2), 1.0};

        double []matrixElements = {
                cos, 0, sen, 0,
                0, 1, 0, 0,
                -sen, 0, cos, 0,
                0, 0, 0, 1
        };

        Matrix rotationMatrix = new Matrix(4, 4, matrixElements);
        Vector homogeneousVector = new Vector(4, homogeneous, false);

        Matrix resultMatrix = LinearAlgebra.dot(rotationMatrix, homogeneousVector);

        double[] result = new double[] {
                resultMatrix.getElement(0, 0),
                resultMatrix.getElement(1, 0),
                resultMatrix.getElement(2, 0),
        };

        return new Vector(3, result, false);
    }

    public static Vector rotation3DZ(Vector vector, double angle) {
        if(vector.getDim() != 3) {
            throw new IllegalArgumentException("Vetor 3D precisa ter 3 elementos");
        }

        double radians = Math.toRadians(angle);

        double cos = Math.cos(radians);
        double sen = Math.sin(radians);

        double []homogeneous = {vector.getElement(0), vector.getElement(1), vector.getElement(2), 1.0};

        double []matrixElements = {
                cos, -sen, 0, 0,
                sen, cos, 0, 0,
                0, 0, 1, 0,
                0, 0, 0, 1
        };

        Matrix rotationMatrix = new Matrix(4, 4, matrixElements);
        Vector homogeneousVector = new Vector(4, homogeneous, false);

        Matrix resultMatrix = LinearAlgebra.dot(rotationMatrix, homogeneousVector);

        double[] result = new double[] {
                resultMatrix.getElement(0, 0),
                resultMatrix.getElement(1, 0),
                resultMatrix.getElement(2, 0),
        };

        return new Vector(3, result, false);
    }

    public static Vector horizontalShearing2D(Vector vector, double k) {
        if(vector.getDim() != 2) {
            throw new IllegalArgumentException("Vetor 2D precisa ter 2 elementos");
        }

        double []homogeneous = {vector.getElement(0), vector.getElement(1), 1.0};

        double []matrixElements = {
                1, k, 0,
                0, 1, 0,
                0, 0, 1
        };

        Matrix horizontalShearingMatrix = new Matrix(3, 3, matrixElements);
        Vector homogeneousVector = new Vector(3, homogeneous, false);

        Matrix resultMatrix = LinearAlgebra.dot(horizontalShearingMatrix, homogeneousVector);

        double[] result = new double[] {
                resultMatrix.getElement(0, 0),
                resultMatrix.getElement(1, 0)
        };
        return new Vector(3, result, false);
    }

    public static Vector verticalShearing2D(Vector vector, double k) {
        if(vector.getDim() != 2) {
            throw new IllegalArgumentException("Vetor 2D precisa ter 2 elementos");
        }

        double []homogeneous = {vector.getElement(0), vector.getElement(1), 1.0};

        double []matrixElements = {
                1, 0, 0,
                k, 1, 0,
                0, 0, 1
        };

        Matrix verticalShearingMatrix = new Matrix(3, 3, matrixElements);
        Vector homogeneousVector = new Vector(3, homogeneous, false);

        Matrix resultMatrix = LinearAlgebra.dot(verticalShearingMatrix, homogeneousVector);

        double[] result = new double[] {
                resultMatrix.getElement(0, 0),
                resultMatrix.getElement(1, 0)
        };
        return new Vector(2, result, false);
    }

    public static Vector shearing(Vector vector, double kx, double ky) {
        if(vector.getDim() != 2) {
            throw new IllegalArgumentException("Vetor 2D precisa ter 2 elementos");
        }

        double []homogeneous = {vector.getElement(0), vector.getElement(1), 1.0};

        double []matrixElements = {
                1, kx, 0,
                ky, 1, 0,
                0, 0, 1
        };

        Matrix shearingMatrix = new Matrix(3, 3, matrixElements);
        Vector homogeneousVector = new Vector(3, homogeneous, false);

        Matrix resultMatrix = LinearAlgebra.dot(shearingMatrix, homogeneousVector);

        double[] result = new double[] {
                resultMatrix.getElement(0, 0),
                resultMatrix.getElement(1, 0)
        };

        return new Vector(2, result, false);
    }

    public static Vector projection2DX(Vector vector) {
        if(vector.getDim() != 2) {
            throw new IllegalArgumentException("Vetor 2D precisa ter 2 elementos");
        }

        double []homogeneous = {vector.getElement(0), vector.getElement(1), 1.0};

        double []matrixElements = {
                1, 0, 0,
                0, 0, 0,
                0, 0, 1
        };

        Matrix projectionMatrix = new Matrix(3, 3, matrixElements);
        Vector homogeneousVector = new Vector(3, homogeneous, false);

        Matrix resultMatrix = LinearAlgebra.dot(projectionMatrix, homogeneousVector);

        double[] result = new double[] {
                resultMatrix.getElement(0, 0),
                resultMatrix.getElement(1, 0)
        };
        return new Vector(2, result, false);
    }

    public static Vector projection2DY(Vector vector) {
        if(vector.getDim() != 2) {
            throw new IllegalArgumentException("Vetor 2D precisa ter 2 elementos");
        }

        double []homogeneous = {vector.getElement(0), vector.getElement(1), 1.0};

        double []matrixElements = {
                0, 0, 0,
                0, 1, 0,
                0, 0, 1
        };

        Matrix projectionMatrix = new Matrix(3, 3, matrixElements);
        Vector homogeneousVector = new Vector(3, homogeneous, false);

        Matrix resultMatrix = LinearAlgebra.dot(projectionMatrix, homogeneousVector);

        double[] result = new double[] {
                resultMatrix.getElement(0, 0),
                resultMatrix.getElement(1, 0)
        };
        return new Vector(2, result, false);
    }

    public static Vector projection3DX(Vector vector) {
        if(vector.getDim() != 3) {
            throw new IllegalArgumentException("Vetor 3D precisa ter 3 elementos");
        }

        double []homogeneous = {vector.getElement(0), vector.getElement(1), vector.getElement(2), 1.0};

        double []matrixElements = {
                1, 0, 0, 0,
                0, 0, 0, 0,
                0, 0, 0, 0,
                0, 0, 0, 1
        };

        Matrix projectionMatrix = new Matrix(4,4,matrixElements);
        Vector homogeneousVector = new Vector(4, homogeneous, false);

        Matrix resultMatrix = LinearAlgebra.dot(projectionMatrix, homogeneousVector);

        double[] result = new double[] {
                resultMatrix.getElement(0, 0),
                resultMatrix.getElement(1, 0),
                resultMatrix.getElement(2, 0)
        };
        return new Vector(3, result, false);
    }

    public static Vector projection3DY(Vector vector) {
        if(vector.getDim() != 3) {
            throw new IllegalArgumentException("Vetor 3D precisa ter 3 elementos");
        }

        double []homogeneous = {vector.getElement(0), vector.getElement(1), vector.getElement(2), 1.0};

        double []matrixElements = {
                0, 0, 0, 0,
                0, 1, 0, 0,
                0, 0, 0, 0,
                0, 0, 0, 1
        };

        Matrix projectionMatrix = new Matrix(4,4,matrixElements);
        Vector homogeneousVector = new Vector(4, homogeneous, false);

        Matrix resultMatrix = LinearAlgebra.dot(projectionMatrix, homogeneousVector);

        double[] result = new double[] {
                resultMatrix.getElement(0, 0),
                resultMatrix.getElement(1, 0),
                resultMatrix.getElement(2, 0)
        };
        return new Vector(3, result, false);
    }

    public static Vector projection3DZ(Vector vector) {
        if(vector.getDim() != 3) {
            throw new IllegalArgumentException("Vetor 3D precisa ter 3 elementos");
        }

        double []homogeneous = {vector.getElement(0), vector.getElement(1), vector.getElement(2), 1.0};

        double []matrixElements = {
                0, 0, 0, 0,
                0, 0, 0, 0,
                0, 0, 1, 0,
                0, 0, 0, 1
        };

        Matrix projectionMatrix = new Matrix(4,4,matrixElements);
        Vector homogeneousVector = new Vector(4, homogeneous, false);

        Matrix resultMatrix = LinearAlgebra.dot(projectionMatrix, homogeneousVector);

        double[] result = new double[] {
                resultMatrix.getElement(0, 0),
                resultMatrix.getElement(1, 0),
                resultMatrix.getElement(2, 0)
        };
        return new Vector(3, result, false);
    }
    public static Vector reflection2DX(Vector vector) {
        if (vector.getDim() != 2) {
            throw new IllegalArgumentException("Vetor 2D precisa ter dois elementos");
        }

        double[] homogeneous = {vector.getElement(0), vector.getElement(1), 1.0};

        double[] matrixElements = {
                1, 0, 0,
                0, -1, 0,
                0, 0, 1
        };

        Matrix reflectionMatrix = new Matrix(3, 3, matrixElements);
        Vector homogeneousVector = new Vector(3, homogeneous, false);
        Matrix resultMatrix = LinearAlgebra.dot(reflectionMatrix, homogeneousVector);

        double[] result = new double[]{
                resultMatrix.getElement(0, 0),
                resultMatrix.getElement(1, 0)
        };
        return new Vector(2, result, false);
    }

    public static Vector reflection2DY(Vector vector) {
        if (vector.getDim() != 2) {
            throw new IllegalArgumentException("Vetor 2D precisa ter dois elementos");
        }

        double[] homogeneous = {vector.getElement(0), vector.getElement(1), 1.0};

        double[] matrixElements = {
                -1, 0, 0,
                0, 1, 0,
                0, 0, 1
        };

        Matrix reflectionMatrix = new Matrix(3, 3, matrixElements);
        Vector homogeneousVector = new Vector(3, homogeneous, false);
        Matrix resultMatrix = LinearAlgebra.dot(reflectionMatrix, homogeneousVector);

        double[] result = new double[]{
                resultMatrix.getElement(0, 0),
                resultMatrix.getElement(1, 0)
        };
        return new Vector(2, result, false);
    }

    public static Vector reflection3DX(Vector vector) {
        if (vector.getDim() != 3) {
            throw new IllegalArgumentException("Vetor 3D precisa ter três elementos");
        }

        double[] homogeneous = {vector.getElement(0), vector.getElement(1), vector.getElement(2), 1.0};

        double[] matrixElements = {
                1, 0, 0, 0,
                0, -1, 0, 0,
                0, 0, -1, 0,
                0, 0, 0, 1
        };

        Matrix reflectionMatrix = new Matrix(4, 4, matrixElements);
        Vector homogeneousVector = new Vector(4, homogeneous, false);
        Matrix resultMatrix = LinearAlgebra.dot(reflectionMatrix, homogeneousVector);

        double[] result = new double[]{
                resultMatrix.getElement(0, 0),
                resultMatrix.getElement(1, 0),
                resultMatrix.getElement(2, 0)
        };
        return new Vector(3, result, false);
    }

    public static Vector reflection3DY(Vector vector) {
        if (vector.getDim() != 3) {
            throw new IllegalArgumentException("Vetor 3D precisa ter três elementos");
        }

        double[] homogeneous = {vector.getElement(0), vector.getElement(1), vector.getElement(2), 1.0};

        double[] matrixElements = {
                -1, 0, 0, 0,
                0, 1, 0, 0,
                0, 0, -1, 0,
                0, 0, 0, 1
        };

        Matrix reflectionMatrix = new Matrix(4, 4, matrixElements);
        Vector homogeneousVector = new Vector(4, homogeneous, false);
        Matrix resultMatrix = LinearAlgebra.dot(reflectionMatrix, homogeneousVector);

        double[] result = new double[]{
                resultMatrix.getElement(0, 0),
                resultMatrix.getElement(1, 0),
                resultMatrix.getElement(2, 0)
        };
        return new Vector(3, result, false);
    }

    public static Vector reflection3DZ(Vector vector) {
        if (vector.getDim() != 3) {
            throw new IllegalArgumentException("Vetor 3D precisa ter três elementos");
        }

        double[] homogeneous = {vector.getElement(0), vector.getElement(1), vector.getElement(2), 1.0};

        double[] matrixElements = {
                -1, 0, 0, 0,
                0, -1, 0, 0,
                0, 0, 1, 0,
                0, 0, 0, 1
        };

        Matrix reflectionMatrix = new Matrix(4, 4, matrixElements);
        Vector homogeneousVector = new Vector(4, homogeneous, false);
        Matrix resultMatrix = LinearAlgebra.dot(reflectionMatrix, homogeneousVector);

        double[] result = new double[]{
                resultMatrix.getElement(0, 0),
                resultMatrix.getElement(1, 0),
                resultMatrix.getElement(2, 0)
        };
        return new Vector(3, result, false);
    }
}
