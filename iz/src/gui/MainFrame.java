package gui;

import de.javasoft.synthetica.dark.SyntheticaDarkLookAndFeel;
import model.CBC;
import model.BMP;
import model.Bolest;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MainFrame {

    private JPanel mainPanel;
    private JButton DOPUNSKAISPITIVANJAButton;
    private JButton FIZIKALNIPREGLEDButton;
    private JButton ANAMNEZAButton;
    private static JFrame frame;
    private static JDialog dialog;
    private static ArrayList<Bolest> bolesti;
    private static CBC cbc;
    private static BMP bmp;

    public MainFrame() {
        ANAMNEZAButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                cbc = new CBC();
                bmp = new BMP();

                dialog = new JDialog();
                dialog.setTitle("Anamnesis");
                dialog.setContentPane(new AnamnezaFrame().getAnamnezaPanel());
                dialog.setSize(800,750);
                dialog.setModal(true);
                dialog.setLocationRelativeTo(null);
                dialog.setVisible(true);
            }
        });
    }

    public static void main(String[] args) {

        try
        {
            UIManager.setLookAndFeel(new SyntheticaDarkLookAndFeel());
            EventQueue.invokeLater(() -> new MainFrame());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        frame = new JFrame("IZ");
        frame.setContentPane(new MainFrame().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(800,600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public void setMainPanel(JPanel mainPanel) {
        this.mainPanel = mainPanel;
    }

    public JButton getDOPUNSKAISPITIVANJAButton() {
        return DOPUNSKAISPITIVANJAButton;
    }

    public void setDOPUNSKAISPITIVANJAButton(JButton DOPUNSKAISPITIVANJAButton) {
        this.DOPUNSKAISPITIVANJAButton = DOPUNSKAISPITIVANJAButton;
    }

    public JButton getFIZIKALNIPREGLEDButton() {
        return FIZIKALNIPREGLEDButton;
    }

    public void setFIZIKALNIPREGLEDButton(JButton FIZIKALNIPREGLEDButton) {
        this.FIZIKALNIPREGLEDButton = FIZIKALNIPREGLEDButton;
    }

    public JButton getANAMNEZAButton() {
        return ANAMNEZAButton;
    }

    public void setANAMNEZAButton(JButton ANAMNEZAButton) {
        this.ANAMNEZAButton = ANAMNEZAButton;
    }

    public static JFrame getFrame() {
        return frame;
    }

    public static void setFrame(JFrame frame) {
        MainFrame.frame = frame;
    }

    public static JDialog getDialog() {
        return dialog;
    }

    public static void setDialog(JDialog dialog) {
        MainFrame.dialog = dialog;
    }

    public static ArrayList<Bolest> getBolesti() {
        return bolesti;
    }

    public static void setBolesti(ArrayList<Bolest> bolesti) {
        MainFrame.bolesti = bolesti;
    }

    public static CBC getCbc() {
        return cbc;
    }

    public static void setCbc(CBC cbc) {
        MainFrame.cbc = cbc;
    }

    public static BMP getBmp() {
        return bmp;
    }

    public static void setBmp(BMP bmp) {
        MainFrame.bmp = bmp;
    }
}
