package GUI;

import DataMap.DataMap;
import DataMap.DataMapBuilder;
import DataMap.DataMapExporter;
import GUI.SubMenu.SubMenuController;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.MenuItem;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
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
    private ImageView imageHighlight;

    @FXML
    private MenuItem saveAsMenu;

    @FXML
    private ChoiceBox<DataMap.HighlightType> choiceBox;

    @FXML
    private ImageView imageView;

    @FXML
    private Button refreshButton;

    @FXML
    private BorderPane sideMenuRoot;

    private Stage stage;
    private MainApp mainApp;
    private DataMap dataMap;
    private SubMenuController subMenuController;


    @FXML
    public void initialize() {
        ObservableList<DataMap.HighlightType> highlightTypes =
                FXCollections.observableArrayList( DataMap.HighlightType.values());
        ChangeListener<DataMap.HighlightType> changeListener = new ChangeListener<DataMap.HighlightType>() {
            @Override
            public void changed(ObservableValue<? extends DataMap.HighlightType> observableValue,
                                DataMap.HighlightType highlightType, DataMap.HighlightType t1) {
                mainApp.loadSubMenu(t1);

                subMenuController.setHighlighted(imageHighlight);
                sideMenuRoot.setCenter(subMenuController.getRootLayout());
            }
        };
        choiceBox.getSelectionModel().selectedItemProperty().addListener(changeListener);
        choiceBox.setItems(highlightTypes);
    }


    @FXML
    void openMenuEvent(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Map File");
        File file = fileChooser.showOpenDialog(stage);
        try {
            this.dataMap = DataMapBuilder.fromIntFile(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        refreshEvent(null);
    }

    @FXML
    void refreshEvent(ActionEvent event) {
        imageView.setImage(DataMapExporter.toWritableImage(dataMap));
        subMenuController.setDataMap(dataMap);
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


    public void setSubMenuController(SubMenuController subMenuController) {
        this.subMenuController = subMenuController;
    }
}
