package sort;
import java.text.DecimalFormat;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Test
{
	public static void main(String[] args)
	{
		String typeofsort = "";
		String typeofcomp = "";
		int n = 0;
		int i = 0;
		char quote = '’';
		String comp1 = "";
		comp1+=quote;
		comp1+="<=";
		comp1+=quote;
		String comp2 = "";
		comp2+=quote;
		comp2+=">=";
		comp2+=quote;
		int k = 0;
		String nameoffile = "C:\\users\\sebastian\\Desktop\\PWR\\I\\SEM6\\AiSD\\Lab2\\";
		BufferedWriter bw = null;
		FileWriter fw = null;

	
		while(i<args.length)
		{
			if(args[i].equals("--type"))
			{
				if(i+1<args.length)
				{
					typeofsort = args[i+1];
				}
				break;
			}
			
			i++;
		}
		
		
		
		
		i = 0;
		
		while(i<args.length)
		{
			if(args[i].equals("--comp"))
			{
				if(i+1<args.length)
				{
					typeofcomp = args[i+1];
				}
				break;
			}
			
			i++;
		}

		i = 0;
		
		while(i<args.length)
		{
			if(args[i].equals("--asc"))
			{
				typeofcomp = comp1;
			}
			else if(args[i].equals("--desc"))
			{
				typeofcomp = comp2;
			}
			
			i++;
		}
		
		//int p = i;
		i = 0;
		
		while(i<args.length)
		{
			if(args[i].equals("--stat"))
			{
				if(i+2<args.length)
				{
					nameoffile += args[i+1];
					nameoffile += ".txt";
					k = Integer.parseInt(args[i+2]);
				}
				break;
			}
			
			i++;
			
			/*if(i == args.length)
			{
				i = p;
				break;
			}*/
		}
		
		
		if(typeofcomp.equals(comp1))
		{
			//System.out.println(typeofcomp);
		}
		else if(typeofcomp.equals(comp2))
		{
			//System.out.println(typeofcomp);
		}
		else
		{
			System.out.println("Error: Wrong type of comp.");
		}
		
		i = 0;
		boolean fail = false;
		
		while(i<args.length)
		{
			fail = false;
			try
			{
			    n = Integer.parseInt(args[i]);
			    if(k > 0)
				{
					i++;
				}
			    n = Integer.parseInt(args[i]);
			}
			catch (NumberFormatException e)
			{
				fail = true;
			}
			
			if(!fail)
			{
				break;
			}
			
			i++;
		}
		
		int []tabbb = new int[n];
		
		for(int j = 0; j<n; j++)
		{
			try
			{
				tabbb[j] = Integer.parseInt(args[j+i+1]);
			}
			catch (NumberFormatException e)
			{
			}
			
		}
		
		int []sortedtab = new int[n];
		
		
		if(k > 0)
		{
			typeofsort = "";
			try
			{
				fw = new FileWriter(nameoffile);
				bw = new BufferedWriter(fw);
				//bw.write("Number of comparisons: "+String.valueOf(sort.getNumOfComp())+" | Number of swaps: "+String.valueOf(sort.getNumOfSwap())+" | Time: "+new DecimalFormat("###.###############").format(seconds)+"s "+"| Number of elements: "+tabbb.length);

				Random random = new Random();

				for(i = 1000; i <= 100000; i += 1000)
				{
					bw.write(String.valueOf(i));
					bw.newLine();
					
					
					int []randtab = new int[i];
					
					for(int j = 0; j < i; j++)
					{
						randtab[j] = Math.abs(random.nextInt());
					}
					
					
					long start = 0;
					long elapsedTime = 0;
					double seconds = 0;
					
					
					//insert
					Sort insertsort = new InsertionSort(randtab);
					start = System.nanoTime();
					insertsort.sortAsc();
					elapsedTime = System.nanoTime() - start;
					sortedtab = insertsort.getSortedAsc();
					
					seconds = (double)elapsedTime / 1_000_000_000.0;
					
					bw.write(String.valueOf(insertsort.getNumOfComp())+" "+String.valueOf(insertsort.getNumOfSwap())+" "+new DecimalFormat("###.###############").format(seconds));
					bw.newLine();
					
					
					//merge
					Sort mergesort = new MergeSort(randtab);
					start = System.nanoTime();
					mergesort.sortAsc();
					elapsedTime = System.nanoTime() - start;
					sortedtab = mergesort.getSortedAsc();
					
					seconds = (double)elapsedTime / 1_000_000_000.0;
					
					bw.write(String.valueOf(mergesort.getNumOfComp())+" "+String.valueOf(mergesort.getNumOfSwap())+" "+new DecimalFormat("###.###############").format(seconds));
					bw.newLine();
					
					
					//quick
					Sort quicksort = new QuickSort(randtab);
					start = System.nanoTime();
					quicksort.sortAsc();
					elapsedTime = System.nanoTime() - start;
					sortedtab = quicksort.getSortedAsc();
					
					
					seconds = (double)elapsedTime / 1_000_000_000.0;
					
					bw.write(String.valueOf(quicksort.getNumOfComp())+" "+String.valueOf(quicksort.getNumOfSwap())+" "+new DecimalFormat("###.###############").format(seconds));
					bw.newLine();
					
					
					
					//heap
					Sort heapsort = new HeapSort(randtab);
					start = System.nanoTime();
					heapsort.sortAsc();
					elapsedTime = System.nanoTime() - start;
					sortedtab = heapsort.getSortedAsc();
					
					seconds = (double)elapsedTime / 1_000_000_000.0;
					
					bw.write(String.valueOf(heapsort.getNumOfComp())+" "+String.valueOf(heapsort.getNumOfSwap())+" "+new DecimalFormat("###.###############").format(seconds));
					bw.newLine();
					
					
					
					//select
					Sort selectsort = new SelectSort(randtab);
					start = System.nanoTime();
					selectsort.sortAsc();
					elapsedTime = System.nanoTime() - start;
					sortedtab = selectsort.getSortedAsc();

					
					seconds = (double)elapsedTime / 1_000_000_000.0;
					
					bw.write(String.valueOf(selectsort.getNumOfComp())+" "+String.valueOf(selectsort.getNumOfSwap())+" "+new DecimalFormat("###.###############").format(seconds));
					bw.newLine();
					
					
					
					//modifiedquick
					Sort modifiedquicksort = new ModifiedQuickSort(randtab);
					start = System.nanoTime();
					modifiedquicksort.sortAsc();
					elapsedTime = System.nanoTime() - start;
					sortedtab = modifiedquicksort.getSortedAsc();
					
					seconds = (double)elapsedTime / 1_000_000_000.0;
					
					bw.write(String.valueOf(modifiedquicksort.getNumOfComp())+" "+String.valueOf(modifiedquicksort.getNumOfSwap())+" "+new DecimalFormat("###.###############").format(seconds));
					bw.newLine();
					
					
					
				}
				
				
				
				
				
				
				
				
				System.out.println("Done");

			}
			catch (IOException e)
			{
				e.printStackTrace();

			} 
			finally
			{
				try
				{

					if (bw != null)
						bw.close();

					if (fw != null)
						fw.close();

				} catch (IOException ex)
				{
					ex.printStackTrace();
				}

			}
		}
		else if(typeofsort.equals("insert"))
		{
			Sort sort = new InsertionSort(tabbb);
			long start = 0;
			long elapsedTime = 0;
			
			if(typeofcomp.equals(comp1))
			{
				start = System.nanoTime();
				sort.sortAsc();
				sortedtab = sort.getSortedAsc();
				elapsedTime = System.nanoTime() - start;
			}
			else if(typeofcomp.equals(comp2))
			{
				start = System.nanoTime();
				sort.sortDesc();
				sortedtab = sort.getSortedDesc();
				elapsedTime = System.nanoTime() - start;
			}
			else
			{
				System.out.println("Error: Wrong type of comp.");
			}
			
			double seconds = (double)elapsedTime / 1_000_000_000.0;
			
			System.out.println("Number of comparisons: "+String.valueOf(sort.getNumOfComp())+" | Number of swaps: "+String.valueOf(sort.getNumOfSwap())+" | Time: "+new DecimalFormat("###.###############").format(seconds)+"s "+"| Number of elements: "+tabbb.length);
		}
		else if(typeofsort.equals("merge"))
		{
			Sort sort = new MergeSort(tabbb);
			long start = 0;
			long elapsedTime = 0;
			
			if(typeofcomp.equals(comp1))
			{
				start = System.nanoTime();
				sort.sortAsc();
				sortedtab = sort.getSortedAsc();
				elapsedTime = System.nanoTime() - start;
			}
			else if(typeofcomp.equals(comp2))
			{
				start = System.nanoTime();
				sort.sortDesc();
				sortedtab = sort.getSortedDesc();
				elapsedTime = System.nanoTime() - start;
			}
			else
			{
				System.out.println("Error: Wrong type of comp.");
			}
			
			double seconds = (double)elapsedTime / 1_000_000_000.0;
			
			System.out.println("Number of comparisons: "+String.valueOf(sort.getNumOfComp())+" | Number of swaps: "+String.valueOf(sort.getNumOfSwap())+" | Time: "+new DecimalFormat("###.###############").format(seconds)+"s "+"| Number of elements: "+tabbb.length);
		}
		else if(typeofsort.equals("quick"))
		{
			Sort sort = new QuickSort(tabbb);
			long start = 0;
			long elapsedTime = 0;
			
			if(typeofcomp.equals(comp1))
			{
				start = System.nanoTime();
				sort.sortAsc();
				sortedtab = sort.getSortedAsc();
				elapsedTime = System.nanoTime() - start;
			}
			else if(typeofcomp.equals(comp2))
			{
				start = System.nanoTime();
				sort.sortDesc();
				sortedtab = sort.getSortedDesc();
				elapsedTime = System.nanoTime() - start;
			}
			else
			{
				System.out.println("Error: Wrong type of comp.");
			}
			
			double seconds = (double)elapsedTime / 1_000_000_000.0;
			
			System.out.println("Number of comparisons: "+String.valueOf(sort.getNumOfComp())+" | Number of swaps: "+String.valueOf(sort.getNumOfSwap())+" | Time: "+new DecimalFormat("###.###############").format(seconds)+"s "+"| Number of elements: "+tabbb.length);
		}
		else if(typeofsort.equals("heap"))
		{
			Sort sort = new HeapSort(tabbb);
			long start = 0;
			long elapsedTime = 0;
			
			if(typeofcomp.equals(comp1))
			{
				start = System.nanoTime();
				sort.sortAsc();
				sortedtab = sort.getSortedAsc();
				elapsedTime = System.nanoTime() - start;
			}
			else if(typeofcomp.equals(comp2))
			{
				start = System.nanoTime();
				sort.sortDesc();
				sortedtab = sort.getSortedDesc();
				elapsedTime = System.nanoTime() - start;
			}
			else
			{
				System.out.println("Error: Wrong type of comp.");
			}
			
			double seconds = (double)elapsedTime / 1_000_000_000.0;
			
			System.out.println("Number of comparisons: "+String.valueOf(sort.getNumOfComp())+" | Number of swaps: "+String.valueOf(sort.getNumOfSwap())+" | Time: "+new DecimalFormat("###.###############").format(seconds)+"s "+"| Number of elements: "+tabbb.length);
		}
		else if(typeofsort.equals("select"))
		{
			Sort sort = new SelectSort(tabbb);
			long start = 0;
			long elapsedTime = 0;
			
			if(typeofcomp.equals(comp1))
			{
				start = System.nanoTime();
				sort.sortAsc();
				sortedtab = sort.getSortedAsc();
				elapsedTime = System.nanoTime() - start;
			}
			else if(typeofcomp.equals(comp2))
			{
				start = System.nanoTime();
				sort.sortDesc();
				sortedtab = sort.getSortedDesc();
				elapsedTime = System.nanoTime() - start;
			}
			else
			{
				System.out.println("Error: Wrong type of comp.");
			}
			
			double seconds = (double)elapsedTime / 1_000_000_000.0;
			
			
			System.out.println("Number of comparisons: "+String.valueOf(sort.getNumOfComp())+" | Number of swaps: "+String.valueOf(sort.getNumOfSwap())+" | Time: "+new DecimalFormat("###.###############").format(seconds)+"s "+"| Number of elements: "+tabbb.length);
		}
		else
		{
			System.out.println("Error: Wrong type of sort.");
		}
		
		
		
		
		
		
		
		if(k == 0)
		{
			for(i = 0; i < sortedtab.length; i++)
			{
				System.out.println(typeofsort+": "+sortedtab[i]);
			}
		}
		
		
	}

}
