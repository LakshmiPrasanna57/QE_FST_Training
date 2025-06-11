package Activites;
class customException{
	
}
public class Activity8 {
    public void exceptionTest(String str) throws StringEmptyException{
    	if(str.isEmpty()) {
    		throw new StringEmptyException("String cannot be empty");
    	} else {
    		System.out.println(str);
    	}
    }
    
    public static void main(String[] args) {
    	Activity8 obj = new Activity8();
    	try {
    		obj.exceptionTest("This will be printed");
    		obj.exceptionTest("");
    	}catch(StringEmptyException ex) {
    		System.out.println(ex.getMessage());
    	}
    	System.out.println("End of program");
    }
}
