import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class MatrixPrinterTests {

    @Test
    public void testOutlineMatrixPrinter() {
        int[][] matrixData = {
            {0, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 0}
        };

        Matrix matrix = new Matrix(matrixData);
        MatrixOutlinePrinter outlinePrinter = new MatrixOutlinePrinter();
        
        String outlineExpected =
            "+----+\n"+
            "|    |\n"+
            "|    |\n"+
            "|    |\n"+
            "+----+";

        assertEquals(outlineExpected, outlinePrinter.printMatrix(matrix));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testBoolMatrixPrinterIllegalMatrix() {
        int[][] illegalMatrixData = {
            {0, 1, 2},
            {1, 0, 1}
        };

        Matrix illegalMatrix = new Matrix(illegalMatrixData);
        BoolMatrixPrinter boolMatrixPrinter = new BoolMatrixPrinter();
        boolMatrixPrinter.printMatrix(illegalMatrix); // This should raise an IllegalArgumentException
    }

    @Test
    public void testBoolMatrixPrinterValidMatrices() {
        int[][] matrix1 = {
            {0, 0, 0, 0},
            {1, 0, 0, 0}
        };

        int[][] matrix2 = {
            {1, 1},
            {1, 0}
        };

        Matrix testMatrix1 = new Matrix(matrix1);
        Matrix testMatrix2 = new Matrix(matrix2);

        BoolMatrixPrinter boolMatrixPrinter = new BoolMatrixPrinter();

        String Test1 = 
            "+----+\n" +
            "|    |\n" +
            "|#   |\n" +
            "+----+";

        String Test2 = 
            "+--+\n" +
            "|##|\n" +
            "|# |\n" +
            "+--+";

        assertEquals(Test1, boolMatrixPrinter.printMatrix(testMatrix1));
        assertEquals(Test2, boolMatrixPrinter.printMatrix(testMatrix2));
    }
}

