package views.login;

import javafx.geometry.Pos;
import javafx.scene.layout.VBox;
import views.InputPanel;
import views.PassPanel;
import views.TitlePanel;

public class LoginView extends VBox {
    
    TitlePanel titlePanel;
    InputPanel emailInput;
    PassPanel passInput;

    public LoginView() {
        this.initComponent();
        this.setComponent();
        this.addComponent();
        this.setPanel();
    }

    private void initComponent() {
        this.titlePanel = new TitlePanel();
        this.emailInput = new InputPanel();
        this.passInput = new PassPanel();
    }

    private void setComponent() {
        this.titlePanel.setText(" Bejelentkezés ");
        this.emailInput.setText("Email :");
        this.passInput.setText("Jelszó :");
    }

    private void addComponent() {
        this.getChildren().add(this.titlePanel);
        this.getChildren().add(this.emailInput);
        this.getChildren().add(this.passInput);
    }

    private void setPanel() {
        this.setAlignment(Pos.CENTER);
    }
}
