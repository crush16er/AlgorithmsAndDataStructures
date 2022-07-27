package structures;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main
{

	public static void main(String[] args)
	{
		long startTime = System.currentTimeMillis();
		String[] launch = {"--type", "bst", "<./input", ">out.res"};
		String structure = "";
		int n = 0;
		int lastAmountOfElements = 0;
		int maxAmountOfElements = 0;
		int AmountOfInsert = 0;
		int AmountOfLoad = 0;
		int AmountOfDelete = 0;
		int AmountOfFind = 0;
		int AmountOfMin = 0;
		int AmountOfMax = 0;
		int AmountOfSuccessor = 0;
		int AmountOfInorder = 0;
		String fout = "C:\\Users\\sebastian\\workspace\\AiSD4\\src\\structures\\";
		String[] data = null;
		
		for(int i = 0; i < launch.length; i++)
		{
			if(launch[i].equals("--type") && i < launch.length + 1)
			{
				structure = launch[i+1];
			}
			else if(Character.toString((launch[i].charAt(0))).matches(">"))
			{
				fout += launch[i].substring(1);
			}
			else if(Character.toString((launch[i].charAt(0))).matches("<"))
			{
				if(launch[i].substring(1).equals("./input"))
				{
					data = args;
				}
				else
				{
					
				}
			}
		}
		
		//structure = "bst";
		//fout += "out.res";
		PrintWriter writer = null;
		
		try
		{
			writer = new PrintWriter(fout, "UTF-8");
	    } catch (FileNotFoundException e)
		{
	        e.printStackTrace();  
	    } catch (UnsupportedEncodingException e)
		{
			e.printStackTrace();
		}
		
		
		
		
		
		try
		{
		    n = Integer.parseInt(data[0]);
		}
		catch (NumberFormatException e)
		{
		}
		
		if(structure.equals("bst") && n > 0)
		{
			BinarySearchTree bst = new BinarySearchTree();
			
			
			for(int i = 1; i < data.length; i++)
			{
				if(data[i].equals("insert"))
				{
					String key = data[i+1];
					
					while(!key.equals("") & (!Character.toString((key.charAt(0))).matches("[A-Za-z]") || !Character.toString((key.charAt(key.length()-1))).matches("[A-Za-z]")))
					{
						if(!Character.toString((key.charAt(0))).matches("[A-Za-z]"))
						{
							key = key.substring(1);
						}
						
						if(!Character.toString((key.charAt(key.length()-1))).matches("[A-Za-z]"))
						{
							key = key.substring(0,key.length()-1);
						}
					}
					
					if(!key.equals(""))
					{
						bst.insert(key);
						AmountOfInsert++;
					}
					
					i++;
				}
				else if(data[i].equals("load"))
				{
					AmountOfLoad++;
					String file = "C:\\Users\\sebastian\\workspace\\AiSD4\\src\\structures\\";
					file += data[i+1];
					Scanner sc2 = null;
				    try {
				        sc2 = new Scanner(new File(file));
				    } catch (FileNotFoundException e) {
				        e.printStackTrace();  
				    }
				    while (sc2.hasNextLine()) {
				            Scanner s2 = new Scanner(sc2.nextLine());
				        while (s2.hasNext()) {
				            String s = s2.next();
				            //System.out.println(s);
				            //bst.insert(s);
				            
				            
				            /**/
				            String key = s;
							
							while(!key.equals("") & (!Character.toString((key.charAt(0))).matches("[A-Za-z]") || !Character.toString((key.charAt(key.length()-1))).matches("[A-Za-z]")))
							{
								if(!Character.toString((key.charAt(0))).matches("[A-Za-z]"))
								{
									key = key.substring(1);
								}
								
								if(!Character.toString((key.charAt(key.length()-1))).matches("[A-Za-z]"))
								{
									key = key.substring(0,key.length()-1);
								}
							}
							
							if(!key.equals(""))
							{
								bst.insert(key);
								AmountOfInsert++;
							}
				            /**/
				        }
				        s2.close();
				    }
					
					i++;
				}
				else if(data[i].equals("delete"))
				{
					AmountOfDelete++;
					AmountOfSuccessor++;
					AmountOfFind+=2;
					if(bst.find(data[i+1]) != null)
					{
						bst.delete(data[i+1]);
					}
					
					i++;
				}
				else if(data[i].equals("find"))
				{
					/*System.out.println("find1");
					bst.inOrder(bst.returnRoot());
					
					ArrayList<String> inOrderList = bst.printInOrder();
					for(int j = 0; j < inOrderList.size(); j++)
					{
						System.out.print(inOrderList.get(j) + " ");
					}
					System.out.println();
					System.out.println(data[i+1]);*/
					//System.out.println(bst.returnFound(bst.find(data[i+1])));
					writer.println(bst.returnFound(bst.find(data[i+1])));
					i++;
					AmountOfFind++;
					//System.out.println("find2");
				}
				else if(data[i].equals("min"))
				{
					//System.out.println("Min: " + bst.printKey(bst.min(bst.returnRoot())));
					//System.out.println(bst.printKey(bst.min(bst.returnRoot())));
					writer.println(bst.printKey(bst.min(bst.returnRoot())));
					AmountOfMin++;
				}
				else if(data[i].equals("max"))
				{
					//System.out.println("Max: " + bst.printKey(bst.max(bst.returnRoot())));
					//System.out.println(bst.printKey(bst.max(bst.returnRoot())));
					writer.println(bst.printKey(bst.max(bst.returnRoot())));
					AmountOfMax++;
				}
				else if(data[i].equals("successor"))
				{
					//System.out.println(bst.printKey(bst.successor(data[i+1])));
					if(bst.find(data[i+1]) != null)
					{
						writer.println(bst.printKey(bst.successor(data[i+1])));
					}
					else
					{
						writer.println("Error: key not found");
					}
					
					i++;
					AmountOfSuccessor++;
					AmountOfFind+=2;
				}
				else if(data[i].equals("inorder"))
				{
					AmountOfInorder++;
					bst.inOrder(bst.returnRoot());
					
					ArrayList<String> inOrderList = bst.printInOrder();
					for(int j = 0; j < inOrderList.size(); j++)
					{
						//System.out.print(inOrderList.get(j) + " ");
						writer.print(inOrderList.get(j) + " ");
					}
					//System.out.println();
					writer.println();
				}
			}
			
			lastAmountOfElements = bst.getLastAmount();
			maxAmountOfElements = bst.getMaxAmount();
			
		}
		else if(structure.equals("rbt") && n > 0)
		{
			RedBlackTree rbt = new RedBlackTree();
			
			
			for(int i = 1; i < data.length; i++)
			{
				if(data[i].equals("insert"))
				{
					String key = data[i+1];
					
					while(!key.equals("") & (!Character.toString((key.charAt(0))).matches("[A-Za-z]") || !Character.toString((key.charAt(key.length()-1))).matches("[A-Za-z]")))
					{
						if(!Character.toString((key.charAt(0))).matches("[A-Za-z]"))
						{
							key = key.substring(1);
						}
						
						if(!Character.toString((key.charAt(key.length()-1))).matches("[A-Za-z]"))
						{
							key = key.substring(0,key.length()-1);
						}
					}
					
					if(!key.equals(""))
					{
						rbt.insert(key);
						AmountOfInsert++;
					}
					
					i++;
				}
				else if(data[i].equals("load"))
				{
					AmountOfLoad++;
					String file = "C:\\Users\\sebastian\\workspace\\AiSD4\\src\\structures\\";
					file += data[i+1];
					Scanner sc2 = null;
				    try {
				        sc2 = new Scanner(new File(file));
				    } catch (FileNotFoundException e) {
				        e.printStackTrace();  
				    }
				    while (sc2.hasNextLine()) {
				            Scanner s2 = new Scanner(sc2.nextLine());
				        while (s2.hasNext()) {
				            String s = s2.next();
				            //System.out.println(s);
				            //bst.insert(s);
				            
				            
				            /**/
				            String key = s;
							
							while(!key.equals("") & (!Character.toString((key.charAt(0))).matches("[A-Za-z]") || !Character.toString((key.charAt(key.length()-1))).matches("[A-Za-z]")))
							{
								if(!Character.toString((key.charAt(0))).matches("[A-Za-z]"))
								{
									key = key.substring(1);
								}
								
								if(!Character.toString((key.charAt(key.length()-1))).matches("[A-Za-z]"))
								{
									key = key.substring(0,key.length()-1);
								}
							}
							
							if(!key.equals(""))
							{
								rbt.insert(key);
								AmountOfInsert++;
							}
				            /**/
				        }
				        s2.close();
				    }
					
					i++;
				}
				else if(data[i].equals("delete"))
				{
					AmountOfDelete++;
					AmountOfSuccessor++;
					AmountOfFind+=2;
					if(rbt.find(data[i+1]) != null)
					{
						rbt.delete(data[i+1]);
					}
					
					i++;
				}
				else if(data[i].equals("find"))
				{
					/*System.out.println("find1");
					bst.inOrder(bst.returnRoot());
					
					ArrayList<String> inOrderList = bst.printInOrder();
					for(int j = 0; j < inOrderList.size(); j++)
					{
						System.out.print(inOrderList.get(j) + " ");
					}
					System.out.println();
					System.out.println(data[i+1]);*/
					//System.out.println(bst.returnFound(bst.find(data[i+1])));
					writer.println(rbt.returnFound(rbt.find(data[i+1])));
					i++;
					AmountOfFind++;
					//System.out.println("find2");
				}
				else if(data[i].equals("min"))
				{
					//System.out.println("Min: " + bst.printKey(bst.min(bst.returnRoot())));
					//System.out.println(bst.printKey(bst.min(bst.returnRoot())));
					writer.println(rbt.printKey(rbt.min(rbt.returnRoot())));
					AmountOfMin++;
				}
				else if(data[i].equals("max"))
				{
					//System.out.println("Max: " + bst.printKey(bst.max(bst.returnRoot())));
					//System.out.println(bst.printKey(bst.max(bst.returnRoot())));
					writer.println(rbt.printKey(rbt.max(rbt.returnRoot())));
					AmountOfMax++;
				}
				else if(data[i].equals("successor"))
				{
					//System.out.println(bst.printKey(bst.successor(data[i+1])));
					if(rbt.find(data[i+1]) != null)
					{
						writer.println(rbt.printKey(rbt.successor(data[i+1])));
					}
					else
					{
						writer.println("Error: key not found");
					}
					
					i++;
					AmountOfSuccessor++;
					AmountOfFind+=2;
				}
				else if(data[i].equals("inorder"))
				{
					AmountOfInorder++;
					rbt.inOrder(rbt.returnRoot());
					
					ArrayList<String> inOrderList = rbt.printInOrder();
					for(int j = 0; j < inOrderList.size(); j++)
					{
						//System.out.print(inOrderList.get(j) + " ");
						writer.print(inOrderList.get(j) + " ");
					}
					//System.out.println();
					writer.println();
				}
			}
			
			lastAmountOfElements = rbt.getLastAmount();
			maxAmountOfElements = rbt.getMaxAmount();
		}
		else if(structure.equals("hmap") && n > 0)
		{
			HashMap hmp = new HashMap();
			
			
			for(int i = 1; i < data.length; i++)
			{
				if(data[i].equals("insert"))
				{
					String key = data[i+1];
					
					while(!key.equals("") & (!Character.toString((key.charAt(0))).matches("[A-Za-z]") || !Character.toString((key.charAt(key.length()-1))).matches("[A-Za-z]")))
					{
						if(!Character.toString((key.charAt(0))).matches("[A-Za-z]"))
						{
							key = key.substring(1);
						}
						
						if(!Character.toString((key.charAt(key.length()-1))).matches("[A-Za-z]"))
						{
							key = key.substring(0,key.length()-1);
						}
					}
					
					if(!key.equals(""))
					{
						hmp.insert(key);
						AmountOfInsert++;
					}
					
					i++;
				}
				else if(data[i].equals("load"))
				{
					AmountOfLoad++;
					String file = "C:\\Users\\sebastian\\workspace\\AiSD4\\src\\structures\\";
					file += data[i+1];
					Scanner sc2 = null;
				    try {
				        sc2 = new Scanner(new File(file));
				    } catch (FileNotFoundException e) {
				        e.printStackTrace();  
				    }
				    while (sc2.hasNextLine()) {
				            Scanner s2 = new Scanner(sc2.nextLine());
				        while (s2.hasNext()) {
				            String s = s2.next();
				            //System.out.println(s);
				            //bst.insert(s);
				            
				            
				            /**/
				            String key = s;
							
							while(!key.equals("") & (!Character.toString((key.charAt(0))).matches("[A-Za-z]") || !Character.toString((key.charAt(key.length()-1))).matches("[A-Za-z]")))
							{
								if(!Character.toString((key.charAt(0))).matches("[A-Za-z]"))
								{
									key = key.substring(1);
								}
								
								if(!Character.toString((key.charAt(key.length()-1))).matches("[A-Za-z]"))
								{
									key = key.substring(0,key.length()-1);
								}
							}
							
							if(!key.equals(""))
							{
								hmp.insert(key);
								AmountOfInsert++;
							}
				            /**/
				        }
				        s2.close();
				    }
					
					i++;
				}
				else if(data[i].equals("delete"))
				{
					AmountOfDelete++;
					AmountOfSuccessor++;
					AmountOfFind+=2;
					if(hmp.find(data[i+1]) != null)
					{
						hmp.delete(data[i+1]);
					}
					
					i++;
				}
				else if(data[i].equals("find"))
				{
					/*System.out.println("find1");
					bst.inOrder(bst.returnRoot());
					
					ArrayList<String> inOrderList = bst.printInOrder();
					for(int j = 0; j < inOrderList.size(); j++)
					{
						System.out.print(inOrderList.get(j) + " ");
					}
					System.out.println();
					System.out.println(data[i+1]);*/
					//System.out.println(bst.returnFound(bst.find(data[i+1])));
					writer.println(hmp.returnFound(hmp.find(data[i+1])));
					i++;
					AmountOfFind++;
					//System.out.println("find2");
				}
				else if(data[i].equals("min"))
				{
					//System.out.println("Min: " + bst.printKey(bst.min(bst.returnRoot())));
					//System.out.println(bst.printKey(bst.min(bst.returnRoot())));
					writer.println(hmp.printKey(hmp.min(hmp.returnRoot())));
					AmountOfMin++;
				}
				else if(data[i].equals("max"))
				{
					//System.out.println("Max: " + bst.printKey(bst.max(bst.returnRoot())));
					//System.out.println(bst.printKey(bst.max(bst.returnRoot())));
					writer.println(hmp.printKey(hmp.max(hmp.returnRoot())));
					AmountOfMax++;
				}
				else if(data[i].equals("successor"))
				{
					//System.out.println(bst.printKey(bst.successor(data[i+1])));
					if(hmp.find(data[i+1]) != null)
					{
						writer.println(hmp.printKey(hmp.successor(data[i+1])));
					}
					else
					{
						writer.println("Error: key not found");
					}
					
					i++;
					AmountOfSuccessor++;
					AmountOfFind+=2;
				}
				else if(data[i].equals("inorder"))
				{
					AmountOfInorder++;
					hmp.inOrder(hmp.returnRoot());
					
					ArrayList<String> inOrderList = hmp.printInOrder();
					for(int j = 0; j < inOrderList.size(); j++)
					{
						//System.out.print(inOrderList.get(j) + " ");
						writer.print(inOrderList.get(j) + " ");
					}
					//System.out.println();
					writer.println();
				}
			}
			
			lastAmountOfElements = hmp.getLastAmount();
			maxAmountOfElements = hmp.getMaxAmount();
		}
		
		writer.close();

		System.out.println("Time: " + (System.currentTimeMillis() - startTime) + "ms");
		System.out.println("Amount of insert operations: " + AmountOfInsert);
		System.out.println("Amount of load operations: " + AmountOfLoad);
		System.out.println("Amount of delete operations: " + AmountOfDelete);
		System.out.println("Amount of find operations: " + AmountOfFind);
		System.out.println("Amount of min operations: " + AmountOfMin);
		System.out.println("Amount of max operations: " + AmountOfMax);
		System.out.println("Amount of successor operations: " + AmountOfSuccessor);
		System.out.println("Amount of inorder operations: " + AmountOfInorder);
		System.out.println("Max amount of elements: " + maxAmountOfElements);	
		System.out.println("Last amount of elements: " + lastAmountOfElements);
		
	}

}
