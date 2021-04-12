package home;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXSnackbar;
import com.jfoenix.controls.JFXSnackbarLayout;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;


public class LoginController {
//region FXML
    @FXML
    private JFXSnackbar obavestenje;
    @FXML
    private Label sbLabel;
    @FXML
    private AnchorPane ancLogin;
    @FXML
    private JFXTextField tRegPrezime;
    @FXML
    private JFXTextField tRegIme;
    @FXML
    private StackPane spLogin;
    @FXML
    private Pane pnRegister;
    @FXML
    private JFXTextField tRegKorisnicko;
    @FXML
    private JFXPasswordField tRegLozinka;
    @FXML
    private JFXPasswordField tRegLozinka2;
    @FXML
    private Button bRegister;
    @FXML
    private Button bToLogin;
    @FXML
    private JFXPasswordField tAdminCode;
    @FXML
    private Button bToReg;
    @FXML
    private Pane pnLogin;
    @FXML
    private String aCode = "agent";
    @FXML
    private Button bLogin;

    @FXML
    private JFXTextField tfKorisnicko;

    @FXML
    private JFXPasswordField tfLozinka;
//endregion
    public LoginController() {
        Klijent.ucitaj();
        Adresa.ucitaj();
        Agent.ucitaj();
        Apartman.ucitaj();
        Aranzman.ucitaj();
        Avion.ucitaj();
        Drzava.ucitaj();
        Hotel.ucitaj();
        Mesto.ucitaj();
        Paket.ucitaj();
        Voz.ucitaj();

    }

    //region polja
    private double x, y;
    String kor;
    String lozinka;
    //endregion

//region Metode
    public void handleClicks(ActionEvent actionEvent) {
        if (actionEvent.getSource() == bLogin) {
            login(actionEvent);
        }
        if (actionEvent.getSource() == bToReg) {
            pnRegister.toFront();
        }
        if (actionEvent.getSource() == bToLogin) {
            pnLogin.toFront();
        }
        if (actionEvent.getSource() == bRegister) {
            register();
        }

    }

    private void login(Event ev) {
        if (prijava()) {
            Parent root;
            try {
                root = FXMLLoader.load(getClass().getResource("FXML/Home.fxml"));
                Stage stage = new Stage();
                stage.setTitle("Turistička agencija");
                stage.setScene(new Scene(root));
                stage.initStyle(StageStyle.UNDECORATED);
                root.setOnMousePressed(event -> {
                    x = event.getSceneX();
                    y = event.getSceneY();
                });
                root.setOnMouseDragged(event -> {

                    stage.setX(event.getScreenX() - x);
                    stage.setY(event.getScreenY() - y);

                });
                stage.show();
                ((Node) (ev.getSource())).getScene().getWindow().hide();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public Korisnik prijavi(String kor, String lozinka) {
        boolean nadjen = false;
        for (int i = 0; i < Agent.getSve().size() && !nadjen; i += 1) {
            if ((Agent.getSve().get(i).getKorisnickoIme().equals(kor) && Agent.getSve().get(i).getLozinka().equals(lozinka))) {
                Korisnik.setPrijavljen(Agent.getSve().get(i));// = TuristickaAgencija.agenti.get(i);
                nadjen = true;
            }
        }
        for (int i = 0; i < Klijent.getSve().size() && !nadjen; i += 1) {
            if ((Klijent.getSve().get(i).getKorisnickoIme().equals(kor) && Klijent.getSve().get(i).getLozinka().equals(lozinka))) {
                Korisnik.setPrijavljen(Klijent.getSve().get(i));
                nadjen = true;
            }
        }
        if (nadjen) {
            prikazi("Uspesna prijava kao " + Korisnik.getPrijavljen().getClass().getSimpleName() + "!");
            return Korisnik.getPrijavljen();
        }
        prikazi("Nalog nije pronadjen.");
        return null;
    }

    public boolean prijava() {
        kor = tfKorisnicko.getText();
        lozinka = tfLozinka.getText();
        Korisnik.setPrijavljen(prijavi(kor, lozinka));
        if (Korisnik.getPrijavljen() == null) {
            return false;
        }
        return true;
    }

    public void handleKeyPress(KeyEvent keyEvent) {
        if (keyEvent.getCode() == KeyCode.ENTER) {
            login(keyEvent);
        }
    }

    public void register() {
        AtomicBoolean postoji = new AtomicBoolean(false);
        String uKor = tRegKorisnicko.getText();
        ArrayList korisnici = new ArrayList<Korisnik>();
        korisnici.addAll(Agent.getSve());
        korisnici.addAll(Klijent.getSve());
        korisnici.forEach(o -> {
            if (((Korisnik) o).getKorisnickoIme().equalsIgnoreCase(uKor)) postoji.set(true);
        });
        if (postoji.get()) {
            tRegKorisnicko.setText("");
            tRegLozinka.setText("");
            tRegLozinka2.setText("");
            prikazi("Nalog vec postoji.");
        } else {
            if (tRegLozinka.getText().equals(tRegLozinka2.getText()) && !tRegLozinka.getText().isEmpty() && !tRegIme.getText().isEmpty() && !tRegPrezime.getText().isEmpty() && !uKor.isEmpty()) {
                if (tAdminCode.getText().equals(aCode))
                    new Agent(tRegIme.getText(), tRegPrezime.getText(), uKor, tRegLozinka.getText());
                else new Klijent(tRegIme.getText(), tRegPrezime.getText(), uKor, tRegLozinka.getText(), 0);
                prikazi("Nalog kreiran.");
                pnLogin.toFront();
            } else prikazi("Greska u unosu.");
        }
    }
    public void prikazi(String por){
        sbLabel.setText(por);
        obavestenje.fireEvent(new JFXSnackbar.SnackbarEvent(new JFXSnackbarLayout("", "CLOSE", action -> obavestenje.close()), Duration.millis(2000), null));
    }
}
//endregion



