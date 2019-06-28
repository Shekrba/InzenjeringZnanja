package gui;

import model.Bolest;
import util.DiagnosisUtil;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
    private JList testList;
    private JButton ter1;
    private JButton ter2;
    private JButton ter3;
    private JButton ter4;
    private JButton ter5;
    private JButton ter6;
    private JDialog dialog;


    public ZavrsiAmnezuFrame() {

        ArrayList<Bolest> bolesti = MainFrame.getBolesti();

        DefaultListModel dlmTest = new DefaultListModel();
        testList.setModel(dlmTest);

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
        ArrayList<Integer> oldPercents = new ArrayList<Integer>();
        int sum=0;

        for (Bolest b: bolesti) {
            if(b.getPoklapanje() == poklapanja.get(0)){
                diseases.add(b.getNaziv());
                oldPercents.add(b.getProcenat());
                sum+=b.getProcenat();
            }
        }

        ArrayList<Integer> percents = new ArrayList<Integer>();

        for(int i=0 ; i<oldPercents.size() ; i++){
            percents.add((int)Math.round((float)oldPercents.get(i)*1.0/sum*100));
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

            bolestBut.get(i).setVisible(true);
            bolestTer.get(i).setVisible(true);

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
                    bolestTer.get(i).setVisible(false);
                }

                diseasePanel.repaint();
                diseasePanel.revalidate();

                diseases.clear();
                percents.clear();

                ArrayList<Integer> oldPercents = new ArrayList<Integer>();
                int sum=0;

                for (Bolest b: bolesti) {
                    if(b.getPoklapanje() == selected){
                        diseases.add(b.getNaziv());
                        oldPercents.add(b.getProcenat());
                        sum+=b.getProcenat();
                    }
                }

                ArrayList<Integer> percents = new ArrayList<Integer>();

                for(int i=0 ; i<oldPercents.size() ; i++){
                    percents.add((int)Math.round((float)oldPercents.get(i)*1.0/sum*100));
                }



                sortDiseases(diseases,percents);

                for (int i = 0; i < diseases.size(); i++){

                    bolestLab.get(i).setText(diseases.get(i));
                    bolestLab.get(i).setVisible(true);

                    bolestProg.get(i).setValue(percents.get(i));
                    bolestProg.get(i).setVisible(true);
                    bolestProg.get(i).setStringPainted(true);

                    bolestBut.get(i).setVisible(true);
                    bolestTer.get(i).setVisible(true);

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

        //TERAPIJA

        ter1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Bolest bol1 = new Bolest();

                for (Bolest b: bolesti) {
                    if(b.getNaziv().equals(lab1.getText())){
                        bol1 = b;
                        break;
                    }
                }

                String text = "";
                MainFrame.setBolestOdabrana(bol1.getNaziv());

                fja();
                insertDisease(bol1.getNaziv());

                JDialog dialog = MainFrame.getDialog();
                dialog.dispose();

                dialog.setContentPane(new ZavrsiAmnezuFrame().getZavrsiAmnezuPanel());
                dialog.setTitle(bol1.getNaziv());
                dialog.setContentPane(new TerapijaFrame().getTerapijaPanel());
                dialog.setSize(400,350);
                dialog.setModal(true);
                dialog.setLocationRelativeTo(null);
                dialog.setVisible(true);            }
        });

        ter2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Bolest bol1 = new Bolest();

                for (Bolest b: bolesti) {
                    if(b.getNaziv().equals(lab2.getText())){
                        bol1 = b;
                        break;
                    }
                }

                String text = "";
                MainFrame.setBolestOdabrana(bol1.getNaziv());

                fja();
                insertDisease(bol1.getNaziv());

                JDialog dialog = MainFrame.getDialog();
                dialog.dispose();
                dialog.setTitle("Procedures");
                dialog.setContentPane(new TerapijaFrame().getTerapijaPanel());
                dialog.setSize(400,350);
                dialog.setModal(true);
                dialog.setLocationRelativeTo(null);
                dialog.setVisible(true);               }
        });

        ter3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Bolest bol1 = new Bolest();

                for (Bolest b: bolesti) {
                    if(b.getNaziv().equals(lab3.getText())){
                        bol1 = b;
                        break;
                    }
                }

                String text = "";
                MainFrame.setBolestOdabrana(bol1.getNaziv());

                fja();
                insertDisease(bol1.getNaziv());

                JDialog dialog = MainFrame.getDialog();
                dialog.dispose();
                dialog.setTitle("Procedures");
                dialog.setContentPane(new TerapijaFrame().getTerapijaPanel());
                dialog.setSize(400,350);
                dialog.setModal(true);
                dialog.setLocationRelativeTo(null);
                dialog.setVisible(true);               }
        });

        ter4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Bolest bol1 = new Bolest();

                for (Bolest b: bolesti) {
                    if(b.getNaziv().equals(lab4.getText())){
                        bol1 = b;
                        break;
                    }
                }

                String text = "";
                MainFrame.setBolestOdabrana(bol1.getNaziv());

                fja();
                insertDisease(bol1.getNaziv());

                JDialog dialog = MainFrame.getDialog();
                dialog.dispose();
                dialog.setTitle("Procedures");
                dialog.setContentPane(new TerapijaFrame().getTerapijaPanel());
                dialog.setSize(400,350);
                dialog.setModal(true);
                dialog.setLocationRelativeTo(null);
                dialog.setVisible(true);               }
        });

        ter5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Bolest bol1 = new Bolest();

                for (Bolest b: bolesti) {
                    if(b.getNaziv().equals(lab5.getText())){
                        bol1 = b;
                        break;
                    }
                }

                String text = "";
                MainFrame.setBolestOdabrana(bol1.getNaziv());

                fja();
                insertDisease(bol1.getNaziv());

                JDialog dialog = MainFrame.getDialog();
                dialog.dispose();
                dialog.setTitle("Procedures");
                dialog.setContentPane(new TerapijaFrame().getTerapijaPanel());
                dialog.setSize(400,350);
                dialog.setModal(true);
                dialog.setLocationRelativeTo(null);
                dialog.setVisible(true);               }
        });

        ter6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Bolest bol1 = new Bolest();

                for (Bolest b: bolesti) {
                    if(b.getNaziv().equals(lab6.getText())){
                        bol1 = b;
                        break;
                    }
                }

                String text = "";
                MainFrame.setBolestOdabrana(bol1.getNaziv());

                fja();
                insertDisease(bol1.getNaziv());

                JDialog dialog = MainFrame.getDialog();
                dialog.dispose();
                dialog.setTitle("Procedures");
                dialog.setContentPane(new TerapijaFrame().getTerapijaPanel());
                dialog.setSize(400,350);
                dialog.setModal(true);
                dialog.setLocationRelativeTo(null);
                dialog.setVisible(true);
            }
        });

    }

    public void insertDisease(String disease){
        Connection conn = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/iz", "root", "1234");

            String sql = "INSERT INTO disease_history (patient_id,disease) VALUES (?, ?)";

            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, AnamnezaFrame.ID);
            preparedStatement.setString(2,disease);
            preparedStatement.executeUpdate();

        } catch(Exception ex) {

        }
    }

    public void fja() {

        String s = "";
        for (String b:
                MainFrame.getSimptomi()) {
            b = b.toLowerCase().replaceAll(" ", "_");
            s+=b;
            s+="?";
        }
        s+=";";
        if(MainFrame.getTemperatura() == 0) {
            s+=36.5;
        }else {
            s += MainFrame.getTemperatura();
        }
        s+=";";
        s+=MainFrame.getPritisakHigh();
        s+=";";
        s+=MainFrame.getPritisakLow();
        s+=";";
        s+=MainFrame.getBmi();
        s+=";";
        if(MainFrame.getCbc().getRedBloodCellCount() == 0) {
            s+=4.8;
        } else {
            s += MainFrame.getCbc().getRedBloodCellCount();
        }
        s+=";";
        if(MainFrame.getCbc().getHemoglobin() == 0) {
            s+= 14;
        } else {
            s += MainFrame.getCbc().getHemoglobin();
        }
        s+=";";
        if(MainFrame.getCbc().getHematocrit() ==0) {
            s+= 41;
        } else {
            s += MainFrame.getCbc().getHematocrit();
        }
        s+=";";
        if(MainFrame.getCbc().getWhiteBloodCellCount() == 0) {
            s+= 6;
        } else {
            s += MainFrame.getCbc().getWhiteBloodCellCount();
        }
        s+=";";
        if(MainFrame.getCbc().getPlatelet() == 0) {
            s+= 250;
        }else {
            s += MainFrame.getCbc().getPlatelet();
        }
        s+=";";
        if(MainFrame.getBmp().getGlucose() == 0) {
            s+= 80;
        }else {
            s += MainFrame.getBmp().getGlucose();
        }
        s+=";";
        if(MainFrame.getBmp().getCalcium() == 0) {
            s+=9.5;
        }
        else {
            s += MainFrame.getBmp().getCalcium();
        }
        s+=";";
        if(MainFrame.getBmp().getSodium() ==0) {
            s+=130;
        }
        else {
            s += MainFrame.getBmp().getSodium();
        }
        s+=";";
        if(MainFrame.getBmp().getPotassium() == 0) {
            s+=4.2;
        }else {
            s += MainFrame.getBmp().getPotassium();
        }
        s+=";";
        if(MainFrame.getBmp().getUrea() == 0) {
            s+=4;
        }else {
            s += MainFrame.getBmp().getUrea();
        }
        s+=";";
        if(MainFrame.getBmp().getCreatinine() == 0) {
            s+=110;
        } else {
            s += MainFrame.getBmp().getCreatinine();
        }
        s+=";";
        if(MainFrame.getBmp().getBilirubin() == 0) {
            s+=1.1;
        } else {
            s += MainFrame.getBmp().getBilirubin();
        }
        s+=";";
        s+=MainFrame.getGodine();
        s+=";";
        s+=MainFrame.getPol();
        s+=";";
        s+=MainFrame.getBolestOdabrana();

        System.out.println(s);

        FileWriter fileWriter = null; //Set true for append mode
        try {
            fileWriter = new FileWriter("data\\results.csv", true);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.println(s);  //New line
        printWriter.close();
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

