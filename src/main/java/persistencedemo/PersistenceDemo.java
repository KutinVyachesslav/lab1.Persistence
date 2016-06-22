package persistencedemo;
import java.math.BigDecimal;
import java.util.List;
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
        City c2 = new City(new java.math.BigDecimal(50), "Russia", "test", "Ekb2", "Ural");
        em.persist(c1);
        em.persist(c2);

        Hotel h1 = new Hotel(new java.math.BigDecimal(10),"Биологическая 1","Hotel 1","0000000");
        h1.setCity(c1);
        c1.getHotelCollection().add(h1);

        em.persist(h1);
        em.persist(new Hotel(new java.math.BigDecimal(20),"Биологическая 2","Hotel 2","0000000"));
        em.persist(new Hotel(new java.math.BigDecimal(30),"Биологическая 3","Hotel 3","0000000"));

        em.persist(new Attractions(new java.math.BigDecimal(10),"Интересный","атракцион №1"));
        em.persist(new Attractions(new java.math.BigDecimal(20),"Быстрые машинки","атракцион №2"));

        em.getTransaction().commit();

        List<Hotel> list = em.createQuery("select h from Hotel h",Hotel.class).getResultList();
        System.out.println("size:"+list.size());
        for(Hotel h:list)
        {
            System.out.println(h);
        }

        em.close();
        emf.close();
    }  
}
