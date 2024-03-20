public class Shape extends Matrix {
    private String name;

    public String getName() {
        return name;
    }

    

    public Shape(String name, int[][] matrix) {
        super(matrix); 
        this.name = name;

        for (int[] row : matrix) {
            for (int num : row) {
                if (num != 0 && num != 1) {
                    throw new IllegalArgumentException("Values must be 0 or 1");
                }
            }
        }
    }

public class ShapeTest {

    public static void main(String[] args) {

        int[][] beehive = {
            {0, 0, 1, 0, 0},
            {0, 1, 1, 1, 0},
            {0, 0, 1, 0, 0}
        };

        int[][] boat = {
            {0, 0, 0, 0, 0},
            {0, 1, 1, 1, 0},
            {0, 0, 1, 0, 0},
        };

        Shape beehiveShape = new Shape("Beehive", beehive);
        Shape boatShape = new Shape("Boat", boat);

        BoolMatrixPrinter print = new BoolMatrixPrinter();
        System.out.println(print.printMatrix(beehiveShape));
        System.out.println(print.printMatrix(boatShape));
    }
}
}