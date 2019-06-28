package gui;

import model.Bolest;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CaseBaseFrame {
    private JButton zatvoriButton;
    private JList testList;
    private JPanel diseasePanel;
    private JLabel lab1;
    private JLabel lab2;
    private JLabel lab3;
    private JLabel lab4;
    private JLabel lab5;
    private JLabel lab6;
    private JProgressBar prog1;
    private JProgressBar prog2;
    private JProgressBar prog3;
    private JProgressBar prog4;
    private JProgressBar prog5;
    private JProgressBar prog6;
    private JButton ter1;
    private JButton ter2;
    private JButton ter3;
    private JButton ter4;
    private JButton ter5;
    private JButton ter6;
    private JPanel CaseBased;
    private JButton closeButton;

    public CaseBaseFrame() {

        ArrayList<Bolest> bolesti = MainFrame.getBolesti();

        DefaultListModel dlmTest = new DefaultListModel();
        testList.setModel(dlmTest);

        ArrayList<String> diseases = new ArrayList<String>();
        ArrayList<Integer> percents = new ArrayList<Integer>();
        int sum=0;

        for (Bolest b: bolesti) {
            diseases.add(b.getNaziv());
            percents.add(b.getProcenat());
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

        ArrayList<JButton> bolestTer = new ArrayList<>();
        bolestTer.add(ter1);
        bolestTer.add(ter2);
        bolestTer.add(ter3);
        bolestTer.add(ter4);
        bolestTer.add(ter5);
        bolestTer.add(ter6);

        for (int i = 0; i < diseases.size(); i++){

            bolestLab.get(i).setText(diseases.get(i));
            bolestLab.get(i).setVisible(true);

            bolestProg.get(i).setValue(percents.get(i));
            bolestProg.get(i).setVisible(true);
            bolestProg.get(i).setStringPainted(true);

            bolestTer.get(i).setVisible(true);

            if(i==5)
                break;
        }

        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame.getDialog().dispose();
            }
        });

        //TERAPIJA

        ter1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String text = "";

                JOptionPane.showMessageDialog(null,text,"THERAPY",JOptionPane.INFORMATION_MESSAGE);
            }
        });

        ter2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String text = "";

                JOptionPane.showMessageDialog(null,text,"THERAPY",JOptionPane.INFORMATION_MESSAGE);
            }
        });

        ter3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String text = "";

                JOptionPane.showMessageDialog(null,text,"THERAPY",JOptionPane.INFORMATION_MESSAGE);
            }
        });

        ter4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String text = "";

                JOptionPane.showMessageDialog(null,text,"THERAPY",JOptionPane.INFORMATION_MESSAGE);
            }
        });

        ter5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String text = "";

                JOptionPane.showMessageDialog(null,text,"THERAPY",JOptionPane.INFORMATION_MESSAGE);
            }
        });

        ter6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String text = "";

                JOptionPane.showMessageDialog(null,text,"THERAPY",JOptionPane.INFORMATION_MESSAGE);
            }
        });
    }

    public JPanel getCaseBased() {
        return CaseBased;
    }

    public void setCaseBased(JPanel caseBased) {
        CaseBased = caseBased;
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
