package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ZavrsiAmnezuFrame {
    private JPanel zavrsiAmnezuPanel;
    private JButton zatvoriButton;
    private JPanel diseasePanel;
    private JProgressBar prog1;
    private JProgressBar prog2;
    private JProgressBar prog3;
    private JProgressBar prog4;
    private JProgressBar prog5;
    private JProgressBar prog6;
    private JLabel lab1;
    private JLabel lab2;
    private JLabel lab3;
    private JLabel lab4;
    private JLabel lab5;
    private JLabel lab6;
    private JComboBox numberOfSym;
    private JButton but1;
    private JButton but2;
    private JButton but3;
    private JButton but4;
    private JButton but5;
    private JButton but6;

    public ZavrsiAmnezuFrame() {

        numberOfSym.addItem("2");
        numberOfSym.addItem("1");

        ArrayList<String> diseases = new ArrayList<String>();
        ArrayList<Integer> percents = new ArrayList<Integer>();

        ArrayList<JLabel> bolestLab= new ArrayList<>();
        bolestLab.add(lab1);
        bolestLab.add(lab2);
        bolestLab.add(lab3);
        bolestLab.add(lab4);
        bolestLab.add(lab5);
        bolestLab.add(lab6);

        ArrayList<JProgressBar> bolestProg= new ArrayList<>();
        bolestProg.add(prog1);
        bolestProg.add(prog2);
        bolestProg.add(prog3);
        bolestProg.add(prog4);
        bolestProg.add(prog5);
        bolestProg.add(prog6);

        ArrayList<JButton> bolestBut = new ArrayList<>();
        bolestBut.add(but1);
        bolestBut.add(but2);
        bolestBut.add(but3);
        bolestBut.add(but4);
        bolestBut.add(but5);
        bolestBut.add(but6);

        diseases.add("Acute respiratory distress syndrome");
        percents.add(50);

        diseases.add("Ischemic heart disease");
        percents.add(68);

        sortDiseases(diseases,percents);

        for (int i = 0; i < diseases.size(); i++){

            bolestLab.get(i).setText(diseases.get(i));
            bolestLab.get(i).setVisible(true);

            bolestProg.get(i).setValue(percents.get(i));
            bolestProg.get(i).setVisible(true);
            bolestProg.get(i).setStringPainted(true);

            bolestBut.get(i).setVisible(true);
        }

        zatvoriButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame.getDialog().dispose();
            }
        });
        numberOfSym.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bolestProg.get(0).setValue(10);
            }
        });
        but1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                JOptionPane.showMessageDialog(null,"Sharp chest pain");
            }
        });
    }

    public JPanel getZavrsiAmnezuPanel() {
        return zavrsiAmnezuPanel;
    }

    public void setZavrsiAmnezuPanel(JPanel zavrsiAmezuPanel) {
        this.zavrsiAmnezuPanel = zavrsiAmezuPanel;
    }

    public void sortDiseases(ArrayList<String> diseases, ArrayList<Integer> percents){
        for (int i = 0; i < percents.size(); i++){
            for(int j = i+1; j<percents.size(); j++){
                if (percents.get(j) > percents.get(i)) {

                    int pi = percents.get(i);
                    int pj = percents.get(j);

                    percents.set(i,pj);
                    percents.set(j,pi);

                    String di = diseases.get(i);
                    String dj = diseases.get(j);

                    diseases.set(i,dj);
                    diseases.set(j,di);

                }
            }
        }
    }
}

