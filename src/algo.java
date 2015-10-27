import java.util.Scanner;

public class algo
{
    public static void main(String[] args)
	{
        /*
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Please Enter n: ");
        int n = keyboard.nextInt();
        System.out.println("Please percentage that a spot has a charge statiom (0 - 100): ");
        int percent = keyboard.nextInt();
        */

        DFS searchTest = new DFS(10, 5);
        //DFS searchTest = new DFS(n, percent);

        searchTest.printGraph();

        searchTest.FindEndPath();
	}
}
