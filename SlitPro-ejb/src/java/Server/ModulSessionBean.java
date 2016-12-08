/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import Data.BrukerData;
import Data.ModulData;
import Database.Bruker;
import Database.Modul;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Erikdjon
 */
@Stateless
public class ModulSessionBean implements ModulSessionBeanRemote {

    @PersistenceContext(unitName = "SlitPro-ejbPU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }
    
     @Override
        public ModulData getModul(int modul_nummer) {
        Modul modul = em.find(Modul.class, modul_nummer);
        
        return this.convertModul(modul);
        
        }
    
    @Override
        public List<ModulData> getAllModules() {
            
            List<ModulData> modulListe = new ArrayList<ModulData>();
            
             try {
             Query q = em.createNamedQuery("Modul.findAll", Modul.class);
            
            List <Modul> m = q.getResultList();
            
            for(Modul modul : m) {
                modulListe.add(this.convertModul(modul));
            }
            
             }
            catch (Exception e)
            {
                 e.printStackTrace();
            }
                 return modulListe;
                
        }
        
        private ModulData convertModul(Modul modulEn) {
        
        ModulData modulData = new ModulData();
        
        modulData.setModul_nummer(modulEn.getModulNummer());
        modulData.setLagd_av(modulEn.getLagdAv());
        modulData.setFrist(modulEn.getFrist());
        modulData.setVarsel(modulEn.getVarsel());
        modulData.setInnhold(modulEn.getInnhold());
        
        return modulData;
    }
        
           private Modul convertToEntity(ModulData modulEn) {
        
        Modul modulData = new Modul();
        
        modulData.setModulNummer(modulEn.getModul_nummer());
        modulData.setLagdAv(modulEn.getLagd_av());
        modulData.setFrist(modulEn.getFrist());
        modulData.setInnhold(modulEn.getInnhold());
        
        return modulData;
    
        }
           
           @Override
      public boolean storeModul(ModulData modulEn) {
          Modul modul = this.convertToEntity(modulEn);
          
          try {
          em.persist(modul);
          }
          catch (Exception e) {
              e.printStackTrace();
              return false;
          }
          return true;

      }
           
           
}