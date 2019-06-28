package gui;

import com.ugos.jiprolog.engine.JIPEngine;
import com.ugos.jiprolog.engine.JIPQuery;
import com.ugos.jiprolog.engine.JIPTerm;
import com.ugos.jiprolog.engine.JIPVariable;
import model.DodatanTest;
import org.apache.jena.datatypes.xsd.XSDDatatype;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Property;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.riot.Lang;
import org.apache.jena.riot.RDFDataMgr;
import org.apache.jena.vocabulary.RDF;
import unbbayes.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;

public class TerapijaFrameCBR {
    private JPanel terapijaPanel;
    private JButton prepisi1;
    private JButton prepisi2;
    private JButton prepisi3;
    private JButton prepisi4;

    public TerapijaFrameCBR(ArrayList<String> terapije) {



        prepisi1.setVisible(false);
        prepisi2.setVisible(false);
        prepisi3.setVisible(false);
        prepisi4.setVisible(false);
        prepisi5.setVisible(false);

        l1.setVisible(false);
        l2.setVisible(false);
        l3.setVisible(false);
        l4.setVisible(false);
        l5.setVisible(false);

        if(terapije.size()>0) {
            l1.setText(terapije.get(0));
            prepisi1.setVisible(true);
            l1.setVisible(true);
        }
        if(terapije.size()>1) {
            l2.setText(terapije.get(1));
            prepisi2.setVisible(true);
            l2.setVisible(true);
        }
        if(terapije.size()>2) {
            l3.setText(terapije.get(2));
            prepisi3.setVisible(true);
            l3.setVisible(true);
        }
        if(terapije.size()>3) {
            l4.setText(terapije.get(3));
            prepisi4.setVisible(true);
            l4.setVisible(true);
        }
        if(terapije.size()>4) {
            l5.setText(terapije.get(4));
            prepisi5.setVisible(true);
            l5.setVisible(true);
        }


        int i=0;
        for(String s : terapije){
            String str=s.substring(0,s.indexOf(" "));
            terapije.set(i,str);
            i++;
        }

        prepisi1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int option = JOptionPane.showConfirmDialog(null, "Are you prescribing this procedure?", "Therapy", JOptionPane.YES_NO_CANCEL_OPTION);
                if (option == JOptionPane.YES_OPTION) {
                    saveTherapy(terapije.get(0));

                }
                JDialog dialog = MainFrame.getDialog();
                dialog.dispose();
            }
        });
        prepisi2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int option = JOptionPane.showConfirmDialog(null, "Are you prescribing this procedure?", "Therapy", JOptionPane.YES_NO_CANCEL_OPTION);
                if(option == JOptionPane.YES_OPTION) {
                    saveTherapy(terapije.get(1));
                }
                JDialog dialog = MainFrame.getDialog();
                dialog.dispose();
            }
        });
        prepisi3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int option = JOptionPane.showConfirmDialog(null, "Are you prescribing this procedure?", "Therapy", JOptionPane.YES_NO_CANCEL_OPTION);
                if(option == JOptionPane.YES_OPTION) {
                    saveTherapy(terapije.get(2));
                }
                JDialog dialog = MainFrame.getDialog();
                dialog.dispose();
            }
        });
        prepisi4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int option = JOptionPane.showConfirmDialog(null, "Are you prescribing this procedure?", "Therapy", JOptionPane.YES_NO_CANCEL_OPTION);
                if(option == JOptionPane.YES_OPTION) {
                    saveTherapy(terapije.get(3));
                }
                JDialog dialog = MainFrame.getDialog();
                dialog.dispose();
            }
        });
        prepisi5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int option = JOptionPane.showConfirmDialog(null, "Are you prescribing this procedure?", "Therapy", JOptionPane.YES_NO_CANCEL_OPTION);
                if(option == JOptionPane.YES_OPTION) {
                    saveTherapy(terapije.get(4));
                }
                JDialog dialog = MainFrame.getDialog();
                dialog.dispose();
            }
        });
    }

    private JButton prepisi5;
    private JLabel l1;
    private JLabel l2;
    private JLabel l3;
    private JLabel l4;
    private JLabel l5;

    public void setTerapijaPanel(JPanel terapijaPanel) {
        this.terapijaPanel = terapijaPanel;
    }

    public void setPrepisi1(JButton prepisi1) {
        this.prepisi1 = prepisi1;
    }

    public void setPrepisi2(JButton prepisi2) {
        this.prepisi2 = prepisi2;
    }

    public void setPrepisi3(JButton prepisi3) {
        this.prepisi3 = prepisi3;
    }

    public void setPrepisi4(JButton prepisi4) {
        this.prepisi4 = prepisi4;
    }

    public void setPrepisi5(JButton prepisi5) {
        this.prepisi5 = prepisi5;
    }

    public JPanel getTerapijaPanel() {
        return terapijaPanel;
    }

    public JButton getPrepisi1() {
        return prepisi1;
    }

    public JButton getPrepisi2() {
        return prepisi2;
    }

    public JButton getPrepisi3() {
        return prepisi3;
    }

    public JButton getPrepisi4() {
        return prepisi4;
    }

    public JButton getPrepisi5() {
        return prepisi5;
    }

    public void saveTherapy(String therapy){
        Model model = ModelFactory.createDefaultModel();
        try {

            InputStream is = new FileInputStream("data/diseasestherapies.ttl");
            RDFDataMgr.read(model, is, Lang.TURTLE);
            is.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        String namespace = "http://www.donttrustus.rs/medhelp";

        int n=8;

        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789"
                + "abcdefghijklmnopqrstuvxyz";
        StringBuilder sb = new StringBuilder(n);

        for (int i = 0; i < n; i++) {

            // generate a random number between
            // 0 to AlphaNumericString variable length
            int index
                    = (int)(AlphaNumericString.length()
                    * Math.random());

            // add Character one by one in end of sb
            sb.append(AlphaNumericString
                    .charAt(index));
        }


        Resource subject1 = model.createResource(namespace + "#"+sb.toString());
        Resource object1 = model.getResource(namespace + "#Patient");
        subject1.addProperty(RDF.type, object1);
        subject1.addProperty(
                model.getProperty(namespace + "#name"),
                MainFrame.getIme()+" "+MainFrame.getPrezime(),
                XSDDatatype.XSDstring);
        System.out.println(MainFrame.getBolestOdabrana());
        subject1.addProperty(
                model.getProperty(namespace + "#hasdisease"),
                MainFrame.getBolestOdabrana(),
                XSDDatatype.XSDstring);
        subject1.addProperty(
                model.getProperty(namespace + "#gottherapy"),
                therapy,
                XSDDatatype.XSDstring);



        try {
            OutputStream os = new FileOutputStream("data/diseasestherapies.ttl");
            RDFDataMgr.write(os, model, Lang.TURTLE);
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }




}
