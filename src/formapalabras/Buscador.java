package formapalabras;

import static java.lang.Math.abs;
import java.util.ArrayList;
import java.util.List;


public class Buscador {
    
    boolean extendido;
    boolean todasSobran;
    int tolerancia;
    
    public Buscador(boolean extendido, int tolerancia){
        this.extendido = extendido;   //Usar, o no, el diccionario grande.
        this.tolerancia = tolerancia;   //Límite máximo de letras añadidas o no usadas para formar la palabra.
    }
    
    public List<Palabra> similares(String letras){
        //Cargar el diccionario.
        Diccionario d;
        if(extendido){
            d = new Diccionario("src/Dics/extendido.txt");      //Esta linea para user dentro del IDE
            //d = new Diccionario("Dics/extendido.txt");        //Esta línea para usar fuera del IDE
        }else{
            d = new Diccionario("src/Dics/estandar.txt");       //Esta linea para user dentro del IDE
            //d = new Diccionario("Dics/estandar.txt");         //Esta línea para usar fuera del IDE
        }
        
        ArrayList<Palabra> palabras = new ArrayList<>();
        String palabra;
        Palabra resultado;    //variable temporal
        
        //Recorrer todas las palabras del diccionario
        while(d.existeSiguiente()){
           palabra = d.siguiente();
            if(abs(letras.length() - palabra.length()) <= tolerancia){  //Primera comprovación. Si no coinciden en numero de letras, no pueden ser iguales.
                resultado = diferencia(letras,palabra);
                if(resultado.getSobran() + resultado.getFaltan() <= tolerancia){  //Si culple los requisitos, crea el objeto y lo devuelve
                    palabras.add(resultado);
                }
            }
        }
        
        return palabras;
    }
    
    
    private Palabra diferencia(String letras, String original){
        String adaptada = eliminarTildes(original);    //No distingue entre vocales con tilde
        int j, sobran = 0, faltan = 0;

        //Pasa por todas las letras de la palabra
        for(int i = 0; i < adaptada.length(); i++){
            j = 0;
            //Busca coincidencias entre las letras introducidas
            while(j < letras.length() && j != -1){
                if(adaptada.charAt(i) == letras.charAt(j)){
                    letras = letras.replaceFirst(adaptada.charAt(i)+"",""); //Elimina la letra
                    j = -1; //acaba el bucle con resultado afirmativo
                }else{
                    j++;
                }
            }
            //Si el resultado no es afirmativo, esa letra falta
            if(j != -1)
                faltan++;
        }
        sobran = letras.length();   //Las letras que no hayan sido eliminadas, sobran

        return new Palabra(original,sobran,faltan);
    }
    
    private String eliminarTildes(String palabra){
        return palabra.replace('á', 'a')
                .replace('é', 'e')
                .replace('í', 'i')
                .replace('ó', 'o')
                .replace('ú', 'u');
    }
    
}
