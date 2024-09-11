package com.example;

public class PruebaArbolBinarioBusqueda {

    // Método para calcular la suma de los dígitos de un número
    public static int calcularSumaDeDigitos(String nombre, int identificacion) {
        String idStr = String.valueOf(identificacion);
        int suma = 0;
        System.out.print(nombre + " (" + identificacion + "): Suma de los dígitos: ");
        
        // Mostrar el desglose de la suma de los dígitos
        for (int i = 0; i < idStr.length(); i++) {
            char digitoChar = idStr.charAt(i);
            int digito = Character.getNumericValue(digitoChar);
            suma += digito;
            System.out.print(digito);
            if (i < idStr.length() - 1) {
                System.out.print("+");
            }
        }
        
        System.out.println("= " + "k: " + suma);
        return suma;
    }

    public static void main(String[] args) {
        ArbolBinarioBusqueda abb = new ArbolBinarioBusqueda();

        // Insertando los usuarios con la suma de los dígitos de su identificación
        int claveDavid = calcularSumaDeDigitos("David Taimal", 10201013);
        abb.insertar(claveDavid, "David 10201013");

        int claveMariaConstanza = calcularSumaDeDigitos("María Constanza", 10101011);
        abb.insertar(claveMariaConstanza, "María 10121011");

        int claveLuis = calcularSumaDeDigitos("Luis Camilo", 10302115);
        abb.insertar(claveLuis, "Luis 10301115");

        int claveCarlos = calcularSumaDeDigitos("Carlos Andrés", 1010301);
        abb.insertar(claveCarlos, "Carlos 1010300");

        int claveDiana = calcularSumaDeDigitos("Diana Fernanda", 10111105);
        abb.insertar(claveDiana, "Diana 10111105");

        int claveJuan = calcularSumaDeDigitos("Juan Esteban", 10110205);
        abb.insertar(claveJuan, "Juan 10110205");

        // Mostrando el árbol
        System.out.println("\nEstructura del árbol:");
        abb.mostrarArbol();

        // Realizando recorrido inorder
        System.out.println("\nRecorrido inorder:");
        abb.recorridoInorder();

        // Buscar un nodo
        System.out.println("\nBuscar clave " + claveLuis + " (Luis): " + abb.buscar(claveLuis).valor);

        // Valor mínimo y máximo
        System.out.println("\nValor mínimo: " + abb.minimo());
        System.out.println("Valor máximo: " + abb.maximo());

        // Eliminando un nodo y mostrando el árbol nuevamente
        abb.eliminar(claveMariaConstanza); // Elimina la clave actualizada de María Constanza
        System.out.println("\nEstructura del árbol después de eliminar a María Constanza:");
        abb.mostrarArbol();

        // Realizando el recorrido inorder después de eliminar a María Constanza
        System.out.println("\nRecorrido inorder después de eliminar a María Constanza:");
        abb.recorridoInorder();
    }
}


