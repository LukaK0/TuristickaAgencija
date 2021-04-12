package home;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ItemController  implements Initializable {

    @FXML
    private HBox hbAranzman;
    @FXML
    private Button bOdjava;
    @FXML
    private Label lbOsiguranje;
    @FXML
    private Label lbGrupni;
    @FXML
    private Label lbDatumPolaska;
    @FXML
    private Label lbDatumPovratka;
    @FXML
    private Label lbPrevoz;
    @FXML
    private Label lbSmestaj;

    public HBox getHbAranzman() {
        return hbAranzman;
    }

    public void setHbAranzman(HBox hbAranzman) {
        this.hbAranzman = hbAranzman;
    }

    public Label getLbOsiguranje() {
        return lbOsiguranje;
    }

    public void setLbOsiguranje(Label lbOsiguranje) {
        this.lbOsiguranje = lbOsiguranje;
    }

    public Label getLbGrupni() {
        return lbGrupni;
    }

    public void setLbGrupni(Label lbGrupni) {
        this.lbGrupni = lbGrupni;
    }

    public Label getLbDatumPolaska() {
        return lbDatumPolaska;
    }

    public void setLbDatumPolaska(Label lbDatumPolaska) {
        this.lbDatumPolaska = lbDatumPolaska;
    }

    public Label getLbDatumPovratka() {
        return lbDatumPovratka;
    }

    public void setLbDatumPovratka(Label lbDatumPovratka) {
        this.lbDatumPovratka = lbDatumPovratka;
    }

    public Label getLbPrevoz() {
        return lbPrevoz;
    }

    public void setLbPrevoz(Label lbPrevoz) {
        this.lbPrevoz = lbPrevoz;
    }

    public Label getLbSmestaj() {
        return lbSmestaj;
    }

    public void setLbSmestaj(Label lbSmestaj) {
        this.lbSmestaj = lbSmestaj;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
