package maven_project2.TShirt_App;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class SearchTshirt {

	public void search(String color, String size, String gender,int choice) {
		Configuration con = new Configuration().configure().addAnnotatedClass(TshirtDetails.class);
		SessionFactory sf = con.buildSessionFactory();			
		Session session = sf.openSession();
		Transaction tx=session.beginTransaction();
		Query q= session.createQuery("from TshirtDetails t where t.Color=:c and t.Size=:s and t.Gender=:g and availability='Y'");
		q.setParameter("c", color);
		q.setParameter("s", size);
		q.setParameter("g", gender);
		List<TshirtDetails> shirtsFound=q.list();
		//ArrayList<TshirtDetails> shirts = new ArrayList(shirtsFound.size());
		//shirts.addAll(shirtsFound);
		modifyView(shirtsFound,choice);
		if(shirtsFound.size()==0)
			System.out.println("...Out of Stock!!...");
		else {
			for(TshirtDetails ts:shirtsFound) {
				System.out.println(ts);
			}
		}
		//q=session.createQuery("drop TshirtDetails");
		tx.commit();
		session.close();
	}

	public void modifyView(List<TshirtDetails> shirtsFound,int c) {

		if(c==1) {
			Collections.sort(shirtsFound,new Comparator<TshirtDetails>() {
				public int compare(TshirtDetails m1,TshirtDetails m2) {
					return (int)(Float.parseFloat(m2.getPrice())-Float.parseFloat(m1.getPrice()));
				}
			}); 

		}else if(c==2) {
			Collections.sort(shirtsFound,new Comparator<TshirtDetails>() {
				public int compare(TshirtDetails m1,TshirtDetails m2) {
					return (int)(Float.parseFloat(m2.getRating())-Float.parseFloat(m1.getRating()));
				}
			});
		}else if(c==3){
			Collections.sort(shirtsFound,new Comparator<TshirtDetails>() {
				public int compare(TshirtDetails m1, TshirtDetails m2) {
					if(Float.parseFloat(m1.getPrice())==Float.parseFloat(m2.getPrice())) {
						return (int)(Float.parseFloat(m2.getRating())-Float.parseFloat(m1.getRating()));
					}
					else {
						return (int)(Float.parseFloat(m1.getPrice())-Float.parseFloat(m2.getPrice()));
					}

				}
			});
		}

	}
}
