import java.util.Random;

public class DFS
{
	private int[][] grid;
	private int[] visited;
	private int stationProb;
	private int n;
	private int charge;
	private String path;

	public DFS(int vert, double charProb)
	{
		stationProb = (int)(charProb*100);
		n = vert;
		grid = new int[n][n];
		visited = new int[n];
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
				System.out.print( "\t" + grid[ i ][j]);
			}
			System.out.print("\n");
		}
	}

	public int DepthSearch(int up, int down, int left, int right, String path)
	{
		//int j;
		//visited[i]=1;

		path = path+ down +","+ right +"  ";
		if(down==0 && right==0)
		{
			//System.out.println(path);
			return 1;
		}

		int counter = 0;

		if(down==0)
			counter = DepthSearch( 0, down, 0, right - 1, path );
		else if(right==0)
			counter = DepthSearch( 0, down - 1, 0, right, path );
		else
			counter = DepthSearch( 0, down, 0, right - 1, path ) + DepthSearch(0, down-1,0, right, path);

		return counter;




//		for(j=0;j<n;j++)
//		{
//			if ( visited[ j ] == 0  )
//			{
//				if( charge > 0 || grid[ i ][ j ] == 1)
//				{
//					charge--;
//					DepthSearch( j );
//				}
//			}
//		}
	}
}
