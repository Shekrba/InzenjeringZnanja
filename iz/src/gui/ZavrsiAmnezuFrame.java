package gui;

import model.Bolest;
import util.DiagnosisUtil;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

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

        ArrayList<Bolest> bolesti = MainFrame.getBolesti();

        ArrayList<Integer> poklapanja = new ArrayList<>();
        for (Bolest b: bolesti) {
            if(!poklapanja.contains(b.getPoklapanje())) {
                poklapanja.add(b.getPoklapanje());
            }
        }

        Collections.sort(poklapanja);
        Collections.reverse(poklapanja);

        for (Integer p: poklapanja) {
            numberOfSym.addItem(p+"");
        }

        ArrayList<String> diseases = new ArrayList<String>();
        ArrayList<Integer> percents = new ArrayList<Integer>();

        for (Bolest b: bolesti) {
            if(b.getPoklapanje() == poklapanja.get(0)){
                diseases.add(b.getNaziv());
                percents.add(b.getProcenat());
            }
        }

        sortDiseases(diseases,percents);

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

        for (int i = 0; i < diseases.size(); i++){

            bolestLab.get(i).setText(diseases.get(i));
            bolestLab.get(i).setVisible(true);

            bolestProg.get(i).setValue(percents.get(i));
            bolestProg.get(i).setVisible(true);
            bolestProg.get(i).setStringPainted(true);

            bolestBut.get(i).setVisible(true);

            if(i==5)
                break;
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
                int selected = Integer.parseInt(String.valueOf(numberOfSym.getSelectedItem()));

                for(int i = 0; i<=5; i++){
                    bolestBut.get(i).setVisible(false);
                    bolestLab.get(i).setVisible(false);
                    bolestProg.get(i).setVisible(false);
                }

                diseasePanel.repaint();
                diseasePanel.revalidate();

                diseases.clear();
                percents.clear();

                for (Bolest b: bolesti) {
                    if(b.getPoklapanje() == selected){
                        diseases.add(b.getNaziv());
                        percents.add(b.getProcenat());
                    }
                }

                sortDiseases(diseases,percents);

                for (int i = 0; i < diseases.size(); i++){

                    bolestLab.get(i).setText(diseases.get(i));
                    bolestLab.get(i).setVisible(true);

                    bolestProg.get(i).setValue(percents.get(i));
                    bolestProg.get(i).setVisible(true);
                    bolestProg.get(i).setStringPainted(true);

                    bolestBut.get(i).setVisible(true);

                    if(i==5)
                        break;
                }
            }
        });

        but1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Bolest bol = new Bolest();

                for (Bolest b: bolesti) {
                    if(b.getNaziv().equals(lab1.getText())){
                        bol = b;
                        break;
                    }
                }

                String text = "";

                for (String s: bol.getSimptomi()) {
                    text += s + "\n";
                }

                JOptionPane.showMessageDialog(null,text,"SYMPTHOMS",JOptionPane.INFORMATION_MESSAGE);
            }
        });

        but2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Bolest bol = new Bolest();

                for (Bolest b: bolesti) {
                    if(b.getNaziv().equals(lab2.getText())){
                        bol = b;
                        break;
                    }
                }

                String text = "";

                for (String s: bol.getSimptomi()) {
                    text += s + "\n";
                }

                JOptionPane.showMessageDialog(null,text,"SYMPTHOMS",JOptionPane.INFORMATION_MESSAGE);
            }
        });

        but3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Bolest bol = new Bolest();

                for (Bolest b: bolesti) {
                    if(b.getNaziv().equals(lab3.getText())){
                        bol = b;
                        break;
                    }
                }

                String text = "";

                for (String s: bol.getSimptomi()) {
                    text += s + "\n";
                }

                JOptionPane.showMessageDialog(null,text,"SYMPTHOMS",JOptionPane.INFORMATION_MESSAGE);
            }
        });

        but4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Bolest bol = new Bolest();

                for (Bolest b: bolesti) {
                    if(b.getNaziv().equals(lab4.getText())){
                        bol = b;
                        break;
                    }
                }

                String text = "";

                for (String s: bol.getSimptomi()) {
                    text += s + "\n";
                }

                JOptionPane.showMessageDialog(null,text,"SYMPTHOMS",JOptionPane.INFORMATION_MESSAGE);
            }
        });

        but5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Bolest bol = new Bolest();

                for (Bolest b: bolesti) {
                    if(b.getNaziv().equals(lab5.getText())){
                        bol = b;
                        break;
                    }
                }

                String text = "";

                for (String s: bol.getSimptomi()) {
                    text += s + "\n";
                }

                JOptionPane.showMessageDialog(null,text,"SYMPTHOMS",JOptionPane.INFORMATION_MESSAGE);
            }
        });

        but6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Bolest bol = new Bolest();

                for (Bolest b: bolesti) {
                    if(b.getNaziv().equals(lab6.getText())){
                        bol = b;
                        break;
                    }
                }

                String text = "";

                for (String s: bol.getSimptomi()) {
                    text += s + "\n";
                }

                JOptionPane.showMessageDialog(null,text,"SYMPTHOMS",JOptionPane.INFORMATION_MESSAGE);
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

