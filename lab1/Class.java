
/*
This is a programe to find student attendance
 */

/**
 * Date : 7/10/2017 
 */

public class Student {

    private final String name;//student name
    private final int attendance;//student attendance
    static int total_attendance;
    
    private final int MAX_ATTENDANCE = 45;//this variable can not change
    private final int NUM_STUDENTS = 61;
   
    public Student(String name,int attendance){
        this.name = name;
        this.attendance = attendance;
        total_attendance += this.attendance;
    }
 
    public String showName(){//get name 
        return this.name;
    }    
    
    public double getAttendancePrecentage(){
        //return this.attendance;
        return (this.attendance)*100/MAX_ATTENDANCE;
    }
    
    public double getAverageAttendancePrecentage(){
        return total_attendance*100/(NUM_STUDENTS*MAX_ATTENDANCE);
    }
    
}
