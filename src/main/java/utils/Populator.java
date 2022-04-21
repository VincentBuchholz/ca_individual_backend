package utils;

import entities.Address;
import entities.Hazard;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class Populator {
    public static void main(String[] args) {

        EntityManagerFactory emf = EMF_Creator.createEntityManagerFactory();
        EntityManager em = emf.createEntityManager();

        Hazard hazard1 = new Hazard("Fotovogn");
        Hazard hazard2 = new Hazard("Politi");
        Address address1 = new Address("Nymøllevej","47",2800);
        Address address2 = new Address("Ulrikkenborg alle","33",2800);

        hazard1.setAddress(address1);
        hazard2.setAddress(address2);
        try {
            em.getTransaction().begin();
            em.persist(hazard1);
            em.persist(address1);
            em.persist(hazard2);
            em.persist(address2);
            em.getTransaction().commit();
        } finally {
            em.close();
        }

    }
    }
