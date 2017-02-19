import java.util.Random;
import java.io.PrintWriter;
/**
 * Matrix.java
 *
 * @author Erick Lares
 * @author Eric Cambel
 * @author Praveen Mariappan
 * @version Feb 2017
 */

/**
*The Matrix class provides 
*implementation for all the methods 
*in Javatrix Java Matrix Class. 
*
*@author Erick Lares
*@author Eric Cambel
*@author Praveen Mariappan
*
*@version Feb 2017
 */


public class Matrix 
{
   
    private  double [][] matrix;
    private  int m;
    private  int n;
/**
*
*Constructor that build a matrix full of zeros.
*
*@param m rows
*@param n colums
*/
    public  Matrix(int m, int n) 
    {
        this.m = m;
	this.n = n;
	matrix = new double[m][n];
	for (int i = 0; i < m; i++)
	{
	    for (int j = 0; j < n; j++)
	    {
	        matrix [i][j] = 0;	
	    }	
	}
    }

/**
*
*Constructor to build a fast matrix without cheking arguments.
*
*@param m rows
*@param n colums
*@param a double to copy into matrix for fast generation
*/

    public Matrix(double[][] a, int m, int n)
    {
	this.m = m;
        this.n = n;
        matrix = new double[m][n];
        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {

                matrix[i][j] = a[i][j];
            }
        }
        
        
    }



/**
*
*Constructor to build a matrix from a one-dimensional array.
*
*@param vals single dimensional array
*@param m Rows
*
*/

    public Matrix(double[] vals, int m)
    {
        this.m = m;
        this.n = (vals.length) / m;
	int ismultiple = (vals.length) % m;
	int nextval = 0;
	if (ismultiple == 0)
	{
	    matrix = new double[m][n];
	    for (int i = 0; i < n; i++)
            {
                for (int j = 0; j < m; j++)
                {
                    matrix[i][j] = vals[nextval];
		    nextval = nextval + 1;
                }
            }

	}
	else
	{
	    throw new IllegalArgumentException();
	}

    }


/**
*
*Constructor that builds a m-by-n constant matrix.
*
*@param m - Number of rows.
*@param n - Number of colums.
*@param s - Fill the matrix with this scalar value.
*/
    public Matrix(int m, int n, double s)
    {
	this.m = m;
	this.n = n;
	matrix = new double[m][n];
	for (int i = 0; i < m; i++)
	{
	    for (int j = 0; j < n; j++)
	    {
	        matrix [i][j] = s;	
	    }	
	}
    }

/**
 * Constructor that sets the 2D param to the constant matrix.
 *
 * @param a - Double 2D array to be used as matrix.
 */
    public Matrix(double[][] a)
    {
        m = a.length;
        n = a[0].length;
        matrix = new double[m][n];
        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                matrix [i][j] = a[i][j];
            }
        }
    }

    /**
     * Method that returns the dimension of the matrix.
     * 
     * @return the matrix row dimension.
     */
    public int getRowDimension()
    {
        return m;
    }

    /** 
     * Method the returns the matrix column number.
     *
     * @return the matrix column.
     */
    public int getColumnDimension()
    {
        return n;
    }

/**
* Return the array.
*
* @return double[][]
*/
    public double[][] getArray()
    {
        return matrix;
    }



/**
*
* Method to set a double in the matrix.
* @param i Rows
* @param j colums
* @param s double to be inside the matrix
*/

    public void set(int i, int j, double s)
    {
	if (i > m || j > n)
	{
	    throw new ArrayIndexOutOfBoundsException();
	}	
	matrix [i][j] = s;

    }    


/**
*
* Method to get a double from a matrix at the position [i][j].
* @param i Rows
* @param j colums
* @return double inside the matrix at i,j.
*/

    public double get(int i, int j)
    {
        if (i > this.m || j > this.n)
        {
            throw new ArrayIndexOutOfBoundsException();
        }
        double s = matrix [i][j];
	return s;
    }



/**
* Method to generate a random matrix.
*
* @param m  Rows
* @param n  Colums
* @return Random matrix.
*/

    public static Matrix random(int m, int n)
    {
    	Matrix matrix = new Matrix(m, n);
	Random random = new Random();
	for (int i = 0; i < m; i++)
	{
	    for (int j = 0; i < 1; i++)
	    {
	        matrix.set(i, j, random.nextInt());
    	    }
	}
	
	return matrix;
    }

/**
* Method to multiply a matrix by a scalar.
* 
* @param s Scalar
* @return Matrix multiplied by the scalar.
*/

    public Matrix times(double s)
    {
	Matrix result = new Matrix(m, n);
	for (int i = 0; i < m; i++)
	{
	    for (int j = 0; j < n; j++)
	    {
	        result.set(i, j, matrix[i][j] * s);
 	    }
	}
   	return result;
    }  

/**
* Method to multiply a matrix by a scalar in place.
*
* @param s Scalar
* @return Matrix multiplied by the scalar.
*/

    public Matrix timesEquals(double s)
    {

        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                matrix[i][j] = (matrix[i][j] * s);
            }
        }
        return this;
    }


/**
* Method to multiply a matrix by a matrix.
*
* @param b matrix
* @return MAtrix the product of this * b.
*/

    public Matrix times(Matrix b)
    {
	int bRow = b.getRowDimension();
	int bCol = b.getColumnDimension();
	Matrix result = new Matrix(m, bCol);
	
	if (n != bRow)
	{
	    throw new IllegalArgumentException();
	}
	
	double x = 0;
	for (int vals = 0; vals < (m); vals++)
	{
	    for (int j = 0; j < bCol; j++)
	    {
	       	for (int i = 0; i < n; i++)
	     	{    
	    	    x = x + (matrix[vals][i] * b.get(i, j));
	    	}
	    	result.set(vals, j, x);
	    	x = 0;
	    }
	} 
        return result;
    }


/**
* Print the matrix to the output stream.  
* 
* @param output  the output stream
* @param w  column space in between
* @param d number of digits after the decimal
*/
    public void print(java.io.PrintWriter output, int w, int d)
    {
	if (w <= 0 || d < 0)
	{ 
	    return;
	}	
	for (int i = 0; i < m; i++) 
	{
	    for (int j = 0; j < n; j++) 
	    {
		if (matrix[i][j] < 0)
		{
		    output.print(String.format("%" + (w + 1) 
		        + "." + d + "f ", (matrix[i][j])));
		}
		else
		{
		    output.print(String.format(" %" + w 
			+ "." + d + "f ", (matrix[i][j])));
	    	}
	    }
	    output.println();
	}
	output.println();
    }




/**
* Method to print the matrix to console.
*
* @param w space in between
* @param d number of digits after decimal
*/

    public void print(int w, int d) 
    {
	print(new PrintWriter(System.out, true), w, d);
    }


}    
