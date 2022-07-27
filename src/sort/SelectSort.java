package sort;

public class SelectSort implements Sort
{
	private int []desc;
	private int []asc;
	private int []pre;
	private int numofcomp = 0;
	private int numofswap = 0;
	
	
	public SelectSort(int []tab)
	{
		this.pre = tab;
		this.asc = tab;
		this.desc = tab;
	}
	
	@Override
	public void sortAsc()
	{
		numofcomp = 0;
		numofswap = 0;
		
		int n = asc.length;
		int min = 0;
		int tmp = 0;
		
		for(int i = 0; i < n - 1; i++)
		{
			min = i;
			
			for(int j = i + 1; j < n; j++)
			{
				if(asc[j] < asc[min])
				{
					min = j;
				}
				numofcomp++;
			}
			
			if(min != i)
			{
				tmp = asc[min];
				asc[min] = asc[i];
				asc[i] = tmp;
				numofswap++;
			}
		}
	}
	
	@Override
	public void sortDesc()
	{
		numofcomp = 0;
		numofswap = 0;
		
		int n = asc.length;
		int max = 0;
		int tmp = 0;
		
		for(int i = 0; i < n - 1; i++)
		{
			max = i;
			
			for(int j = i + 1; j < n; j++)
			{
				if(asc[j] > asc[max])
				{
					max = j;
				}
				numofcomp++;
			}
			
			if(max != i)
			{
				tmp = asc[max];
				asc[max] = asc[i];
				asc[i] = tmp;
				numofswap++;
			}
		}
	}

	@Override
	public int [] getSortedAsc()
	{
		return this.asc;
	}
	
	@Override
	public int [] getSortedDesc()
	{
		return this.desc;
	}
	
	@Override
	public int getNumOfComp()
	{
		return numofcomp;
	}
	
	@Override
	public int getNumOfSwap()
	{
		return numofswap;
	}
	
	@Override
	public int [] initialData()
	{
		return pre;
	}
}
