/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datamahasiswa.penilaian;

import datamahasiswa.penilaian.exceptions.NonexistentEntityException;
import datamahasiswa.penilaian.exceptions.PreexistingEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author MSI NOTEBOOK
 */
public class MahasiswaumyJpaController implements Serializable {

    public MahasiswaumyJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("datamahasiswa_penilaian_jar_0.0.1-SNAPSHOTPU");

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public MahasiswaumyJpaController() {
    }
    
    

    public void create(Mahasiswaumy mahasiswaumy) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(mahasiswaumy);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findMahasiswaumy(mahasiswaumy.getNim()) != null) {
                throw new PreexistingEntityException("Mahasiswaumy " + mahasiswaumy + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Mahasiswaumy mahasiswaumy) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            mahasiswaumy = em.merge(mahasiswaumy);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = mahasiswaumy.getNim();
                if (findMahasiswaumy(id) == null) {
                    throw new NonexistentEntityException("The mahasiswaumy with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(String id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Mahasiswaumy mahasiswaumy;
            try {
                mahasiswaumy = em.getReference(Mahasiswaumy.class, id);
                mahasiswaumy.getNim();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The mahasiswaumy with id " + id + " no longer exists.", enfe);
            }
            em.remove(mahasiswaumy);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Mahasiswaumy> findMahasiswaumyEntities() {
        return findMahasiswaumyEntities(true, -1, -1);
    }

    public List<Mahasiswaumy> findMahasiswaumyEntities(int maxResults, int firstResult) {
        return findMahasiswaumyEntities(false, maxResults, firstResult);
    }

    private List<Mahasiswaumy> findMahasiswaumyEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Mahasiswaumy.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Mahasiswaumy findMahasiswaumy(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Mahasiswaumy.class, id);
        } finally {
            em.close();
        }
    }

    public int getMahasiswaumyCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Mahasiswaumy> rt = cq.from(Mahasiswaumy.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
