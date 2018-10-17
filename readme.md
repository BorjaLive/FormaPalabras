# FormaPalabras

Una forma sencilla de ordenar letras en palabras con sentido

## Uso

La parte funcional consta de tres clases que pueden ser implementadas en cualquier proyecto.

### Instalación

Se recomienda descargar el zip principal e importarno en Netbeans.
Tambien es posible descargar todo el respositorio y abrirlo manualmente.

## Ejecutar el ejemplo

En el main se incluye el mínimo código para funcionar.

### Uso

El constructor de la clase Buscador pregunta si debe usar el diccionario extendido mediante el primer parametro. En caso contrario usa la versión reducida. Para definir la cantidad de diferencias entre las letras introducidas y la palabra a revsar, se usa el segundo parametro; 0 para ser extricto.
El método similares pide un conjunto de letras todas juntas en un string y devuelve una lista de objetos Palabra que contienen la palabra coincidente y el numero de le tras que faltan o sobran, en caso de no coincider perfectamente.
El código no hace distincion entre vocales con tilde o sin ella, pero si distingue mayusculas. Se recomienda usar solo letras minusculas.

```
Buscador b = new Buscador(true, 0);
List<Palabra> coincidencias = b.similares("añac");
```

## Diccionarios

Los diccionarios que incluye son de libre uso y no pertenecen al autor del código, estos han sido levemente adaptados para usarlos en este código. Se encuentran incluidos en el proyecto.