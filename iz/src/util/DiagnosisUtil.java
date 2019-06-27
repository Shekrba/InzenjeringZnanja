package util;

import com.ugos.jiprolog.engine.JIPEngine;
import com.ugos.jiprolog.engine.JIPQuery;
import com.ugos.jiprolog.engine.JIPTerm;
import com.ugos.jiprolog.engine.JIPVariable;
import gui.MainFrame;
import model.BMP;
import model.Bolest;
import model.CBC;
import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.JFuzzyLogic;
import net.sourceforge.jFuzzyLogic.rule.Variable;
import unbbayes.io.BaseIO;
import unbbayes.io.NetIO;
import unbbayes.prs.Edge;
import unbbayes.prs.Node;
import unbbayes.prs.bn.JunctionTreeAlgorithm;
import unbbayes.prs.bn.PotentialTable;
import unbbayes.prs.bn.ProbabilisticNetwork;
import unbbayes.prs.bn.ProbabilisticNode;
import unbbayes.util.extension.bn.inference.IInferenceAlgorithm;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DiagnosisUtil {

    public static ArrayList<Bolest> findDiagnosis(ArrayList<String> simptomi,int age,String pol){
        ArrayList<Bolest> ret=new ArrayList<>();

        String symptoms="";
        int i=0;
        for (String s:
             simptomi) {
            String str=s.toLowerCase();
            String strs=str.replaceAll(" ","_");
            if(i!=0)
                symptoms+=","+strs;
            else
                symptoms+=strs;
            i++;
        }
        //consult prologue file for matching symptoms
        JIPEngine engine = new JIPEngine();

        engine.consultFile("data/program.pl");
        JIPQuery query = engine.openSynchronousQuery("poklapanje_simptoma(["+symptoms+"],X,Y,Z)");


        JIPTerm solution;
        while ( (solution = query.nextSolution()) != null) {
            ArrayList<String> symp=new ArrayList<>();
            Bolest b=new Bolest();
            for (JIPVariable var: solution.getVariables()) {
                if(var.getName().equals("Z")) {
                    String parsedStr = var.getValue().toString().replaceAll("[.'()\\[\\]]+","");
                    if(parsedStr.length()>0) {
                        parsedStr = parsedStr.substring(0, parsedStr.length() - 1);
                        String[] split=parsedStr.split(",");
                        for (String s:
                             split) {
                            symp.add(s);
                        }

                    }
                }
                b.setSimptomi(symp);
                if(var.getName().equals("X")){
                    b.setNaziv(var.getValue().toString());
                }
                if(var.getName().equals("Y")){
                    int flag=Integer.parseInt(var.getValue().toString());
                    b.setPoklapanje(flag);
                }
            }

            b.setProcenat(calculateProb(b,age,pol));
            if(b.getPoklapanje()!=0)
                ret.add(b);
        }


        return ret;
    }

    /*
    Metoda sracunava verovatnocu bolesti pomocu BN. Fuzzy logika povecava odnosno smanjuje verovatnocu
    na osnovu unetih nalaza krvi. Godine, krvni pritisak, pol kao i temperatura takodje uticu na rezultat.
     */
    private static int calculateProb(Bolest b,int age,String pol){

        int ret=0;

        ProbabilisticNetwork net;
        // loading from file

        try {
            BaseIO io=new NetIO();
            net = (ProbabilisticNetwork)io.load(new File("data/BNs/"+b.getNaziv()+".net"));


            //change strating probibility based on age and sex
            JIPEngine engine = new JIPEngine();
            engine.consultFile("data/program.pl");
            JIPQuery query;
            if(pol.equals("Male")) {
                query = engine.openSynchronousQuery("sex_factor(" + b.getNaziv() + ",male,X)");
            }else{
                query = engine.openSynchronousQuery("sex_factor(" + b.getNaziv() + ",female,X)");
            }
            JIPTerm solution;
            while ( (solution = query.nextSolution()) != null) {
                for(JIPVariable var : solution.getVariables()){
                    ProbabilisticNode bolestNode = (ProbabilisticNode)net.getNode(b.getNaziv());
                    PotentialTable bolestProb=bolestNode.getProbabilityFunction();
                    bolestProb.setValue(0,bolestProb.getValue(0)*Float.parseFloat(var.getValue().toString()));
                    bolestProb.setValue(1,1-bolestProb.getValue(0));
                }
            }
            JIPQuery query1;
            if(age<=1) {
                query1 = engine.openSynchronousQuery("ages_factor(" + b.getNaziv() + ",0,1,X)");
            }else if(age>1 && age<=4){
                query1 = engine.openSynchronousQuery("ages_factor(" + b.getNaziv() + ",1,4,X)");
            }else if(age>4 && age<=14){
                query1 = engine.openSynchronousQuery("ages_factor(" + b.getNaziv() + ",5,14,X)");
            }else if(age>14 && age<=29){
                query1 = engine.openSynchronousQuery("ages_factor(" + b.getNaziv() + ",15,29,X)");
            }else if(age>29 && age<=44){
                query1 = engine.openSynchronousQuery("ages_factor(" + b.getNaziv() + ",30,44,X)");
            }else if(age>44 && age<=59){
                query1 = engine.openSynchronousQuery("ages_factor(" + b.getNaziv() + ",45,59,X)");
            }else if(age>59 && age<=74){
                query1 = engine.openSynchronousQuery("ages_factor(" + b.getNaziv() + ",60,74,X)");
            }else {
                query1 = engine.openSynchronousQuery("ages_factor(" + b.getNaziv() + ",75,150,X)");
            }

            JIPTerm solution1;
            while ( (solution1 = query1.nextSolution()) != null) {
                for(JIPVariable var : solution1.getVariables()){

                    ProbabilisticNode bolestNode = (ProbabilisticNode)net.getNode(b.getNaziv());
                    PotentialTable bolestProb=bolestNode.getProbabilityFunction();
                    bolestProb.setValue(0,bolestProb.getValue(0)*Float.parseFloat(var.getValue().toString()));
                    bolestProb.setValue(1,1-bolestProb.getValue(0));

                }
            }



            CBC cbc= MainFrame.getCbc();
            //ako je cbc test unet
            if(cbc.getWhiteBloodCellCount()!=0.0) {
                String[] args = new String[]{"-noCharts", "-e", "fuzzy/fcl/cbc"+pol+".fcl", "" + cbc.getHematocrit(), "" + cbc.getHemoglobin(), "" + cbc.getPlatelet(), "" + cbc.getRedBloodCellCount(), "" + cbc.getWhiteBloodCellCount()};
                JFuzzyLogic jFuzzyLogic = new JFuzzyLogic(args);
                jFuzzyLogic.run();
                FIS fis = jFuzzyLogic.getFis();

                //anemia
                Variable anemia=fis.getVariable("anemia");
                if(b.getNaziv().equals("anemia")) {
                    ProbabilisticNode anemiaNode = (ProbabilisticNode) net.getNode("anemia");
                    if (anemia.getValue() < 0) {
                        PotentialTable bolestProb = anemiaNode.getProbabilityFunction();
                        bolestProb.setValue(0, bolestProb.getValue(0) * (float) 0.5);
                        bolestProb.setValue(1, 1 - bolestProb.getValue(0));
                    } else {
                        PotentialTable bolestProb = anemiaNode.getProbabilityFunction();
                        bolestProb.setValue(0, bolestProb.getValue(0) + (float) anemia.getValue() / 100);
                        bolestProb.setValue(1, 1 - bolestProb.getValue(0));
                    }
                }




                //heart diseases
                boolean flagHD=false;
                JIPQuery queryHD1=engine.openSynchronousQuery("heart(X)");
                JIPTerm solutionHD1;
                while ( (solutionHD1 = queryHD1.nextSolution()) != null) {
                    if(solutionHD1.getVariables()[0].getValue().toString().equals(b.getNaziv())){
                        flagHD=true;
                        break;
                    }
                }
                if(flagHD) {
                    Variable heartDisease = fis.getVariable("heart_desease");
                    ProbabilisticNode bolestNode = (ProbabilisticNode) net.getNode(b.getNaziv());
                    if (heartDisease.getValue() < 0) {
                        PotentialTable bolestProb = bolestNode.getProbabilityFunction();
                        bolestProb.setValue(0, bolestProb.getValue(0) * (float) 0.5);
                        bolestProb.setValue(1, 1 - bolestProb.getValue(0));
                    } else {
                        PotentialTable bolestProb = bolestNode.getProbabilityFunction();
                        bolestProb.setValue(0, bolestProb.getValue(0) + (float) heartDisease.getValue() / (10*10));
                        bolestProb.setValue(1, 1 - bolestProb.getValue(0));
                    }

                }

                //autoimune diseases
                boolean flagAI=false;
                JIPQuery queryAI1=engine.openSynchronousQuery("autoimune(X)");
                JIPTerm solutionAI1;
                while ( (solutionAI1 = queryAI1.nextSolution()) != null) {
                    if(solutionAI1.getVariables()[0].getValue().toString().equals(b.getNaziv())){
                        flagAI=true;
                        break;
                    }
                }
                if(flagAI) {
                    Variable autoimuneDisease = fis.getVariable("autoimune");
                    ProbabilisticNode bolestNode = (ProbabilisticNode) net.getNode(b.getNaziv());
                    if (autoimuneDisease.getValue() < 0) {
                        PotentialTable bolestProb = bolestNode.getProbabilityFunction();
                        bolestProb.setValue(0, bolestProb.getValue(0) * (float) 0.5);
                        bolestProb.setValue(1, 1 - bolestProb.getValue(0));
                    } else {
                        PotentialTable bolestProb = bolestNode.getProbabilityFunction();
                        bolestProb.setValue(0, bolestProb.getValue(0) + (float) autoimuneDisease.getValue() / (10*10));
                        bolestProb.setValue(1, 1 - bolestProb.getValue(0));
                    }

                }

                //cancer diseases
                boolean flagC=false;
                JIPQuery queryC1=engine.openSynchronousQuery("cancer(X)");
                JIPTerm solutionC1;
                while ( (solutionC1 = queryC1.nextSolution()) != null) {
                    if(solutionC1.getVariables()[0].getValue().toString().equals(b.getNaziv())){
                        flagC=true;
                        break;
                    }
                }
                if(flagC) {
                    Variable cancerDisease = fis.getVariable("cancer");
                    ProbabilisticNode bolestNode = (ProbabilisticNode) net.getNode(b.getNaziv());
                    if (cancerDisease.getValue() < 0) {
                        PotentialTable bolestProb = bolestNode.getProbabilityFunction();
                        bolestProb.setValue(0, bolestProb.getValue(0) * (float) 0.5);
                        bolestProb.setValue(1, 1 - bolestProb.getValue(0));
                    } else {
                        PotentialTable bolestProb = bolestNode.getProbabilityFunction();
                        bolestProb.setValue(0, bolestProb.getValue(0) + (float) cancerDisease.getValue() / (10*10));
                        bolestProb.setValue(1, 1 - bolestProb.getValue(0));
                    }

                }



                //infection diseases
                boolean flagINF=false;
                JIPQuery queryINF1=engine.openSynchronousQuery("infekcija(X)");
                JIPTerm solutionINF1;
                while ( (solutionINF1 = queryINF1.nextSolution()) != null) {
                    if(solutionINF1.getVariables()[0].getValue().toString().equals(b.getNaziv())){
                        flagINF=true;
                        break;
                    }
                }
                if(flagINF) {
                    Variable infectionDisease = fis.getVariable("infections");
                    ProbabilisticNode bolestNode = (ProbabilisticNode) net.getNode(b.getNaziv());
                    if (infectionDisease.getValue() < 0) {
                        PotentialTable bolestProb = bolestNode.getProbabilityFunction();
                        bolestProb.setValue(0, bolestProb.getValue(0) * (float) 0.5);
                        bolestProb.setValue(1, 1 - bolestProb.getValue(0));
                    } else {
                        PotentialTable bolestProb = bolestNode.getProbabilityFunction();
                        bolestProb.setValue(0, bolestProb.getValue(0) + (float) infectionDisease.getValue() / (10*10));
                        bolestProb.setValue(1, 1 - bolestProb.getValue(0));
                    }

                }


            }



            BMP bmp= MainFrame.getBmp();
            //ako je bmp test unet
            if(bmp.getCalcium()!=0.0) {

                String[] args = new String[]{"-noCharts", "-e", "fuzzy/fcl/bmp"+pol+".fcl", "" + bmp.getBilirubin(), "" + bmp.getCalcium(), "" + bmp.getCreatinine(), "" + bmp.getGlucose(), "" + bmp.getPotassium(), "" + bmp.getSodium(), "" + bmp.getUrea()};
                JFuzzyLogic jFuzzyLogic = new JFuzzyLogic(args);
                jFuzzyLogic.run();
                FIS fis = jFuzzyLogic.getFis();


                //kidney disease
                boolean flagKD=false;
                JIPQuery queryKD1=engine.openSynchronousQuery("kidney(X)");
                JIPTerm solutionKD1;
                while ( (solutionKD1 = queryKD1.nextSolution()) != null) {
                    if(solutionKD1.getVariables()[0].getValue().toString().equals(b.getNaziv())){
                        flagKD=true;
                        break;
                    }
                }
                if(flagKD) {
                    Variable kidneyDisease = fis.getVariable("kidney");
                    ProbabilisticNode bolestNode = (ProbabilisticNode) net.getNode(b.getNaziv());
                    if (kidneyDisease.getValue() < 0) {
                        PotentialTable bolestProb = bolestNode.getProbabilityFunction();
                        bolestProb.setValue(0, bolestProb.getValue(0) * (float) 0.5);
                        bolestProb.setValue(1, 1 - bolestProb.getValue(0));
                    } else {
                        PotentialTable bolestProb = bolestNode.getProbabilityFunction();
                        bolestProb.setValue(0, bolestProb.getValue(0) + (float) kidneyDisease.getValue() / (10*10));
                        bolestProb.setValue(1, 1 - bolestProb.getValue(0));
                    }

                }




                //liver disease
                boolean flagLD=false;
                JIPQuery queryLD1=engine.openSynchronousQuery("liver(X)");
                JIPTerm solutionLD1;
                while ( (solutionLD1 = queryLD1.nextSolution()) != null) {
                    if(solutionLD1.getVariables()[0].getValue().toString().equals(b.getNaziv())){
                        flagLD=true;
                        break;
                    }
                }
                if(flagLD) {
                    Variable liverDisease = fis.getVariable("liver");
                    ProbabilisticNode bolestNode = (ProbabilisticNode) net.getNode(b.getNaziv());
                    if (liverDisease.getValue() < 0) {
                        PotentialTable bolestProb = bolestNode.getProbabilityFunction();
                        bolestProb.setValue(0, bolestProb.getValue(0) * (float) 0.5);
                        bolestProb.setValue(1, 1 - bolestProb.getValue(0));
                    } else {
                        PotentialTable bolestProb = bolestNode.getProbabilityFunction();
                        bolestProb.setValue(0, bolestProb.getValue(0) + (float) liverDisease.getValue() / (10*10));
                        bolestProb.setValue(1, 1 - bolestProb.getValue(0));
                    }

                }

                //pancreatitis disease
                boolean flagPC=false;
                JIPQuery queryPC1=engine.openSynchronousQuery("pancreatitis(X)");
                JIPTerm solutionPC1;
                while ( (solutionPC1 = queryPC1.nextSolution()) != null) {
                    if(solutionPC1.getVariables()[0].getValue().toString().equals(b.getNaziv())){
                        flagPC=true;
                        break;
                    }
                }
                if(flagPC) {
                    Variable pancreatitisDisease = fis.getVariable("pankreatitis");
                    ProbabilisticNode bolestNode = (ProbabilisticNode) net.getNode(b.getNaziv());
                    if (pancreatitisDisease.getValue() < 0) {
                        PotentialTable bolestProb = bolestNode.getProbabilityFunction();
                        bolestProb.setValue(0, bolestProb.getValue(0) * (float) 0.5);
                        bolestProb.setValue(1, 1 - bolestProb.getValue(0));
                    } else {
                        PotentialTable bolestProb = bolestNode.getProbabilityFunction();
                        bolestProb.setValue(0, bolestProb.getValue(0) + (float) pancreatitisDisease.getValue() / (10*10));
                        bolestProb.setValue(1, 1 - bolestProb.getValue(0));
                    }

                }



                //diabetes
                boolean flagDB=false;
                JIPQuery queryDB1=engine.openSynchronousQuery("diabetes(X)");
                JIPTerm solutionDB1;
                while ( (solutionDB1 = queryDB1.nextSolution()) != null) {
                    if(solutionDB1.getVariables()[0].getValue().toString().equals(b.getNaziv())){
                        flagDB=true;
                        break;
                    }
                }
                if(flagDB) {
                    Variable kidneyDisease = fis.getVariable("diabetes");
                    ProbabilisticNode bolestNode = (ProbabilisticNode) net.getNode(b.getNaziv());
                    if (kidneyDisease.getValue() < 0) {
                        PotentialTable bolestProb = bolestNode.getProbabilityFunction();
                        bolestProb.setValue(0, bolestProb.getValue(0) * (float) 0.5);
                        bolestProb.setValue(1, 1 - bolestProb.getValue(0));
                    } else {
                        PotentialTable bolestProb = bolestNode.getProbabilityFunction();
                        bolestProb.setValue(0, bolestProb.getValue(0) + (float) kidneyDisease.getValue() / (10*10));
                        bolestProb.setValue(1, 1 - bolestProb.getValue(0));
                    }

                }



                //heart diseases
                boolean flagHD=false;
                JIPQuery queryHD1=engine.openSynchronousQuery("heart(X)");
                JIPTerm solutionHD1;
                while ( (solutionHD1 = queryHD1.nextSolution()) != null) {
                    if(solutionHD1.getVariables()[0].getValue().toString().equals(b.getNaziv())){
                        flagHD=true;
                        break;
                    }
                }
                if(flagHD) {
                    Variable heartDisease = fis.getVariable("heart_desease");
                    ProbabilisticNode bolestNode = (ProbabilisticNode) net.getNode(b.getNaziv());
                    if (heartDisease.getValue() < 0) {
                        PotentialTable bolestProb = bolestNode.getProbabilityFunction();
                        bolestProb.setValue(0, bolestProb.getValue(0) * (float) 0.5);
                        bolestProb.setValue(1, 1 - bolestProb.getValue(0));
                    } else {
                        PotentialTable bolestProb = bolestNode.getProbabilityFunction();
                        bolestProb.setValue(0, bolestProb.getValue(0) + (float) heartDisease.getValue() / (10*10));
                        bolestProb.setValue(1, 1 - bolestProb.getValue(0));
                    }

                }



                //autoimune diseases
                boolean flagAI=false;
                JIPQuery queryAI1=engine.openSynchronousQuery("autoimune(X)");
                JIPTerm solutionAI1;
                while ( (solutionAI1 = queryAI1.nextSolution()) != null) {
                    if(solutionAI1.getVariables()[0].getValue().toString().equals(b.getNaziv())){
                        flagAI=true;
                        break;
                    }
                }
                if(flagAI) {
                    Variable autoimuneDisease = fis.getVariable("autoimune");
                    ProbabilisticNode bolestNode = (ProbabilisticNode) net.getNode(b.getNaziv());
                    if (autoimuneDisease.getValue() < 0) {
                        PotentialTable bolestProb = bolestNode.getProbabilityFunction();
                        bolestProb.setValue(0, bolestProb.getValue(0) * (float) 0.5);
                        bolestProb.setValue(1, 1 - bolestProb.getValue(0));
                    } else {
                        PotentialTable bolestProb = bolestNode.getProbabilityFunction();
                        bolestProb.setValue(0, bolestProb.getValue(0) + (float) autoimuneDisease.getValue() / (10*10));
                        bolestProb.setValue(1, 1 - bolestProb.getValue(0));
                    }

                }

                //cancer diseases
                boolean flagC=false;
                JIPQuery queryC1=engine.openSynchronousQuery("cancer(X)");
                JIPTerm solutionC1;
                while ( (solutionC1 = queryC1.nextSolution()) != null) {
                    if(solutionC1.getVariables()[0].getValue().toString().equals(b.getNaziv())){
                        flagC=true;
                        break;
                    }
                }
                if(flagC) {
                    Variable cancerDisease = fis.getVariable("cancer");
                    ProbabilisticNode bolestNode = (ProbabilisticNode) net.getNode(b.getNaziv());
                    if (cancerDisease.getValue() < 0) {
                        PotentialTable bolestProb = bolestNode.getProbabilityFunction();
                        bolestProb.setValue(0, bolestProb.getValue(0) * (float) 0.5);
                        bolestProb.setValue(1, 1 - bolestProb.getValue(0));
                    } else {
                        PotentialTable bolestProb = bolestNode.getProbabilityFunction();
                        bolestProb.setValue(0, bolestProb.getValue(0) + (float) cancerDisease.getValue() / (10*10));
                        bolestProb.setValue(1, 1 - bolestProb.getValue(0));
                    }

                }



                //infection diseases
                boolean flagINF=false;
                JIPQuery queryINF1=engine.openSynchronousQuery("infekcija(X)");
                JIPTerm solutionINF1;
                while ( (solutionINF1 = queryINF1.nextSolution()) != null) {
                    if(solutionINF1.getVariables()[0].getValue().toString().equals(b.getNaziv())){
                        flagINF=true;
                        break;
                    }
                }
                if(flagINF) {
                    Variable infectionDisease = fis.getVariable("infections");
                    ProbabilisticNode bolestNode = (ProbabilisticNode) net.getNode(b.getNaziv());
                    if (infectionDisease.getValue() < 0) {
                        PotentialTable bolestProb = bolestNode.getProbabilityFunction();
                        bolestProb.setValue(0, bolestProb.getValue(0) * (float) 0.5);
                        bolestProb.setValue(1, 1 - bolestProb.getValue(0));
                    } else {
                        PotentialTable bolestProb = bolestNode.getProbabilityFunction();
                        bolestProb.setValue(0, bolestProb.getValue(0) + (float) infectionDisease.getValue() / (10*10));
                        bolestProb.setValue(1, 1 - bolestProb.getValue(0));
                    }

                }


            }



            IInferenceAlgorithm algorithm = new JunctionTreeAlgorithm();
            algorithm.setNetwork(net);
            algorithm.run();

            for (String sympom:
                    b.getSimptomi()) {
                if(!sympom.equals("blood_test")) {
                    ProbabilisticNode factNode = (ProbabilisticNode) net.getNode(sympom);
                    int stateIndex = 0; // index of state "da"
                    factNode.addFinding(stateIndex);
                }
            }

            try {
                net.updateEvidences();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            ProbabilisticNode diseaseNode = (ProbabilisticNode)net.getNode(b.getNaziv());
            ret=Math.round(((ProbabilisticNode)diseaseNode).getMarginalAt(0)*100);
          
        } catch (IOException e) {
            e.printStackTrace();
        }

        return ret;
    }

}
