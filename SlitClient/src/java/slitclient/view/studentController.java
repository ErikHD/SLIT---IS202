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
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import slitclient.manager.BeskjedManager;
import slitclient.manager.BrukerManager;
import slitclient.manager.ModulManager;




public class studentController implements Initializable {
   
   
    public Label textMelding;
    
    public Label beskjedDato;
    @FXML
    private Label fornavnLabel;
  
    @FXML
    private Label InformasjonomModulLabel;
    @FXML
    private TableColumn<?, ?> LevertDatoColumn;
    @FXML
    private TableColumn<?, ?> KomentarColumn;
    @FXML
    private Button LastOppModulButton;
    @FXML
    private TableView<ModulData> forsideTableView;
    
    @FXML
    private TableColumn<ModulData, String> columnModul;
            
    @FXML
    private TableColumn<ModulData, String> columnFrist;
    
    @FXML 
    private TableColumn<ModulData, String> columnModulInfo;
   
    public ObservableList<ModulData> modulData;
    
   @Override 
    public void initialize(URL u, ResourceBundle b) {
       
       
        
        ModulManager mmanager = new ModulManager();
        
        columnModul.setCellValueFactory(new PropertyValueFactory<> ("modul_nummer"));
        columnFrist.setCellValueFactory(new PropertyValueFactory<> ("frist"));
        columnModulInfo.setCellValueFactory(new PropertyValueFactory<> ("innhold"));
                 
        this.modulData = FXCollections.observableArrayList();
        
        this.modulData.addAll(mmanager.getAllModules());
        this.forsideTableView.setItems(modulData);
        
        String firstname = (BrukerManager.getUserFirstName());
        fornavnLabel.setText("Hei, "+firstname);
        
        BeskjedManager bm = new BeskjedManager();
        textMelding.setText(bm.getBeskjedFromId(1));
    }
    
@FXML
    public void leggTilBesvarelse(ActionEvent e) throws IOException { //åpner vindu for å legge til ny modul
        
        if(e.getSource() == LastOppModulButton) {
            
        FXMLLoader modulLoader = new FXMLLoader();
        modulLoader.setLocation(getClass().getResource("StudentLastOppModul.fxml"));
        modulLoader.load();
        Parent modulroot = modulLoader.getRoot();
        
        Stage modul = new Stage();
        modul.setTitle("Legg til besvarelse");
        Scene scene = new Scene(modulroot);
        
        modul.initModality(Modality.APPLICATION_MODAL);
        modul.setScene(scene);
        modul.showAndWait();
}

}
    
}