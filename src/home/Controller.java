package home;

import com.jfoenix.controls.*;
import enumeracije.TipKlaseAvionskogMesta;
import enumeracije.TipKlaseVoznogMesta;
import enumeracije.TipPansiona;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    //region Polja
    private String tip="";
    private String dodajeSe="";
    private Object obj;
    private Object obj1;
    private ArrayList<Node> vbNoviRez = new ArrayList<>();
    Korisnik prijavljen = Korisnik.getPrijavljen();
    //region FXML
    //region AnchorPane
    @FXML
    private AnchorPane ancMeni;
    //endregion
    //region VBox
    @FXML
    private VBox vbMeni;
    @FXML
    private VBox spAranzmani;
    @FXML
    private VBox vbDrzave;
    @FXML
    private VBox vbMesta;
    @FXML
    private VBox vbAdrese;
    @FXML
    private VBox vbSmestaj;
    @FXML
    private VBox vbPrevoz;
    @FXML
    private VBox vbPaket;
    @FXML
    private VBox vbRezervacije;
    @FXML
    private VBox vbDodaj;
    @FXML
    private VBox vbNovi;
    //endregion
    //region Pane
    @FXML
    private Pane pnAdrese = null;
    @FXML
    private Pane pnDrzave = null;
    @FXML
    private Pane pnMesta = null;
    @FXML
    private Pane pnAranzmani = null;
    @FXML
    private Pane pnSmestaj = null;
    @FXML
    private Pane pnPaket = null;
    @FXML
    private Pane pnPrevoz = null;
    @FXML
    private Pane pnUplata = null;
    @FXML
    private Pane pnRezervacije = null;
    @FXML
    private Pane pnNoviPaket = null;
    @FXML
    private Pane pnDodaj = null;
    @FXML
    private Pane pnHide = null;
    //endregion
    //region Button
    @FXML
    private Button bAgentAranzman;
    @FXML
    private Button bAgentPaket;
    @FXML
    private Button bAgentPrevoz;
    @FXML
    private Button bAgentSmestaj;
    @FXML
    private Button bAgentAdrese;
    @FXML
    private Button bAgentDrzave;
    @FXML
    private Button bAgentMesta;
    @FXML
    private Button bKlijentUplata;
    @FXML
    private Button bKlijentPaket;
    @FXML
    private Button bKlijentZakupljeni;
    @FXML
    private Button bOdjava;
    @FXML
    private Button bUplata;
    //endregion
    //region HBox
    @FXML
    private HBox hbDodaj;
    @FXML
    private HBox hbDrzave;
    @FXML
    private HBox hbMesta;
    @FXML
    private HBox hbAdrese;
    @FXML
    private HBox hbAranzman;
    @FXML
    private HBox hbPaketAranz;
    @FXML
    private HBox hbSmestaj;
    @FXML
    private HBox hbAranzmanPr;
    @FXML
    private HBox hbAranzmanSm;
    @FXML
    private HBox hbPrevozOd;
    @FXML
    private HBox hbPrevozDo;
    @FXML
    private HBox hbPrevozi;
    @FXML
    private HBox hbSmestajNaAdresi;
    @FXML
    private HBox hbAdresaUMestu;
    @FXML
    private HBox hbNoviDugm;
    @FXML
    private HBox hbMestoUDrzavi;
    //endregion
    //region JFXButton
    @FXML
    private JFXButton bDodajAranzman;
    @FXML
    private JFXButton bDodajPaket;
    @FXML
    private JFXButton bDodajPrevoz;
    @FXML
    private JFXButton bDodajSmestaj;
    @FXML
    private JFXButton bDodajDrzava;
    @FXML
    private JFXButton bDodajMesto;
    @FXML
    private JFXButton bDodajAdresa;
    @FXML
    private JFXButton bMestoUDrzavi;
    @FXML
    private JFXButton bNoviPotvrdi;
    @FXML
    private JFXButton bNoviOtkazi;
    @FXML
    private JFXButton bAdresaUMestu;
    @FXML
    private JFXButton bSmestajNaAdresi;
    @FXML
    private JFXButton bPrevozDo;
    @FXML
    private JFXButton bPrevozOd;
    @FXML
    private JFXButton bAranzmanSm;
    @FXML
    private JFXButton bAranzmanPr;
    @FXML
    private JFXButton bPaketAranz;
    //endregion
    //region JFXTextField
    @FXML
    private JFXTextField tfTrenutnoStanje;
    @FXML
    private JFXTextField tfZaUplatu;
    @FXML
    private JFXTextField tMestoIme;
    @FXML
    private JFXTextField tDrzavaIme;
    @FXML
    private JFXTextField tMestoUDrzavi;
    @FXML
    private JFXTextField tAdresaUMestu;
    @FXML
    private JFXTextField tAdresaUlica;
    @FXML
    private JFXTextField tAdresaBroj;
    @FXML
    private JFXTextField tSmestajNaAdresi;
    @FXML
    private JFXTextField tSmestajPovrsina;
    @FXML
    private JFXTextField tSmestajBrojKreveta;
    @FXML
    private JFXTextField tPrevozDo;
    @FXML
    private JFXTextField tPrevozOd;
    @FXML
    private JFXTextField tAranzmanSm;
    @FXML
    private JFXTextField tAranzmanPr;
    @FXML
    private JFXTextField tAranzmanDatumOd;
    @FXML
    private JFXTextField tAranzmanDatumDo;
    @FXML
    private JFXTextField tPaketAranz;
    @FXML
    private JFXTextField tPaketPovrat;
    //endregion
    //region JFXComboBox
    @FXML
    private JFXComboBox cbSmestajTipPansiona;
    @FXML
    private JFXComboBox cbSmestajBrojZvezdica;
    @FXML
    private JFXComboBox cbPrevozKlasa;
    @FXML
    private JFXCheckBox chkPrevozObrok;
    @FXML
    private JFXComboBox cbPrevozTip;
    @FXML
    private JFXComboBox cbAranzmanSmTip;
    @FXML
    private JFXComboBox cbAranzmanPrTip;
    //endregion
    //region JFXCheckBox
    @FXML
    private JFXCheckBox chkAranzmanOsiguranje;
    @FXML
    private JFXCheckBox chkAranzmanGrupni;
    //endregion
    public Label sbLabelM;
    public Label lbTip;
    public JFXSnackbar obavestenjeM;
