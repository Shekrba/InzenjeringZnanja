package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BMP {
    private JPanel bmp;
    private JTextField tfGlucose;
    private JTextField tfCalcium;
    private JTextField tfSodium;
    private JTextField tfPotassium;
    private JTextField tfUrea;
    private JTextField tfCreatinine;
    private JTextField tfBilirubin;
    private JButton submit;

    public BMP() {
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String glucose = tfGlucose.getText();
                String calcium = tfCalcium.getText();
                String bilirubin = tfBilirubin.getText();
                String creatinine = tfCreatinine.getText();
                String potassium = tfPotassium.getText();
                String urea = tfUrea.getText();
                String sodium = tfSodium.getText();

                double glucoseDouble;
                double calciumDouble;
                double bilirubinDouble;
                double creatinineDouble;
                double potassiumDouble;
                double ureaDouble;
                double sodiumDouble;

                if(glucose.trim().equals("")){
                    JOptionPane.showMessageDialog(null, "Please fill all fields with numbers.");
                    return;
                }
                if(calcium.trim().equals("")){
                    JOptionPane.showMessageDialog(null, "Please fill all fields with numbers.");
                    return;
                }
                if(bilirubin.trim().equals("")){
                    JOptionPane.showMessageDialog(null, "Please fill all fields with numbers.");
                    return;
                }
                if(creatinine.trim().equals("")){
                    JOptionPane.showMessageDialog(null, "Please fill all fields with numbers.");
                    return;
                }
                if(potassium.trim().equals("")){
                    JOptionPane.showMessageDialog(null, "Please fill all fields with numbers.");
                    return;
                }
                if(urea.trim().equals("")){
                    JOptionPane.showMessageDialog(null, "Please fill all fields with numbers.");
                    return;
                }
                if(sodium.trim().equals("")){
                    JOptionPane.showMessageDialog(null, "Please fill all fields with numbers.");
                    return;
                }

                try{
                    glucoseDouble = Double.parseDouble(glucose);
                    calciumDouble = Double.parseDouble(calcium);
                    creatinineDouble = Double.parseDouble(creatinine);
                    bilirubinDouble = Double.parseDouble(bilirubin);
                    potassiumDouble = Double.parseDouble(potassium);
                    ureaDouble = Double.parseDouble(urea);
                    sodiumDouble = Double.parseDouble(sodium);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Please fill all fields with numbers.");
                    return;
                }

                MainFrame.getBmp().setBilirubin(bilirubinDouble);
                MainFrame.getBmp().setCalcium(calciumDouble);
                MainFrame.getBmp().setCreatinine(creatinineDouble);
                MainFrame.getBmp().setGlucose(glucoseDouble);
                MainFrame.getBmp().setPotassium(potassiumDouble);
                MainFrame.getBmp().setSodium(sodiumDouble);
                MainFrame.getBmp().setUrea(ureaDouble);



                AnamnezaFrame.dialogBlood.dispose();
            }
        });
    }

    public JPanel getBmp() {
        return bmp;
    }

    public void setBmp(JPanel bmp) {
        this.bmp = bmp;
    }

    public JTextField getTfGlucose() {
        return tfGlucose;
    }

    public void setTfGlucose(JTextField tfGlucose) {
        this.tfGlucose = tfGlucose;
    }

    public JTextField getTfCalcium() {
        return tfCalcium;
    }

    public void setTfCalcium(JTextField tfCalcium) {
        this.tfCalcium = tfCalcium;
    }

    public JTextField getTfSodium() {
        return tfSodium;
    }

    public void setTfSodium(JTextField tfSodium) {
        this.tfSodium = tfSodium;
    }

    public JTextField getTfPotassium() {
        return tfPotassium;
    }

    public void setTfPotassium(JTextField tfPotassium) {
        this.tfPotassium = tfPotassium;
    }

    public JTextField getTfUrea() {
        return tfUrea;
    }

    public void setTfUrea(JTextField tfUrea) {
        this.tfUrea = tfUrea;
    }

    public JTextField getTfCreatinine() {
        return tfCreatinine;
    }

    public void setTfCreatinine(JTextField tfCreatinine) {
        this.tfCreatinine = tfCreatinine;
    }

    public JTextField getTfBilirubin() {
        return tfBilirubin;
    }

    public void setTfBilirubin(JTextField tfBilirubin) {
        this.tfBilirubin = tfBilirubin;
    }

    public JButton getSubmit() {
        return submit;
    }

    public void setSubmit(JButton submit) {
        this.submit = submit;
    }
}
