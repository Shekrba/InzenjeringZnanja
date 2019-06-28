package gui;


import cbr.CbrApplication;
import com.ugos.jiprolog.engine.JIPEngine;
import com.ugos.jiprolog.engine.JIPQuery;
import com.ugos.jiprolog.engine.JIPTerm;
import com.ugos.jiprolog.engine.JIPVariable;
import model.Bolest;
import model.DodatanTest;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import util.DiagnosisUtil;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class AnamnezaFrame {
    private JPanel anamnezaPanel;
    private JButton zavrsiButton;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JComboBox cbPol;
    private JTextField tfSimptom;
    private JButton unesiButton;
    private JList listSimptom;
    private JPanel unetiSimPanel;
    private JButton izbaciButton;
    private JTextField tfFamilly;
    private JButton inputButton;
    private JList listFamilly;
    private JButton removeFamilly;
    private JButton bloodTestsButton;
    private JButton BMPButton;
    private JTextField tfHeight;
    private JTextField tfBPLow;
    private JTextField tfBPHigh;
    private JTextField tfWeight;
    private JTextField tfTemperature;
    private JButton similarityPastExaminationsButton;
    private JTextField tfId;
    private JButton importButton;
    private JList dhList;
    private JButton addButton;
    public static JDialog dialogBlood;
    public static int ID;


    public AnamnezaFrame() {

        ID = 0;

        ArrayList<String> keywords = new ArrayList<String>();
        ArrayList<String> keywordsFamilly = new ArrayList<String>();

        addElements(keywords);
        addElementsFamilly(keywordsFamilly);

        AutoCompleteDecorator.decorate(tfSimptom, keywords, false);
        AutoCompleteDecorator.decorate(tfFamilly, keywordsFamilly, false);

        cbPol.addItem("Male");
        cbPol.addItem("Female");

        DefaultListModel dlmSimptomi = new DefaultListModel();
        listSimptom.setModel(dlmSimptomi);

        DefaultListModel dlmFamilly = new DefaultListModel();
        listFamilly.setModel(dlmFamilly);

        DefaultListModel dlmDh = new DefaultListModel();
        dhList.setModel(dlmDh);

        zavrsiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String c = cbPol.getSelectedItem().toString();
                MainFrame.setPol(c);

                if(textField2.getText().trim().equals("")){
                    JOptionPane.showMessageDialog(null, "Please input patient's first name.");
                    return;
                }

                if(textField3.getText().trim().equals("")){
                    JOptionPane.showMessageDialog(null, "Please input patient's last name.");
                    return;
                }

                if(textField4.getText().trim().equals("")){
                    JOptionPane.showMessageDialog(null, "Please input patient's age.");
                    return;
                }

                try{
                    int go = Integer.parseInt(textField4.getText());
                    MainFrame.setGodine(go);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "You have to input a number in the field \"Age\".");
                    return;
                }

                if(dlmSimptomi.isEmpty()){
                    JOptionPane.showMessageDialog(null, "You have to input at least one symptom.");
                    return;
                }

                try{
                    if(!tfBPHigh.getText().trim().equals("") && !tfBPLow.getText().trim().equals("")) {
                        MainFrame.setPritisakHigh(Integer.parseInt(tfBPHigh.getText()));
                        MainFrame.setPritisakLow(Integer.parseInt(tfBPLow.getText()));
                    }
                    else if((!tfBPHigh.getText().trim().equals("") && tfBPLow.getText().trim().equals("")) || (tfBPHigh.getText().trim().equals("") && !tfBPLow.getText().trim().equals(""))) {
                        JOptionPane.showMessageDialog(null, "You have to input both blood pressure parameters or none.");
                        return;
                    }

                    if(tfHeight.getText().trim().equals("")) {
                        JOptionPane.showMessageDialog(null, "You have to input Height.");
                        return;
                    }

                    if(tfWeight.getText().trim().equals("")) {
                        JOptionPane.showMessageDialog(null, "You have to input Weight.");
                        return;
                    }

                    double height = Double.parseDouble(tfHeight.getText());
                    double weight = Double.parseDouble(tfWeight.getText());

                    double bmi = weight/Math.pow(height,2);

                    MainFrame.setBmi(bmi);

                    if(!tfTemperature.getText().trim().equals("")) {
                        MainFrame.setTemperatura(Double.parseDouble(tfTemperature.getText()));
                    }

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "You have to input numbers in Physical examination fields.");
                    return;
                }

                JDialog dialog = MainFrame.getDialog();
                dialog.dispose();

                MainFrame.getSimptomi().clear();
                for(int i=0 ; i<dlmSimptomi.getSize() ; i++){
                    MainFrame.getSimptomi().add(dlmSimptomi.get(i).toString());
                }

                ArrayList<String> sms=new ArrayList<String>();
                for(int i=0 ; i<dlmSimptomi.getSize() ; i++){
                    sms.add(dlmSimptomi.get(i).toString());
                }

                MainFrame.setBolesti(DiagnosisUtil.findDiagnosis(sms,Integer.parseInt(textField4.getText()),String.valueOf(cbPol.getSelectedItem())));

                String bolesi="";
                int brojac=0;
                for(Bolest boles : MainFrame.getBolesti()){
                    if(brojac>0)
                        bolesi+=",";
                    bolesi+=boles.getNaziv();
                    brojac++;
                }

                //dodatni testovi
                ArrayList<DodatanTest> dodatniTestovi=new ArrayList<>();
                JIPEngine engine = new JIPEngine();
                engine.consultFile("data/program.pl");
                JIPQuery query = engine.openSynchronousQuery("poklapanje_testova(["+bolesi+"],X,Y,Z)");
                JIPTerm solution;
                while ( (solution = query.nextSolution()) != null) {
                    DodatanTest dt=new DodatanTest();
                    for (JIPVariable var: solution.getVariables()) {
                        if(var.getName().equals("X")){
                            dt.setNaziv(var.getValue().toString());
                        }
                        if(var.getName().equals("Y")){
                            dt.setBrojPoklapanja(Integer.parseInt(var.getValue().toString()));
                        }
                    }
                    dodatniTestovi.add(dt);
                }

                MainFrame.setDodatniTestovi(dodatniTestovi);


                dialog.setTitle("Anamnesis");
                dialog.setContentPane(new ZavrsiAmnezuFrame().getZavrsiAmnezuPanel());
                dialog.setSize(900,600);
                dialog.setModal(true);
                dialog.setLocationRelativeTo(null);
                dialog.setVisible(true);
            }
        });
        unesiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String simptom = tfSimptom.getText();

                if(simptom.trim().equals("") || dlmSimptomi.contains(simptom))
                    return;

                if(!keywords.contains(simptom)){
                    JOptionPane.showMessageDialog(null,  "\""+simptom+"\" is not a valid symptom.");
                    return;
                }

                dlmSimptomi.addElement(simptom);

                tfSimptom.setText("");

            }
        });
        izbaciButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(listSimptom.getSelectedIndex() != -1)
                    dlmSimptomi.remove(listSimptom.getSelectedIndex());
            }
        });
        removeFamilly.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(listFamilly.getSelectedIndex() != -1)
                    dlmFamilly.remove(listFamilly.getSelectedIndex());
            }
        });
        inputButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String familly = tfFamilly.getText();

                if(familly.trim().equals("") || dlmFamilly.contains(familly))
                    return;


                dlmFamilly.addElement(familly);

                tfFamilly.setText("");
            }
        });
        bloodTestsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                dialogBlood = new JDialog();

                dialogBlood.setTitle("Blood tests");
                dialogBlood.setContentPane(new CBC().getBloodPanel());
                dialogBlood.setSize(600,400);
                dialogBlood.setModal(true);
                dialogBlood.setLocationRelativeTo(null);
                dialogBlood.setVisible(true);
            }
        });
        BMPButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dialogBlood = new JDialog();

                dialogBlood.setTitle("Blood tests");
                dialogBlood.setContentPane(new BMP().getBmp());
                dialogBlood.setSize(600,400);
                dialogBlood.setModal(true);
                dialogBlood.setLocationRelativeTo(null);
                dialogBlood.setVisible(true);
            }
        });
        similarityPastExaminationsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(textField2.getText().trim().equals("")){
                    JOptionPane.showMessageDialog(null, "Please input patient's first name.");
                    return;
                }

                if(textField3.getText().trim().equals("")){
                    JOptionPane.showMessageDialog(null, "Please input patient's last name.");
                    return;
                }

                if(textField4.getText().trim().equals("")){
                    JOptionPane.showMessageDialog(null, "Please input patient's age.");
                    return;
                }

                try{
                    Integer.parseInt(textField4.getText());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "You have to input a number in the field \"Age\".");
                    return;
                }

                if(dlmSimptomi.isEmpty()){
                    JOptionPane.showMessageDialog(null, "You have to input at least one symptom.");
                    return;
                }

                try{
                    if(!tfBPHigh.getText().trim().equals("") && !tfBPLow.getText().trim().equals("")) {
                        MainFrame.setPritisakHigh(Integer.parseInt(tfBPHigh.getText()));
                        MainFrame.setPritisakLow(Integer.parseInt(tfBPLow.getText()));
                    }
                    else if((!tfBPHigh.getText().trim().equals("") && tfBPLow.getText().trim().equals("")) || (tfBPHigh.getText().trim().equals("") && !tfBPLow.getText().trim().equals(""))) {
                        JOptionPane.showMessageDialog(null, "You have to input both blood pressure parameters or none.");
                        return;
                    }

                    if(tfHeight.getText().trim().equals("")) {
                        JOptionPane.showMessageDialog(null, "You have to input Height.");
                        return;
                    }

                    if(tfWeight.getText().trim().equals("")) {
                        JOptionPane.showMessageDialog(null, "You have to input Weight.");
                        return;
                    }

                    double height = Double.parseDouble(tfHeight.getText());
                    double weight = Double.parseDouble(tfWeight.getText());

                    double bmi = weight/Math.pow(height,2);

                    MainFrame.setBmi(bmi);

                    if(!tfTemperature.getText().trim().equals("")) {
                        MainFrame.setTemperatura(Double.parseDouble(tfTemperature.getText()));
                    }

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "You have to input numbers in Physical examination fields.");
                    return;
                }

                MainFrame.getSimptomi().clear();
                for(int i=0 ; i<dlmSimptomi.getSize() ; i++){
                    MainFrame.getSimptomi().add(dlmSimptomi.get(i).toString());
                }

                double height = Double.parseDouble(tfHeight.getText());
                double weight = Double.parseDouble(tfWeight.getText());

                double bmi = weight/Math.pow(height,2);

                MainFrame.setBmi(bmi);

                double temp=Double.parseDouble(tfTemperature.getText());
                MainFrame.setTemperatura(temp);

                int lowPritisak=Integer.parseInt(tfBPLow.getText());
                int highPritisak=Integer.parseInt(tfBPHigh.getText());
                MainFrame.setPritisakLow(lowPritisak);
                MainFrame.setPritisakHigh(highPritisak);

                int age=Integer.parseInt(textField4.getText());
                MainFrame.setGodine(age);

                CbrApplication cbr = new CbrApplication();

                boolean cbc=false;
                if(!(MainFrame.getCbc().getWhiteBloodCellCount()==0.0))
                    cbc=true;

                boolean bmp=false;
                if(!(MainFrame.getBmp().getGlucose()==0.0))
                    bmp=true;

                cbr.doCbr(MainFrame.getSimptomi(),cbc,bmp);

                JDialog dialog = MainFrame.getDialog();
                dialog.dispose();







                dialog.setTitle("Anamnesis");
                dialog.setContentPane(new CaseBaseFrame().getCaseBased());
                dialog.setSize(800,600);
                dialog.setModal(true);
                dialog.setLocationRelativeTo(null);
                dialog.setVisible(true);
            }
        });
        importButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Connection conn = null;

                try {

                    try {
                        if(tfId.getText().trim().equals("")){
                            JOptionPane.showMessageDialog(null, "ID cant be empty");
                            return;
                        }
                        ID = Integer.parseInt(tfId.getText());
                    }catch (Exception exep){
                        JOptionPane.showMessageDialog(null, "ID has to be a number");
                        return;
                    }

                    Class.forName("com.mysql.cj.jdbc.Driver");
                    conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/iz", "root", "1234");

                    String sql = "SELECT *  FROM patient WHERE id="+tfId.getText();

                    PreparedStatement preparedStatement = conn.prepareStatement(sql);
                    ResultSet resultSet = preparedStatement.executeQuery();

                    boolean found = false;

                    while (resultSet.next()) {

                        found = true;

                        textField2.setText(resultSet.getString("first_name"));
                        textField3.setText(resultSet.getString("last_name"));
                        textField4.setText(resultSet.getString("age"));
                        if (resultSet.getString("sex").equals("Male")) {
                            cbPol.setSelectedIndex(0);
                        } else if (resultSet.getString("sex").equals("Female")) {
                            cbPol.setSelectedIndex(1);
                        }
                    }

                    if (!found) {
                        JOptionPane.showMessageDialog(null, "No patient with id " + tfId.getText());
                        textField2.setText("");
                        textField3.setText("");
                        textField4.setText("");
                        cbPol.setSelectedIndex(0);
                        dlmDh.removeAllElements();
                        return;
                    }

                    sql = "SELECT *  FROM disease_history WHERE patient_id="+tfId.getText();

                    preparedStatement = conn.prepareStatement(sql);
                    resultSet = preparedStatement.executeQuery();

                    dlmDh.removeAllElements();

                    while (resultSet.next()) {
                        dlmDh.addElement(resultSet.getString("disease"));
                    }

                } catch(Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int age;
                int id;

                if(textField2.getText().trim().equals("")){
                    JOptionPane.showMessageDialog(null, "Please input patient's first name.");
                    return;
                }

                if(textField3.getText().trim().equals("")){
                    JOptionPane.showMessageDialog(null, "Please input patient's last name.");
                    return;
                }

                if(textField4.getText().trim().equals("")){
                    JOptionPane.showMessageDialog(null, "Please input patient's age.");
                    return;
                }

                try{
                    id = Integer.parseInt(tfId.getText());
                    age = Integer.parseInt(textField4.getText());

                    ID = id;
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "You have to input a number in the field \"ID\" and \"Age\".");
                    return;
                }

                Connection conn = null;

                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/iz", "root", "1234");

                    String sql = "INSERT INTO patient (id, first_name, last_name, age, sex) VALUES (?, ?, ?, ?, ?)";

                    PreparedStatement preparedStatement = conn.prepareStatement(sql);
                    preparedStatement.setInt(1,id);
                    preparedStatement.setString(2, textField2.getText());
                    preparedStatement.setString(3, textField3.getText());
                    preparedStatement.setInt(4, age);
                    preparedStatement.setString(5, cbPol.getSelectedItem().toString());
                    preparedStatement.executeUpdate();

                    JOptionPane.showMessageDialog(null, "Patient added to database");

                } catch(Exception ex) {
                    JOptionPane.showMessageDialog(null, "ID is already taken in database");
                }
            }
        });
    }

    public JPanel getAnamnezaPanel() {
        return anamnezaPanel;
    }

    public void setAnamnezaPanel(JPanel anamnezaPanel) {
        this.anamnezaPanel = anamnezaPanel;
    }

    public void addElements(ArrayList<String> keywords){
        keywords.add("Shortness of breath");
        keywords.add("Difficulty breathing");
        keywords.add("Cough");
        keywords.add("Sharp chest pain");
        keywords.add("Depressive or psychotic symptoms");
        keywords.add("Fever");
        keywords.add("Wheezing");
        keywords.add("Hurts to breath");
        keywords.add("Chest tightness");
        keywords.add("Chills");
        keywords.add("Coughing up sputum");
        keywords.add("Congestion in chest");
        keywords.add("Palpitations");
        keywords.add("Shortness of breath");
        keywords.add("Sharp chest pain");
        keywords.add("Difficulty breathing");
        keywords.add("Weakness");
        keywords.add("Fatigue");
        keywords.add("Chest tightness");
        keywords.add("Insomnia");
        keywords.add("Heartburn");
        keywords.add("Leg swelling");
        keywords.add("Fluid retention");
        keywords.add("Recent pregnancy");
        keywords.add("Sharp chest pain");
        keywords.add("Shortness of breath");
        keywords.add("Difficulty breathing");
        keywords.add("Palpitations");
        keywords.add("Dizziness");
        keywords.add("Fatigue");
        keywords.add("Chest tightness");
        keywords.add("Peripheral edema");
        keywords.add("Lymphedemia");
        keywords.add("Increased heart rate");
        keywords.add("Muscle pain");
        keywords.add("Throat feels tight");
        keywords.add("Weight gain");
        keywords.add("Thirst");
        keywords.add("Symptoms of the kidneys");
        keywords.add("Fatigue");
        keywords.add("Weakness");
        keywords.add("Dizziness");
        keywords.add("Shortness of breath");
        keywords.add("Nosebleed");
        keywords.add("Heavy menstrual flow");
        keywords.add("Melena");
        keywords.add("Unpredictable menstruation");
        keywords.add("Vomiting blood");
        keywords.add("Changes in stool appearance");
        keywords.add("Recent pregnancy");
        keywords.add("Too little hair");
        keywords.add("Leg pain");
        keywords.add("Leg swelling");
        keywords.add("Nosebleed");
        keywords.add("Blood in urine");
        keywords.add("Eye redness");
        keywords.add("Melena");
        keywords.add("Lymphedema");
        keywords.add("Hemoptysis");
        keywords.add("Leg cramps or spasms");
        keywords.add("Early or late onset of menopause");
        keywords.add("Knee swelling");
        keywords.add("Vaginal pain");
        keywords.add("Sharp abdominal pain");
        keywords.add("Abusing alcohol");
        keywords.add("Drug abuse");
        keywords.add("Melena");
        keywords.add("Stomach bloating");
        keywords.add("Symptoms of the kidneys");
        keywords.add("Hand or finger stiffness or tightness");
        keywords.add("Low self esteem");
        keywords.add("Incontinence of stool");
        keywords.add("Sharp chest pain");
        keywords.add("Sharp abdominal pain");
        keywords.add("Vomiting");
        keywords.add("Heartburn");
        keywords.add("Cough");
        keywords.add("Nausea");
        keywords.add("Burning abdominal pain");
        keywords.add("Upper abdominal pain");
        keywords.add("Difficulty in swallowing");
        keywords.add("Regurgitation");
        keywords.add("Chest tightness");
        keywords.add("Hoarse voice");
        keywords.add("Constipation");
        keywords.add("Sharp abdominal pain");
        keywords.add("Burning abdominal pain");
        keywords.add("Vomiting");
        keywords.add("Nausea");
        keywords.add("Lower abdominal pain");
        keywords.add("Rectal bleeding");
        keywords.add("Blood in stool");
        keywords.add("Pain of the anus");
        keywords.add("Retention of urine");
        keywords.add("Stomach bloating");
        keywords.add("Changes in stool appearance");
        keywords.add("Sharp chest pain");
        keywords.add("Shortness of breath");
        keywords.add("Chest tightness");
        keywords.add("Cough");
        keywords.add("Nausea");
        keywords.add("Ache all over");
        keywords.add("Back pain");
        keywords.add("Cross eyed");
        keywords.add("Itchy eyelid");
        keywords.add("Excessive growth");
        keywords.add("Emotional symptoms");
        keywords.add("Elbow cramps or spasms");
        keywords.add("Painful urination");
        keywords.add("Suprapubic pain");
        keywords.add("Sharp abdominal pain");
        keywords.add("Frequent urination");
        keywords.add("Fever");
        keywords.add("Vomiting");
        keywords.add("Back pain");
        keywords.add("Nausea");
        keywords.add("Blood in urine");
        keywords.add("Side pain");
        keywords.add("Retention of urine");
        keywords.add("Lower abdominal pain");
        keywords.add("Disturbance of memory");
        keywords.add("Problems with movement");
        keywords.add("Dizziness");
        keywords.add("Depressive or psychotic symptoms");
        keywords.add("Abnormal involuntary movements");
        keywords.add("Paresthesia");
        keywords.add("Hostile behavior");
        keywords.add("Delusions or hallucinations");
        keywords.add("Difficulty speaking");
        keywords.add("Insomnia");
        keywords.add("Disturbance of smell or taste");
        keywords.add("Focal weakness");
        keywords.add("Sharp chest pain");
        keywords.add("Weight gain");
        keywords.add("Lymphedema");
        keywords.add("Smoking problems");
        keywords.add("Leg cramps or spasms");
        keywords.add("Shortness of breath");
        keywords.add("Sharp chest pain");
        keywords.add("Fatigue");
        keywords.add("Peripheral edema");
        keywords.add("Palpitations");
        keywords.add("Chest tightness");
        keywords.add("Weight gain");
        keywords.add("Irregular heartbeat");
        keywords.add("Heartburn");
        keywords.add("Excessive urination at night");
        keywords.add("Decreased heart rate");
        keywords.add("Muscle weakness");
        keywords.add("Cough");
        keywords.add("Shortness of breath");
        keywords.add("Hemoptysis");
        keywords.add("Difficulty breathing");
        keywords.add("Coughing up sputum");
        keywords.add("Nasal congestion");
        keywords.add("Coryza");
        keywords.add("Sore throat");
        keywords.add("Fever");
        keywords.add("Fatigue");
        keywords.add("Drainage in throat");
        keywords.add("Fluid retention");
        keywords.add("Sharp abdominal pain");
        keywords.add("Diarrhea");
        keywords.add("Regurgitation");
        keywords.add("Fatigue");
        keywords.add("Vomiting");
        keywords.add("Nausea");
        keywords.add("Allergic reaction");
        keywords.add("Sharp chest pain");
        keywords.add("Fears and phobias");
        keywords.add("Peripheral edema");
        keywords.add("Leg lump or mass");
        keywords.add("Constipation");
        keywords.add("Sharp abdominal pain");
        keywords.add("Vomiting");
        keywords.add("Nausea");
        keywords.add("Burning abdominal pain");
        keywords.add("Sharp chest pain");
        keywords.add("Upper abdominal pain");
        keywords.add("Diarrhea");
        keywords.add("Fever");
        keywords.add("Headache");
        keywords.add("Heartburn");
        keywords.add("Vomiting blood");
        keywords.add("Regurgitation");
        keywords.add("Sharp abdominal pain");
        keywords.add("Shortness of breath");
        keywords.add("Peripheral edema");
        keywords.add("Fatigue");
        keywords.add("Upper abdominal pain");
        keywords.add("Abdominal distention");
        keywords.add("Stomach bloating");
        keywords.add("Blood in stool");
        keywords.add("Regurgitation");
        keywords.add("Symptoms of the kidneys");
        keywords.add("Vomiting blood");
        keywords.add("Melena");
        keywords.add("Weakness");
        keywords.add("Vomiting");
        keywords.add("Nausea");
        keywords.add("Shortness of breath");
        keywords.add("Dizziness");
        keywords.add("Sharp abdominal pain");
        keywords.add("Sharp chest pain");
        keywords.add("Headache");
        keywords.add("Back pain");
        keywords.add("Fever");
        keywords.add("Fainting");
        keywords.add("Seizures");
        keywords.add("Seizures");
        keywords.add("Problems with movement");
        keywords.add("Cramps and spasms");
        keywords.add("Difficulty eating");
        keywords.add("Lack of growth");
        keywords.add("Leg cramps or spasms");
        keywords.add("Back cramps or spasms");
        keywords.add("Blindness");
        keywords.add("Infant feeding problem");
        keywords.add("Swollen tongue");
        keywords.add("Lip sore");
        keywords.add("Tongue lesions");
        keywords.add("Fatigue");
        keywords.add("Shoulder pain");
        keywords.add("Leg pain");
        keywords.add("Ache all over");
        keywords.add("Sharp chest pain");
        keywords.add("Muscle pain");
        keywords.add("Hip pain");
        keywords.add("Irregular heartbeat");
        keywords.add("Leg weakness");
        keywords.add("Stiffness all over");
        keywords.add("Difficulty in swallowing");
        keywords.add("Temper problems");
        keywords.add("Palpitations");
        keywords.add("Ache all over");
        keywords.add("Cough");
        keywords.add("Chest tightness");
        keywords.add("Fever");
        keywords.add("Sharp chest pain");
        keywords.add("Weakness");
        keywords.add("Diarrhea");
        keywords.add("Headache");
        keywords.add("Difficulty breathing");
        keywords.add("Dizziness");
        keywords.add("Coughing up sputum");
        keywords.add("Headache");
        keywords.add("Fever");
        keywords.add("Vomiting");
        keywords.add("Neck pain");
        keywords.add("Ache all over");
        keywords.add("Back pain");
        keywords.add("Seizures");
        keywords.add("Nausea");
        keywords.add("Low back pain");
        keywords.add("Cough");
        keywords.add("Leg pain");
        keywords.add("Neck stiffness or tightness");
        keywords.add("Fatigue");
        keywords.add("Loss of sensation");
        keywords.add("Headache");
        keywords.add("Dizziness");
        keywords.add("Problems with movement");
        keywords.add("Weakness");
        keywords.add("Leg weakness");
        keywords.add("Paresthesia");
        keywords.add("Disturbance of memory");
        keywords.add("Abnormal involuntary movements");
        keywords.add("Leg stiffness or tightness");
        keywords.add("Focal weakness");
        keywords.add("Abnormal involuntary movements");
        keywords.add("Problems with movement");
        keywords.add("Disturbance of memory");
        keywords.add("Dizziness");
        keywords.add("Weakness");
        keywords.add("Stiffness all over");
        keywords.add("Leg weakness");
        keywords.add("Focal weakness");
        keywords.add("Muscle stiffness or tightness");
        keywords.add("Difficulty speaking");
        keywords.add("Leg stiffness or tightness");
        keywords.add("Fears and phobias");
        keywords.add("Headache");
        keywords.add("Loss of sensation");
        keywords.add("Seizures");
        keywords.add("Dizziness");
        keywords.add("Leg pain");
        keywords.add("Fatigue");
        keywords.add("Disturbance of memory");
        keywords.add("Problems with movement");
        keywords.add("Paresthesia");
        keywords.add("Joint pain");
        keywords.add("Leg weakness");
        keywords.add("Focal weakness");
        keywords.add("Loss of sensation");
        keywords.add("Symptoms of the face");
        keywords.add("Headache");
        keywords.add("Facial pain");
        keywords.add("Weakness");
        keywords.add("Peripheral edema");
        keywords.add("Symptoms of eye");
        keywords.add("Paresthesia");
        keywords.add("Diminished vision");
        keywords.add("Eyelid lesion or rash");
        keywords.add("Abnormal involuntary movements");
    }

    public void addElementsFamilly(ArrayList<String> keywordsFamilly){
        keywordsFamilly.add("myocarditis");
        keywordsFamilly.add("meningitis");
        keywordsFamilly.add("urinary_tract_infection");
        keywordsFamilly.add("acute_respiratory_distress_syndrome");
        keywordsFamilly.add("viral_hepatitis");
        keywordsFamilly.add("cardiomyopathy");
        keywordsFamilly.add("ischemic_heart_disease");
        keywordsFamilly.add("hypertensive_heart_disease");
        keywordsFamilly.add("hyponatremia");
        keywordsFamilly.add("diabetes");
        keywordsFamilly.add("anemia");
        keywordsFamilly.add("gastroesophageal_reflux_disease_gerd");
        keywordsFamilly.add("emphysema");
        keywordsFamilly.add("celiac_disease");
        keywordsFamilly.add("gastritis");
        keywordsFamilly.add("cirrhosis");
        keywordsFamilly.add("cerebral_palsy");
        keywordsFamilly.add("multiple_sclerosis");
        keywordsFamilly.add("acute_pancreatitis");
        keywordsFamilly.add("the_pancreatic_cancer");
    }

    public JDialog getDialogBlood() {
        return dialogBlood;
    }

    public void setDialogBlood(JDialog dialogBlood) {
        this.dialogBlood = dialogBlood;
    }



}