//endregion
//endregion
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadAll(prijavljen.getTip());
        lbTip.setText(prijavljen.getTip());
        setupMenu();
        vbNoviRez.addAll(vbNovi.getChildren());
    }
//region Event Handlers
    public void handleClicks(ActionEvent actionEvent) throws IOException {
        changeFocus(actionEvent, bAgentPaket, pnPaket);
        changeFocus(actionEvent, bAgentAdrese, pnAdrese);
        changeFocus(actionEvent, bAgentDrzave, pnDrzave);
        changeFocus(actionEvent, bAgentMesta, pnMesta);
        changeFocus(actionEvent, bAgentAranzman, pnAranzmani);
        changeFocus(actionEvent, bAgentSmestaj, pnSmestaj);
        changeFocus(actionEvent, bAgentPrevoz, pnPrevoz);
        changeFocus(actionEvent, bKlijentUplata, pnUplata);
        if (actionEvent.getSource() == bOdjava) {
            prijavljen.odjava();
            System.exit(1);
        }
        if (actionEvent.getSource() == bUplata){
            sendUplata();
        }
        if (actionEvent.getSource() == bKlijentZakupljeni) {
            focusOn(pnRezervacije);
            refreshItems(vbRezervacije, ((Klijent)prijavljen).getZakupljeni(), "FXML/Paket.fxml");
            refreshItems(vbPaket, Paket.getSlobodni(), "FXML/Paket.fxml");
        }
        if (actionEvent.getSource() == bKlijentPaket) {
            focusOn(pnPaket);
            refreshItems(vbRezervacije, ((Klijent)prijavljen).getZakupljeni(), "FXML/Paket.fxml");
            refreshItems(vbPaket, Paket.getSlobodni(), "FXML/Paket.fxml");
        }
        if((Arrays.asList(bDodajDrzava, bDodajMesto, bDodajAdresa, bDodajPrevoz, bDodajSmestaj, bDodajAranzman)).contains(actionEvent.getSource())){
            dodavanje(actionEvent, (JFXButton)actionEvent.getSource());
        }
        if (actionEvent.getSource() == bDodajPaket) {
            dodajeSe=((JFXButton)actionEvent.getSource()).getId().substring(6);
            if(prijavljen.getTip().equalsIgnoreCase("klijent")){
            tPaketPovrat.setText("40");
            tPaketPovrat.setDisable(true);}
            setupNovi(dodajeSe);
        }
        if (actionEvent.getSource() == bNoviPotvrdi) {
            sendDodaj();
            vbNovi.toBack();
            pnHide.toBack();
        }
        if (actionEvent.getSource() == bNoviOtkazi) {
            vbNovi.toBack();
            pnHide.toBack();
        }
        if (actionEvent.getSource() == bMestoUDrzavi) {
            select(hbDrzave, Drzava.getSve(), "FXML/Drzave.fxml");
        }
        if (actionEvent.getSource() == bAdresaUMestu) {
            select(hbMesta, Mesto.getSve(), "FXML/Mesta.fxml");
        }
        if (actionEvent.getSource() == bSmestajNaAdresi) {
            select(hbAdrese, Adresa.getSve(), "FXML/Adrese.fxml");
        }
        if (actionEvent.getSource() == bPrevozOd) {
            select(hbAdrese, Adresa.getSve(), "FXML/Adrese.fxml");
        }
        if (actionEvent.getSource() == bPrevozDo) {
            select2(hbAdrese, Adresa.getSve(), "FXML/Adrese.fxml");
            //zatvori((JFXButton) actionEvent.getSource());
        }
        if (actionEvent.getSource() == bAranzmanPr) {
            if(cbAranzmanPrTip.getValue()==null) return;
            if(cbAranzmanPrTip.getValue().toString().equalsIgnoreCase("Avion")) select(hbPrevozi, Avion.getSve(), "FXML/Prevoz.fxml");
            else if(cbAranzmanPrTip.getValue().toString().equalsIgnoreCase("Voz")) select(hbPrevozi, Voz.getSve(), "FXML/Prevoz.fxml");
            //zatvori((JFXButton) actionEvent.getSource());
        }
        if (actionEvent.getSource() == bAranzmanSm) {
            if(cbAranzmanSmTip.getValue()==null) return;
            if(cbAranzmanSmTip.getValue().toString().equalsIgnoreCase("Hotel")) select2(hbSmestaj, Hotel.getSve(), "FXML/Smestaj.fxml");
            else if(cbAranzmanSmTip.getValue().toString().equalsIgnoreCase("Apartman")) select2(hbSmestaj, Apartman.getSve(), "FXML/Smestaj.fxml");
            //zatvori((JFXButton) actionEvent.getSource());
        }
        if (actionEvent.getSource() == bPaketAranz) {
            select(hbAranzman, Aranzman.getSve(), "FXML/Item.fxml");
            //zatvori((JFXButton) actionEvent.getSource());
        }
    }
    public void handleCbSelect(ActionEvent actionEvent) {
        String tip = ((String) cbPrevozTip.getValue());
        var klasaItems = cbPrevozKlasa.getItems();
        if(actionEvent.getSource()==cbPrevozTip) {
            if (tip.equalsIgnoreCase("Avion"))
                klasaItems.setAll(TipKlaseAvionskogMesta.values());
            else if (tip.equalsIgnoreCase("Voz"))
                klasaItems.setAll(TipKlaseVoznogMesta.values());
            else prikazi("Nista odabrali tip.");
        }

    }
    public void handleKeyPress(KeyEvent keyEvent) {
        if(keyEvent.getCode() == KeyCode.ESCAPE)
        {
            pnHide.setVisible(false);
            pnDodaj.setVisible(false);
        }
    }
    public void changeFocus(ActionEvent actionEvent, Button button, Pane pane) {
        if (actionEvent.getSource() == button) {
            focusOn(pane);
        }
    }
    public void dodavanje(ActionEvent actionEvent, JFXButton b) {
        dodajeSe = b.getId().substring(6);
        setupNovi(dodajeSe);
    }
