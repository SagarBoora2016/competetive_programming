package avltree;

public class AVLTREE {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		BST b = new BST();
		System.out.println(" ins " + 20);
		b.insert(20);
		b.display();
		System.out.println();
		
		System.out.println(" ins " + 25);
		b.insert(25);
        b.display();
		System.out.println();
		
		System.out.println(" ins " + 30);
		b.insert(30);
		b.display();
		System.out.println();
		
		System.out.println(" ins " + 10);
		b.insert(10);
		b.display();
		System.out.println();
		
		System.out.println(" ins " + 5);
		b.insert(5);
		b.display();
		System.out.println();
//		b.insert(15);
//		b.display();
		
		
		
		
	}

}
class BST{
	private Node root;
	public void insert(int item) {
		if(root==null) {
			root = new Node(item);
		}else {
			root = insert(root,item);
		}
	}
	public void display() {
		display(root);
		
	}
	private void display(Node root2) {
		// TODO Auto-generated method stub
		if(root2==null) {
			return;
		}
		String s="";
		if(root2.left!=null) {
			s = s + root2.left.data + " " + root2.left.height;
		}
		s =s + "<L ";
		s =s +root2.data+ " " + root2.height;
		s = s+" >R ";
		if(root2.right!=null) {
			s =s + root2.right.data+ " " + root2.right.height;
		}
		System.out.println(s);
		display(root2.left);
		display(root2.right);
		
	}
	private Node insert(Node root1, int item) {
		// TODO Auto-generated method stub
		if(root1==null) {
			Node a1 = new Node(item);
//			System.out.println(a1.data);
			return a1;
		}
		if(root1.data<item) {
			root1.right = insert(root1.right, item);
			int a1=0;
			int a2=0;
			if(root1.left!=null) {
				a1 = root1.left.height;
			}
			a2 = root1.right.height+1;
			root1.height= Math.abs(Math.max(a1, a2));
			if(Math.abs(a1-a2)>1) {
				System.out.println("balance right");
				return balance(root1,item);
			}else {
				return root1;
			}
		}else {
			root1.left = insert(root1.left, item);
			int a1=0;
			int a2=0;
			if(root1.right!=null) {
				a1 = root1.right.height;
			}
			a2 = root1.left.height+1;
			root1.height= Math.abs(Math.max(a1, a2));
			System.out.println(root1.right.data);
			System.out.println(a1 + " " + a2);
			if(Math.abs(a1-a2)>1) {
				System.out.println("balance left");
				return balance(root1,item);
			}else {
				return root1;
			}
		}
	}
	private Node balance(Node root1, int item) {
		// TODO Auto-generated method stub
		String s = "";
		if(root1.data<item) {
			s=s+"R";
			if(root1.right!=null && root1.right.data<item) {
				s=s+"R";
			}else {
				s=s+"L";
			}
		}else {
			s=s+"L";
			if(root1.left!=null && root1.left.data<item) {
				s=s+"R";
			}else {
				s=s+"L";
			}
		}
		System.out.println(s);
		if(s.equals("LL")) {
			Node n1=callLL(root1);
			return n1;
		}else if(s.equals("LR")) {
			Node b2 = callLR(root1);
			return b2;
		}else if(s.equals("RR")) {
			Node n2 = callRR(root1);
			return n2;
			
		}else {
			Node b2 = callRL(root1);
			return b2;
		}
		
	}
	private Node callRL(Node root1) {
		// TODO Auto-generated method stub
		Node a = root1;
		Node b =a.right;
		Node c = b.left;
		Node t4 = c.right;
	
		a.right=c;
		c.right=b;
		b.left = t4;
		
		int bbl=0;
		int bbr=0;
		if(b.left!=null) {
			bbl = b.left.height;
		}
		if(b.right!=null) {
			bbr = b.right.height;
		}
		b.height = Math.max(bbl, bbr)+1;
		
		int ccl=0;
		int ccr=0;
		if(c.left!=null) {
			ccl = c.left.height;
		}
		if(c.right!=null) {
			ccr = c.right.height;
		}
		c.height = Math.max(ccl, ccr)+1;
		
		int aal=0;
		int aar=0;
		if(a.left!=null) {
			aal = a.left.height;
		}
		if(b.right!=null) {
			aar = a.right.height;
		}
		a.height = Math.max(aal, aar)+1;
		
		return callRR(root1);
	}
	private Node callLR(Node root1) {
		// TODO Auto-generated method stub
		Node a = root1;
		Node b = a.left;
		Node c = b.right;
		Node t3 = c.left;
		a.left=c;
		c.left=b;
		b.right=t3;
		
		int bbl=0;
		int bbr=0;
		if(b.left!=null) {
			bbl = b.left.height;
		}
		if(b.right!=null) {
			bbr = b.right.height;
		}
		b.height = Math.max(bbl, bbr)+1;
		
		int ccl=0;
		int ccr=0;
		if(c.left!=null) {
			ccl = c.left.height;
		}
		if(c.right!=null) {
			ccr = c.right.height;
		}
		c.height = Math.max(ccl, ccr)+1;
		
		int aal=0;
		int aar=0;
		if(a.left!=null) {
			aal = a.left.height;
		}
		if(b.right!=null) {
			aar = a.right.height;
		}
		a.height = Math.max(aal, aar)+1;
		
		
		return callLL(root1);
	}
	private Node callRR(Node root1) {
		// TODO Auto-generated method stub
		Node a=root1;
		Node b = root1.right;
		Node t2 = b.left;
		System.out.println(t2);
		b.left=a;
		a.right=t2;
		int aal=0;
		int aar=0;
		if(a.left!=null) {
			aal=a.left.height;
		}
		if(a.right!=null) {
			aar=a.right.height;
		}
		a.height = Math.max(aal, aar);
		System.out.println("jheifht os a  " + a.height);
		int bbl=0;
		int bbr=0;
		if(b.left!=null) {
			bbl=b.left.height;
		}
		if(b.right!=null) {
			bbr=b.right.height;
		}
		b.height = Math.max(bbl, bbr)+1;
		return b;
	}
	private Node callLL(Node root1) {
		// TODO Auto-generated method stub
		System.out.println("LL");
		Node a=root1;
		Node b = root1.left;
		//Node c = root1.left.left;
		Node t2 = b.right;
		b.right=a;
		a.left=t2;
		int aal=0;
		int aar=0;
		if(a.left!=null) {
			aal=a.left.height;
		}
		if(a.right!=null) {
			aar=a.right.height;
		}
		a.height = Math.max(aal, aar)+1;
		
		int bbl=0;
		int bbr=0;
		if(b.left!=null) {
			bbl=b.left.height;
		}
		if(b.right!=null) {
			bbr=b.right.height;
		}
		b.height = Math.max(bbl, bbr)+1;
		
		return b;
	}
	
}
class Node{
	int data;
	Node left;
	Node right;
	int height;
	public Node(int data) {
		super();
		this.data = data;
		height=0;
		left=null;
		right=null;
	}
}
