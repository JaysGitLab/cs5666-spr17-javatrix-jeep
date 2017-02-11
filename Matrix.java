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

public class Matrix extends java.lang.Object 
    implements java.lang.Cloneable, java.io.Serializable 
{
   
    static double [][] matrix;
    static int m;
    static int n;
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
}
