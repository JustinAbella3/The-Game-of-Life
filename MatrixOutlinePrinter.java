public class MatrixOutlinePrinter implements MatrixPrinter {
    @Override

    public String printMatrix(Matrix matrix){
        StringBuilder result = new StringBuilder();

        // top border
        result.append("+");
        for(int c = 0;c < matrix.columns(); c++){
            result.append("-");
        }
        result.append("+\n");

        // for each row
        for(int i = 0; i < matrix.rows(); i++){
            result.append("|");
            printRow(matrix, i, result);
            result.append("|\n");
        }

        // bottom border
        result.append("+");
        for(int c = 0;c < matrix.columns(); c++){
            result.append("-");
        }
        result.append("+");

        return result.toString();
        
    }

    
    protected void printRow(Matrix matrix,int i, StringBuilder result){
        for(int j = 0; j < matrix.columns(); j++){
            result.append(" ");
        }
    
    }



}
