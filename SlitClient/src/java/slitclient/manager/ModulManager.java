/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slitclient.manager;
import Data.ModulData;
import Server.ModulSessionBeanRemote;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author Erikdjon
 */
public class ModulManager {

    private ModulSessionBeanRemote lookupModulSessionBeanRemote() {
        try {
            Context c = new InitialContext();
            return (ModulSessionBeanRemote) c.lookup("java:comp/env/ModulSessionBean");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
        
    }
    
    public ModulData getModul(int id)
    {
        return this.lookupModulSessionBeanRemote().getModul(id);
            
    }
    
    public List<ModulData> getAllModules() {
        return this.lookupModulSessionBeanRemote().getAllModules();
    }
    
    public boolean storeModul(ModulData modulEn) {
        
        return this.lookupModulSessionBeanRemote().storeModul(modulEn);
    }
}
