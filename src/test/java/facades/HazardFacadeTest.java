package facades;

import dtos.AddressDTO;
import dtos.HazardDTO;
import entities.Address;
import entities.Hazard;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.EMF_Creator;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HazardFacadeTest {

    private static EntityManagerFactory emf;
    private static HazardFacade hazardFacade;
    private Hazard hazard2;

    @BeforeAll
    public static void setUpClass() {
        emf = EMF_Creator.createEntityManagerFactoryForTest();
        hazardFacade = HazardFacade.getHazardFacade(emf);
    }

    @BeforeEach
    void setUp() {
        Hazard hazard1 = new Hazard("Fotovogn");
        hazard2 = new Hazard("Politi");
        Address address1 = new Address("Nymøllevej","47",2800);
        Address address2 = new Address("Ulrikkenborg alle","33",2800);

        hazard1.setAddress(address1);
        hazard2.setAddress(address2);
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.createNamedQuery("Hazard.deleteAllRows").executeUpdate();
        em.createNamedQuery("Address.deleteAllRows").executeUpdate();
        em.getTransaction().commit();

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

    @AfterEach
    void tearDown() {
    }

    @Test
    void getAllHazards() {
        List<HazardDTO> hazardDTOS = hazardFacade.getAllHazards();

        assertEquals(2,hazardDTOS.size());
    }

    @Test
    void createHazardTest(){
        HazardDTO hazardDTO = new HazardDTO("Ulykke",new AddressDTO("Ulrikkenborg plads","2",2800));
        assertEquals(2,hazardFacade.getAllHazards().size());
        hazardFacade.createHazard(hazardDTO);
        assertEquals(3,hazardFacade.getAllHazards().size());
    }

    @Test
    void deleteHazardTest(){
        assertEquals(2,hazardFacade.getAllHazards().size());
        hazardFacade.deleteHazard(hazard2.getId());
        assertEquals(1,hazardFacade.getAllHazards().size());
    }
}