package com.example;

class ArbolBinarioBusqueda extends ArbolBinario {

    public ArbolBinarioBusqueda() {
        super();
    }

    public void insertar(int clave, Object valor) {
        raiz = insertarNodo(raiz, clave, valor);
        tamano++;
    }

    private NodoArbol insertarNodo(NodoArbol raiz, int clave, Object valor) {
        if (raiz == null) {
            raiz = new NodoArbol(clave, valor);
            return raiz;
        }

        if (clave < raiz.clave)
            raiz.izquierdo = insertarNodo(raiz.izquierdo, clave, valor);
        else if (clave > raiz.clave)
            raiz.derecho = insertarNodo(raiz.derecho, clave, valor);

        return raiz;
    }

    public Object eliminar(int clave) {
        NodoArbol nodoEliminado = eliminarNodo(raiz, clave);
        tamano--;
        return nodoEliminado != null ? nodoEliminado.valor : null;
    }

    private NodoArbol eliminarNodo(NodoArbol raiz, int clave) {
        if (raiz == null) {
            return null;
        }

        if (clave < raiz.clave)
            raiz.izquierdo = eliminarNodo(raiz.izquierdo, clave);
        else if (clave > raiz.clave)
            raiz.derecho = eliminarNodo(raiz.derecho, clave);
        else {
            if (raiz.izquierdo == null)
                return raiz.derecho;
            else if (raiz.derecho == null)
                return raiz.izquierdo;

            raiz.clave = valorMinimo(raiz.derecho);
            raiz.derecho = eliminarNodo(raiz.derecho, raiz.clave);
        }

        return raiz;
    }

    private int valorMinimo(NodoArbol raiz) {
        int min = raiz.clave;
        while (raiz.izquierdo != null) {
            min = raiz.izquierdo.clave;
            raiz = raiz.izquierdo;
        }
        return min;
    }

    public int minimo() {
        return valorMinimo(raiz);
    }

    public int maximo() {
        return valorMaximo(raiz);
    }

    private int valorMaximo(NodoArbol raiz) {
        int max = raiz.clave;
        while (raiz.derecho != null) {
            max = raiz.derecho.clave;
            raiz = raiz.derecho;
        }
        return max;
    }

    public NodoArbol buscar(int clave) {
        return buscarNodo(raiz, clave);
    }

    private NodoArbol buscarNodo(NodoArbol raiz, int clave) {
        if (raiz == null || raiz.clave == clave)
            return raiz;

        if (clave < raiz.clave)
            return buscarNodo(raiz.izquierdo, clave);

        return buscarNodo(raiz.derecho, clave);
    }

    public void recorridoInorder() {
        recorridoInorderNodo(raiz);
        System.out.println();
    }

    private void recorridoInorderNodo(NodoArbol raiz) {
        if (raiz != null) {
            recorridoInorderNodo(raiz.izquierdo);
            System.out.print(raiz.clave + " ");
            recorridoInorderNodo(raiz.derecho);
        }
    }

    public void mostrarArbol() {
        if (raiz != null) {
            System.out.println("Raiz: " + raiz.clave + " (" + raiz.valor + ")");
            mostrarArbolRecursivo(raiz.izquierdo, "       ", true);
            mostrarArbolRecursivo(raiz.derecho, "       ", false);
        } else {
            System.out.println("El árbol está vacío.");
        }
    }

    private void mostrarArbolRecursivo(NodoArbol raiz, String prefijo, boolean esIzquierdo) {
        if (raiz != null) {
            if (esIzquierdo) {
                System.out.println(prefijo + "L---- " + raiz.clave + " (" + raiz.valor + ")");
            } else {
                System.out.println(prefijo + "R---- " + raiz.clave + " (" + raiz.valor + ")");
            }
            mostrarArbolRecursivo(raiz.izquierdo, prefijo + (esIzquierdo ? "       " : "       "), true);
            mostrarArbolRecursivo(raiz.derecho, prefijo + (esIzquierdo ? "       " : "       "), false);
        }
    }
}
