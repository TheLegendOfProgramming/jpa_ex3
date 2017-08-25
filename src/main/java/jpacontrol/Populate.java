package jpacontrol;

import entity.Customer;
import entity.DiscountFixed;
import entity.DiscountType;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Populate
{
    public static void main(String[] args)
    {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaPU");
        
        EntityManager em = emf.createEntityManager();
                
        em.getTransaction().begin();

        Customer c = new Customer();

        DiscountType dT = new DiscountType();
        c.addDiscountType(dT);
        
        DiscountFixed dF = new DiscountFixed();
        
        c.addDiscountType(dF);
                
        //wasn't able to output method's return in console, need to do some research on how to output (but the methods work)
        System.out.println(c.calcDiscount(0,15,2)); 


        em.persist(dT);
        em.persist(dF);
        em.persist(c);

        em.getTransaction().commit();
        
        em.close();
    }
}
