//listas con memoria estática
#include <stdio.h>

#define maxEle 10

/* =============================================================================================================
 *  TIPOS DE DATOS
 * ============================================================================================================= */
typedef int lista;
//La lista es un entero y se va a almacenar en la función Main.
// Tendrá valor -1 cuando la lista esté vacía.
// Si hay datos, almacenará la posición del último elemento que se ha introducido en la lista.
typedef int tipoelemento;
//El tipoelemento va a corresponderse a la estructura con los datos propios del problema que queramos resolver (¡CAMBIAR!).

struct componente
{
	tipoelemento elemento;
	lista enlace;
};

struct memoria
{
	lista vacios; //Almacena el número de elementos que contiene la lista
	struct componente almacen[maxEle];
};

/* =============================================================================================================
 *  FUNCIONES DE LISTAS ESTÁTICAS
 * ============================================================================================================= */
void inicializar(struct memoria *inf)
{
	int i;
    //Esta función inicializa la memoria.

    //Establece la lista ("vacíos") a 0 porque al principio no hay elementos
	inf->vacios=0;

    //Pone como valor del enlace de cada componente el índice del siguiente componente en la lista (posiciones array).
	for (i=0; i<maxEle-1; i++) {
		inf->almacen[i].enlace=i+1;
    }

    //En el caso del último componente, el enlace vale -1 para indicar que no hay más componentes detrás.
	inf->almacen[maxEle-1].enlace=-1;
}

void listaVacia(lista *l)
{
    //Inicializa la lista que mantenemos en el Main.
	*l=-1;
}

int esvacia(lista l)
{
    //Comprueba si la lista está vacía o ya tiene elementos

    //Si la lista está vacía, tomará valor -1; y por lo tanto devuelve un 1 (VERDADERO, la lista está vacía)
    //Si en la lista hay elementos tendrá un valor diferente a -1 y devolvemos un 0 (FALSO, la lista no está vacía)
	return (l==-1);

    //El código siguiente es equivalente:
    /*
     * if (l == -1) {
     *      return 1; }
     * else {
     *      return 0; }
     */
}

void nuevo(lista *l, struct memoria *inf)
{
    //En la inserción, actualiza vacíos y obtiene la posición en la que vamos a insertar

    //Si no hay huecos libres en la lista se indica que la memoria está agotada
	if (inf->vacios==-1)
	{
		printf("Error. Memoria agotada\n");
	}
    //Si hay huecos libres, se actualiza la lista con el número de elementos + 1
    //Cada componente contiene como valor del enlace el índice del componente siguiente,
    //que a su vez es el número de elementos que hay en la lista + 1
    //salvo para el último componente, que toma valor -1
	else
	{
		*l=inf->vacios;
		inf->vacios=inf->almacen[inf->vacios].enlace;
	}
}

void insertar(lista *l, tipoelemento x, struct memoria *inf)
{
	lista aux;

    //En la inserción, almacena datos (tipoElemento) y cambia los valores de la lista del Main y del enlace correspondiente

    //Llama a la función nuevo() para obtener en aux la posición en la que tiene que insertar datos
    //y para aumentar el valor de vacíos (o darle valor -1 en caso de ser el último elemento a insertar)
	nuevo(&aux, inf);

    //Inserta la estructura de datos en el componente correspondiente de la lista
	inf->almacen[aux].elemento=x;
    //Actualiza el enlace del componente que inserta
    //Al ir insertando, cada componente va a tener como enlace la posición del elemento anterior en el array
    //y el primer elemento va a tener como enlace el valor -1 para indicar que no se pueden sacar más elementos
	inf->almacen[aux].enlace=(*l);
	*l=aux;
}

void primero(lista l, tipoelemento *x, struct memoria inf)
{
    //Si la lista está vacía, l vale -1 y se muestra un mensaje de error porque no se puede obtener el elemento
	if (l==-1)
	{
		printf("Error. Lista vacia");
	}
    //Si hay datos en la lista, se obtiene el tipoElemento del último elemento insertado en la lista
	else
	{
		*x=inf.almacen[l].elemento;
	}
}

void resto(lista l, lista *sigl, struct memoria inf)
{
    //Si la lista está vacía, l vale -1 y se muestra un mensaje de error porque no se puede obtener el elemento
	if (l==-1)
	{
		printf("Error. Lista vacia");
	}
    //Si hay datos en la lista, la lista (sigl) obtiene el enlace del último elemento insertado
    //que se corresponde con la posición del elemento anterior a él (o -1 en caso del primer elemento de la lista)
	else
	{
		*sigl=inf.almacen[l].enlace;
	}
}
