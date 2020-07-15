package Kakao2020Internship;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exam_Trie {
	static class TrieNode{
		TrieNode[] child;
		boolean isTerminal;
		TrieNode(){
			this.child = new TrieNode[26];
			this.isTerminal = false;
		}
		
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		TrieNode nRoot = new TrieNode();
		
	}
}
