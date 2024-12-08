package sequencealignment.PSA.Local;

/**
 *
 * @author LEILA
 */
public class SmithWaterman {

    private int match;
    private int mismatch;
    private int gap;
    
    private  String seq1;
    private  String seq2;
    
    private  int[][] F;

    private int s;
    private int Score;
    private String result;
    
    private String[][] traceMatrix;
    
    // for PAM or BLOSUM
    public SmithWaterman(int gap, String seq1, String seq2, String scoring){
        this.gap = gap;
        this.seq1 = seq1;
        this.seq2 = seq2; 
        initializationTableF();
        fillingTheMatrix();
        traceback();
    }
    
    // for ficed values
    public SmithWaterman(int match, int mismatch, int gap, String seq1, String seq2) {
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
        for(int j=1; j<seq1.length()+1; j++){
            F[0][j]= 0;
        }
        for(int i=1; i<seq2.length()+1; i++){
            F[i][0]= 0;
        }
        
    }

     /**
      * F(i,j) = max {
      *              F(i-1,j-1) + S(i,j) ===> match OR mismutch
      *              F(i-1,j) + Gap
      *              F(i,j-1) + gap
      *              0
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
                 }else{
                     traceMatrix[i][j]="0";
                 }
            }
        }
        System.out.println(printMatrixF());
        System.out.println(printTraceMatrix());
    }
    
    private StringBuilder trace1= new StringBuilder();
    private StringBuilder trace2= new StringBuilder();
    private void traceback() {
        System.out.println("traceback");
    
        int[] maxVal = findMax(F);
        int i = maxVal[0];
        int j = maxVal[1];
    
        while (i > 0 && j > 0) {
            if (traceMatrix[i][j].equals("D")) {  
                trace1.append(seq1.charAt(j - 1));
                trace2.append(seq2.charAt(i - 1));
                i--;
                j--;
            } else if (traceMatrix[i][j].equals("V")) {
                trace1.append("_");
                trace2.append(seq2.charAt(i - 1));
                i--;
            } else if (traceMatrix[i][j].equals("H")) {
                trace1.append(seq1.charAt(j - 1));
                trace2.append("_");
                j--;
            } else {
                break; // Exit if traceMatrix[i][j] == 0
        }
    }

    System.out.println("********************************");
    System.out.println("Global Alignment");
    trace1.reverse();
    trace2.reverse();
    System.out.println(trace1);
    System.out.println(trace2);
    result= trace1.toString() + "\n" + trace2.toString();
        System.out.println("leila" + result);
    System.out.println("\nScore = " + F[maxVal[0]][maxVal[1]]);
    Score=F[maxVal[0]][maxVal[1]];
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
    
    public String printTraceMatrix() {
        StringBuilder sb = new StringBuilder();
        sb.append(", traceMatrix=\n");
      
        for (String[] row : traceMatrix) {
            for (String cell : row) {
                sb.append(cell).append("\t");
            }
            sb.append("\n");
        }
        return sb.toString();
    }


    private int max(int a, int b, int c) {
        return Math.max(Math.max(Math.max(a, b), c), 0);
    }
    
    public static int[] findMax(int[][] matrix) {
        int max = Integer.MIN_VALUE;
        int row = -1;
        int col = -1;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] > max) {
                    max = matrix[i][j];
                    row = i;
                    col = j;
                }
            }
        }

        return new int[]{row, col};
    }

public String[][] resultSWFTable() {
    int rows = seq2.length() + 2; 
    int cols = seq1.length() + 2;
    String[][] resultSWFTable = new String[rows][cols];

    resultSWFTable[0][0] = ""; 

    // Fill the first row with seq1 characters 
    for (int j = 2; j < cols; j++) {
        resultSWFTable[0][j] = String.valueOf(seq1.charAt(j - 2)); 
    }

    // Fill the first column with seq2 characters 
    for (int i = 2; i < rows; i++) {
        resultSWFTable[i][0] = String.valueOf(seq2.charAt(i - 2)); 
    }

    for (int i = 1; i < rows; i++) {
        resultSWFTable[i][1] = "0"; 
    }
    for (int j = 1; j < cols; j++) {
        resultSWFTable[1][j] = "0"; 
    }

    for (int i = 2; i < rows; i++) {
        for (int j = 2; j < cols; j++) {
            String s;
            switch (traceMatrix[i - 1][j - 1]) {
                case "D":
                    s = "↘";
                    break;
                case "V":
                    s = "↓";
                    break;
                case "H":
                    s = "→";
                    break;
                case "0":
                    s = "";
                    break;
                default:
                    s = "";
            }
            resultSWFTable[i][j] = F[i - 1][j - 1] + s;
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
