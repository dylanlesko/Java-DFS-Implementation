public class algo
{
	public static void main(String[] args)
	{
		DFS searchTest = new DFS(10, 0.1);
		searchTest.printGraph();
		searchTest.DepthSearch(0);
	}

}
