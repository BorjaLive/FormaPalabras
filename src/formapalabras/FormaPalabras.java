package formapalabras;

import java.util.List;

public class FormaPalabras {

    public static void main(String[] args) {
        Buscador b = new Buscador(false, 0, 100, 4); //Usar diccionario grande, Faltan 0 Sobran 0
        
        List<Palabra> coincidencias = b.similares("EDODSCASO");
        
        for(Palabra coincidencia : coincidencias){
            System.out.println("PALABRA: "+coincidencia.getPalabra()+"\tSOBRAN: "+coincidencia.getSobran()+"\tFALTAN: "+coincidencia.getFaltan());
        }
    }
}
