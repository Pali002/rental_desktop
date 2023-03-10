package views;

import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

public class MainTab extends TabPane {

    Tab carTab;
    Tab loginTab;
    MainView mainView;

    public MainTab(MainView mainView ) {

        this.mainView = mainView;
        this.initComponent();
        this.addComponent();
        
    }

    private void initComponent() {
        this.carTab = new Tab("Autók", this.mainView);
        this.loginTab = new Tab("Belépés");
    }

    private void addComponent() {
        this.getTabs().add(this.carTab);
        this.getTabs().add(this.loginTab);
    }
    
}
