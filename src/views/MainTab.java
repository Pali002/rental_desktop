package views;

import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import views.login.LoginView;
import views.registry.RegistryView;

public class MainTab extends TabPane {

    Tab carTab;
    Tab loginTab;
    Tab registryTab;
    MainView mainView;
    RegistryView registryView;
    LoginView loginView;

    public MainTab(MainView mainView ) {

        this.mainView = mainView;
        this.registryView = new RegistryView();
        this.loginView = new LoginView();
        this.initComponent();
        this.addComponent();
        
    }

    private void initComponent() {
        this.carTab = new Tab("Autók", this.mainView);
        this.loginTab = new Tab("Bejelentkezés", this.loginView);
        this.registryTab = new Tab("Regisztráció", this.registryView);
    }

    private void addComponent() {
        this.getTabs().add(this.loginTab);
        this.getTabs().add(this.carTab);
        this.getTabs().add(this.registryTab);
    }
    
}
