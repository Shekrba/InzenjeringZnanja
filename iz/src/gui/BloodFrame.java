package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BloodFrame {
    private JTextField tfRbcc;
    private JTextField tfHemoglobin;
    private JTextField tfHematocrit;
    private JTextField tfWbcc;
    private JTextField tfPlatelet;
    private JButton submitButton;
    private JPanel bloodPanel;

    public BloodFrame() {
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
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
