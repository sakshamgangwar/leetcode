package leetcode.hard;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedLists {
	
	 
	
	 static class PQsort implements Comparator<ListNode> {
		 
			public int compare(ListNode one, ListNode two) {
				return one.val - two.val;
			}
		}
	    public ListNode mergeKLists(ListNode[] lists) {
	        PQsort sort = new PQsort();
	        PriorityQueue<ListNode> list = new PriorityQueue<ListNode>(lists.length,sort);
	        
	        for(ListNode root:lists){
	        	list.add(root);
	        }
	        
	        ListNode root = null;
	        ListNode travel = null;
	        
	        while(!list.isEmpty()){
	        	ListNode temp = list.peek();
	        	temp = temp.next;
	        	
	        	if (root==null) {
	        		root = list.poll();
	        		travel = root;
	        	}else{
	        		travel.next = list.poll();
	        		travel = travel.next;
	        	}
	        	
	        	if(temp!=null){
	        		list.add(temp);
	        	}
	        	
	        }
	        
	        return root;
	    }
	    
	    public static void main(String args[]){
	    	ListNode n1 = new ListNode(12);
	    	ListNode n2 = new ListNode(24);
	    	ListNode n3 = new ListNode(10);
	    	
	    	ListNode[] list = new ListNode[3];
	    	list[0] = n1;
	    	list[1] = n2;
	    	list[2] = n3;
	    	
	    	ListNode root = new MergeKSortedLists().mergeKLists(list);
	    	
	    	while(root!=null){
	    		System.out.println(root.val);
	    		root = root.next;
	    	}
	    	
	    }
	    
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
