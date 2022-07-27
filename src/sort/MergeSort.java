package sort;

public class MergeSort implements Sort
{
	private int []desc;
	private int []asc;
	private int []pre;
	private int numofcomp = 0;
	private int numofswap = 0;
	
	
	public MergeSort(int []tab)
	{
		this.pre = tab;
		this.asc = tab;
		this.desc = tab;
	}
	
	
	/*@Override
	public void sortAsc()
	{
		numofcomp = 0;
		numofswap = 0;
		
		int n = asc.length;
		int curr_size;
		int left_start;
		
		for (curr_size = 1; curr_size <= n-1; curr_size = 2*curr_size)
		{
			for (left_start = 0; left_start < n-1; left_start += 2*curr_size)
			{
				int mid = left_start + curr_size - 1;
				int right_end = Math.min(left_start + 2*curr_size - 1, n-1);
				mergeAsc(left_start, mid, right_end);
			}
		}
	}*/
	
	public void sortAsc()
	{
		mergeSort(this.pre, this.pre.length);
	}
	
	public static void mergeSort(int[] a, int n)
	{
	    if (n < 2) {
	        return;
	    }
	    int mid = n / 2;
	    int[] l = new int[mid];
	    int[] r = new int[n - mid];
	 
	    for (int i = 0; i < mid; i++) {
	        l[i] = a[i];
	    }
	    for (int i = mid; i < n; i++) {
	        r[i - mid] = a[i];
	    }
	    mergeSort(l, mid);
	    mergeSort(r, n - mid);
	 
	    mergeAsc(a, l, r, mid, n - mid);
	}
	
	@Override
	public void sortDesc()
	{
		numofcomp = 0;
		numofswap = 0;
		
		int n = asc.length;
		int curr_size;
		int left_start;

		for (curr_size = 1; curr_size <= n-1; curr_size = 2*curr_size)
		{
			for (left_start = 0; left_start < n-1; left_start += 2*curr_size)
			{
				int mid = left_start + curr_size - 1;
				int right_end = Math.min(left_start + 2*curr_size - 1, n-1);
				mergeDesc(left_start, mid, right_end);
			}
		}

	}
	
	
	/*void mergeAsc(int l, int m, int r)
	{
	    int i, j, k;
	    int n1 = m - l + 1;
	    int n2 =  r - m;

	    int []L = new int[n1];
	    System.out.println(r+" "+m);
	    int []R = new int[n2];
	 
	    for (i = 0; i < n1; i++)
	    {
	    	L[i] = asc[l + i];
	    	numofswap++;
	    }
	        
	    for (j = 0; j < n2; j++)
	    {
	    	R[j] = asc[m + 1+ j];
	    	numofswap++;
	    }
	       
	 
	    i = 0;
	    j = 0;
	    k = l;
	    
	    while (i < n1 && j < n2)
	    {
	        if (L[i] <= R[j])
	        {
	            asc[k] = L[i];
	            i++;
	            
	        }
	        else
	        {
	            asc[k] = R[j];
	            j++;
	        }
	        
	        numofcomp++;
            numofswap++;
	        k++;
	    }
	    numofcomp++;
	 
	    while (i < n1)
	    {
	        asc[k] = L[i];
	        i++;
	        k++;
	        numofcomp++;
            numofswap++;
	    }
	    numofcomp++;
	 
	    while (j < n2)
	    {
	        asc[k] = R[j];
	        j++;
	        k++;
	        numofcomp++;
            numofswap++;
	    }
	    numofcomp++;
	}*/
	
	public static void mergeAsc(
			  int[] a, int[] l, int[] r, int left, int right) {
			  
			    int i = 0, j = 0, k = 0;
			    while (i < left && j < right) {
			        if (l[i] <= r[j]) {
			            a[k++] = l[i++];
			        }
			        else {
			            a[k++] = r[j++];
			        }
			    }
			    while (i < left) {
			        a[k++] = l[i++];
			    }
			    while (j < right) {
			        a[k++] = r[j++];
			    }
			}
	
	void mergeDesc(int l, int m, int r)
	{
	    int i, j, k;
	    int n1 = m - l + 1;
	    int n2 =  r - m;

	    int []L = new int[n1];
	    int []R = new int[n2];
	 
	    for (i = 0; i < n1; i++)
	    {
	    	L[i] = asc[l + i];
	    	numofswap++;
	    }
	        
	    for (j = 0; j < n2; j++)
	    {
	    	R[j] = asc[m + 1+ j];
	    	numofswap++;
	    }
	        
	 
	    i = 0;
	    j = 0;
	    k = l;
	    
	    while (i < n1 && j < n2)
	    {
	        if (L[i] >= R[j])
	        {
	            asc[k] = L[i];
	            i++;
	        }
	        else
	        {
	            asc[k] = R[j];
	            j++;
	        }
	        
	        numofcomp++;
            numofswap++;
	        k++;
	    }
	    numofcomp++;
	 
	    while (i < n1)
	    {
	        asc[k] = L[i];
	        i++;
	        k++;
	        numofcomp++;
            numofswap++;
	    }
	    numofcomp++;

	    
	    while (j < n2)
	    {
	        asc[k] = R[j];
	        j++;
	        k++;
	        numofcomp++;
            numofswap++;
	    }
	    numofcomp++;
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
