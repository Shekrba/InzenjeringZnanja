package gui;

import de.javasoft.synthetica.aluoxide.SyntheticaAluOxideLookAndFeel;
import de.javasoft.synthetica.dark.SyntheticaDarkLookAndFeel;
import de.javasoft.synthetica.plain.SyntheticaPlainLookAndFeel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame {

    private JPanel mainPanel;
    private JButton DOPUNSKAISPITIVANJAButton;
    private JButton FIZIKALNIPREGLEDButton;
    private JButton ANAMNEZAButton;
    private static JFrame frame;
    private static JDialog dialog;

    public MainFrame() {
        ANAMNEZAButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dialog = new JDialog();
                dialog.setTitle("Anamnesis");
                dialog.setContentPane(new AnamnezaFrame().getAnamnezaPanel());
                dialog.setSize(800,600);
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
}
