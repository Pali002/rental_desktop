package views.login;

import javax.swing.JFrame;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import views.InputPanel;
import views.PassPanel;
import views.TitlePanel;

public class LoginView extends VBox {
    
    JFrame frame;
    TitlePanel titlePanel;
    InputPanel emailInput;
    PassPanel passInput;
    Button loginButton;

    public LoginView() {

        this.initComponent();
        this.setComponent();
        this.login();
        this.addComponent();
        this.setPanel();
    }

    private void initComponent() {
        this.titlePanel = new TitlePanel();
        this.emailInput = new InputPanel();
        this.passInput = new PassPanel();
        this.loginButton = new Button();
    }

    private void setComponent() {
        this.titlePanel.setText(" Bejelentkezés ");
        this.emailInput.setText("Email :");
        this.passInput.setText("Jelszó :");
        this.loginButton.setText("Bejelentkezés");
    }

    private void addComponent() {
        this.getChildren().add(this.titlePanel);
        this.getChildren().add(this.emailInput);
        this.getChildren().add(this.passInput);
        this.getChildren().add(this.loginButton);
    }

    private void setPanel() {
        this.setAlignment(Pos.CENTER);
    }

    private void login() {
        
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        loginButton.setOnAction(e -> {
            String email = emailInput.getText();
            String pass = passInput.getText();
            System.out.printf("|%s|\n", email);
            System.out.printf("|%s|\n", pass);
            String msgStr = "";
            if(email.equals("admin") && pass.equals("titok")) {
                msgStr = "Sikeres bejelentkezés";
            }else {
                msgStr = "Sikertelen bejelentkezés";
            }
            alert.setContentText(msgStr);
            alert.showAndWait();
        });

        VBox vbox = new VBox();
        vbox.setPadding(new Insets(10, 10, 10, 10));
        vbox.setSpacing(10);
 
        vbox.getChildren().add(emailInput);
        vbox.getChildren().add(passInput);
        vbox.getChildren().add(loginButton);
    }
}
