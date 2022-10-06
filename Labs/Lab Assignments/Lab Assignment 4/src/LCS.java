public class LCS {
    char[] c1,c2;
    int m;
    int n;
    int [][] mat;
    public LCS(char[] c, char[] c_, int mr, int nr){
        m=mr;
        n=nr;
        c1=c;
        c2=c_;
        mat=new int [m+1][n+1];
    }

    public int lcs_length(){
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0)
                    mat[i][j] = 0;
                else if (c1[i - 1] == c2[j - 1])
                    mat[i][j] = mat[i - 1][j - 1] + 1;
                else
                    mat[i][j] = Math.max(mat[i - 1][j], mat[i][j - 1]);
            }
        }
        return mat[m][n];
    }

    public char[] lcs_string(){
        int index=mat[m][n];
        int temp=index;
        char[]lcs=new char[index+1];
        int i=m;
        int j=n;
        while(i>0 && j>0){
            if(c1[i-1]==c2[j-1]){
                lcs[index-1]=c1[i-1];
                i--;
                j--;
                index--;
            }
            else if(mat[i-1][j]>mat[i][j-1]){
                i--;
            }
            else{
                j--;
            }
        }
        return lcs;
    }
}
