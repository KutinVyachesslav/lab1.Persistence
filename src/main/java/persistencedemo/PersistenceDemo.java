package persistenceDemo;

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

        List<A1> list_a1 = em.createQuery("select c from A1 c",A1.class).getResultList();

        Address2 address = new Address2("street","city","zip");

        em.persist(new A1(address,"a1"));

        A3 a3 = new A3("a3");
        em.persist(a3);
        a3.addPhone("Домашний","123456789");
        a3.addPhone("WORK","000-000-000");

//
//        City c1 = new City(new java.math.BigDecimal(40), "Russia", "test", "Ekb", "Ural");
//        City c2 = new City(new java.math.BigDecimal(50), "Russia", "test", "Ekb2", "Ural");
//        em.persist(c1);
//        em.persist(c2);
//
//        Hotel h1 = new Hotel(new java.math.BigDecimal(10),"Биологическая 1","Hotel 1","0000000");
//        h1.setCity(c1);
//        c1.getHotelCollection().add(h1);
//
//        em.persist(h1);
//        em.persist(new Hotel(new java.math.BigDecimal(20),"Биологическая 2","Hotel 2","0000000"));
//        em.persist(new Hotel(new java.math.BigDecimal(30),"Биологическая 3","Hotel 3","0000000"));
//
//        em.persist(new Attractions(new java.math.BigDecimal(10),"Интересный","атракцион №1"));
//        em.persist(new Attractions(new java.math.BigDecimal(20),"Быстрые машинки","атракцион №2"));
//
        em.getTransaction().commit();

        //d
        List<A3> list = em.createQuery("select c from A3 c",A3.class).getResultList();
        System.out.println("size:"+list.size());
        for(A3 c:list)
        {
            System.out.println(c);
        }

        em.close();
        emf.close();
    }  
}
