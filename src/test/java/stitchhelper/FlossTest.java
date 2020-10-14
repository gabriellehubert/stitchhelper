package stitchhelper;

import junit.framework.TestCase;
import model.Floss;
import model.FlossBrand;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class FlossTest extends TestCase {
	
	private Floss f1 = new Floss(FlossBrand.DMC, 3713, "Very Light Salmon", "ffe2e2");
	
	 public void testGetBrand(){
	        System.out.println("Running testGetName");
	        assertEquals(FlossBrand.DMC, f1.getBrand());
	    }
	 
	 public void testGetCode(){
	        System.out.println("Running testGetCode");
	        assertEquals(3713, f1.getNumCode());
	    }
	 
	 public void testGetName() {
		 System.out.println("Running testGetName");
		 assertEquals("Very Light Salmon", f1.getColourName());
	 }
	 
	 public void testGetHex() {
		 System.out.println("Running testGetHex");
		 assertEquals("ffe2e2", f1.getColourHex());
	 }
	 
	 public void testFlossPersistence() {
		 Floss f2 = new Floss();
		 f2.setBrand(FlossBrand.DMC);
		 f2.setNumCode(761);
		 f2.setColourName("Light Salmon");
		 f2.setColourHex("ffc9c9");
		 
		 Floss f3 = new Floss();
		 f3.setBrand(FlossBrand.DMC);
		 f3.setNumCode(760);
		 f3.setColourName("Salmon");
		 f3.setColourHex("f5adad");

		 Floss f4 = new Floss();
		 f4.setBrand(FlossBrand.DMC);
		 f4.setNumCode(3712);
		 f4.setColourName("Medium Salmon");
		 f4.setColourHex("f18787");
		 
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-test");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        em.persist(f2);
        em.persist(f3);
        em.persist(f4);
        tx.commit();

        Query q = em.createQuery("SELECT f FROM Floss f");

        @SuppressWarnings("unchecked")
        List<Floss> results = q.getResultList();
        System.out.println("---------------------------------");
        System.out.println("List of floss");
        System.out.println("---------------------------------");
        for (Floss floss : results) {

            System.out.println("id=" + floss.getID() + " brand=" + floss.getBrand() + " colourName=" + floss.getColourName() + " colourHex=" + floss.getColourHex());
        }
        System.out.println("---------------------------------");

        em.close();
        emf.close();
	 }

}
