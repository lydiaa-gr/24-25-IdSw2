#### 1️⃣ **Error en la estructura de `CentroComercial` - Método `deColaACaja`**
##### 📍 **Línea 29 - Clase `CentroComercial` **
##### ❌ **Código incorrecto:**
`for (int i = 0; i < cajas.length; i++) {
if (cajas[i].estaLibre() && !cola.isEmpty()) {
Persona persona = cola.poll();
cajas[i].recibe(persona);
}
}
`
##### 🔴 **Probelema:**
##### •Se está sacando a la persona de la cola `(poll())` antes de verificar si hay cajas libres, lo que podría llevar a errores si la cola está vacía.
##### ✅ **Corrección:**
`if (!cola.isEmpty()) {
for (int i = 0; i < cajas.length; i++) {
if (cajas[i].estaLibre()) {
Persona persona = cola.poll();
cajas[i].recibe(persona);
break; // Asignamos a una sola caja y salimos del bucle
}
}
}`
##### ✅ Esto asegura que no sacamos personas de la cola innecesariamente.

___


#### 2️⃣**Error en la entrada de usuario en `Mundo.simular()`**
##### 📍 **Línea 37 - Clase `Mundo`**
##### ❌ **Código incorrecto:**
`new Scanner(System.in).nextLine();`
##### 🔴 **Probelema:**
##### •Se está creando un nuevo objeto `Scanner` en cada iteración, lo cual consume memoria innecesariamente.
##### ✅ **Corrección:**
`Scanner scanner = new Scanner(System.in);
do {
...
scanner.nextLine(); // Mantiene la pausa
} while (centroAbierto);
scanner.close(); // Cerrar Scanner al final del método
`
##### ✅  Esto mejora la eficiencia de la simulación.

___

#### 3️⃣ **Error en la asignación de `personasAtendidas`**
##### 📍 **Línea 54 - Clase `Mundo`**
##### ❌ **Código incorrecto:**
`for (Caja caja : centroComercial.getCajas()) {
if (!caja.estaLibre()) {
personasAtendidas++;
itemsVendidos += caja.getItemsPorAtender();
}
}`

##### 🔴 **Probelema:**
•Se está contando cada iteración de caja como una persona atendida, lo cual es incorrecto.
##### ✅ **Corrección:**
`for (Caja caja : centroComercial.getCajas()) {
if (caja.getItemsPorAtender() == 0) {
personasAtendidas++;
}
itemsVendidos += caja.getItemsPorAtender();
}
`

##### ✅ Ahora se cuenta correctamente cada persona atendida.

___

#### 4️⃣**Error en la generación de `items` en `Persona`**
##### 📍 **Línea 7 - Clase `Persona`**
##### ❌ **Código incorrecto:**
`this.items = 5 + (int) (Math.random() * 11); 
` 
##### 🔴 **Probelema:**
•`Math.random() * 11` puede generar valores decimales, aunque el casting a `(int)` lo redondea hacia abajo.
•Esto puede dar valores fuera del rango esperado (por ejemplo, no incluir el 15 correctamente).


##### ✅ **Corrección:**
`import java.util.concurrent.ThreadLocalRandom;
this.items = ThreadLocalRandom.current().nextInt(5, 16);
`
##### ✅ Ahora los valores se generan de manera precisa y eficiente.

___

