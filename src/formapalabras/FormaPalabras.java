package formapalabras;

import java.util.List;

public class FormaPalabras {

    public static void main(String[] args) {
        Buscador b = new Buscador(true, 0); //Usar diccionario grande, buscar la palabra exacta
        
        List<Palabra> coincidencias = b.similares("añac");
        
        for(Palabra coincidencia : coincidencias){
            System.out.println("PALABRA: "+coincidencia.getPalabra()+"\tSOBRAN: "+coincidencia.getSobran()+"\tFALTAN: "+coincidencia.getFaltan());
        }
    }
}
