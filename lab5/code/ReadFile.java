
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//read file and take data into matrix
public class ReadFile {
    
    String FileName;
    int row,col;
    
    public ReadFile(String FileName){
        this.FileName = FileName;
    }
    
    @SuppressWarnings("empty-statement")
    public int [][] getMatrix() throws FileNotFoundException, IOException{

        List <String> list = new ArrayList <>();

        String line;
        String []element = null;
        
            FileReader fileReader;
            fileReader = new FileReader(FileName);
            
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            
                while ( (line = bufferedReader.readLine())!= null ){
                    list.add(line);
                }
             //take row and col size of the matix   
             row = list.size();
             col = list.get(1).split(" ").length;
         
            int matrix [][]= new int [row][col];
           
                for ( int rowNum = 0; rowNum < row ; rowNum++ ){
                    element = list.get(rowNum).split(" "); 
                    
                    for ( int colNum = 0; colNum < col ; colNum++ ){
                        matrix[rowNum][colNum] = Integer.parseInt(element[colNum]);  
                    }
                }
  
    return matrix;
    }
    

    
    
}
