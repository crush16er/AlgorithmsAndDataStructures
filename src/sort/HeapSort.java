package sort;

public class HeapSort implements Sort
{
	private int []desc;
	private int []asc;
	private int []pre;
	private int numofcomp = 0;
	private int numofswap = 0;
	
	
	public HeapSort(int []tab)
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
		
		for (int i = n / 2 - 1; i >= 0; i--)
		{
			heapifyAsc(i, n);
		}
		
		for (int i=n-1; i>=0; i--) 
		{
			int temp = asc[0]; 
			asc[0] = asc[i]; 
			asc[i] = temp;
			numofswap++;

			heapifyAsc(0, i); 
		} 
	}
	
	void heapifyAsc(int x, int n) 
	{ 
		int l = 2*x + 1;
		int r = 2*x + 2;
		int max = x;
		int tmp = 0;

		if (l < n && asc[l] > asc[max])
		{
			max = l;
		}

		if (r < n && asc[r] > asc[max])
		{
			max = r; 
		}
		
		numofcomp++;
		numofcomp++;
		numofcomp++;
		
		if (max != x) 
		{ 
			tmp = asc[x]; 
			asc[x] = asc[max]; 
			asc[max] = tmp; 
			numofswap++;

			heapifyAsc(max, n); 
		}
	} 
	
	@Override
	public void sortDesc()
	{
		int n = desc.length; 
		
		for (int i = n / 2 - 1; i >= 0; i--)
		{
			heapifyDesc(i, n);
		}
		
		for (int i=n-1; i>=0; i--) 
		{
			int temp = desc[0]; 
			desc[0] = desc[i]; 
			desc[i] = temp;
			numofswap++;

			heapifyDesc(0, i); 
		} 
	}
	
	void heapifyDesc(int x, int n) 
	{ 
		int l = 2*x + 1;
		int r = 2*x + 2;
		int min = x;
		int tmp = 0;

		if (l < n && asc[l] < asc[min])
		{
			min = l;
		}

		if (r < n && asc[r] < asc[min])
		{
			min = r; 
		}
		
		numofcomp++;
		numofcomp++;
		numofcomp++;
		
		if (min != x) 
		{ 
			tmp = asc[x];
			asc[x] = asc[min];
			asc[min] = tmp;
			numofswap++;

			heapifyDesc(min, n); 
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
