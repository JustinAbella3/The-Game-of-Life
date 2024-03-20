public class BoolMatrixPrinter extends MatrixOutlinePrinter{

    

    @Override
    protected void printRow(Matrix matrix, int i, StringBuilder result) {
        if (matrix == null || matrix.rows()== 0 || matrix.columns() == 0) {
            return;
        }

        int[]row = matrix.getData()[i];

        for(int num: row){
            if(num == 0){
                result.append(" ");
            }
            else if(num == 1){
                result.append("#");
            }else{
                throw new IllegalArgumentException("Matrix can only contain 0 or 1");
            }
        }
    }
}
