package selects;

import java.util.ArrayList;

public class Select
{
	int idx = 0;
	int [] a;

	public Select(int [] tab)
	{
		this.a = tab;
	}

	public int select(int[] tab, int p, int q, int ii)
	{
		int n = q-p+1;
		int np = (int)Math.ceil(n/5.0);
		//System.out.println(np);
		int [][] arr = new int [np][5];
		int x = 0;
		
		for(int i=0; i<n; i++)
		{
			arr[x][i%5] = tab[i];
			
			if(i%5 == 4)
			{
				x++;
			}
		}
		
		ArrayList<ArrayList> array = new ArrayList<ArrayList>();
		
		
		
		for(int i=0; i<np; i++)
		{
			ArrayList<Integer> tmp = new ArrayList<Integer>();
			
			for(int j=0; j<5; j++)
			{
				//System.out.println(arr[i][j]+" ");
				tmp.add(arr[i][j]);
			}
			
			array.add(tmp);
		}
		
		int del = n%5;
		//System.out.println(arr[6][0]+ " "+arr[6][1]+ " "+arr[6][2]+ " "+arr[6][3]+ " "+arr[6][4]+ " "+del);
		if(del>0)
		{
			ArrayList<Integer> tmpp = new ArrayList<Integer>();
			
			tmpp = array.get(array.size()-1);
			
			for(int i = del; i<5; i++)
			{
				tmpp.remove(del);
			}
			
			array.set(array.size()-1, tmpp);
		}
		
		
		
		
		for(int i = 0; i < array.size(); i++)
		{
			if(array.get(i).size() == 5)
			{
				
				ArrayList<Integer> tmpp = new ArrayList<Integer>();
				
				tmpp = array.get(i);
				
				int min = tmpp.get(0);
				int idx = 0;
				
				
				for(int j = 1; j < 5; j++)
				{
					if(tmpp.get(j) < min)
					{
						idx = j;
						min = tmpp.get(j);
					}
				}
				
				
				int tmp = tmpp.get(idx);
				tmpp.set(idx, tmpp.get(0));
				tmpp.set(0, tmp);
				
				
				min = tmpp.get(1);
				idx = 1;
				
				
				for(int j = 2; j < 5; j++)
				{
					if(tmpp.get(j) < min)
					{
						idx = j;
						min = tmpp.get(j);
					}
				}
				
				
				tmp = tmpp.get(idx);
				tmpp.set(idx, tmpp.get(1));
				tmpp.set(1, tmp);
				
				
				
				min = tmpp.get(2);
				idx = 2;
				
				
				for(int j = 3; j < 5; j++)
				{
					if(tmpp.get(j) < min)
					{
						idx = j;
						min = tmpp.get(j);
					}
				}
				
				
				tmp = tmpp.get(idx);
				tmpp.set(idx, tmpp.get(0));
				tmpp.set(0, tmp);
				
				
				array.set(i, tmpp);
				
			}
			else if(array.get(i).size() == 4 || array.get(i).size() == 3)
			{
				ArrayList<Integer> tmpp = new ArrayList<Integer>();
				
				tmpp = array.get(i);
				
				int min = tmpp.get(0);
				int idx = 0;
				
				
				for(int j = 1; j < tmpp.size(); j++)
				{
					if(tmpp.get(j) < min)
					{
						idx = j;
						min = tmpp.get(j);
					}
				}
				
				
				int tmp = tmpp.get(idx);
				tmpp.set(idx, tmpp.get(0));
				tmpp.set(0, tmp);
				
				
				min = tmpp.get(1);
				idx = 1;
				
				
				for(int j = 2; j < tmpp.size(); j++)
				{
					if(tmpp.get(j) < min)
					{
						idx = j;
						min = tmpp.get(j);
					}
				}
				
				
				tmp = tmpp.get(idx);
				tmpp.set(idx, tmpp.get(0));
				tmpp.set(0, tmp);
				
				
				array.set(i, tmpp);
			}
			else if(array.get(i).size() == 2)
			{
				ArrayList<Integer> tmpp = new ArrayList<Integer>();
				
				tmpp = array.get(i);
				
				if(tmpp.get(0)>tmpp.get(1))
				{
					int tmp = tmpp.get(0);
					tmpp.set(0, tmpp.get(1));
					tmpp.set(1, tmp);
				}
				
				
				array.set(i, tmpp);
			}
		}
		
		for(int i=0; i<array.size(); i++)
		{
			for(int j=0; j<array.get(i).size(); j++)
			{
				System.out.println(array.get(i).get(j)+" ");
			}
			
			System.out.println();
		}
		
		int [] t = new int [np];
		
		for(int i = 0; i < np; i++)
		{
			t[i] = (int)array.get(i).get(0);
		}
		
		int pivot;
		System.out.println(tab.length);
		if(t.length<=5)
		{
			//System.out.println("y"+np);
			int min = t[0];
			int idx = 0;
			
			for(int i = 0; i < t.length-1; i++)
			{
				for(int j = i; j < t.length-1; j++)
				{
					if(t[j]<min)
					{
						min = t[j];
						idx = j;
					}
				}
				
				t[idx] = t[i];
				t[i] = min;
			}
			//System.out.print(t[0]+" "+t[1]+"x"+t.length+" "+(int)(Math.floor((t.length-1)/2.0))+"x");
			pivot = t[(int)(Math.floor((t.length-1)/2.0))];
		}
		else
		{
			//System.out.println("z"+np);
			pivot = select(t, 0, np-1, (int)Math.floor(np/2.0));
		}
		int r=0;
		for(int i = 0; i < a.length; i++)
		{
			if(a[i] == pivot)
			{
				r = i;
			}
		}
		
		int tmp = a[r];
		a[r] = a[a.length-1];
		a[a.length-1] = tmp;
		
		a = partition(a, p, q, q);
		
		
		if(this.idx-1 == ii)
		{
			return pivot;
		}
		else if(ii < this.idx-1)
		{
			return select(a, p, this.idx-2, ii);
		}
		else
		{
			return select(a, this.idx, q, ii-(this.idx-1));
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

}