//endregion
//region Setup
    public void setupMenu() {
        if(prijavljen.getTip().equalsIgnoreCase("agent")){
            vbMeni.getChildren().removeIf(node -> node.getId().contains("Klijent"));
            addRippler(new ArrayList<>(Arrays.asList(bAgentAranzman, bAgentPaket, bAgentPrevoz, bAgentSmestaj, bAgentDrzave, bAgentMesta, bAgentAdrese)));
            setupCheckBoxVal();
        }
        else if (prijavljen.getTip().equalsIgnoreCase("klijent")){
            vbMeni.getChildren().removeIf(node -> node.getId().contains("Agent"));
            addRippler(new ArrayList<>(Arrays.asList(bKlijentUplata, bKlijentPaket, bKlijentZakupljeni)));
        }
        addRippler(bOdjava);
    }
    public void setupNovi(String t) {
        tip = t;
        vbNovi.getChildren().setAll(vbNoviRez);
        vbNovi.getChildren().removeIf(node -> !node.getId().contains(tip) && !node.getId().contains("hbNoviDugm"));
        pnHide.setVisible(true);
        pnHide.toFront();
        vbNovi.toFront();
    }
    private void setupCheckBoxVal() {
        cbSmestajTipPansiona.getItems().setAll(TipPansiona.values());
        cbSmestajBrojZvezdica.getItems().setAll("0 (Apartman)", 1,2,3,4,5);
        cbPrevozTip.getItems().setAll("Avion", "Voz");
        cbAranzmanPrTip.getItems().setAll("Avion", "Voz");
        cbAranzmanSmTip.getItems().setAll("Hotel", "Apartman");
    }
    private void setupDugme(VBox vb, MouseEvent e, JFXButton dugme, JFXPopup popup) {
        if(vb.getId().equalsIgnoreCase("vbRezervacije")) {
            dugme.setStyle("-fx-background-color: #FF0000");
            dugme.setText("Otkazi");
            dugme.setOnAction(actionEvent -> {sendOtkazi((HBox) e.getSource()); popup.hide();});
        }
        else{
            dugme.setStyle("-fx-background-color: #00ff00");
            dugme.setText("Zakupi");
            dugme.setOnAction(actionEvent -> {sendZakupi((HBox) e.getSource()); popup.hide();});
        }
    }
    private void addRippler(Button b) {
        vbMeni.getChildren().add(new JFXRippler(b));
    }
    private void addRippler(ArrayList<Button> b) {
        b.forEach(button -> vbMeni.getChildren().add(new JFXRippler(button)));
    }
    //endregion
