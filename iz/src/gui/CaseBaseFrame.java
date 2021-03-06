package gui;

import model.Bolest;
import org.apache.jena.query.*;
import org.apache.jena.rdf.model.Literal;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.riot.Lang;
import org.apache.jena.riot.RDFDataMgr;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
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
                MainFrame.setBolestOdabrana(lab1.getText());
                JDialog dialog=MainFrame.getDialog();
                dialog.dispose();
                dialog = new JDialog();
                dialog.setTitle("Therapies");
                dialog.setContentPane(new TerapijaFrameCBR(runSparqlQuery(lab1.getText())).getTerapijaPanel());
                dialog.setSize(400,350);
                dialog.setModal(true);
                dialog.setLocationRelativeTo(null);
                dialog.setVisible(true);
                MainFrame.setDialog(dialog);
                fja();
            }
        });

        ter2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame.setBolestOdabrana(lab2.getText());
                JDialog dialog=MainFrame.getDialog();
                dialog.dispose();
                dialog = new JDialog();
                dialog.setTitle("Therapies");
                dialog.setContentPane(new TerapijaFrameCBR(runSparqlQuery(lab2.getText())).getTerapijaPanel());
                dialog.setSize(400,350);
                dialog.setModal(true);
                dialog.setLocationRelativeTo(null);
                dialog.setVisible(true);
                MainFrame.setDialog(dialog);
                fja();
            }
        });

        ter3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame.setBolestOdabrana(lab3.getText());
                JDialog dialog=MainFrame.getDialog();
                dialog.dispose();
                dialog = new JDialog();
                dialog.setTitle("Therapies");
                dialog.setContentPane(new TerapijaFrameCBR(runSparqlQuery(lab3.getText())).getTerapijaPanel());
                dialog.setSize(400,350);
                dialog.setModal(true);
                dialog.setLocationRelativeTo(null);
                dialog.setVisible(true);
                MainFrame.setDialog(dialog);
                fja();
            }
        });

        ter4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame.setBolestOdabrana(lab4.getText());
                JDialog dialog=MainFrame.getDialog();
                dialog.dispose();
                dialog = new JDialog();
                dialog.setTitle("Therapies");
                dialog.setContentPane(new TerapijaFrameCBR(runSparqlQuery(lab4.getText())).getTerapijaPanel());
                dialog.setSize(400,350);
                dialog.setModal(true);
                dialog.setLocationRelativeTo(null);
                dialog.setVisible(true);
                MainFrame.setDialog(dialog);
                fja();
            }
        });

        ter5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame.setBolestOdabrana(lab5.getText());
                JDialog dialog=MainFrame.getDialog();
                dialog.dispose();
                dialog = new JDialog();
                dialog.setTitle("Therapies");
                dialog.setContentPane(new TerapijaFrameCBR(runSparqlQuery(lab5.getText())).getTerapijaPanel());
                dialog.setSize(400,350);
                dialog.setModal(true);
                dialog.setLocationRelativeTo(null);
                dialog.setVisible(true);
                MainFrame.setDialog(dialog);
                fja();
            }
        });

        ter6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame.setBolestOdabrana(lab6.getText());
                JDialog dialog=MainFrame.getDialog();
                dialog.dispose();
                dialog = new JDialog();
                dialog.setTitle("Therapies");
                dialog.setContentPane(new TerapijaFrameCBR(runSparqlQuery(lab6.getText())).getTerapijaPanel());
                dialog.setSize(400,350);
                dialog.setModal(true);
                dialog.setLocationRelativeTo(null);
                dialog.setVisible(true);
                MainFrame.setDialog(dialog);
                fja();
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

    public ArrayList<String> runSparqlQuery(String bolest){
        Model model = ModelFactory.createDefaultModel();
        try {
            InputStream is = new FileInputStream("data/diseasestherapies.ttl");
            RDFDataMgr.read(model, is, Lang.TURTLE);
            is.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        String queryString = ""
                + "PREFIX iz: <http://www.donttrustus.rs/medhelp#> "
                + "PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>"
                + "SELECT ?therapy  (count(?patient) as ?br)"
                + "WHERE {"
                + "    ?patient iz:hasdisease \""+bolest+"\" ;"
                + "      iz:gottherapy ?therapy ."
                + "}"
                +"GROUP BY ?therapy "
                +"ORDER BY DESC(xsd:nonNegativeInteger(?br))";
        Query query = QueryFactory.create(queryString) ;
        QueryExecution qexec = QueryExecutionFactory.create(query, model);
        ResultSet results = qexec.execSelect() ;
        ArrayList<String> ret=new ArrayList<>();
        while (results.hasNext()) {
            QuerySolution solution = results.nextSolution() ;
            Literal literal = solution.getLiteral("therapy");
            Literal literal1 = solution.getLiteral("br");
            ret.add(literal.getString()+"   -   "+literal1.getInt());
        }
        return ret;
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
}
