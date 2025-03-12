#### 1️⃣ **Error en el bucle `for` vacío**
##### 📍 **Línea 12**
##### ❌ **Código incorrecto:**
`for (int i = 0; i < intentos; i--) {}`
##### 🔴 **Probelema:**
##### •El bucle for está vacío y no hace nada.
##### •i-- es incorrecto aquí porque i debería aumentar para que la condición i < intentos se cumpla.
##### ✅ **Corrección:**
##### •Eliminar el for ya que no es necesario.

___


#### 2️⃣**Error en la comparación dentro del `if`**
##### 📍 **Línea 22**
#### ❌ **Código incorrecto:**
`if (agujeroElegido == (agujeroMonigote1 | agujeroMonigote2)) {`
#### 🔴 **Probelema:**
#### •Se está usando `|` (operador de bits) en lugar de `||` (operador lógico OR).
#### •`agujeroElegido == (agujeroMonigote1 | agujeroMonigote2)` no es una comparación válida.
#### ✅ **Corrección:**
`if (agujeroElegido == agujeroMonigote1 || agujeroElegido == agujeroMonigote2) {`
####✅ Ahora se compara correctamente si el jugador ha acertado.

___

#### 3️⃣ **Error en la generación de números aleatorios**
📍 **Línea 19-20**
#### ❌ **Código incorrecto:**
`agujeroMonigote1 = (int) (Math.random() * (16) + 1);

agujeroMonigote2 = (int) (Math.random() * (16) + 1);
`
#### 🔴 **Probelema:**
•`agujeroMonigote1 y agujeroMonigote2`pueden ser iguales, lo que no es deseado.
#### ✅ **Corrección:**
`agujeroMonigote1 = (int) (Math.random() * 16 + 1);`

`do {`
`agujeroMonigote2 = (int) (Math.random() * 16 + 1);`

`} while (agujeroMonigote1 == agujeroMonigote2);`

#### ✅ Ahora los dos valores siempre serán diferentes.

___

#### 4️⃣**Error en la validación del número ingresado por el usuario**
##### 📍 **Línea 26**
#### ❌ **Código incorrecto:**
`if (agujeroElegido > 16) {
System.out.print("        ");
System.out.print("Ese agujero no existe");
}`
#### 🔴 **Probelema:**
•No verifica si el usuario ingresa un número menor que 1.
•Si el número es inválido, el código sigue ejecutándose.


#### ✅ **Corrección:**
`if (agujeroElegido < 1 || agujeroElegido > 16) {
System.out.println("Ese agujero no existe. Escoja un número entre 1 y 16.");
continue;
}
`
✅ Ahora se maneja correctamente la validación.

___

#### 5️⃣**Error en la validación del número ingresado por el usuario**
#####📍 **Línea 42**
#### ❌ **Código incorrecto:**
`} while (intentos == 15 | intentos > 0);
`
#### 🔴 **Probelema:**
#### •`|` es un operador de bits en lugar de `||` (OR lógico).
#### •`intentos == 15` no es necesario.
#### ✅ **Corrección:**
`} while (intentos > 0);
`
#### ✅  Ahora el bucle se ejecuta hasta que se terminen los intentos.

___

#### 6️⃣**Error en la validación del número ingresado por el usuario**
##### 📍 **Línea 39**
#### ❌ **Código incorrecto:**
`System.out.print("        ");
System.out.print("Aciertos:" + aciertos);
System.out.print("        ");
System.out.print("Intentos restantes:" + intentos);
System.out.print("        ");
`
#### 🔴 **Probelema:**
•`System.out.print()` hace que todo salga en la misma línea desordenadamente.
#### ✅ **Corrección:**
`System.out.println("Aciertos: " + aciertos);
System.out.println("Intentos restantes: " + intentos);
`
#### ✅  Ahora la salida es más clara y legible.