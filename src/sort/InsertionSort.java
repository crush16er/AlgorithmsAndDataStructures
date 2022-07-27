package sort;

public class InsertionSort implements Sort
{
	private int []desc;
	private int []asc;
	private int []pre;
	private int numofcomp = 0;
	private int numofswap = 0;
	
	
	public InsertionSort(int []tab)
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
        
        for (int i = 1; i < n; i++)
        {
            int key = asc[i];
            
            int j = i-1;
 
            while (j >= 0 && asc[j] > key)
            {
                asc[j+1] = asc[j];
                numofcomp++;
                numofswap++;
                j = j-1;
            }
            numofcomp++;
            
            asc[j+1] = key;
            numofswap++;
        }
	}
	
	@Override
	public void sortDesc()
	{
		numofcomp = 0;
		numofswap = 0;
		
		int n = desc.length;
        
		for (int i = 1; i < n; i++)
        {
            int key = desc[i];
            int j = i-1;
 
            while (j >= 0 && desc[j] < key)
            {
                desc[j+1] = desc[j];
                numofcomp++;
                numofswap++;
                j = j-1;
            }
            numofcomp++;
            
            
            desc[j+1] = key;
            numofswap++;
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
