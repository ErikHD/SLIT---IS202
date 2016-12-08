
package slitclient.view;

import Data.BrukerData;
import Data.ModulData;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import slitclient.manager.BrukerManager;
import slitclient.manager.ModulManager;


public class foreleserController {
    @FXML
    private Button leggTilModulBtn;
    @FXML
    private TextField modulNavn;
    
    @FXML
    private Button submitModulBtn;
    public Label labelModulNavn;
    public Button tilStudentButton;
    public ListView deltakereList;
    private Button tilbakeLogInn;
    @FXML
    private AnchorPane page;
    @FXML
    private TextField modulNummer;
    @FXML
    private DatePicker datoFelt;
    @FXML
    private TextField lagdAv;
    @FXML
    private TextArea innhold;
    @FXML
    public void leggTilModul(ActionEvent e) throws IOException { //åpner vindu for å legge til ny modul
        
        if(e.getSource() == leggTilModulBtn) {
           
        FXMLLoader modulLoader = new FXMLLoader();
        modulLoader.setLocation(getClass().getResource("foreleserLeggTilModul.fxml"));
        modulLoader.load();
        Parent modulroot = modulLoader.getRoot();
        
        Stage modul = new Stage();
        modul.setTitle("Legg til modul");
        Scene scene = new Scene(modulroot);
        
        modul.initModality(Modality.APPLICATION_MODAL);
        modul.setScene(scene);
        modul.showAndWait();
            
           
    }
 }   
        @FXML //laster opp modul - sjekker om textfield har innhold
        public void submitModul(ActionEvent e) {
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
        
        public void tilStudentUI(ActionEvent e) throws IOException {
            if(e.getSource() == tilStudentButton) {
           Stage stage3 = (Stage) tilStudentButton.getScene().getWindow();
           Parent root = FXMLLoader.load(getClass().getResource("studentUI.fxml"));
           
           Scene scene3 = new Scene(root);
           stage3.setScene(scene3);
           stage3.show();
        }
        }
        public void tilLogInn(ActionEvent e) throws IOException {
            if(e.getSource() == tilbakeLogInn) {
           Stage stage3 = (Stage) tilbakeLogInn.getScene().getWindow();
           Parent root = FXMLLoader.load(getClass().getResource("logInn.fxml"));
           
           Scene scene3 = new Scene(root);
           stage3.setScene(scene3);
           stage3.show();
        
    
            }
}
       /* @Override
        public void initialize(URL url, ResourceBundle rb) {
            BrukerManager bm = new BrukerManager();
            
            ObservableList<String> items = FXCollections.observableArrayList();
            
            for(BrukerData b : bm.getAllUsers())
                 items.add(b.getEpost());
        }
        */
        
        
}
