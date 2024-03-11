
// These are the new changes done 
// These are the new changes done 2 

public class Binary  {

		Node root;
		public Binary()
		{
			root = null;
		}
	      // COMMENTED BY KUNDAN

		public void print_H()
		{
			int level = print_height(root);
			System.out.println();
			System.out.println("Height is = "+level);
		}
		public int print_height(Node it)
		{
			//Node it = root;
			//int count =0;
			//int cnt =0;

			if(it!=null)
			{
					//it = it.left;
					int count = print_height(it.left);
					int cnt = print_height(it.right);
					
					if(count>cnt)
					{
						return (count+1);
					}
					
					else 
					{
						return(cnt+1);
					}
				
				}
			return 0;
		
			}
			/*if(count > cnt)
			{
				System.out.println("Height is "+count);
			}
			else
			{
				System.out.println("Height is "+cnt);
			}
			return 0;*/
		

		public void print_smallest()
		{
			Node it = root;
			if(it==null)//checking root is null or not
			{
				System.out.println("empty");
			}
			else
			{
				while(it.left!=null)
				{
					it = it.left;
				}
				System.out.println("Smallest "+ it.data);

			}
		}

		public void print_secondsmallest()
		{
			Node it = root;
			if(it==null)//checking root is null or not
			{
				System.out.println("empty");
			}
			else
			{
				while(it.left.left!=null)
				{
					it = it.left;
				}
				System.out.println("Second Smallest "+ it.data);

			}
		}
		
		public void print_largest()
		{
			Node it = root;
			if(it==null)//checking root is null or not
			{
				System.out.println("empty");
			}
			else
			{
				while(it.right!=null)
				{
					it = it.right;
				}
				System.out.println("Largest "+ it.data);

			}
		}
		public void print_secondLargest()
		{
			Node it = root;
			if(it == null)
			{
				System.out.println("empty");
			}
			else
			{
				while(it.right.right!=null)
				{
					it = it.right;
				}
				System.out.println("second Largest " + it.data);
			}
		}
		
		public void insert(int data)
		{
			if(root == null)
			{
				Node new_node = new Node(data);
				root = new_node;
			}
			else
			{
				Node new_node = new Node(data);


				Node it = root;
				while(true)
				{
					// new value is>node value
					if(data <it.data)
					{
						if(it.left == null)
						{
							it.left = new_node;
							break;
						}
						else
						{
							it = it.left;
						}

					}
					else if(data> it.data)
					{
						if(it.right == null)
						{
							it.right = new_node;
							break;
						}
						else
						{
							it = it.right;
						}

					}
					//duplicate value
					else
						break;

				}
			}
		}
		//root, left, right
		public void preOrder()
		{
			printpreOrder(root);


		}
		private void printpreOrder(Node it)
		{
			if(it != null)
			{
				System.out.print(it.data+", ");
				printpreOrder(it.left);
				printpreOrder(it.right);
			}
		}

		//left, root, right
		public void InOrder()
		{
			printInOrder(root);
		}
		private void printInOrder(Node it) {

			if(it != null)
			{
				printInOrder(it.left);
				System.out.print(it.data+", ");
				printInOrder(it.right);
			}
		}
		public void printT()
		{
			print(root);
		}
		public void print(Node it)
		{
			while(it!=null)
			{
				System.out.println(it.data+", ");
			
			}
		}
		//left,right,root
		public void postOrder()
		{
			printPostOrder(root);
		}
		private void printPostOrder(Node it) 
		{
			if(it != null)
			{
				printPostOrder(it.left);
				printPostOrder(it.right);
				System.out.print(it.data+", ");
			}

		}
		public void delete(int key)
		{
			root = deleteValue(root, key);

		}


		private Node deleteValue(Node curRoot, int i) 
		{
			//check node is empty or not
			if(curRoot == null)
			{
				return null;
			}
			//confirmed BST has more than one node

			if(i<curRoot.data)
			{
				curRoot.left = deleteValue(curRoot.left,i);
			}
			else if(i>curRoot.data)
			{
				curRoot.right = deleteValue(curRoot.right,i);
			}
			else
			{
				//we reach the node...
				if(curRoot.left==null)
				{
					Node tmp= curRoot.right;
					curRoot.right = null;
					return tmp;
				}
				else if(curRoot.right==null)
				{
					Node tmp = curRoot.left;
					curRoot.left= null;
					return tmp;
				}
				else
				{
					//I have both not null left and right 
					//find the smallest from right tree...
					int x = getprint_smallest(curRoot.right);
					//new root value;
					curRoot.data=x;

					curRoot.right =deleteValue(curRoot.right,x);

				}
			}
			return curRoot;
		}


		private int getprint_smallest(Node it) {
			while(it.left!=null)
			{
				it=it.left;
			}
			return it.data;
		}
		//public void height_p()
		int height(Node r_ref)
		{
			int h_left,h_right;
			if(r_ref==null)
			{
				return 0;
			}
			h_left = height(r_ref.left);
			h_right = height(r_ref.right);
			if(h_left >h_right)
				return 1+h_left;
			else
				return 1+h_right;
			
			
			
		}
	}
