#include <stdio.h>
#include <stdlib.h>
#include <string.h>


typedef XXX tipoelementolista;


typedef  struct componente* lista;

struct componente
{
	tipoelementolista elemento;
	lista enlace;
};



void listaVacia(lista* l)
{
	*l=NULL;
}

void insertarLista(lista *l, tipoelementolista x)
{
	lista aux;

	aux=(struct componente *)malloc(sizeof(struct componente));
	if (aux==NULL)
	{
		printf("No hay memoria. No se pueder realizar la insercion\n");
	}
	else
	{
		aux->elemento=x;
		aux->enlace=*l;
		*l=aux;
	}
}

int esVaciaLista(lista l)
{
	return (l==NULL);
}

void primero(lista l, tipoelementolista* x)
{
	if (l==NULL)
	{
		printf("La lista está vacia");
	}
	else
	{
		*x=l->elemento;
	}
}

void resto(lista l, lista *sigl)
{
	if (l==NULL)
	{
		printf("Lista vacia");
	}
	else
	{
		*sigl=l->enlace;
	}
}
