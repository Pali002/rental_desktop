package views;

import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

public class MainTab extends TabPane {
    Tab carsTab;
    Tab loginTab;
    MainView mainView;

    public MainTab(MainView mainView ) {

        this.mainView = mainView;
        this.initComponent();
        this.addComponent();
        
    }

    private void initComponent() {
        this.carsTab = new Tab("Autók", this.mainView);
        this.loginTab = new Tab("Belépés");
    }

    private void addComponent() {
        this.getTabs().add(this.carsTab);
        this.getTabs().add(this.loginTab);
    }
    
}