//region Load&Refresh
    public void loadUplata(){
        tfZaUplatu.setText("");
        tfTrenutnoStanje.setText(String.valueOf(((Klijent)prijavljen).getNovcanoStanje()));
    }
    public void loadAll(String klasa){
        if(klasa.equalsIgnoreCase("agent")) {
            loadItems(spAranzmani, Aranzman.getSve(), "FXML/Item.fxml");
            loadItems(vbDrzave, Drzava.getSve(), "FXML/Drzave.fxml");
            loadItems(vbMesta, Mesto.getSve(), "FXML/Mesta.fxml");
            loadItems(vbAdrese, Adresa.getSve(), "FXML/Adrese.fxml");
            loadItems(vbSmestaj, Hotel.getSve(), "FXML/Smestaj.fxml");
            loadItems(vbSmestaj, Apartman.getSve(), "FXML/Smestaj.fxml");
            loadItems(vbPrevoz, Avion.getSve(), "FXML/Prevoz.fxml");
            loadItems(vbPrevoz, Voz.getSve(), "FXML/Prevoz.fxml");
            loadItems(vbPaket, Paket.getSve(), "FXML/Paket.fxml");
        }
        else if(klasa.equalsIgnoreCase("klijent")){
            loadUplata();
            ocistiVB(vbRezervacije);
            ocistiVB(vbPaket);
            loadItems(vbRezervacije, ((Klijent)prijavljen).getZakupljeni(), "FXML/Paket.fxml");
            loadItems(vbPaket, Paket.getSlobodni(), "FXML/Paket.fxml");
        }
    }
    public void loadItems(VBox loc, ArrayList lista, String fxml){

        Node[] nodes = new Node[lista.size()];
        for (int i = 0; i < nodes.length; i++) {
            try {
                nodes[i] = FXMLLoader.load(getClass().getResource(fxml));
                HBox tmp = (HBox)nodes[i];
                fill(tmp, lista, i, lista.get(0).getClass().getSimpleName());
                loc.getChildren().add(tmp);
                addItemEffectsVB(loc);
            } catch (IOException e) {
                System.out.println("Fajl nije pronadjen. Bice kreiran novi.");
            }
        }
    }
    public void refreshItems(VBox loc, ArrayList lista, String fxml){
        ocistiVB(loc);
        loadItems(loc, lista, fxml);
    }
    public void refreshItems(VBox loc, ArrayList lista, ArrayList lista2, String fxml){
        ocistiVB(loc);
        loadItems(loc, lista, fxml);
        loadItems(loc, lista2, fxml);
    }
    public void focusOn(Pane pane){
        pane.setStyle("-fx-background-color : #03030A");
        pane.toFront();
    }
    //endregion
