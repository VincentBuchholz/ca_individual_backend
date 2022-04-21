package facades;

import dtos.HazardDTO;
import entities.Address;
import entities.Hazard;
import errorhandling.NotFoundException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.List;

public class HazardFacade {

    private static EntityManagerFactory emf;
    private static HazardFacade instance;


    public static HazardFacade getHazardFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new HazardFacade();
        }
        return instance;
    }

    public List<HazardDTO> getAllHazards() {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<HazardDTO> query = em.createQuery("SELECT new dtos.HazardDTO(h) FROM Hazard h join Address a where h.address.id = a.id", HazardDTO.class);
            List<HazardDTO> HazardDTOs = query.getResultList();
            return HazardDTOs;
        } finally {
            em.close();
        }
    }

        public HazardDTO createHazard(HazardDTO hazardDTO) {

            Hazard hazard = new Hazard(hazardDTO.getType());
            Address address = new Address(hazardDTO.getAddressDTO().getRoad(),hazardDTO.getAddressDTO().getNumber(),hazardDTO.getAddressDTO().getZip());

            hazard.setAddress(address);
            EntityManager em = emf.createEntityManager();
            try {
                em.getTransaction().begin();
                em.persist(hazard);
                em.persist(address);
                em.getTransaction().commit();
            } finally {
                em.close();
            }
            return new HazardDTO(hazard);
        }

    public void deleteHazard(int id) {
        EntityManager em = emf.createEntityManager();
        try {
            Hazard h = em.find(Hazard.class, id);
            Address a = em.find(Address.class, h.getAddress().getId());
            em.getTransaction().begin();
            em.remove(h);
            em.remove(a);
            em.getTransaction().commit();
        }finally {
            em.close();
        }
    }
}
