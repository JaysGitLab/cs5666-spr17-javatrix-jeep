import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;

public class MatrixTest {
	
	double [][] testmatrix;
	int m;
	int n;	

	@Test
	public void MainTest(){
		m = 5;
		n = 5;
		Matrix matrix = new Matrix(m,n);
		
		double[][] testmatrix = new double[m][n];

		for (int i=0; i<m; i++){
			for(int j=0; j<n; j++){
			testmatrix [i][j]=0; 
			}
		}
		
    		 assertArrayEquals("Not the same",testmatrix,matrix.matrix);
	}


}
