package leetcode.hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;

public class RemoveDuplicateLetters {
	public static void main(String args[]){
		Solution solution = new Solution();
		System.out.println(solution.removeDuplicateLetters("bcacbkc"));
	
		
		
	}
	
	
}


 class Solution {
    public String removeDuplicateLetters(String s) {
    	char[] str = s.toCharArray();
    	Integer[] count = new Integer[26];
    	boolean[] visited = new boolean[26];
    	for(int i=0;i<26;i++)count[i]=0;
    	for(char c:str)count[c-'a']++;
    	
    	//for(int i=0;i<26;i++)System.out.print((char)(i+'a')+ " ");
    	//System.out.println();
    	//for(int c:count)System.out.print(c+" ");
    	//System.out.println();
    	
    	StringBuilder sb = new StringBuilder();
    	
    	for(char c:str){
    		if(visited[c-'a']) {
    			count[c-'a']--;
    			continue;
    		}
    		else{
    			while(sb!=null && sb.length()>0 && sb.charAt(sb.length()-1)>c && count[sb.charAt(sb.length()-1)-'a']>0){
    				visited[sb.charAt(sb.length()-1)-'a']=false;
    				sb.deleteCharAt(sb.length()-1);
    			}
    			sb.append(c);
    			visited[c-'a']=true;
    			count[c-'a']--;
    		}
    		
    		
    	}
    	
    	
    	return sb.toString();
    	
    }
}