//region VBox edit
    public void addItemEffectsVB(VBox vb){
        vb.getChildren().forEach(node -> node.setOnMouseEntered(event -> {node.setStyle("-fx-background-color : #0B0E3F");}));
        vb.getChildren().forEach(node -> node.setOnMouseExited(event -> {node.setStyle("-fx-background-color : #03030A");}));
        if(prijavljen.getTip().equalsIgnoreCase("klijent")) {
            vb.getChildren().forEach(node -> {node.setOnMouseClicked(e -> {if (e.getButton() == MouseButton.SECONDARY) showPopup(node, vb, e);});});
        }

    }
    public void fill(HBox tmp, ArrayList list, int i, String klasa){
        var hbChildren = tmp.getChildren();
        var listEl = list.get(i);
        switch (klasa){
            case "Adresa":
                ((Label)hbChildren.get(0)).setText(((Adresa)listEl).getUlica());
                ((Label)hbChildren.get(1)).setText(((Adresa)listEl).getBroj());
                ((Label)hbChildren.get(2)).setText(((Adresa)listEl).getMesto().getImeMesto());
                ((Label)hbChildren.get(3)).setText(((Adresa)listEl).getMesto().getuDrzavi().getImeDrzava());
                break;
            case "Aranzman":
                ((Label)hbChildren.get(0)).setText(((Aranzman)listEl).isOsiguranje() ? "Da" : "Ne");
                ((Label)hbChildren.get(1)).setText(((Aranzman)listEl).isGrupni() ? "Da" : "Ne");
                ((Label)hbChildren.get(2)).setText(((Aranzman)listEl).getDatumPolaska());
                ((Label)hbChildren.get(3)).setText(((Aranzman)listEl).getDatumPovratka());
                ((Label)hbChildren.get(4)).setText(((Aranzman)listEl).getPrevoznoVoz()==null ? "Avion" : "Voz");
                ((Label)hbChildren.get(5)).setText(((Aranzman)listEl).getSmestajHotel()==null ? "Apartman" : "Hotel");
                break;
            case "Drzava":
                ((Label)hbChildren.get(0)).setText(((Drzava)listEl).getImeDrzava());
                String mesta = "";
                for (Mesto m:((Drzava)listEl).getMestaUDrzavi()) {mesta+=m.getImeMesto() + ", ";}
                if(!mesta.isEmpty()) ((Label)hbChildren.get(1)).setText(mesta.substring(0, mesta.length()-2));
                else ((Label)hbChildren.get(1)).setText("");
                break;
            case "Mesto":
                ((Label)hbChildren.get(0)).setText(((Mesto)listEl).getImeMesto());
                ((Label)hbChildren.get(1)).setText(((Mesto)listEl).getuDrzavi().getImeDrzava());
                break;
            case "Hotel":
                ((Label)hbChildren.get(0)).setText("Hotel");
                ((Label)hbChildren.get(1)).setText(String.valueOf(((Hotel)listEl).getPovrsina()));
                ((Label)hbChildren.get(2)).setText(String.valueOf(((Hotel)listEl).getBrojKreveta()));
                ((Label)hbChildren.get(3)).setText(((Hotel)listEl).getTipPansiona().toString());
                Adresa adr = ((Hotel)listEl).getAdresa();
                ((Label)hbChildren.get(4)).setText(adr.getUlica() + " " + adr.getBroj() + " " + adr.getMesto().getImeMesto() + " " + adr.getMesto().getuDrzavi().getImeDrzava());
                ((Label)hbChildren.get(5)).setText(String.valueOf(((Hotel)listEl).getBrojZvezdica()));
                break;
            case "Apartman":
                ((Label)hbChildren.get(0)).setText("Apartman");
                ((Label)hbChildren.get(1)).setText(String.valueOf(((Apartman)listEl).getPovrsina()));
                ((Label)hbChildren.get(2)).setText(String.valueOf(((Apartman)listEl).getBrojKreveta()));
                ((Label)hbChildren.get(3)).setText(((Apartman)listEl).getTipPansiona().toString());
                Adresa adr1 = ((Apartman)listEl).getAdresa();
                ((Label)hbChildren.get(4)).setText(adr1.getUlica() + " " + adr1.getBroj() + " " + adr1.getMesto().getImeMesto() + " " + adr1.getMesto().getuDrzavi().getImeDrzava());
                ((Label)hbChildren.get(5)).setText("0");
                break;
            case "Avion":
                ((Label)hbChildren.get(0)).setText("Avion");
                ((Label)hbChildren.get(1)).setText(((Avion)listEl).isObrok() ? "Da" : "Ne");
                Adresa adr2 = ((Avion)listEl).getPolaznaAdresa();
                ((Label)hbChildren.get(2)).setText(adr2.getUlica() + " " + adr2.getBroj() + ", " + adr2.getMesto().getImeMesto());
                adr2 = ((Avion)listEl).getOdredisnaAdresa();
                ((Label)hbChildren.get(3)).setText(adr2.getUlica() + " " + adr2.getBroj() + ", " + adr2.getMesto().getImeMesto());
                ((Label)hbChildren.get(4)).setText(((Avion)listEl).getKlasaAvionskogMesta().toString());
                break;
            case "Voz":
                ((Label)hbChildren.get(0)).setText("Voz");
                ((Label)hbChildren.get(1)).setText(((Voz)listEl).isObrok() ? "Da" : "Ne");
                Adresa adr3 = ((Voz)listEl).getPolaznaAdresa();
                ((Label)hbChildren.get(2)).setText(adr3.getUlica() + " " + adr3.getBroj() + ", " + adr3.getMesto().getImeMesto());
                adr3 = ((Voz)listEl).getOdredisnaAdresa();
                ((Label)hbChildren.get(3)).setText(adr3.getUlica() + " " + adr3.getBroj() + ", " + adr3.getMesto().getImeMesto());
                ((Label)hbChildren.get(4)).setText(((Voz)listEl).getKlasaVoznogMesta().toString());
                break;
            case "Paket":
                ((Label)hbChildren.get(0)).setText(String.valueOf(((Paket)listEl).getAranzmaniUPaketu().size()));
                ((Label)hbChildren.get(1)).setText(((Paket)listEl).getPovrat() + "%");
                try {
                    ((Label)hbChildren.get(2)).setText(String.valueOf(((Paket)listEl).zakupi()));
                } catch (ParseException e) {
                    System.out.println("Fajl nije pronadjen. Bice kreiran novi.");
                }
                ((Label)hbChildren.get(3)).setText(((Paket)listEl).getKreiraoA()==null ? ((Paket)listEl).getKreiraoK().getKorisnickoIme() : ((Paket)listEl).getKreiraoA().getKorisnickoIme());
                ((Label)hbChildren.get(4)).setText(((Paket)listEl).getZakupio()==null ? "Ne" : ((Paket)listEl).getZakupio().getKorisnickoIme());
                break;
            default:
        }}
    public void ocistiVB(VBox vb){
        while(vb.getChildren().size()>0){
            vb.getChildren().remove(0);
        }
    }
    public void showPopup(Node node, VBox vb, MouseEvent e) {
        JFXButton dugme = new JFXButton("");
        JFXPopup popup = new JFXPopup();
        popup.setPopupContent(dugme);
        setupDugme(vb, e, dugme, popup);
        popup.show(node, JFXPopup.PopupVPosition.TOP, JFXPopup.PopupHPosition.LEFT, e.getX(), e.getY());
    }
