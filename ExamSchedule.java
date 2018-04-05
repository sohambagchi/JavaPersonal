import java.util.*;
public class ExamSchedule {
    String[][] threeWeeks;
    String[][] uniqueCombos;
    String[] subjectList;
    String subjects;
    String[] subjectsAdded;
    int[] daysSince;
    ExamSchedule(Scanner cons){
        threeWeeks = new String[15][4];
        for(int i = 0; i < 15; i += 5){
            threeWeeks[i][0] = "MON";
            threeWeeks[i + 1][0] = "TUE";
            threeWeeks[i + 2][0] = "WED";
            threeWeeks[i + 3][0] = "THU";
            threeWeeks[i + 4][0] = "FRI";            
        }
        subjects = "LANGUAGE LITERATURE";
        System.out.println("Please enter number of unique combinations - ");
        int n = cons.nextInt();
        uniqueCombos = new String[n][7];
        daysSince = new int[n];
        for(int i = 0; i < uniqueCombos.length; i++){
            uniqueCombos[i][0] = "LANGUAGE";
            uniqueCombos[i][1] = "LITERATURE";
            daysSince[i] = 0;
        }
        cons.nextLine();
        for(int i = 0; i < threeWeeks.length; i++){
            for(int j = 1; j < threeWeeks[0].length; j++){
                threeWeeks[i][j] = "-";
            }
        }
    }

    void createUniqueCombos(Scanner sub, ExamSchedule eV){
        Scanner input = new Scanner(System.in);
        Random rand = new Random();
        for(int i = 0; i < uniqueCombos.length; i++){
            for(int j = 2; j < uniqueCombos[0].length - 1; j++){
                System.out.println("Please enter COMBO " + (i+1) + " SUBJECT " + (j));
                String tempa = input.nextLine();
                String tempb = tempa.toUpperCase();
                eV.artIsAPain(tempb, i, j);
                eV.addToSL(tempb);
            }
        }
        System.out.println(subjects);
        eV.SLtoArray();
        for(int i = 0; i < uniqueCombos.length; i++){
            for(int j = 0; j < uniqueCombos[0].length; j++){
                if(uniqueCombos[i][j]==null){
                    uniqueCombos[i][j] = " ";
                }
            }
        }
        for(int i = 0; i < subjectList.length; i++){
            int index = rand.nextInt(subjectList.length);
            String temp = subjectList[i];
            subjectList[i] = subjectList[index];
            subjectList[index] = temp;
        }
        for(int i = 0; i < subjectsAdded.length; i++){
            subjectsAdded[i] = " ";
        }
    }

    void artIsAPain(String subB, int m, int n){
        boolean temp = false;
        if(subB.equals("ART")){
            uniqueCombos[m][n] = "ART1";
            uniqueCombos[m][6] = "ART2";
        }
        else{
            uniqueCombos[m][n] = subB;
        }
    }

    void addToSL(String subA){
        boolean temp = false;
        if(subA.equals("ART")){
            temp = subjects.contains("ART1");
            if(temp == false){
                subjects += " ";
                subjects += "ART1 ";
                subjects += "ART2";
            }
        }
        else{
            temp = subjects.contains(subA);
            if(temp == false){
                subjects += " ";
                subjects += subA;
            }
        }
    }

    void createSchedule(ExamSchedule eV){
        loop1:
        for(int i = 0; i < threeWeeks.length; i++){
            ;
        }
    }

    boolean checkAlreadyPlotted(String toC){
        for(int i = 0; i < subjectsAdded.length; i++){
            if(subjectsAdded[i].equals(toC)) return false;
        }
        return true;
    }

    void datePassed(){
        for(int i = 0; i < daysSince.length; i++){
            daysSince[i] -= 1;
        }
    }

    boolean checkCommonSubject(String toC, int n){
        System.out.println("CCS");
        for(int i = 0; i < uniqueCombos.length; i++){
            for(int j = 0; j < uniqueCombos[0].length; j++){
                System.out.println("COMPARING " + toC + " WITH " + uniqueCombos[i][j]);
                if(uniqueCombos[i][j].equals(toC)){
                    System.out.println("STUDENT" + (i+1) + "HAS THE SUBJECT " + toC);
                    for(int k = 0; k < uniqueCombos[0].length; k++){
                        if(threeWeeks[n][1].equals(uniqueCombos[i][k])){ 
                            System.out.println(threeWeeks[n][1] + " (1) MATCHES " + uniqueCombos[i][k]);
                            return false;
                        }
                        else if(threeWeeks[n][2].equals(uniqueCombos[i][k])){
                            System.out.println(threeWeeks[n][2] + " (2) MATCHES " + uniqueCombos[i][k]);
                            return false;
                        }
                        else return true;
                    }
                }
            }
        }
        return false;
    }

    void dateGap(String examSub){
        for(int i = 0; i < uniqueCombos.length; i++){
            for(int j = 0; j < uniqueCombos[0].length; j++){
                if(examSub.equals(uniqueCombos[i][j])){
                    daysSince[i] = 2;
                }
            }
        }
    }

    int checkDateGap(String topic){
        for(int i = 0; i < uniqueCombos.length; i++){
            for(int j = 0; j < uniqueCombos[0].length; j++){
                if(uniqueCombos[i][j].equals(topic)) return daysSince[i];
            }
        }
        return 2;
    }

    void SLtoArray(){
        subjectList = subjects.split(" "); 
        subjectsAdded = new String[subjectList.length];
    }

    void printSchedule(){
        System.out.println(" ");
        System.out.println("DAY \t\t EXAM 1 \t\t EXAM 2 \t\t EXAM 3");
        for(int i = 0; i < threeWeeks.length; i++){
            for(int j = 0; j < threeWeeks[0].length; j++){
                System.out.print(threeWeeks[i][j] + "\t\t");
            }
            System.out.println(" ");
        }
        System.out.println(" ");
    }

    void printAll(){
        for(int i = 0; i < uniqueCombos.length; i++){
            for(int j = 0; j < uniqueCombos[0].length; j++){
                System.out.print(uniqueCombos[i][j] + "\t");
            }
            System.out.println(" ");
        }
        for(int i = 0; i < subjectList.length; i++){
            System.out.println(subjectList[i]);
        }
    }

    void printTheGap(String tiC, int p, String toM){
        System.out.println(tiC + "\t" + p + "\t" + toM);
        for(int i = 0; i < uniqueCombos.length; i++){
            System.out.print(daysSince[i] + "\t");
            for(int j = 0; j < uniqueCombos[0].length; j++){
                System.out.print(uniqueCombos[i][j] + "\t");
            }
            System.out.println(" ");
        }
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        ExamSchedule eS = new ExamSchedule(input);
        eS.createUniqueCombos(input, eS);
        eS.printAll();
        eS.createSchedule(eS);
        eS.printSchedule();
    }
}