public class GameOfLife extends Matrix {

    public GameOfLife(int rows, int columns) {
        super(rows, columns);
    }

    public void addShape(Shape shape, int rowIndex, int columnIndex) {

        int[][] shapeMatrix = shape.getData();
    
        if (rowIndex + shapeMatrix.length > rows() || columnIndex + shapeMatrix[0].length > columns()) {
            throw new IllegalArgumentException("Shape must be within matrix borders");
        }
    
        for (int i = 0; i < shapeMatrix.length; i++) {
            for (int j = 0; j < shapeMatrix[0].length; j++) {
                getData()[rowIndex + i][columnIndex + j] = shapeMatrix[i][j];
            }
        }
    }
    

    public void step() {
        int[][] nextGen = new int[rows()][columns()];

        for (int i = 0; i < rows(); i++) {
            for (int j = 0; j < columns(); j++) {
                int neighbors = 0;

                for (int i2 = i - 1; i2 <= i + 1; i2++) {
                    for (int j2 = j - 1; j2 <= j + 1; j2++) {
                        if (i2 >= 0 && i2 < rows() && j2 >= 0 && j2 < columns() && !(i2 == i && j2 == j)) {
                            neighbors += getData()[i2][j2];
                        }
                    }
                }

                if (getData()[i][j] == 1) {
                    if (neighbors < 2 || neighbors > 3) {
                        nextGen[i][j] = 0;
                    } else {
                        nextGen[i][j] = 1;
                    }
                } else {
                    if (neighbors == 3) {
                        nextGen[i][j] = 1;
                    }
                }
            }
        }

        setData(nextGen);
    }

    public static void main(String[] args) {
        GameOfLife test = new GameOfLife(10, 10);

        int[][] blinkerDesign = {
                {1},
                {1},
                {1},
        };

        Shape blinder = new Shape("Blinder", blinkerDesign);

        int[][] gliderDesign = {
                {0, 1, 0},
                {0, 0, 1},
                {1, 1, 1}
        };

        Shape glider = new Shape("Glider", gliderDesign);

        test.addShape(blinder, 3, 4);
        test.addShape(glider, 5, 6);

        BoolMatrixPrinter printer = new BoolMatrixPrinter();

        while (true) {

            System.out.println(printer.printMatrix(test));

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            test.step();
        }
    }
}


    