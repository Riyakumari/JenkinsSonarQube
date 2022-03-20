package maven_project2.TShirt_App;

import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;


public class DBInitiator extends Thread{
	String path = "src/main/resources";
	File [] csvfiles = new File(path).listFiles(new FileFilter() {
		public boolean accept(File path) {
			if(path.isFile()) {
				return true;
			}
			return false;
		}
	});	
	
	public void run() {
		while(true) {
			for(int i=0;i<csvfiles.length;i++) {
				try {
					readData(csvfiles[i].toString());
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
			}
			try {
				Thread.sleep(20000);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public void readData(String filename)throws FileNotFoundException{
		Scanner sc = new Scanner(new File(filename));
		ArrayList<String> csvCol;    	 
		Configuration con = new Configuration().configure().addAnnotatedClass(TshirtDetails.class);
		SessionFactory sf = con.buildSessionFactory();			
		Session session = sf.openSession();    	 
		int cnt = 0;
		while(sc.hasNext()) {
			if(cnt == 0) {
				++cnt;
				sc.nextLine();
				continue;

			}++cnt; 			
			String row = sc.nextLine().toString();
			if(!row.isEmpty()) {
				StringTokenizer token = new StringTokenizer(row,"|");
				csvCol = new ArrayList<String>(token.countTokens());
				while(token.hasMoreTokens()) {
					csvCol.add(token.nextToken());

				}
				Query q=session.createQuery("select SID from TshirtDetails t where t.SID=: s");
				q.setParameter("s", csvCol.get(0));
				List<TshirtDetails> ids=q.list();
				if(ids.size()<1) {					
				TshirtDetails shirt = new TshirtDetails(); 				 
				shirt.setID(csvCol.get(0));
				shirt.setName(csvCol.get(1));
				shirt.setColor(csvCol.get(2));
				shirt.setGender(csvCol.get(3));
				shirt.setSize(csvCol.get(4));
				shirt.setPrice(csvCol.get(5));
				shirt.setRating(csvCol.get(6));
				shirt.setAvailability(csvCol.get(7)); 				
				Transaction tx = session.beginTransaction(); 				
				session.save(shirt); 
				tx.commit();
				}
			}
		}
		
		session.close();
	}
}
