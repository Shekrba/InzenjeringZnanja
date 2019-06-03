package util;

import com.ugos.jiprolog.engine.JIPEngine;
import com.ugos.jiprolog.engine.JIPQuery;
import com.ugos.jiprolog.engine.JIPTerm;
import com.ugos.jiprolog.engine.JIPVariable;
import model.Bolest;
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

            b.setProcenat(calculateProb(b));
            if(b.getPoklapanje()!=0)
                ret.add(b);
        }


        return ret;
    }

    private static int calculateProb(Bolest b){

        int ret=0;

        ProbabilisticNetwork net;
        // loading from file

        try {
            BaseIO io=new NetIO();
            net = (ProbabilisticNetwork)io.load(new File("data/BNs/"+b.getNaziv()+".net"));
            IInferenceAlgorithm algorithm = new JunctionTreeAlgorithm();
            algorithm.setNetwork(net);
            algorithm.run();


            for (String sympom:
                    b.getSimptomi()) {
                ProbabilisticNode factNode = (ProbabilisticNode)net.getNode(sympom);
                int stateIndex = 0; // index of state "green"
                factNode.addFinding(stateIndex);

                System.out.println();

                // propagation

            }

            try {
                net.updateEvidences();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            ProbabilisticNode diseaseNode = (ProbabilisticNode)net.getNode(b.getNaziv());
            ret=Math.round(((ProbabilisticNode)diseaseNode).getMarginalAt(0)*100);
            System.out.println(b.getNaziv());
            System.out.println(diseaseNode.getStateAt(0) + ": " + ret);
            System.out.println(diseaseNode.getStateAt(1) + ": " + ((ProbabilisticNode)diseaseNode).getMarginalAt(1));

        } catch (IOException e) {
            e.printStackTrace();
        }

        return ret;
    }

}
