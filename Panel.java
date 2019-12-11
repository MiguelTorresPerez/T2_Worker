import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Panel extends JPanel{
    JTextField numPrimos;
    private JTextArea primos;
    private JLabel lNumPrimos;
    private JPanel panelSup,panelCent,panelInf;
    JProgressBar barra;
    private JButton calc;
    Panel panel;

    public Panel() {
        initGUI();
    }

    public void initGUI() {
        instancias();
        acciones();
        configurarPanel();
    }

    private void acciones() {
        calc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(numPrimos.getText().isEmpty()){
                    JOptionPane.showMessageDialog(panel, "Introduce un valor.",
                            "Empty bro", JOptionPane.INFORMATION_MESSAGE, null);
                }
                else {
                    WorkerBro bro = new WorkerBro(panel);
                    bro.execute();
                }
            }
        });
    }

    private JPanel configurarPanelSup(){
        panelSup.setLayout(new GridBagLayout());
        configurarConstraint(0,0,GridBagConstraints.HORIZONTAL,GridBagConstraints.WEST,0,0.5,1,1,lNumPrimos);
        configurarConstraint(1,0,GridBagConstraints.HORIZONTAL,GridBagConstraints.WEST,0,0.5,1,1,numPrimos);
        configurarConstraint(0,1,GridBagConstraints.HORIZONTAL,GridBagConstraints.WEST,0,0,2,1,calc);
        return panelSup;
    }

    private JPanel configurarPanelInf(){
        barra.setStringPainted(true);
        panelInf.add(barra);
        return panelInf;
    }
    public void configurarConstraint(int posX, int posY, int fill, int anchor,
                                     double pesX, double pesY, int tamX, int tamY, JComponent component) {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = posX;
        constraints.gridy = posY;
        constraints.fill = fill;
        constraints.anchor = anchor;
        constraints.weightx = pesX;
        constraints.weighty = pesY;
        constraints.gridwidth = tamX;
        constraints.gridheight = tamY;
        panelSup.add(component, constraints);
    }

    private void configurarPanel() {
        this.setLayout(new BorderLayout());
        this.add(configurarPanelSup(), BorderLayout.NORTH);
        this.add(new JScrollPane(primos),BorderLayout.CENTER);
        this.add(configurarPanelInf(), BorderLayout.SOUTH);
    }

    private void instancias() {
        panel = this;
        panelInf = new JPanel();
        panelSup = new JPanel();
        panelCent = new JPanel();
        numPrimos = new JTextField();
        primos = new JTextArea();
        barra = new JProgressBar();
        calc = new JButton("CALCULAR");
        lNumPrimos = new JLabel("Numero primos:");
    }

    public Integer getNumPrimos() {
        return Integer.valueOf(numPrimos.getText());
    }

    public JTextArea getPrimos() {
        return primos;
    }

    public JProgressBar getBarra() {
        return barra;
    }
    }



