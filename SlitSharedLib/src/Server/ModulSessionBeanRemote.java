/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import Data.ModulData;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Erikdjon
 */
@Remote
public interface ModulSessionBeanRemote {
       ModulData getModul(int modul_nummer);
    
    List<ModulData> getAllModules();
    
    boolean storeModul(ModulData modulEn);
    
    
    
}
