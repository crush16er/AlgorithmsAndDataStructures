package sort;

public class ModifiedQuickSort implements Sort
{
	private int []desc;
	private int []asc;
	private int []pre;
	private int numofcomp = 0;
	private int numofswap = 0;
	
	
	public ModifiedQuickSort(int []tab)
	{
		this.pre = tab;
		this.asc = tab;
		this.desc = tab;
	}
	
	void swap(int i, int j)
    {
        int t = asc[i];
        asc[i] = asc[j];
        asc[j] = t;
        numofswap++;
    }
 
	int partitionAsc(int l, int h)
    {
        int x = asc[h];
        int i = (l - 1);
 
        for (int j = l; j <= h- 1; j++)
        {
            if (asc[j] <= x)
            {
            	
                i++;
                swap(i, j);
            }
            numofcomp++;
        }
        swap(i+1, h);
        return (i + 1);
    }
	
	int partitionDesc(int l, int h)
    {
        int x = asc[h];
        int i = (l - 1);
 
        for (int j = l; j <= h- 1; j++)
        {
            if (asc[j] >= x)
            {
                i++;
                swap(i, j);
            }
            numofcomp++;
        }
        
        swap(i+1, h);
        return (i + 1);
    }
 
	@Override
	public void sortAsc()
	{
		numofcomp = 0;
		numofswap = 0;
		
		int h = asc.length-1;
		int l = 0;
        int stack[] = new int[h-l+1];
        int top = -1;
 
        stack[++top] = l;
        stack[++top] = h;
 
        while (top >= 0)
        {
            h = stack[top--];
            l = stack[top--];
 
            int p = partitionAsc(l, h);
 
            if ( p-1 > l )
            {
                stack[ ++top ] = l;
                stack[ ++top ] = p - 1;
            }
            numofcomp++;
            
            if ( p+1 < h )
            {
                stack[ ++top ] = p + 1;
                stack[ ++top ] = h;
            }
            numofcomp++;
       }

	}
	
	@Override
	public void sortDesc()
	{
		numofcomp = 0;
		numofswap = 0;
		
		int h = asc.length-1;
		int l = 0;
        int stack[] = new int[h-l+1];
 
        int top = -1;
 
        stack[++top] = l;
        stack[++top] = h;
 
        while (top >= 0)
        {
            h = stack[top--];
            l = stack[top--];
 
            int p = partitionDesc(l, h);
 
            if ( p-1 > l )
            {
                stack[ ++top ] = l;
                stack[ ++top ] = p - 1;
            }
            numofcomp++;
            if ( p+1 < h )
            {
                stack[ ++top ] = p + 1;
                stack[ ++top ] = h;
            }
            numofcomp++;
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
