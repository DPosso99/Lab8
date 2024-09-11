package com.example;

class NodoArbol {
    int clave;
    Object valor;
    NodoArbol izquierdo, derecho;

    public NodoArbol(int clave, Object valor) {
        this.clave = clave;
        this.valor = valor;
        izquierdo = derecho = null;
    }
}



