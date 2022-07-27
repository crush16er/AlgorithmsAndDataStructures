package sort;

public interface Sort
{
	public void sortAsc();
	public void sortDesc();
	public int [] getSortedAsc();
	public int [] getSortedDesc();
	public int getNumOfComp();
	public int getNumOfSwap();
	public int [] initialData();
}
