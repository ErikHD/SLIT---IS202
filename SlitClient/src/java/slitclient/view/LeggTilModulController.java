/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slitclient.view;

import Data.ModulData;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import slitclient.manager.ModulManager;

/**
 *
 * @author Erikdjon
 */
public class LeggTilModulController {
    
    @FXML
    private Button submitModulBtn;
    @FXML
    private TextField modulNummer;
    @FXML
    private DatePicker datoFelt;
    @FXML
    private TextField lagdAv;
    @FXML
    private TextArea innhold;
  
    
    @FXML       public void submitModul(ActionEvent e) {
            if(e.getSource() == submitModulBtn && modulNummer.getText() != null) {
            
              ModulData modulEn = new ModulData ();
              modulEn.setModul_nummer(Integer.valueOf(modulNummer.getText()));
              modulEn.setLagd_av(lagdAv.getText());
              modulEn.setFrist(java.sql.Date.valueOf(datoFelt.getValue()));
              modulEn.setInnhold(innhold.getText());
              ModulManager mm  = new ModulManager();
              mm.storeModul(modulEn);
            }
            else {
            
            }
        }
    
}
