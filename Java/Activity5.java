package Activites;

abstract class Book{
	String title;
	public abstract void setTitle(String Title);
	public String getTitle() {
		return title;
	}
}
  class MyBook extends Book{
	  @Override
	  public void setTitle(String title) {
		  if(title != null && ! title.isEmpty()) {
			  this.title= title;
		  }
	  }
	
}
public class Activity5 {
	public static void main(String[] args) {
		Book someBook = new MyBook();
		someBook.setTitle("percy jackson and the Titan's Curse");
		System.out.println("Book added is:" +someBook.getTitle());
		
	}

}
