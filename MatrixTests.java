import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Test;

public class MatrixTests {
    @Test
    
    public void testConstructor(){
        assertThrows(IllegalArgumentException.class, () -> new Matrix(0,3));
        assertThrows(IllegalArgumentException.class, () -> new Matrix(5,-3));
        assertThrows(IllegalArgumentException.class, () -> new Matrix(-2,0));
        assertThrows(IllegalArgumentException.class, () -> new Matrix(null));

    }

    @Test
    public void testRowAndColumn(){

        Matrix matrix = new Matrix(3,4);

        assertEquals(3, matrix.rows());
        assertEquals(4, matrix.columns());


    }
}
