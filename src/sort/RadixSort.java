package sort;

public class RadixSort implements Sort
{
	private int []desc;
	private int []asc;
	private int []pre;
	private int numofcomp = 0;
	private int numofswap = 0;
	private int d;
	
	
	public RadixSort(int []tab)
	{
		this.pre = tab;
		this.asc = tab;
		this.desc = tab;
		
		setD();
	}

	
	
	private void setD()
	{
		int max = pre[0];
		int count = 0;
		
		for(int i = 1; i < pre.length; i++)
		{
			if(pre[i] > max)
			{
				max = pre[i];
			}
		}
		
		
		while(max>0)
		{
			max/=10;
			count++;
		}
		
		this.d = count;
	}




	@Override
	public void sortAsc()
	{
		int p = 0;
		int md = 1;
		int dv = 1;
		int n = asc.length;
		int l = -1;
		
		//System.out.println("d: "+d);
		for(int i = 1; i <= d; i++)
		{
			p = 0;
			md *= 10;
			dv = md/10;
			
			for(int c = -1; c <= 9; c++)
			{
				for(int j = p; j < n; j++)
				{
					if(asc[j]<dv)
					{
						l = -1;
					}
					else
					{
						l = (asc[j]%md)/dv;
					}
					
					
					if(l == c)
					{
						int tmp = asc[p];
						asc[p] = asc[j];
						asc[j] = tmp;
						p++;
					}
				}
			}
		}
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Override
	public void sortDesc()
	{
		// TODO Auto-generated method stub
		
		
		int p = 0;
		int md = 1;
		int dv = 1;
		int n = desc.length;
		int l = -1;
		
		System.out.println("d: "+d);
		for(int i = 1; i <= d; i++)
		{
			p = n-1;
			md *= 10;
			dv = md/10;
			
			for(int c = -1; c <= 9; c++)
			{
				for(int j = p; j >= 0; j--)
				{
					if(desc[j]<dv)
					{
						l = -1;
					}
					else
					{
						l = (desc[j]%md)/dv;
					}
					
					
					if(l == c)
					{
						int tmp = desc[p];
						desc[p] = desc[j];
						desc[j] = tmp;
						p--;
					}
				}
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
