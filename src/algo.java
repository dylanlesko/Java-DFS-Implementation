public class algo
{
	public static void main(String[] args)
	{
		DFS searchTest = new DFS(10, 0.05);
		//searchTest.printGraph();
		//searchTest.DepthSearch( 9, 9, 9, 9, "" );
		System.out.println("Total possible paths: "+searchTest.DepthSearch(9,9,9,9, ""));
	}

}
