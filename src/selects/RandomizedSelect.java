package selects;

public class RandomizedSelect
{
	int idx = 0;
	private int amountOfSwap = 0;
	private int amountOfComp = 0;

	public RandomizedSelect()
	{
	}

	public void randomizedSelect(int[] tab, int p, int q, int k)
	{

		this.amountOfComp++;
		if(p == q)
		{
			//return tab[p];
			if(tab.length<=50)
			{
				for(int l = 0; l < tab.length; l++)
				{
					if(l == p)
					{
						System.out.format("[%d] ", tab[l]);
					}
					else
					{
						System.out.format("%d ", tab[l]);
					}
					
				}
			}
			else
			{
				System.out.println(tab[p]);
			}
			
		}
		
		/*Random rand = new Random();
		int r = rand.nextInt(q-p+1) + p;*/
		
		int r = p + (int)(Math.random() * ((q-p) + 1));

		//System.out.println("pivot: "+tab[r]);
		int tmp = tab[r];
		tab[r] = tab[q];
		tab[q] = tmp;
		this.amountOfSwap++;
		
		tab = partition(tab, p, q, q);
		/*for(int l = 0; l < tab.length; l++)
		{
			System.out.format("%d ", tab[l]);
		}
		System.out.println("");*/
		r = idx;
		int i = r-p+1;
		
		if(k == i)
		{

			this.amountOfComp++;
			if(tab.length<=50)
			{
				for(int l = 0; l < tab.length; l++)
				{
					if(l == p)
					{
						System.out.format("[%d] ", tab[l]);
					}
					else
					{
						System.out.format("%d ", tab[l]);
					}
					
				}
			}
			else
			{
				System.out.println(tab[p]);
			}
			
			//return tab[r];
		}
		else if(k < i)
		{

			this.amountOfComp++;
			this.amountOfComp++;
			/*return */randomizedSelect(tab, p, r-1, k);
		}
		else
		{

			this.amountOfComp++;
			this.amountOfComp++;
			/*return*/ randomizedSelect(tab, r+1, q, k-i);
		}
	}

	public int[] partition(int[] tab, int p, int q, int r)
	{
		int pivot = tab[q];

        int i = p-1;
        int temp=0;

        for(int j=p; j<r; j++)
        {
            if(tab[j]<=pivot)
            {
                i++;
                temp = tab[i];
                tab[i] = tab[j];
                tab[j] = temp;
            }
        }

        temp = tab[i+1];
        tab[i+1] = tab[r];
        tab[r] = temp;
        
        idx = (i+1);
        
        return tab;
	}
	
	public int getAmountOfComp()
	{
		return this.amountOfComp;
	}
	
	public int getAmountOfSwap()
	{
		return this.amountOfSwap;
	}

}
