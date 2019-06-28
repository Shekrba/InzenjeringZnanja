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
import java.util.List;

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

    private static double bmi;
    private static double temperatura;
    private static double pritisakLow;
    private static double pritisakHigh;
    private static ArrayList<String> simptomi=new ArrayList<>();
    private static int godine;
    private static String pol;
    private static String bolestOdabrana;

    public static void setBolestOdabrana(String bolestOdabrana) {
        MainFrame.bolestOdabrana = bolestOdabrana;
    }

    public static String getBolestOdabrana() {
        return bolestOdabrana;
    }

    public static void setGodine(int godine) {
        MainFrame.godine = godine;
    }

    public static void setPol(String pol) {
        MainFrame.pol = pol;
    }

    public static int getGodine() {
        return godine;
    }

    public static String getPol() {
        return pol;
    }

    public static ArrayList<String> getSimptomi() {
        return simptomi;
    }



    private static List<String> positiveBloodTests=new ArrayList<>();


    public MainFrame() {
        ANAMNEZAButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                cbc = new CBC();
                bmp = new BMP();

                bmi = 22;
                temperatura = 36.5;
                pritisakLow = 80;
                pritisakHigh = 120;

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


    public static double getBmi() {
        return bmi;
    }

    public static void setBmi(double bmi) {
        MainFrame.bmi = bmi;
    }

    public static double getTemperatura() {
        return temperatura;
    }

    public static void setTemperatura(double temperatura) {
        MainFrame.temperatura = temperatura;
    }

    public static double getPritisakLow() {
        return pritisakLow;
    }

    public static void setPritisakLow(double pritisakLow) {
        MainFrame.pritisakLow = pritisakLow;
    }

    public static double getPritisakHigh() {
        return pritisakHigh;
    }

    public static void setPritisakHigh(double pritisakHigh) {
        MainFrame.pritisakHigh = pritisakHigh;

    }
    public static List<String> getPositiveBloodTests() {
        return positiveBloodTests;
    }

    public static void setPositiveBloodTests(List<String> positiveBloodTests) {
        MainFrame.positiveBloodTests = positiveBloodTests;
    }
}
