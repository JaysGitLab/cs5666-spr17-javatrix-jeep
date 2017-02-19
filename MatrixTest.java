import java.io.PrintStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintWriter;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.After;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.equalTo;
import org.junit.Before;

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
    private double [][] testmatrix;
    private int m;
    private int n;
    private Matrix matrix;	
    private final ByteArrayOutputStream 
    outContent = new ByteArrayOutputStream();
    private PrintStream initial;
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
	assertArrayEquals("Not the same", testmatrix, matrix.getArray());
    }
	
    /**
    *Test for creating a matrix of a one dimentional array.
    *Success test.
    */
    @Test
    public void issue36Success()
    {
        m = 2;
        n = 2;
	double[] oneD = new double[] {0, 1, 2, 3};
	testmatrix = new double[m][n];
	testmatrix[0][0] = oneD[0];
	testmatrix[0][1] = oneD[1];
	testmatrix[1][0] = oneD[2];
	testmatrix[1][1] = oneD[3];
   	matrix = new Matrix(oneD, m);
        assertArrayEquals("Not the same", matrix.getArray(), testmatrix);


    }

     /**
    *Test for creating a matrix of a one dimentional array.
    *Fail test.
    */
    @Test(expected = IllegalArgumentException.class)
    public void issue36Fail()
    {
        m = 3;
        n = 2;
        double[] oneD = new double[]{0, 1, 2, 3};
        testmatrix = new double[m][n];
        testmatrix[0][0] = oneD[0];
        testmatrix[0][1] = oneD[1];
        testmatrix[1][0] = oneD[2];
        testmatrix[1][1] = oneD[3];
        matrix = new Matrix(oneD, m);
        assertArrayEquals("Not the same", testmatrix, matrix.getArray());


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
                testmatrix [i][j] = i;
            }
        }
	Matrix matrix = new Matrix(testmatrix, m, n);
	assertArrayEquals("Not the same", testmatrix, matrix.getArray());


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
        assertArrayEquals("Not the same", testmatrix, matrix.getArray());
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
			   testmatrix, matrix.getArray());
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
        assertArrayEquals("Not the same.", testmatrix, matrix.getArray());
    }


     /**
     * Test for get.
     */
    @Test
    public void issue10Test()
    {
        m = 5;
        n = 5;
	int i = 3;
	int j = 2;
        Matrix matrix = new Matrix(m, n);
	double s = matrix.get(i, j);
        assertEquals(s, 0, 0);
    }

    /**
     * Test for get failure.
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void issue10TestFailure()
    {
        m = 5;
        n = 5;
        int i = 10;
        int j = 10;
        Matrix matrix = new Matrix(m, n);
        double s = matrix.get(i, j);
        assertEquals(s, 0, 0);
    }

     /**
     * Test for set.
     */
    @Test
    public void issue40Test()
    {
        m = 5;
        n = 5;
        int i = 3;
        int j = 2;
        Matrix matrix = new Matrix(m, n);
        double s = 5;
	matrix.set(i, j, s);
	double test = matrix.get(i, j);
        assertEquals(s, test, 0);
    }

    /**
     * Test for set failure.
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void issue40TestFailure()
    {
        m = 5;
        n = 5;
        int i = 10;
        int j = 10;
        Matrix matrix = new Matrix(m, n);
        double s = 5;
        matrix.set(i, j, s);
        double test = matrix.get(i, j);
        assertEquals(s, test, 0);

    }
    
    /**
    * Test for random.
    */
    public void issue33Test()
    {    
	m = 10;
	n = 12;
	Matrix matrix = Matrix.random(m, n);
	Matrix testMatrix = new Matrix(m, n);
	assertThat(matrix, not(equalTo(testMatrix)));
	

    }
    
    /**
     * Test to make sure row dimension is correct.
     */
    @Test
    public void issue19Test()
    {
        m = 5;
        n = 5;

        testmatrix = new double[m][n];
        Matrix matrix = new Matrix(testmatrix);  
        assertEquals("Not the same row dimension.", 
	    n, matrix.getRowDimension());
    }

    /**
     * Test column dimension for accuracy.
     */
    @Test
    public void issue13Test()
    {
        m = 5;
        n = 5;

        testmatrix = new double[m][n];
        Matrix matrix = new Matrix(testmatrix);
        assertEquals("Not the same column dimension.", 
	    m, matrix.getColumnDimension());
    }

   /**
    * Test to thes scalar multiplication.
    */
    @Test
    public void issue45Test()
    {
        m = 5;
        n = 5;
	double s = 2;
	Matrix matrix = new Matrix(m, n, 5);
	Matrix testMatrix = new Matrix(m, n, 5 * s);
	Matrix multiply = matrix.times(s);
   	assertArrayEquals("The multiplication went wrong", 
	    multiply.getArray(), testMatrix.getArray());   
    }

   

    /**
    * Test scalar multiplication in place.
    */
    @Test
    public void issue47Test()
    {
        m = 5;
        n = 5;
	double s = 2;
	Matrix matrix = new Matrix(m, n, 5);
	Matrix testMatrix = new Matrix(m, n, 5 * s);
	matrix.timesEquals(s);
   	assertArrayEquals("The multiplication went wrong", 
	    matrix.getArray(), testMatrix.getArray());   
    }


   /**
    * Test multiplication between matrixs.
    */
    @Test
    public void issue46Test()
    {
        m = 3;
        n = 3;
        double[][] a = new double[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
	double[][] b = new double[][]{{2, 2, 2}, {2, 2, 2}, {2, 2, 2}};
	double[][] c = new double[][]{{12, 12, 12}, {30, 30, 30}, {48, 48, 48}};
	Matrix matrix = new Matrix(a, m, n);
	Matrix result = new Matrix(c, m, n);
	Matrix matrixb = new Matrix(b, m, n);
	Matrix testMatrix = matrix.times(matrixb);
	double[][] d = new double[][]{{1}, {2}, {3}};
	double[][] result2 = new double[][]{{14}, {32}, {50}};
	
	Matrix secondTest = new Matrix(d, 3, 1);
	
	
	Matrix final2 = matrix.times(secondTest);
	
      	
        assertArrayEquals("The multiplication went wrong",
            c, testMatrix.getArray());
	assertArrayEquals("The multiplication went wrong",
            result2, final2.getArray());
	

    }

    /**
    * Test multiplication between matrixs.
    * Fail test
    */
    @Test(expected = IllegalArgumentException.class)
    public void issue46TestFail()
    {
        m = 2;
        n = 2;
        double[][] a = new double[][]{{1, 2}, {4, 5}};
        double[][] b = new double[][]{{2, 2, 2}, {2, 2, 2}, {2, 2, 2}};
        double[][] c = new double[][]{{12, 12, 12}, {30, 30, 30}, {48, 48, 48}};
        Matrix matrix = new Matrix(a, m, n);
        Matrix result = new Matrix(b, 3, 3);
        Matrix matrixb = new Matrix(c, 3, 3);
        Matrix testMatrix = matrix.times(matrixb);


        assertArrayEquals("The multiplication went wrong",
            c, testMatrix.getArray());
    }   



/**
* Test print with output.
*/
    @Test
    public void issue31Test() 
    {	
        String out = " 0  0 \n" 
	    + " 0  0 \n\n";
	PrintWriter output = new PrintWriter(outContent, true);
	Matrix matrix = new Matrix(2, 2);
	matrix.print(output, 1, 0);
	assertEquals(outContent.toString(), out);
    }
	
/**
* Test print to console.
*/
    @Test
    public void issue29Test() 
    {
	String out = " 0  0 \n" 
	    + " 0  0 \n\n";
        Matrix matrix = new Matrix(2, 2);
        matrix.print(1, 0);
        assertEquals(outContent.toString(), out);
    }
/**
*
* Test for minus method. 
*
*/

    @Test
    public void issue22Test()
    {
    	m = 3;
        n = 3;
        double[][] a = new double[][]{{3, 2, 6}, {1, 5, 4}, {2, 10, 5}};
        double[][] b = new double[][]{{2, 1, 5}, {8, 1, 0}, {3, 2, 1}};
        double[][] c = new double[][]{{1, 1, 1}, {-7, 4, 4}, {-1, 8, 4}};
        Matrix matrix = new Matrix(a, m, n);
        Matrix matrixb = new Matrix(b, 3, 3);
        Matrix testMatrix = matrix.minus(matrixb);


        assertArrayEquals("The subtraction went wrong",
            c, testMatrix.getArray());

    }

/**
*
* Test for minus method in place.
*
*/

    @Test
    public void issue23Test()
    {
        m = 3;
        n = 3;
        double[][] a = new double[][]{{3, 2, 6}, {1, 5, 4}, {2, 10, 5}};
        double[][] b = new double[][]{{2, 1, 5}, {8, 1, 0}, {3, 2, 1}};
        double[][] c = new double[][]{{1, 1, 1}, {-7, 4, 4}, {-1, 8, 4}};
        Matrix matrix = new Matrix(a, m, n);
        Matrix matrixb = new Matrix(b, 3, 3);
        matrix.minusEquals(matrixb);


        assertArrayEquals("The subtranction went wrong",
            c, matrix.getArray());

    }



/**
* Test copy of a matrix.
*/
    @Test
    public void issue9Test()
    {
        matrix = Matrix.random(3, 4);
	Matrix testMatrix = matrix.copy();
	assertArrayEquals("The arrays are not the same",
            matrix.getArray(), testMatrix.getArray());

    }

/**
* Test clone of a matrix.
*/
    @Test
    public void issue7Test()
    {
        matrix = Matrix.random(3, 4);
        Object testMatrix = matrix.clone();
	Matrix result = (Matrix) testMatrix; 
        assertArrayEquals("The array are not the same",
            matrix.getArray(), result.getArray());

    }
/**
* Test getArrayCopy to get a copy of the internal array of a matrix.
*/
    @Test
    public void issue12Test()
    {
	m = 3;
	n = 3;
        double[][] arraytest = new double[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
	matrix = new Matrix(arraytest, m, n);
	double[][] copyarray = matrix.getArrayCopy();
	
	assertArrayEquals("The array are not the same",
            copyarray, arraytest);

    }

/**
* Test multiplication element by element.
*/

    @Test
    public void issue5Test()
    {
    	m = 3;
        n = 3;
        double[][] a = new double[][]{{3, 2, 6}, {1, 5, 4}, {2, 10, 5}};
        double[][] b = new double[][]{{2, 1, 5}, {8, 1, 0}, {3, 2, 1}};
        double[][] c = new double[][]{{6, 2, 30}, {8, 5, 0}, {6, 20, 5}};
        Matrix matrix = new Matrix(a, m, n);
        Matrix matrixb = new Matrix(b, 3, 3);
        Matrix result = matrix.arrayTimes(matrixb);


        assertArrayEquals("The multiplication went wrong",
            c, result.getArray());

    }

/**
* Test multiplication element by element in place.
*/

    @Test
    public void issue6Test()
    {
        m = 3;
        n = 3;
        double[][] a = new double[][]{{3, 2, 6}, {1, 5, 4}, {2, 10, 5}};
        double[][] b = new double[][]{{2, 1, 5}, {8, 1, 0}, {3, 2, 1}};
        double[][] c = new double[][]{{6, 2, 30}, {8, 5, 0}, {6, 20, 5}};
        Matrix matrix = new Matrix(a, m, n);
        Matrix matrixb = new Matrix(b, 3, 3);
        matrix.arrayTimesEquals(matrixb);


        assertArrayEquals("The multiplication went wrong",
            c, matrix.getArray());

    }




/**
* Set up initial output.
*/
    @Before	
    public void setUpStreams() 
    {
  	initial = System.out;
	System.setOut(new PrintStream(outContent));	
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
        System.setOut(initial);
    }


}
