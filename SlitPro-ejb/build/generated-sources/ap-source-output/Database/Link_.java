package Database;

import Database.Modul;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-11T21:47:36")
@StaticMetamodel(Link.class)
public class Link_ { 

    public static volatile SingularAttribute<Link, String> ressurser;
    public static volatile SingularAttribute<Link, Integer> linkId;
    public static volatile ListAttribute<Link, Modul> modulList;
    public static volatile SingularAttribute<Link, String> beskrivelse;

}