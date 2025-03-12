#### 1️⃣ ** Error en la clase `Baraja` - `Manejo de barajar()` - Método `deColaACaja`**
##### 📍 **Método `barajar()` - Clase `Baraja` **
##### ❌ **Código incorrecto:**
`private void barajar() {
Random aleatorio = new Random();
for (int i = 0; i < 1000; i++) {
int origen = aleatorio.nextInt(TOTAL_CARTAS);
int destino = aleatorio.nextInt(TOTAL_CARTAS);
Carta carta = cartas[origen];
cartas[origen] = cartas[destino];
cartas[destino] = carta;
}
}
`
##### 🔴 **Probelema:**
##### •Mala eficiencia en el shuffle: Se hacen 1000 swaps aleatorios, lo cual no garantiza una distribución uniforme.
##### •Se puede optimizar con `Collections.shuffle()` en una lista.
##### ✅ **Corrección:**
`private void barajar() {
List<Carta> listaCartas = Arrays.asList(cartas);
Collections.shuffle(listaCartas);
cartas = listaCartas.toArray(new Carta[0]);
}`
##### ✅  Ahora la baraja se mezcla de forma eficiente.

___


#### 2️⃣**Error en `Carta` - Manejo de `mostrar()` con símbolos de palo**
##### 📍 **Método `mostrar()` - Clase `Carta`**
##### ❌ **Código incorrecto:**
`private final String[] PALOS = { "♠️", "♣️", "♦️", "♥️" };
private final String[] NUMEROS = { "A", "2", "3", ..., "K" };
public void mostrar() {
String numero = "?";
String palo = "?";
if (this.bocaArriba) {
numero = NUMEROS[this.numero];
palo = PALOS[this.palo];
}
System.out.print ("[" + numero + " " + palo + "]");
}` 
##### 🔴 **Probelema:**
##### •No hay validación de índices para `NUMEROS` y `PALOS`, lo que puede generar un `ArrayIndexOutOfBoundsException` si los valores son incorrectos.
##### ✅ **Corrección:**
`public void mostrar() {
if (!bocaArriba) {
System.out.print("[? ?]");
return;
}
    if (numero < 0 || numero >= NUMEROS.length || palo < 0 || palo >= PALOS.length) {
        System.out.print("[X X]"); 
    } else {
        System.out.print("[" + NUMEROS[numero] + " " + PALOS[palo] + "]");
    }
}`
##### ✅  Ahora no habrá errores si hay valores fuera de rango.

___

#### 3️⃣ ** Error en `Intervalo` - Métodos privados innecesarios**
##### 📍 **Clase `Intervalo`**
##### ❌ **Código incorrecto:**
`private double getInferior() { return puntoMedio - longitud / 2; }
private void setInferior(double inferior) { longitud = this.getSuperior() - inferior; puntoMedio = inferior + longitud / 2; }
private double getSuperior() { return puntoMedio + longitud / 2; }
private void setSuperior(double superior) { longitud = superior - this.getInferior(); puntoMedio = superior - longitud / 2; }
`

##### 🔴 **Probelema:**
##### •Estos métodos deberían ser `public` o `protected` para que otras clases puedan acceder a ellos.
##### •Demasiadas operaciones matemáticas repetitivas.
##### ✅ **Corrección:**
`public double getInferior() { return puntoMedio - longitud / 2; }
public double getSuperior() { return puntoMedio + longitud / 2; }
public void setExtremos(double inferior, double superior) {
longitud = superior - inferior;
puntoMedio = (inferior + superior) / 2;
}
`

##### ✅ Más limpio y eficiente.

___

#### 4️⃣**Error en `OrdenarCartas` - Uso de `Field` en `obtenerValor()`**
##### 📍 **Clase `OrdenarCartas`**
##### ❌ **Código incorrecto:**
`private static int obtenerValor(Carta carta, String fieldName) {
try {
Field field = Carta.class.getDeclaredField(fieldName);
field.setAccessible(true);
return (int) field.get(carta);
} catch (NoSuchFieldException | IllegalAccessException e) {
throw new RuntimeException(e);
}
}
`
##### 🔴 **Probelema:**
##### •Acceder a atributos privados de `Carta` con `Reflection (Field)` es innecesario y rompe el encapsulamiento.
##### •Esto es peligroso y debe evitarse en código productivo.


##### ✅ **Corrección:**
`private static int obtenerValor(Carta carta, boolean esNumero) {
return esNumero ? carta.getNumero() : carta.getPalo();
}
`
##### ✅ Ahora es más seguro y sigue el principio de encapsulación.

___