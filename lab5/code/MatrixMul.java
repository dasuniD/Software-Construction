
public class MatrixMul extends Thread{    
 
    int [][]A;
    int [][]B;
    int [][]AB;
    int Threads;
    int ThreadIndex;
    
    public MatrixMul(int [][]A , int [][]B , int [][]AB , int Threads , int ThreadIndex){
        this.A = A;
        this.B = B;
        this.AB = AB;
        this.Threads = Threads;
        this.ThreadIndex = ThreadIndex;
    }
    
    /**
     *
     */
    @Override
    public void run(){
    
    int rowA,rowB,colA,colB;
    int element;
    int range;
    
    rowA = A.length;
    rowB = B.length;
    
    colA = A[0].length;
    colB = B[0].length;
    
    //range is the value of rows that run on one thread 
    if ( Threads == 1){
        range = Threads;
    }
    else{
        range = (rowA-(rowA%Threads))/(Threads-1) ;
    }

        if ( range == 0){
            //System.out.println("Row number is smaller than number of Threads!");
        }
        
        else if ( ThreadIndex < (Threads - 1)){

            for ( int x = range*ThreadIndex ; (x < (range*(ThreadIndex+1))) ; x++ ){

                for ( int y=0 ; y < colB ; y++ ){
                     element = 0;    

                    for ( int z=0 ; z < rowB ; z++ ){
                        element += (A[x][z])*(B[z][y]);
                    }
                AB[x][y] = element;    
                }        

            }
        
        }
        
        else {

            for ( int x = range*ThreadIndex ; (x < A.length) ; x++ ){

                for ( int y=0 ; y < colB ; y++ ){
                     element = 0;    

                    for ( int z=0 ; z < rowB ; z++ ){
                        element += (A[x][z])*(B[z][y]);
                    }
                AB[x][y] = element;    
                }        

            }            
            
        }
    
}
    
}
