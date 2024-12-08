package sequencealignment.PSA.Local;

/**
 *
 * @author LEILA
 */
public class NeedlemanWunsch {
    private int match;
    private int mismatch;
    private int gap;
    
    private  String seq1;
    private  String seq2;
    
    private  int[][] F;

    private int s;
    private String[][] traceMatrix;
    private int Score;
    private String result;
    
    public NeedlemanWunsch(int match, int mismatch, int gap, String seq1, String seq2) {
        this.match = match;
        this.mismatch = mismatch;
        this.gap = gap;
        this.seq1 = seq1;
        this.seq2 = seq2; 
        initializationTableF();
        fillingTheMatrix();
        traceback();
    }
    private void initializationTableF(){
        
        F = new int[seq2.length()+1][seq1.length()+1];
        F[0][0] = 0;
        int gapX = gap;
        for(int j=1; j<seq1.length()+1; j++){
            F[0][j]= gapX;
            gapX += gap;
        }
        gapX = gap;
        for(int i=1; i<seq2.length()+1; i++){
            F[i][0]= gapX;
            gapX += gap;
        }
    }

     /**
      * F(i,j) = max {
      *              F(i-1,j-1) + S(i,j) ===> match OR mismutch
      *              F(i-1,j) + Gap
      *              F(i,j-1) + gap
      * }
     */
    
    
    private void fillingTheMatrix(){
        
        System.out.println("\n Filling the matrix ");
        this.traceMatrix = new String[seq2.length() + 1][seq1.length() + 1];
        for(int i=1; i<seq2.length()+1; i++){
            for(int j=1; j<seq1.length()+1; j++){
                if (seq1.charAt(j-1)==seq2.charAt(i-1)) {
                    s=match;
                } else {
                    s=mismatch;
                }
                int diagonal = F[i-1][j-1] + s;
                int vertical = F[i-1][j] + gap;
                int horizontal = F[i][j-1] + gap;
                F[i][j]=max(diagonal, vertical, horizontal);
                 if (F[i][j] == diagonal) {
                    traceMatrix[i][j]="D";
                 } else if (F[i][j] == vertical) {
                    traceMatrix[i][j]="V";
                 } else if (F[i][j] == horizontal) {
                     traceMatrix[i][j]="H";
                 }
            }
        }
        System.out.println(printMatrixF());
    }
    
    private StringBuilder trace1= new StringBuilder();
    private StringBuilder trace2= new StringBuilder();
    
    private void traceback(){    
        int i = seq2.length();
        int j = seq1.length();
        while (i > 0 && j > 0) {
            if (traceMatrix[i][j] == "D") {
                trace1.append(seq1.charAt(j-1));
                trace2.append(seq2.charAt(i-1));
                i--;
                j--;
            } else if (traceMatrix[i][j] == "V") {
                trace1.append("_");
                trace2.append(seq2.charAt(i-1));
                i--;
            } else if (traceMatrix[i][j] == "H") {
                trace1.append(seq1.charAt(j-1));
                trace2.append("_");
                j--;
            }
        }
        
        System.out.println("********************************");
        System.out.println("Global Alignment");
        trace1.reverse();
        trace2.reverse();
        System.out.println(trace1);
        System.out.println(trace2);
        result= trace1.toString() + "\n" + trace2.toString();
        System.out.println("\nScore = " + F[seq2.length()][seq1.length()]);
        Score=F[seq2.length()][seq1.length()];
    }
    
    
    public String printMatrixF() {
        StringBuilder sb = new StringBuilder();
        sb.append(", F=\n");
      
        for (int[] row : F) {
            for (int cell : row) {
                sb.append(cell).append("\t");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
    


    private int max(int a, int b, int c) {
        return Math.max(Math.max(a, b), c);
    }
public String[][] resultSWFTable() {
    int rows = seq2.length() + 2; // Additional row for seq2 and alignment values
    int cols = seq1.length() + 2; // Additional column for seq1 and alignment values
    String[][] resultSWFTable = new String[rows][cols];

    // Top-left corner empty cell
    resultSWFTable[0][0] = "";

    // Fill the first row with seq1 characters
    for (int j = 2; j < cols; j++) {
        resultSWFTable[0][j] = String.valueOf(seq1.charAt(j - 2));
    }

    // Fill the first column with seq2 characters
    for (int i = 2; i < rows; i++) {
        resultSWFTable[i][0] = String.valueOf(seq2.charAt(i - 2));
    }
    
for (int j = 1; j < cols; j++) {
    if (j == 1) {
        resultSWFTable[1][j] = "0"; // Start with 0
    } else {
        resultSWFTable[1][j] = String.valueOf((j - 1) * gap); 
    }
}

// Fill the first column (gaps for seq2)
for (int i = 1; i < rows; i++) {
    if (i == 1) {
        resultSWFTable[i][1] = "0"; 
    } else {
        resultSWFTable[i][1] = String.valueOf((i - 1) * gap); // Gap progression
    }
}

    for (int i = 2; i < rows; i++) {
        for (int j = 2; j < cols; j++) {
            String arrow;
            switch (traceMatrix[i - 1][j - 1]) {
                case "D":
                    arrow = "↘";
                    break;
                case "V":
                    arrow = "↓";
                    break;
                case "H":
                    arrow = "→";
                    break;
                default:
                    arrow = "";
            }
            resultSWFTable[i][j] = F[i - 1][j - 1] + arrow;
        }
    }

    System.out.println("\nResult SWF Table:");
    for (int i = 0; i < rows; i++) {
        for (int j = 0; j < cols; j++) {
            System.out.print((resultSWFTable[i][j] != null ? resultSWFTable[i][j] : " ") + "\t");
        }
        System.out.println();
    }

    return resultSWFTable;
}

public int score(){
    return Score;
}
public String result(){
    return result;
}
}
