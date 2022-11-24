#include <stdio.h>
#include <stdlib.h>

void merge(int Arreglo1[], int p, int q, int r);
void mergesort(int Arreglo1[], int p, int r);

int main() {
	int Arreglo1[100], n, i;

	printf("Ingrese cantidad de datos: ");
	scanf("%d", &n);

	// array input
	for(i = 0; i < n; i++) {
		printf("Ingrese número al arreglo: ", i);
		scanf("%d", &Arreglo1[i]);

	}
    
    printf("Arreglo introducido es: \n");
    for(i = 0; i < n; i++) {
		printf("%d ", Arreglo1[i]);
	}
	// merge sort
	mergesort(Arreglo1, 0, n-1);

	// printing the sorted array
    printf("\nArreglo Sorteado Via mergesort es: \n");
	for(i = 0; i < n; i++) {
		printf("%d ", Arreglo1[i]);
	}

	return 0;
}

void merge (int Arreglo1[], int p, int q, int r) {
	int num1 = q - p + 1;
	int num2 = r - q;
	int L[num1], R[num2];
	int i, j, k;

	for(i = 0; i < num1; i++) {
		L[i] = Arreglo1[p+i];
	}

	for(j = 0; j < num2; j++) {
		R[j] = Arreglo1[q+1+j];
	}

	i = 0;
	j = 0;
	k = p;

  	while (i < num1 && j < num2) {
        if (L[i] <= R[j]) {
            Arreglo1[k] = L[i];
            i++;
        }
        else {
            Arreglo1[k] = R[j];
            j++;
        }
        k++;
    }

    while (i < num1) {
        Arreglo1[k] = L[i];
        i++;
        k++;
    }

    while (j < num2) {
        Arreglo1[k] = R[j];
        j++;
        k++;
    }
}

void mergesort (int Arreglo1[], int p, int r) {
    if (p < r) 
    {
        
        int q = (p+r)/2;
        mergesort(Arreglo1,p,q);
        mergesort(Arreglo1,q+1,r);
        merge(Arreglo1,p,q,r);
		
		
    }
}