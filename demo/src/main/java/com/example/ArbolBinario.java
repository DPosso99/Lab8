package com.example;

class ArbolBinario {
    protected NodoArbol raiz;
    protected int tamano;

    public ArbolBinario() {
        raiz = null;
        tamano = 0;
    }

    public int obtenerTamano() {
        return tamano;
    }

    public boolean estaVacio() {
        return tamano == 0;
    }

    public NodoArbol obtenerRaiz() {
        return raiz;
    }

    public NodoArbol obtenerIzquierdo(NodoArbol nodo) {
        return nodo.izquierdo;
    }

    public NodoArbol obtenerDerecho(NodoArbol nodo) {
        return nodo.derecho;
    }

    public void agregarRaiz(Object clave) {
        raiz = new NodoArbol((int) clave, null);
        tamano = 1;
    }
}