//endregion
//region Selektovanje
    public ArrayList<String> getClicked(HBox clicked){
        ArrayList<String> labelVal = new ArrayList<>();
        clicked.getChildren().forEach(node -> labelVal.add(((Label)node).getText()));
        return labelVal;
    }
    public void select(HBox hb, ArrayList list, String fxml){
        pnHide.toFront();
        pnDodaj.toFront();
        pnHide.setVisible(true);
        pnDodaj.setVisible(true);
        hbDodaj.getChildren().setAll(hb.getChildren());
        refreshItems(vbDodaj, list, fxml);
        vbDodaj.getChildren().forEach(node -> node.setOnMouseClicked(mouseEvent -> {
            obj = list.get(vbDodaj.getChildren().indexOf(mouseEvent.getSource()));
            setSelected(obj.getClass().getSimpleName());
            pnHide.setVisible(false);
            pnDodaj.setVisible(false);
        }));
    }
    public void select2(HBox hb, ArrayList list, String fxml){
        pnHide.toFront();
        pnDodaj.toFront();
        pnHide.setVisible(true);
        pnDodaj.setVisible(true);
        hbDodaj.getChildren().setAll(hb.getChildren());
        refreshItems(vbDodaj, list, fxml);
        vbDodaj.getChildren().forEach(node -> node.setOnMouseClicked(mouseEvent -> {
            obj1 = list.get(vbDodaj.getChildren().indexOf(mouseEvent.getSource()));
            setSelected2(obj1.getClass().getSimpleName());
            pnHide.setVisible(false);
            pnDodaj.setVisible(false);
        }));
    }
    public void setSelected(String klasa){
        switch (klasa){
            case "Drzava":
                tMestoUDrzavi.setText(((Drzava)obj).getImeDrzava());
                break;
            case "Mesto":
                tAdresaUMestu.setText(((Mesto)obj).getImeMesto());
                break;
            case "Adresa":
                tSmestajNaAdresi.setText(((Adresa)obj).toString());
                tPrevozOd.setText(((Adresa)obj).toString());
                break;
            case "Avion":
            case "Voz":
                tAranzmanPr.setText(cbAranzmanPrTip.getValue().toString());
                break;
            case "Aranzman":
                try {
                    tPaketAranz.setText(((Aranzman)obj).getDanaUSmestaju() + " dana");
                } catch (ParseException e) {
                    System.out.println("Fajl nije pronadjen. Bice kreiran novi.");
                }
                break;
        }
    }
    public void setSelected2(String klasa){
        switch (klasa){
            case "Adresa":
                tPrevozDo.setText(((Adresa)obj1).toString());
                break;
            case "Hotel":
            case "Apartman":
                tAranzmanSm.setText(cbAranzmanSmTip.getValue().toString());
                break;
        }
    }
