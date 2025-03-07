# Entrega 001



### **Programación I - WhacAMole**
📌 **[Código original](https://github.com/lydiaa-gr/23-24-prg1/blob/main/entregas/garciaLydia/reto010/Whac/A/Mole.java)**  
❌ **Errores encontrados:**
#### 1️⃣ **Error en el bucle `for` vacío**
📍 **Línea 12**
##### ❌ **Código incorrecto:**
`for (int i = 0; i < intentos; i--) {}`
#### 🔴 **Probelema:**
•El bucle for está vacío y no hace nada.

•i-- es incorrecto aquí porque i debería aumentar para que la condición i < intentos se cumpla.
#### ✅ **Corrección:**
Eliminar el for ya que no es necesario.

___
#### 2️⃣**Error en la comparación dentro del `if`**
📍 **Línea 22**
#### ❌ **Código incorrecto:**
`if (agujeroElegido == (agujeroMonigote1 | agujeroMonigote2)) {`
#### 🔴 **Probelema:**
Se está usando `|` (operador de bits) en lugar de `||` (operador lógico OR).

`agujeroElegido == (agujeroMonigote1 | agujeroMonigote2)` no es una comparación válida.
#### ✅ **Corrección:**
`if (agujeroElegido == agujeroMonigote1 || agujeroElegido == agujeroMonigote2) {`
Ahora se compara correctamente si el jugador ha acertado.

🔗 **[Código corregido]()**

---

### **Programación II - CCF**
📌 **[Código original](https://github.com/lydiaa-gr/23-24-prg2/tree/main/entregas/garciaLydia/Carrefour)**  


🔗 **[Código corregido]()**

---

### **EDA I - Encuesta Nutricional**
📌 **[Código original](https://github.com/lydiaa-gr/23-24-eda1/tree/main/entregas/garciaLydia/reto007)**  

🔗 **[Código corregido]()**

---

### **EDA II - BarajaCartas**
📌 **[Código original](https://github.com/lydiaa-gr/23-24-eda2/tree/main/entregas/garciaLydia/reto007)**  


🔗 **[Código corregido]()**  