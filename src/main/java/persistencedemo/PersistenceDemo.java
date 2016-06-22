package persistencedemo;
import java.math.BigDecimal;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistenceDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.setProperty("file.encoding", "UTF-8");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersistenceDemoPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        
        City c1 = new City(new java.math.BigDecimal(40), "Russia", "test", "Ekb", "Ural");
        City c2 = new City(new java.math.BigDecimal(40), "Russia", "test", "Ekb", "Ural");
        em.persist(c1);

        em.getTransaction().commit();
        em.close();
        emf.close();
    }  
}
