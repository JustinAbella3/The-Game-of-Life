public class Matrix{


    private int[][] data;

    public int[][] getData() {
        return data;
    }

    public void setData(int[][] data) {
        this.data = data;
    }

    public int rows(){
        return data.length;
    }

    public int columns(){
        return data[0].length;
    }

    public Matrix(int rows, int columns){

        if(rows <= 0 || columns <= 0){
            throw new IllegalArgumentException("There should be atleast 1 row and 1 column in matrix");
        }
        this.data = new int[rows][columns];
    }

    public Matrix(int[][] array){
       
        if(array == null || array.length < 1 || array[0].length < 1){
            throw new IllegalArgumentException("Array is null or needs atleast 1 row or column");
        }
        this.data = array;
    }
    
}