//endregion
//region Send
    public void sendOtkazi(HBox otkazi){
        ((Klijent)prijavljen).otkaziPaket(getClicked(otkazi));
        prikazi("Paket uspesno otkazan.");
        loadAll( ((Klijent)prijavljen).getClass().getSimpleName());
    }
    public void sendZakupi(HBox zakupi){
        if(((Klijent)prijavljen).zakupiPaket(getClicked(zakupi))) prikazi("Uspesno zakupljeno.");
        else prikazi("Nedovoljno novca.");
        loadAll( ((Klijent)prijavljen).getClass().getSimpleName());
    }
    public void sendDodaj(){
        switch (dodajeSe){
            case "Drzava":
                if(!tDrzavaIme.getText().isEmpty()) ((Agent)prijavljen).kreirajDrzava(tDrzavaIme.getText());
                else prikazi("Neispravno uneti podaci.");
                refreshItems(vbDrzave, Drzava.getSve(), "FXML/Drzave.fxml");
                break;
            case "Mesto":
                if(!tMestoIme.getText().isEmpty() && !tMestoUDrzavi.getText().isEmpty()) ((Agent)prijavljen).kreirajMesto(tMestoIme.getText(), (Drzava)obj);
                else prikazi("Neispravno uneti podaci.");
                refreshItems(vbMesta, Mesto.getSve(), "FXML/Mesta.fxml");
                refreshItems(vbDrzave, Drzava.getSve(), "FXML/Drzave.fxml");
                break;
            case "Adresa":
                if(!tAdresaUlica.getText().isEmpty() && !tAdresaBroj.getText().isEmpty() && !tAdresaUMestu.getText().isEmpty()) ((Agent)prijavljen).kreirajAdresa((Mesto)obj, tAdresaUlica.getText(), tAdresaBroj.getText());
                else prikazi("Neispravno uneti podaci.");
                refreshItems(vbAdrese, Adresa.getSve(), "FXML/Adrese.fxml");
                break;
            case "Smestaj":
                if(!tSmestajNaAdresi.getText().isEmpty() && !tSmestajPovrsina.getText().isEmpty() && !tSmestajNaAdresi.getText().isEmpty() && cbSmestajTipPansiona.getValue()!=null){
                    if(cbSmestajBrojZvezdica.getValue().getClass().getSimpleName().equalsIgnoreCase("string")) ((Agent)prijavljen).kreirajSmestaj(Integer.parseInt(tSmestajPovrsina.getText()), Integer.parseInt(tSmestajBrojKreveta.getText()), (TipPansiona) cbSmestajTipPansiona.getValue(), (Adresa)obj);
                    else ((Agent)prijavljen).kreirajSmestaj(Integer.parseInt(tSmestajPovrsina.getText()), Integer.parseInt(tSmestajBrojKreveta.getText()), (TipPansiona) cbSmestajTipPansiona.getValue(), (Adresa)obj, (int)cbSmestajBrojZvezdica.getValue());
                }
                else prikazi("Neispravno uneti podaci.");
                refreshItems(vbSmestaj, Hotel.getSve(), Apartman.getSve(), "FXML/Smestaj.fxml");
                break;
            case "Prevoz":
                if(!(cbPrevozKlasa.getValue().toString()).isEmpty() && !((String)cbPrevozTip.getValue()).isEmpty() && !tPrevozOd.getText().isEmpty() && !tPrevozOd.getText().isEmpty()) ((Agent)prijavljen).kreirajPrevoz(chkPrevozObrok.isSelected(), (Adresa)obj, (Adresa)obj1, cbPrevozKlasa.getValue());
                else prikazi("Neispravno uneti podaci.");
                refreshItems(vbPrevoz, Avion.getSve(), Voz.getSve(), "FXML/Prevoz.fxml");
                break;
            case "Aranzman":
                if(!tAranzmanDatumOd.getText().isEmpty() && !tAranzmanDatumDo.getText().isEmpty() && !tAranzmanPr.getText().isEmpty() && !tAranzmanSm.getText().isEmpty()){
                    if (datumiIspravni(tAranzmanDatumOd.getText(), tAranzmanDatumDo.getText())) ((Agent)prijavljen).kreirajAranzman(chkAranzmanOsiguranje.isSelected(), chkAranzmanGrupni.isSelected(), tAranzmanDatumOd.getText(), tAranzmanDatumDo.getText(), (PrevoznoSredstvo)obj, (Smestaj)obj1);
                    refreshItems(spAranzmani, Aranzman.getSve(), "FXML/Item.fxml");
                }
                else prikazi("Neispravno uneti podaci.");
                break;
            case "Paket":
                if(!tPaketAranz.getText().isEmpty() && !tPaketPovrat.getText().isEmpty()){
                    double pov=Integer.parseInt(tPaketPovrat.getText());
                    if(pov<=100 && pov>0){
                        if(prijavljen.getTip().equalsIgnoreCase("agent"))((Agent)prijavljen).kreirajPaket((Aranzman) obj, pov);
                        else ((Klijent)prijavljen).kreirajPaket((Aranzman) obj);
                    }
                    else prikazi("Neispravno uneti podaci.");
                    tPaketPovrat.setText("");
                    tPaketPovrat.setDisable(false);
                    refreshItems(vbPaket, Paket.getSve(), "FXML/Paket.fxml");
                }
                break;
        }
    }
    public void sendUplata(){
        ((Klijent)prijavljen).uplata(Integer.parseInt(tfZaUplatu.getText().equals("") ? "0" : tfZaUplatu.getText()));
        loadUplata();
    }
    private boolean datumiIspravni(String odkad, String dokad) {
        SimpleDateFormat ft = new SimpleDateFormat("dd.MM.yyyy");
        Date t1, t2;
        try {
            t1 = ft.parse(odkad);
            t2 = ft.parse(dokad);
        } catch (ParseException e) {
            return false;
        }
        return true;
    }
//endregion
public void prikazi(String por){
    sbLabelM.setText(por);
    obavestenjeM.fireEvent(new JFXSnackbar.SnackbarEvent(new JFXSnackbarLayout("", "CLOSE", action -> obavestenjeM.close()), Duration.millis(2000), null));
}




}
