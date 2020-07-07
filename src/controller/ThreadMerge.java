package controller;
public class ThreadMerge extends Thread {
	private int vetor[] = new int[100];
	private int inicial;
	private int fim;

	public ThreadMerge(int vetor[]) {
		this.vetor = vetor;
	}

	public void run() {
		this.inicial=(int) System.nanoTime();	
		try {
			mergeSort(this.vetor, 0, 99);

		} catch (Exception e) {
			// TODO: handle exception
		}
		showVetor();
		this.fim=(int) System.nanoTime();
		System.out.println("Tempo Final da MergeSort em nano segundos :"+(this.fim-this.inicial));			
	}
	public  void mergeSort(int vetor [] , int ini, int fim) {
	    if (fim <= ini) return;
	    int meio = (ini+fim)/2;
		mergeSort(vetor, ini, meio);
	    mergeSort(vetor, meio+1, fim);
	    merge(vetor, ini, meio, fim);
	}
	public  void merge(int vetor[], int ini, int meio, int fim) {
	    int esqAUX[] = new int[meio - ini + 1];
	    int dirAUX[] = new int[fim - meio];
	    for (int i = 0; i < esqAUX.length; i++)
	    	esqAUX[i] = vetor[ini + i];
	    for (int i = 0; i < dirAUX.length; i++)
	    	dirAUX[i] = vetor[meio + i + 1];
	    int esq = 0;
	    int dir = 0;
	    for (int i = ini; i < fim + 1; i++) {
	        if (esq < esqAUX.length && dir < dirAUX.length) {
	            if (esqAUX[esq] < dirAUX[dir]) {
	               vetor[i] = esqAUX[esq];
	               esq++;
	            } else {
	                vetor[i] = dirAUX[dir];
	                dir++;
	            }
	        } else if (esq < esqAUX.length) {	            
	            vetor[i] = esqAUX[esq];
	            esq++;
	        } else if (dir < dirAUX.length) {
	            vetor[i] = dirAUX[dir];
	            dir++;
	        }
	    }
	}
	private void showVetor() {
		for (int i = 0; i < 100; i++) {
			System.out.println("MergeSort-Vetor[" + i + "]: " + this.vetor[i]);
		}
	}

}
