package Server;

import Data.BeskjedData;
import javax.ejb.Remote;

/**
 *
 * @author Edvin
 */
@Remote
public interface BeskjedSessionBeanRemote {
    
    public boolean storeBeskjed(BeskjedData beskjedEn);
    
     public String getBeskjedFromId(int beskjedId);
     
     public BeskjedData deleteBeskjed();
}