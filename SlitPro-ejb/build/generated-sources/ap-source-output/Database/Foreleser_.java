package Database;

import Database.Bruker;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-11T21:47:36")
@StaticMetamodel(Foreleser.class)
public class Foreleser_ { 

    public static volatile SingularAttribute<Foreleser, Boolean> tilganger;
    public static volatile SingularAttribute<Foreleser, Bruker> id;
    public static volatile SingularAttribute<Foreleser, Integer> ansattID;
    public static volatile SingularAttribute<Foreleser, String> varslinger;
    public static volatile SingularAttribute<Foreleser, String> moduler;

}