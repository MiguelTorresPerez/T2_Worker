import javax.swing.*;
import java.awt.*;

public class Ventana extends JFrame {
    Container container;
    Panel panel;
    Panel panelDos;

    public Ventana() {
        initGUI();
    }

    public void initGUI() {
        instancias();
        configurarPanel();
        this.setSize(300, 300);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    private void configurarPanel() {
        container.setLayout(new GridLayout(1,2));
        container.add(panel);
        container.add(panelDos);
    }

    private void instancias() {
        container = getContentPane();
        panel = new Panel();
        panelDos = new Panel();
    }
}
