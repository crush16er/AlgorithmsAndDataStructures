package selects;

public class Test
{

	public static void main(String[] args)
	{
		int [] tab = {33,8,34,16,13,25,88,15,23,98,29,77,14,58,30,75,60,40,52,65,31,55,2,97,83,35,42,57,20,49,51};
		int n, k;
		
		if(args.length == 3 && args[0].equals("-r"))
		{
			n = Integer.parseInt(args[1]);
			k = Integer.parseInt(args[2]);
			
			RandomizedSelect select1 = new RandomizedSelect();
			
			/*System.out.println(*///select1.randomizedSelect(tab, 0, n-1, k);/*);*/
			
			/*tab = select1.partition(tab, 0, n-1, 10);
			
			*/
			
			int [] tabR = new int [n];
			
			for(int i = 0; i < n; i++)
			{
				tabR[i] = (int)(Math.random()*2147483647);
			}
			
			
			
			select1.randomizedSelect(tabR, 0, n-1, k);
			System.out.println("NoComp: "+select1.getAmountOfComp());
			System.out.println("NoSwap: "+select1.getAmountOfSwap());
			System.out.println();
			
		}
		else if(args.length == 3 && args[0].equals("-p"))
		{
			n = Integer.parseInt(args[1]);
			k = Integer.parseInt(args[2]);
			
			RandomizedSelect select1 = new RandomizedSelect();
			
			/*System.out.println(*///select1.randomizedSelect(tab, 0, n-1, k);/*);*/
			
			/*tab = select1.partition(tab, 0, n-1, 10);
			
			*/
			
			int [] tabR = new int [n];
			
			for(int i = 0; i < n; i++)
			{
				tabR[i] = i+1;
			}
			
			for(int i=0; i < n*50; i++)
			{
				int x = 1 + (int)(Math.random()*(n-1));
				int y = 1 + (int)(Math.random()*(n-1));
				
				int tmp = tabR[x];
				tabR[x] = tabR[y];
				tabR[y] = tmp;
			}
			
			select1.randomizedSelect(tabR, 0, n-1, k);
			System.out.println();
			System.out.println("NoComp: "+select1.getAmountOfComp());
			System.out.println("NoSwap: "+select1.getAmountOfSwap());
		}
		
		/*Select select2 = new Select(tab);
		System.out.print(select2.select(tab, 0, 30, 15));*/
	}

}
