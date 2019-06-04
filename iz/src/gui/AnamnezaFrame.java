package gui;


import model.Bolest;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import util.DiagnosisUtil;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

public class AnamnezaFrame {
    private JPanel anamnezaPanel;
    private JButton zavrsiButton;
    private JList list1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JComboBox cbPol;
    private JTextField tfSimptom;
    private JButton unesiButton;
    private JList listSimptom;
    private JPanel unetiSimPanel;
    private JButton izbaciButton;

    public AnamnezaFrame() {


        ArrayList<String> keywords = new ArrayList<String>();

        addElements(keywords);

        AutoCompleteDecorator.decorate(tfSimptom, keywords, false);

        cbPol.addItem("Male");
        cbPol.addItem("Female");

        DefaultListModel dlmSimptomi = new DefaultListModel();
        listSimptom.setModel(dlmSimptomi);

        zavrsiButton.addActionListener(new ActionListener() {
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

                JDialog dialog = MainFrame.getDialog();
                dialog.dispose();

                ArrayList<String> sms=new ArrayList<String>();
                for(int i=0 ; i<dlmSimptomi.getSize() ; i++){
                    sms.add(dlmSimptomi.get(i).toString());
                }
                MainFrame.setBolesti(DiagnosisUtil.findDiagnosis(sms,Integer.parseInt(textField4.getText()),String.valueOf(cbPol.getSelectedItem())));

                dialog.setTitle("Anamnesis");
                dialog.setContentPane(new ZavrsiAmnezuFrame().getZavrsiAmnezuPanel());
                dialog.setSize(600,400);
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
}
