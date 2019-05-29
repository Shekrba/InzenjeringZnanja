package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AnamnezaFrame {
    private JPanel anamnezaPanel;
    private JButton zavrsiButton;
    private JList list1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JComboBox cbPol;
    private JComboBox cbRasa;
    private JTextField tfSimptom;
    private JButton unesiButton;
    private JList listSimptom;
    private JPanel unetiSimPanel;
    private JButton izbaciButton;

    public AnamnezaFrame() {

        cbPol.addItem("Muško");
        cbPol.addItem("Žensko");

        cbRasa.addItem("Bela");
        cbRasa.addItem("Crna");
        cbRasa.addItem("Hispanac");
        cbRasa.addItem("Druge");

        DefaultListModel dlmSimptomi = new DefaultListModel();
        listSimptom.setModel(dlmSimptomi);

        zavrsiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(textField2.getText().trim().equals("")){
                    JOptionPane.showMessageDialog(null, "Unesite ime pacijenta.");
                    return;
                }

                if(textField3.getText().trim().equals("")){
                    JOptionPane.showMessageDialog(null, "Unesite prezime pacijenta.");
                    return;
                }

                if(textField4.getText().trim().equals("")){
                    JOptionPane.showMessageDialog(null, "Unesite godine pacijenta.");
                    return;
                }

                try{
                    Integer.parseInt(textField4.getText());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Morate uneti broj u polje \"Godine\".");
                    return;
                }

                JDialog dialog = MainFrame.getDialog();
                dialog.dispose();

                dialog.setTitle("Anamneza");
                dialog.setContentPane(new ZavrsiAmnezuFrame().getZavrsiAmnezuPanel());
                dialog.setSize(800,400);
                dialog.setModal(true);
                dialog.setVisible(true);
            }
        });
        unesiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String simptom = tfSimptom.getText();

                if(simptom.trim().equals(""))
                    return;

                dlmSimptomi.addElement(simptom);

            }
        });
        izbaciButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(listSimptom.getSelectedIndex() != -1)
                    dlmSimptomi.remove(listSimptom.getSelectedIndex());
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
