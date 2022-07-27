package binarysearch;

public class Test
{
	public static void main(String[] args)
	{
		
		int n = 10000000;
		int v = 500000;
		boolean rand = true;
		
		if(args.length>2 && !rand)
		{
			v = Integer.parseInt(args[0]);
			n = Integer.parseInt(args[1]);
			
			int [] tab = new int [n];
			
			for(int i = 2; i < n+2; i++)
			{
				tab[i-2] = Integer.parseInt(args[i]);
			}
			
			BinarySearch search = new BinarySearch(tab);
			
			System.out.println(search.findElement(v));
		}
		else if(rand)
		{
			int [] tab = new int [n];
			
			for(int i = 0; i < n; i++)
			{
				tab[i] = (int)(Math.random()*1000000);
				//System.out.print(tab[i] + " ");
			}
			
			sort.Sort sort = new sort.MergeSort(tab);
			
			sort.sortAsc();
			tab = sort.getSortedAsc();
			
			BinarySearch search = new BinarySearch(tab);
			
			System.out.println(search.findElement(v));
			System.out.println(search.getAmountOfComp());
		}
		
	}
}
