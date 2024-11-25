public class GestionLenguaje {
    private LenguajeProgramacion[] arregloLenguajes;
    private int contadorLenguajes;
    private static final int FACTOR_CRECIIMIENTO = 2;

   
    public GestionLenguaje() {
        this.arregloLenguajes = new LenguajeProgramacion[FACTOR_CRECIIMIENTO];
        this.contadorLenguajes = 0;
    }

   
    public void agregarLenguaje(int anioCreacion, String caracteristicaPrincipal, String nombre, String utilizacion) {
        if (contadorLenguajes == arregloLenguajes.length) {
            expandirArreglo();
        }
        arregloLenguajes[contadorLenguajes++] = new LenguajeProgramacion(anioCreacion, caracteristicaPrincipal, nombre, utilizacion);
    }

    
    public LenguajeProgramacion buscarLenguaje(String nombre) {
        for (int i = 0; i < contadorLenguajes; i++) {
            if (arregloLenguajes[i].getNombre().equalsIgnoreCase(nombre)) {
                return arregloLenguajes[i];
            }
        }
        return null;
    }


    public boolean eliminarLenguaje(String nombre) {
        for (int i = 0; i < contadorLenguajes; i++) {
            if (arregloLenguajes[i].getNombre().equalsIgnoreCase(nombre)) {
                // Mover los elementos hacia la izquierda
                for (int j = i; j < contadorLenguajes - 1; j++) {
                    arregloLenguajes[j] = arregloLenguajes[j + 1];
                }
                arregloLenguajes[--contadorLenguajes] = null;
                return true;
            }
        }
        return false;
    }

    
    public LenguajeProgramacion[] getArregloLenguajes() {
        LenguajeProgramacion[] copia = new LenguajeProgramacion[contadorLenguajes];
        System.arraycopy(arregloLenguajes, 0, copia, 0, contadorLenguajes);
        return copia;
    }

    
    public void imprimirLenguajes() {
        for (int i = 0; i < contadorLenguajes; i++) {
            System.out.println(arregloLenguajes[i]);
        }
    }

    // Método para expandir el arreglo
    private void expandirArreglo() {
        LenguajeProgramacion[] nuevoArreglo = new LenguajeProgramacion[arregloLenguajes.length * 2];
        System.arraycopy(arregloLenguajes, 0, nuevoArreglo, 0, arregloLenguajes.length);
        arregloLenguajes = nuevoArreglo;
    }
}
