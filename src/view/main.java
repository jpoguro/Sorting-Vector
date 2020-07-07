package view;

import controller.ThreadQuick;

public class main {

	public static void main(String[] args) {
		int vetor[] = new int[100];	
		for(int i=0;i<100;i++) {
			vetor[i] = (int) ((Math.random() * 1000)+1);
		}
		Thread quickSort= new ThreadQuick(vetor);
		quickSort.start();
	}
}
		
	
