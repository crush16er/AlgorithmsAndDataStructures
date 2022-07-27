package binarysearch;


public class BinarySearch
{
	private int tab [];
	private int amountOfComp = 0;
	
	
	public BinarySearch(int [] tab)
	{
		this.tab = tab;
	}
	
	
	
	
	public int findElement(int x)
	{
		return searchElement(tab, 0, tab.length-1, x);
	}

	
	
	private int searchElement(int[] array, int left, int right, int x)
	{
		if (right >= left)
        {
			this.amountOfComp++;
			
            int target = left + (right - left)/2;
            
            if (array[target] == x)
            {
            	this.amountOfComp++;
            	return 1;
            }
            else if (array[target] > x)
            {
            	this.amountOfComp++;
            	this.amountOfComp++;
            	return searchElement(array, left, target-1, x);
            }
            else
            {
            	this.amountOfComp++;
            	this.amountOfComp++;
            	return searchElement(array, target+1, right, x);
            }
        }
        
		return 0;
	}
	
	public int getAmountOfComp()
	{
		return this.amountOfComp;
	}
}
