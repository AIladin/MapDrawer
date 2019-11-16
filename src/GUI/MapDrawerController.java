package GUI;

import DataMap.DataMap;
import DataMap.DataMapBuilder;
import DataMap.DataMapExporter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.MenuItem;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;

public class MapDrawerController {
    
    @FXML
    private VBox root;

    @FXML
    private MenuItem openMenu;

    @FXML
    private MenuItem saveAsMenu;

    @FXML
    private Canvas canvas;

    @FXML
    private ChoiceBox<?> choiceBox;

    @FXML
    private ImageView imageView;

    @FXML
    private Button refreshButton;

    private Stage stage;
    private MainApp mainApp;
    private DataMap dataMap;

    @FXML
    void openMenuEvent(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Map File");
        File file = fileChooser.showOpenDialog(stage);
        try {
            this.dataMap = DataMapBuilder.fromIntFile(file); //TODO message
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void refreshEvent(ActionEvent event) {
        imageView.setImage(DataMapExporter.toWritableImage(dataMap));
    }

    @FXML
    void saveAsMenu(ActionEvent event) {

    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }
}
