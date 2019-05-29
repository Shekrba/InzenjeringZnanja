package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AnamnezaFrame {
    private JPanel anamnezaPanel;
    private JTextField textField1;
    private JButton unesiButton;
    private JButton zavrsiButton;
    private JList list1;
    private JList list2;

    public AnamnezaFrame() {
        zavrsiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JDialog dialog = MainFrame.getDialog();
                dialog.dispose();

                dialog.setTitle("Anamneza");
                dialog.setContentPane(new ZavrsiAmnezuFrame().getZavrsiAmnezuPanel());
                dialog.setSize(800,400);
                dialog.setModal(true);
                dialog.setVisible(true);
            }
        });
    }

    public JPanel getAnamnezaPanel() {
        return anamnezaPanel;
    }

    public void setAnamnezaPanel(JPanel anamnezaPanel) {
        this.anamnezaPanel = anamnezaPanel;
    }
}
