package structures;

import java.util.ArrayList;

public class HashMap
{
	private Node root = null;
	private ArrayList<String> inOrderList = new ArrayList<String>();
	private int maxAmountOfElements = 0;
	private int currentAmountOfElements = 0;
	
   
	
	
	
	
    public class Node 
    {
        public String key;
        public Node left = null;
        public Node right = null;
        public Node parent = null;
        
        Node(String key) 
        {
            this.key = key;
        }
    }

    
    
    
    
    
    public void insert(String key) 
    {
        if(root == null)
        {
        	root = new Node(key);
        }
        else 
        {
            Node parent = null;
            Node current = root;
            
            while(current != null)
            {
                parent = current;
                
                if((current.key).compareTo(key) > 0)
                {
                	current = current.left;
                }
                else
                {
                	current = current.right;
                }
            }
            
            if((parent.key).compareTo(key) > 0)
            {
                parent.left = new Node(key);
                parent.left.parent = parent;
            }
            else 
            {
                parent.right = new Node(key);
                parent.right.parent = parent;
            }
        }
        
        this.currentAmountOfElements++;
        
        if(this.currentAmountOfElements > this.maxAmountOfElements)
        {
        	this.maxAmountOfElements = this.currentAmountOfElements;
        }
    }
    
    
    public Node delete(String key)
    {
        Node node = this.find(key);
        Node parent = node.parent;
        Node tmp;
        
        
        this.currentAmountOfElements--;
        
        if(node.left != null && node.right != null)
        {
			tmp = this.delete(this.successor(key).key);
			tmp.left = node.left;
			
			if(tmp.left != null)
			{
				tmp.left.parent = tmp;
			}
				
			tmp.right = node.right;
			
			if(tmp.right != null)
			{
				tmp.right.parent = tmp;
			}
				
        }
        else
        {
        	if(node.left != null)
        	{
        		tmp = node.left;
        	}
        	else
        	{
        		tmp = node.right;
        	}
                
        }
            
        if(tmp != null)
        {
        	node.parent = parent;
        }
        
        if(parent == null)
        {
        	root = tmp;
        }
        else
        {
        	if(parent.left == node)
        	{
        		parent.left = tmp;
        	} 
        	else
        	{
        		parent.right = tmp;
        	}
        }
            
        
        
        return node;
    }
    
    
    public Node successor(String key)
    {
    	Node node = this.find(key);

        if(node.right != null)
        {
            node = node.right;
            
            while(node.left != null)
            {
            	node = node.left;
            }
                
            return node;
        }
        
        else
        {
            if(node.right == null && node != root && node != this.max(root))
            {
                Node parent = node.parent;
                
                while(parent != root && parent.key.compareTo(node.key) < 0)
                {
                	parent = parent.parent;
                }
                    
                return parent;
            }
	        else 
	        {
	        	return null;
	        }
        }
           
	}


	public void inOrder(Node node) 
    {
        if(node != null)
        {
            inOrder(node.left);
            inOrderList.add(node.key);
            inOrder(node.right);
        }
    }
	
    
    public Node returnRoot()
    {
    	return root;
    }


    public Node find(String key)
	{
		Node current = root;
		
        while(current != null && !(current.key).equals(key))
        {
        	if((current.key).compareTo(key) > 0)
        	{
        		current = current.left;
        	}
        	else
        	{
        		current = current.right;
        	}
        }
            
        if(current == null)
        {
        	return null;
        }
        else
        {
        	return current;
        }
        	
		
	}


    public Node max(Node node) 
    {
    	if(node != null)
    	{
    		while(node.right != null)
	        {
	        	node = node.right;
	        }
    	}
            
        return node;
    }
    
    public Node min(Node node) 
    {
    	if(node != null)
    	{
    		while(node.left != null)
	        {
	        	node = node.left;
	        }
    	}
            
        return node;
    }
    
    public String printKey(Node node)
    {
    	if(node != null)
    	{
    		return node.key;
    	}
    	else
    	{
    		return "";
    	}
    	
    }
    
    public ArrayList<String> printInOrder()
    {
    	ArrayList<String> tmp = inOrderList;
    	inOrderList = new ArrayList<String>();
    	
    	return tmp;
    }


	public int returnFound(Node find)
	{
		if(find == null)
		{
			return 0;
		}
		else
		{
			return 1;
		}
	}


	public int getLastAmount()
	{
		return this.currentAmountOfElements;
	}
	
	public int getMaxAmount()
	{
		return this.maxAmountOfElements;
	}

}