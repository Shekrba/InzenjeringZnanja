package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;

public class TerapijaFrame {
    private JPanel terapijaPanel;
    private JButton prepisi1;
    private JButton prepisi2;
    private JButton prepisi3;
    private JButton prepisi4;

    public TerapijaFrame() {

//simptomi sa upitnikom, temperatura, presure high, low, bmi, rbc count, hemoglobin, hematocrit, whitebloodcell count, plete, glucose, calc, sodium, potas
        //urea, crat, bili, godine, pol, bolest
        prepisi1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            int option = JOptionPane.showConfirmDialog(null, "Are you prescribing this procedure?", "Therapy", JOptionPane.YES_NO_CANCEL_OPTION);
            if(option == JOptionPane.YES_OPTION) {
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
        });
        prepisi2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int option = JOptionPane.showConfirmDialog(null, "Are you prescribing this procedure?", "Therapy", JOptionPane.YES_NO_CANCEL_OPTION);
                if(option == JOptionPane.YES_OPTION) {
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
                }            }
        });
        prepisi3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int option = JOptionPane.showConfirmDialog(null, "Are you prescribing this procedure?", "Therapy", JOptionPane.YES_NO_CANCEL_OPTION);
                if(option == JOptionPane.YES_OPTION) {
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
        });
        prepisi4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int option = JOptionPane.showConfirmDialog(null, "Are you prescribing this procedure?", "Therapy", JOptionPane.YES_NO_CANCEL_OPTION);
                if(option == JOptionPane.YES_OPTION) {
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
        });
        prepisi5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int option = JOptionPane.showConfirmDialog(null, "Are you prescribing this procedure?", "Therapy", JOptionPane.YES_NO_CANCEL_OPTION);
                if(option == JOptionPane.YES_OPTION) {
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
                    s+="\n";

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
                   /*
                    try {
                        Writer writer = null;
                        //create a temporary file
                        File logFile = new File("data\\results.csv");

                        // This will output the full path where the file will be written to...

                        writer = new BufferedWriter(new FileWriter(logFile));
                        writer.write(s);

                        writer.close();

                    } catch (Exception e1) {
                        e1.printStackTrace();
                    } finally {
                        try {
                            // Close the writer regardless of what happens...
                        } catch (Exception e1) {
                        }
                    }*/
                }
            }
        });
    }

    private JButton prepisi5;

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
}
