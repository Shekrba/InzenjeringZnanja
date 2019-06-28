package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TerapijaFrame {
    private JPanel terapijaPanel;
    private JButton prepisi1;
    private JButton prepisi2;
    private JButton prepisi3;
    private JButton prepisi4;

    public TerapijaFrame() {

//simptomi sa upitnikom, temperatura, presure high, low, bmi, rbc count, hemoglobin, hematocrit, whitebloodcell count, plete, glucose, calc, sodium, potas
        //urea, crat, bili, godine, pol, bolest
        prepisi1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            int option = JOptionPane.showConfirmDialog(null, "Are you prescribing this procedure?", "Therapy", JOptionPane.YES_NO_CANCEL_OPTION);
            if(option == JOptionPane.YES_OPTION) {
                System.out.println("rbc: " + MainFrame.getCbc().getRedBloodCellCount());
                System.out.println("hemog: " + MainFrame.getCbc().getHemoglobin());
                System.out.println("hemat: " + MainFrame.getCbc().getHematocrit());
                System.out.println("whitebl: " + MainFrame.getCbc().getRedBloodCellCount());
                System.out.println("plate: " + MainFrame.getCbc().getPlatelet());
            }
            }
        });
        prepisi2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showConfirmDialog(null, "Are you prescribing this procedure?", "Therapy", JOptionPane.YES_NO_CANCEL_OPTION);
            }
        });
        prepisi3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showConfirmDialog(null, "Are you prescribing this procedure?", "Therapy", JOptionPane.YES_NO_CANCEL_OPTION);

            }
        });
        prepisi4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showConfirmDialog(null, "Are you prescribing this procedure?", "Therapy", JOptionPane.YES_NO_CANCEL_OPTION);

            }
        });
        prepisi5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showConfirmDialog(null, "Are you prescribing this procedure?", "Therapy", JOptionPane.YES_NO_CANCEL_OPTION);

            }
        });
    }

    private JButton prepisi5;

    public void setTerapijaPanel(JPanel terapijaPanel) {
        this.terapijaPanel = terapijaPanel;
    }

    public void setPrepisi1(JButton prepisi1) {
        this.prepisi1 = prepisi1;
    }

    public void setPrepisi2(JButton prepisi2) {
        this.prepisi2 = prepisi2;
    }

    public void setPrepisi3(JButton prepisi3) {
        this.prepisi3 = prepisi3;
    }

    public void setPrepisi4(JButton prepisi4) {
        this.prepisi4 = prepisi4;
    }

    public void setPrepisi5(JButton prepisi5) {
        this.prepisi5 = prepisi5;
    }

    public JPanel getTerapijaPanel() {
        return terapijaPanel;
    }

    public JButton getPrepisi1() {
        return prepisi1;
    }

    public JButton getPrepisi2() {
        return prepisi2;
    }

    public JButton getPrepisi3() {
        return prepisi3;
    }

    public JButton getPrepisi4() {
        return prepisi4;
    }

    public JButton getPrepisi5() {
        return prepisi5;
    }
}
