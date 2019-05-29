package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ZavrsiAmnezuFrame {
    private JPanel zavrsiAmnezuPanel;
    private JList list1;
    private JButton zatvoriButton;

    public ZavrsiAmnezuFrame() {
        zatvoriButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame.getDialog().dispose();
            }
        });
    }

    public JPanel getZavrsiAmnezuPanel() {
        return zavrsiAmnezuPanel;
    }

    public void setZavrsiAmnezuPanel(JPanel zavrsiAmezuPanel) {
        this.zavrsiAmnezuPanel = zavrsiAmezuPanel;
    }
}

