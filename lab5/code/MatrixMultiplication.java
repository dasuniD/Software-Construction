
import java.io.IOException;

public class MatrixMultiplication {

    @SuppressWarnings("empty-statement")
    public static void main(String []args) throws IOException, InterruptedException{
        //int numThreads = 4;
        int numThreads;
        
        //number of threads we used
        if ( args.length == 1){
            numThreads = Integer.parseInt( args[0]);
        }
        else{
        System.out.println("Wrong input arguments!");
        return;
        }
        
        //System.out.println(numThreads);
        
        //read matrix A and B using ReadFile class
        ReadFile MatA = new ReadFile("A.txt");
        ReadFile MatB = new ReadFile("B.txt");

        int [][]A;
        int [][]B;
        //create matrix A and B using ReadFile class
        A = MatA.getMatrix();
        B = MatB.getMatrix();
        
        //genarate resulting matrix
        int [][]AB = new int[A.length][A[0].length];
        
        //find wrong input size of matrix
        if ( A[0].length != B.length ){
            System.out.println(A[0].length);
            System.out.println("Number of collumns in matrix A should be equal to number of rows in matrix B!");
        }
        //find condition for threads
        else if ( A.length < numThreads ){
            System.out.println("Number of Threads use is larger than number of rows in matrix A!");
        }
        
        else if ( numThreads == 0 ){
            System.out.println("At least number of threads should be equal to one!");
        }
        else{
            //find run time of calculation
            final long startTime = System.nanoTime();
            
            Thread[] thread = new Thread[numThreads];
       
                for ( int threadNum = 0 ; threadNum < numThreads ; threadNum++ )
                    thread[threadNum] = new MatrixMul(A,B,AB,numThreads,threadNum);

                     for (Thread t : thread) {
                         t.start();
                     }       

                     for (Thread t : thread) {
                     try {
                     t.join();
                     }
                     catch (InterruptedException e) {}
                     }
            //find run time of calculation         
            final long duration = System.nanoTime() - startTime;
            System.out.println(duration);

            //print matrix AB
            for ( int rowNum = 0; rowNum < A.length ; rowNum++ ){

                for ( int colNum = 0; colNum < A[0].length ; colNum++ ){
                    System.out.print(AB[rowNum][colNum] + "\t"); ;// = Integer.parseInt(element[colNum]);  
                }
                    System.out.println();
            }        
        
        }
 
    }
        
    
}
