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
	
	if (a.length >=  m && a[0].length >= n)
	{
	    for (int i = 0; i < m; i++)
	    {
		for (int j = 0; i < n; i++)
		{
		    matrix[i][j] = a[i][j];
		} 
	    }
	}
	else
	{
	    throw new IndexOutOfBoundsException();
	}
    }
}

