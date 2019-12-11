import javax.swing.*;
import java.util.List;


public class WorkerBro extends SwingWorker<Boolean,Integer> {
Panel panelPrimos;

    public WorkerBro(Panel panel) {
        panelPrimos = panel;
    }
    public Boolean esprimo(Integer num) {
        for (int i = 2; i < num; i++)
        {
            if(num % i == 0)
            {
                return false;
            }
        }
        return true;
    }
    @Override
    protected Boolean doInBackground() throws Exception {
        for(int i=0;i<panelPrimos.getNumPrimos();i++){
            if(esprimo(i)){
                Thread.sleep(100);
                publish(i);
                //panelPrimos.barra.setValue(panelPrimos.getNumPrimos()+i);
            }
            else{
                continue;
            }
        }
        return true;
    }

    @Override
    protected void process(List<Integer> chunks) {
        super.process(chunks);
        panelPrimos.getPrimos().append(chunks.get(0)+"\n");
        panelPrimos.barra.setMaximum(panelPrimos.getNumPrimos());
        panelPrimos.barra.setValue(chunks.get(0).intValue());
    }

    @Override
    protected void done() {
        super.done();
        JOptionPane.showMessageDialog(panelPrimos, "Done bro",
                "Agregado", JOptionPane.INFORMATION_MESSAGE, null);
    }
}
