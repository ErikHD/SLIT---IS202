/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

/**
 *
 * @author Erikdjon
 */
public class ModulData implements java.io.Serializable {
   
    private int modul_nummer;
   
    private String lagd_av;
    
    private String frist;
    
    private int link_id;
    
    private boolean varsel;
    
    private String innhold;

    public int getModul_nummer() {
        return modul_nummer;
    }

    public void setModul_nummer(int modul_nummer) {
        this.modul_nummer = modul_nummer;
    }

    public String getLagd_av() {
        return lagd_av;
    }

    public void setLagd_av(String lagd_av) {
        this.lagd_av = lagd_av;
    }

    public String getFrist() {
        return frist;
    }

    public void setFrist(String frist) {
        this.frist = frist;
    }

    public int getLink_id() {
        return link_id;
    }

    public void setLink_id(int link_id) {
        this.link_id = link_id;
    }

    public boolean isVarsel() {
        return varsel;
    }

    public void setVarsel(boolean varsel) {
        this.varsel = varsel;
    }

    public String getInnhold() {
        return innhold;
    }

    public void setInnhold(String innhold) {
        this.innhold = innhold;
    }
    
    
}
