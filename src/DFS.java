import java.util.Random;

public class DFS
{
	private int[][] grid;
	private int stationProb;
	private int n;

    public DFS(int vert, int charProb)
	{
		n = vert;
        stationProb = charProb;
		grid = new int[n][n];
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
        search(0,0,"down", "", 10);
        return 1;
    }

    public int search(int x, int y, String step, String path, int curCharge)
    {
        String currentNode = "[" + x + "," + y + "] charge: " + (curCharge) +"\n";
        path = path + currentNode;

        int newCharge = curCharge;

        if(x==(n-1) && y==(n-1))
        {
            System.out.print(path);
            return 1;
        }

        if(x >= 0 && y >= 0 && x < n && y < n)
        {
            if(grid[x][y] == 1)
            {
                newCharge = 10;
            }
            else
            {
                newCharge--;
            }

            if(newCharge > 0)
            {
                if(step != "up")
                {
                    if (search(x+1, y, "down", path, newCharge) == 1)
                    {
                       return 1;
                    }
                }
                if(step != "left")
                {
                    if (search(x, y+1, "right", path, newCharge) == 1)
                    {
                        return 1;
                    }
                }
                if(step != "down")
                {
                    if (search(x-1, y, "up", path, newCharge) == 1)
                    {
                        return 1;
                    }
                }

                if(step != "right")
                {
                    if (search(x, y-1, "left", path, newCharge) == 1)
                    {
                        return 1;
                    }
                }

                return 0;
            }
        }
        return 0;
    }


}
