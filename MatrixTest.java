import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;
import org.junit.After;

/**
* MatrixTest.java
*@author Erick Lares
*@author Eric Cambel
*@author Praveen Mariappan
*@version Feb 2017
*/

/**
* Test for the Matrix Class. 
*@author Erick Lares
*@author Eric Cambel
*@author Praveen Mariappan
*@version Feb 2017 
*/



public class MatrixTest 
{
    double [][] testmatrix;
    int m;
    int n;
    Matrix matrix;	
    /**
    *Test for array of zeros.
    */
    @Test
    public void mainTest()
    {
	m = 5;
	n = 5;
	Matrix matrix = new Matrix(m , n);
	double [][] testmatrix = new double[m][n];
	for (int i = 0; i < m; i++)
	{
	    for (int j = 0; j < n; j++)
	    {
		testmatrix [i][j] = 0; 
	    }
	}
	assertArrayEquals("Not the same" , testmatrix , matrix.matrix);
    }
    /**
    *Clean up for the test.
    */
    @After
    public void cleanUp()
    {
        matrix = null;
	testmatrix = null;
        m = 0;
        n = 0;
    }

}
