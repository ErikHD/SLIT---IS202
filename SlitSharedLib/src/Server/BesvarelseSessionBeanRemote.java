package Server;

import Data.BesvarelseData;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Edvin
 */
@Remote
public interface BesvarelseSessionBeanRemote {
    
    public List<BesvarelseData> getBesvarelser();
    
    public List<BesvarelseData> getBesvarelser2();
}