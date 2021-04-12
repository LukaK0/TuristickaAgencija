package home;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class DrzaveController implements Initializable{

        @FXML
        private HBox hbDrzava;

        @FXML
        private Label lbDrzava;

        @FXML
        private Label lbMestaUDrzavi;

    public HBox getHbDrzava() {
        return hbDrzava;
    }

    public void setHbDrzave(HBox hbDrzava) {
        this.hbDrzava = hbDrzava;
    }

    public Label getLbDrzava() {
        return lbDrzava;
    }

    public void setLbDrzava(Label lbDrzava) {
        this.lbDrzava = lbDrzava;
    }

    public Label getLbMestaUDrzavi() {
        return lbMestaUDrzavi;
    }

    public void setLbMestaUDrzavi(Label lbMestaUDrzavi) {
        this.lbMestaUDrzavi = lbMestaUDrzavi;
    }

    @Override
        public void initialize(URL location, ResourceBundle resources) {

        }



        public void handleClicks(ActionEvent actionEvent) {


        }

}
