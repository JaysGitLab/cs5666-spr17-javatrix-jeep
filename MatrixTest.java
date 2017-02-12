import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;
import org.junit.After;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
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
	Matrix matrix = new Matrix(m, n);
	double [][] testmatrix = new double[m][n];
	for (int i = 0; i < m; i++)
	{
	    for (int j = 0; j < n; j++)
	    {
		testmatrix [i][j] = 0; 
	    }
	}
	assertArrayEquals("Not the same", testmatrix, matrix.matrix);
    }
    
    /**
    *Test for creating a matrix quickly witout cheking arguments.
    *Success test.
    */
    @Test
    public void issue35Success()
    {
   	m = 5;
	n = 5;
	double [][] testmatrix = new double[5][5];
	for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                testmatrix [i][j] = 0;
            }
        }
	Matrix matrix = new Matrix(testmatrix, m, n);
	assertArrayEquals("Not the same", testmatrix, matrix.matrix);


    }
    
    /**
    *Test for creating a matrix quickly witout cheking arguments.
    *Fail test.
    */
    @Test(expected = IndexOutOfBoundsException.class)
    public void issue35Fail()
    {
        m = 15;
        n = 20;
        double [][] testmatrix = new double[5][5];
        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                testmatrix [i][j] = 0;
            }
        }
        Matrix matrix = new Matrix(testmatrix, m, n);
        assertArrayEquals("Not the same", testmatrix, matrix.matrix);
    }

    /**
    *Test for constant matrix of double.
    */
    @Test
    public void constantmatrixTest()
    {
	m = 5;
	n = 5;
	double s = 1.5;
	testmatrix = new double[m][n];
	for (int i = 0; i < m; i++)
	{
	    for (int j = 0; j < n; j++)
	    {
		testmatrix [i][j] = s; 
	    }
	}
	Matrix matrix = new Matrix(m, n, s);
	assertArrayEquals("Constant arrays not the same" ,
			   testmatrix, matrix.matrix);
    }

    /**
     * Test to copy 2D array to a matrix. 
     */
    @Test
    public void issue34Test()
    {
        m = 5;
        n = 5;

        testmatrix = new double[m][n];
        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                testmatrix[i][j] = j;
            }
        }
        Matrix matrix = new Matrix(testmatrix);
        assertArrayEquals("Not the same.", testmatrix, matrix.matrix);
    }


     /**
     * Test for get
     */
    @Test
    public void issue10Test()
    {
        m = 5;
        n = 5;
	int i = 3;
	int j = 2;
        Matrix matrix = new Matrix( m, n);
	double s = matrix.get( i, j);
        assertEquals(s, 0, 0);
    }

    /**
     * Test for get
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void issue10TestFailure()
    {
        m = 5;
        n = 5;
        int i = 10;
        int j = 10;
        Matrix matrix = new Matrix( m, n);
        double s = matrix.get( i, j);
        assertEquals(s, 0, 0);
    }

     /**
     * Test for set
     */
    @Test
    public void issue40Test()
    {
        m = 5;
        n = 5;
        int i = 3;
        int j = 2;
        Matrix matrix = new Matrix( m, n);
        double s = 5;
	matrix.set( i, j, s);
	double test = matrix.get( i, j);
        assertEquals(s, test, 0);
    }

    /**
     * Test for set failure
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void issue40TestFailure()
    {
        m = 5;
        n = 5;
        int i = 10;
        int j = 10;
        Matrix matrix = new Matrix( m, n);
        double s = 5;
        matrix.set( i, j, s);
        double test = matrix.get( i, j);
        assertEquals(s, test, 0);

    }
    
    /**
    * Test for random
    */
    public void issue33Test()
    {    
	m = 10;
	n = 12;
	Matrix matrix = Matrix.random(m,n);
	Matrix testMatrix = new Matrix(m,n);
	assertThat(matrix, not(equalTo(testMatrix)));
	

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
