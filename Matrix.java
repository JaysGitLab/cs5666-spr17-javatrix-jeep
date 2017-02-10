public class Matrix extends java.lang.Object 
    implements java.lang.Cloneable, java.io.Serializable {
   
	static double [][] matrix;
	static int m;
	static int n;
	public  Matrix(int m, int n) {
   	
		this.m = m;
		this.n = n;
		matrix = new double[m][n];
	
		for (int i = 0; i < m; i++){
	
			for (int j = 0; j < n; j++)
			{
				matrix [i][j] = 0;	
			}	
		}
	}
}
