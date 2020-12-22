

public class NameAndContact {
   
    String FirstName;
    String SurName;
    String PhoneNumber;
    
    public NameAndContact(String FirstName , String SurName , String PhoneNumber){
        this.FirstName = FirstName;
        this.SurName = SurName;
        this.PhoneNumber = PhoneNumber;
    }
    
    public String getFirstName(){
        return this.FirstName;
    }
    
    public String getSurName(){
        return this.SurName;
    }    
    
    public String getPhoneNumber(){
        return this.PhoneNumber;
    }    
}
