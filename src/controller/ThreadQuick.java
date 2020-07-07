package controller;

public class ThreadQuick extends Thread {
	private int vetor[] = new int[100];
	private int inicial;
	private int fim;

	public ThreadQuick(int vetor[]) {
		this.vetor = vetor;
	}
	
	public void run() {
		this.inicial=(int) System.nanoTime();	
		try {
			quickSort(this.vetor, 0, 99);
		} 
		catch (Exception e) {
		}
		showVetor();
		this.fim=(int) System.nanoTime();
		System.out.println("Tempo Final da QuickSort em nano segundos :"+(this.fim-this.inicial));	
	}

	private void quickSort(int[] vetor, int esquerda, int direita) {
		int esq = esquerda;
		int dir = direita;
		int pivo = vetor[(esq + dir) / 2];
		int troca;

		while (esq <= dir) {
			while (vetor[esq] < pivo) {
				esq = esq + 1;
			}
			while (vetor[dir] > pivo) {
				dir = dir - 1;
			}
			if (esq <= dir) {
				troca = vetor[esq];
				vetor[esq] = vetor[dir];
				vetor[dir] = troca;
				esq = esq + 1;
				dir = dir - 1;
			}
		}
		if (dir > esquerda) {
			quickSort(vetor, esquerda, dir);
		}

		if (esq < direita) {
			quickSort(vetor, esq, direita);
		}
		this.vetor = vetor;
	}

	private void showVetor() {
		for (int i = 0; i < 100; i++) {
			System.out.println("QuickSort-Vetor[" + i + "]: " + this.vetor[i]);
		}
	}
}
