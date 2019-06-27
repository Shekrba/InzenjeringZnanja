package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CBC {
    private JTextField tfRbcc;
    private JTextField tfHemoglobin;
    private JTextField tfHematocrit;
    private JTextField tfWbcc;
    private JTextField tfPlatelet;
    private JButton submitButton;
    private JPanel bloodPanel;

    public CBC() {
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String hematocrit = tfHematocrit.getText();
                String hemoglobin = tfHemoglobin.getText();
                String platelet = tfPlatelet.getText();
                String rbcc = tfRbcc.getText();
                String wbcc = tfWbcc.getText();

                double hematocritDouble;
                double hemaglobinDouble;
                double plateletDouble;
                double rbccDouble;
                double wbccDouble;

                if(hematocrit.trim().equals("")){
                    JOptionPane.showMessageDialog(null, "Please fill all fields with numbers.");
                    return;
                }
                if(hemoglobin.trim().equals("")){
                    JOptionPane.showMessageDialog(null, "Please fill all fields with numbers.");
                    return;
                }
                if(platelet.trim().equals("")){
                    JOptionPane.showMessageDialog(null, "Please fill all fields with numbers.");
                    return;
                }
                if(rbcc.trim().equals("")){
                    JOptionPane.showMessageDialog(null, "Please fill all fields with numbers.");
                    return;
                }
                if(wbcc.trim().equals("")){
                    JOptionPane.showMessageDialog(null, "Please fill all fields with numbers.");
                    return;
                }
                try{
                    hemaglobinDouble = Double.parseDouble(hemoglobin);
                    hematocritDouble = Double.parseDouble(hematocrit);
                    plateletDouble = Double.parseDouble(platelet);
                    rbccDouble = Double.parseDouble(rbcc);
                    wbccDouble = Double.parseDouble(wbcc);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Please fill all fields with numbers.");
                    return;
                }

                MainFrame.getCbc().setHematocrit(hematocritDouble);
                MainFrame.getCbc().setHemoglobin(hemaglobinDouble);
                MainFrame.getCbc().setPlatelet(plateletDouble);
                MainFrame.getCbc().setRedBloodCellCount(rbccDouble);
                MainFrame.getCbc().setWhiteBloodCellCount(wbccDouble);





                AnamnezaFrame.dialogBlood.dispose();
            }
        });
    }

    public JPanel getBloodPanel() {
        return bloodPanel;
    }

    public void setBloodPanel(JPanel bloodPanel) {
        this.bloodPanel = bloodPanel;
    }
}
