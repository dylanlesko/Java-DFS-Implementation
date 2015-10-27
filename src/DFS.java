import java.util.Random;

public class DFS
{
	private int[][] grid;
	private int stationProb;
	private int n;
	private int charge;

	public DFS(int vert, int charProb)
	{
		n = vert;
        stationProb = charProb;
		grid = new int[n][n];
		charge = 10;
		buildGraph();
	}
	public void buildGraph()
	{
		int randomNum;
		Random rand = new Random();

		for(int i = 0; i < n; i++)
		{
			for(int j = 0; j < n; j++)
			{
				randomNum = rand.nextInt(100) + 1;
				if(stationProb > randomNum)
				{
					grid[i][j] = 1;
				}
				else
				{
					grid[i][j] = 0;
				}
			}
		}
	}

	public void printGraph()
	{
		for(int i = 0; i < n; i++)
		{
			for(int j = 0; j < n; j++)
			{
				System.out.print( "\t" + grid[i][j]);
			}
			System.out.print("\n");
		}
	}

    public int FindEndPath()
    {
        DepthSearch( 0, 0, 0, 0, "" );
        return 1;
    }

	public int DepthSearch(int up, int down, int left, int right, String path)
	{
        String currentNode = "[" + down + "," + right + "] charge: " + charge +"\n";
        path = path + currentNode;

        /* Check if at the [n,n] node */
        if( down==(n-1) && right == (n-1) )
        {
            System.out.println(path);
            return 1;
        }

        /* Check if enough charge to proceed, or if the current node has a station */
        if(charge <= 0 && grid[down][right] == 0)
        {
            return 0;
        }
        if(grid[down][right] == 1)
        {
            charge = 10;
        }

        if(down == (n-1))
        {
            charge--;
            DepthSearch( up, down, left, right+1, path );
        }
        else if(right == (n-1))
        {
            charge--;
            DepthSearch( up, down+1, left, right, path );
        }
        else
        {
            charge--;
            DepthSearch(0, down+1,0, right, path);
            DepthSearch( 0, down, 0, right+1, path );

        }
		return 1;
	}
}
