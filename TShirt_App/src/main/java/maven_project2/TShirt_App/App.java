package maven_project2.TShirt_App;

import java.io.FileNotFoundException;
import java.util.*;

public class App 
{
	public static void main( String[] args )throws FileNotFoundException
	{
		DBInitiator db = new DBInitiator();
		db.start();
		Scanner sc=new Scanner(System.in);
		String gender,size,color,ch="y";
		int choice;
		while(ch.equalsIgnoreCase("Y")) {
			System.out.println("Enter Color of the Shirt:");
			color=sc.next();
			System.out.println("Enter gender:");
			gender=sc.next();
			System.out.println("Enter size:");
			size=sc.next();
			System.out.println("Enter output preference-\n1.Sort by price.\n2. Sort by rating.\n3. Sort by price and rating.");
			choice=sc.nextInt();
			
			SearchTshirt st=new SearchTshirt();
			st.search(color, size, gender,choice);
			
			System.out.println("Want to search for more(Y/N):");
			ch=sc.next();
		}
		
	}
}
