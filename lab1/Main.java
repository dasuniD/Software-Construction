
/**
 * Date : 7/13/2017
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

public class Main {
    
    public static void main(String [] args){
        
        String line = null;
        Student [] student = new Student[62];//declare 61 student objects
        Random new_random = new Random();
        int attendance;
        
        try{
            FileReader file = new FileReader("co225-classlist.txt");
            try (BufferedReader reader = new BufferedReader(file)) {
                for(int i=0; i < student.length ; i++){
                    attendance = new_random.nextInt(45);//genarate random int 0<x<45
                    student[i] = new Student(reader.readLine(),attendance);
                }
            }
            
        } catch(IOException e){
            System.out.println("Bad things happen, what do you do!" + e);
        }
        
       System.out.println("names of students who's attendance " +
"percentage is less than 80"); 
       int j=1; 
       
       for(int i=0; i < student.length-1; i++){               
                if(student[i].getAttendancePrecentage() < 80){
                    System.out.print(j);
 
                    if(student[i].showName().length()>12)
                    System.out.print(':' + student[i].showName() + '\t');
                    else
                    System.out.print(':' + student[i].showName() + '\t' + '\t');
 
                    System.out.println(student[i].getAttendancePrecentage());
                    j++;
                }
        }  
        System.out.printf("\nAverage Attendance Precentage: ");
        System.out.println(student[0].getAverageAttendancePrecentage());

    }    

}
