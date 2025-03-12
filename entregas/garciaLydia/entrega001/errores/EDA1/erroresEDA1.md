#### 1️⃣ **Error en la estructura de `Dia` - Manejo de `tiposIngesta` y `alimentosPorTipo`**
##### 📍 **Clase Dia **
##### ❌ **Código incorrecto:**
`private List<String> tiposIngesta;`
`private List<List<Alimento>> alimentosPorTipo;
`
##### 🔴 **Probelema:**
##### •La estructura actual separa tipos de ingestas y alimentos, lo que puede generar inconsistencias en la relación entre tipos y alimentos.
##### •Mejor usar un `Map<String, List<Alimento>>` para relacionar cada tipo de ingesta con sus alimentos.
##### ✅ **Corrección:**
`private Map<String, List<Alimento>> ingestas;`
`public void agregarAlimento(String tipoIngesta, Alimento alimento) {
ingestas.putIfAbsent(tipoIngesta, new ArrayList<>());
ingestas.get(tipoIngesta).add(alimento);
}
`
##### ✅ Esto simplifica la relación entre tipos de ingesta y alimentos.

___


#### 2️⃣** Error en `GestorEncuesta.simular()` - Manejo del `Scanner`**
##### 📍 **Línea 15 - Clase `GestorEncuesta`**
##### ❌ **Código incorrecto:**
`scanner = new Scanner(System.in);`
##### 🔴 **Probelema:**
##### •Se está creando un nuevo objeto `Scanner` dentro de `simular()`, lo que no es necesario y puede causar fugas de memoria.
##### ✅ **Corrección:**
`this.scanner = new Scanner(System.in);`
`scanner.close();`

##### ✅   Esto mejora la eficiencia del programa.

___

#### 3️⃣ **Error en la validación de fechas en `EncuestaNutricional`**
##### 📍 **Línea 13 - Clase `EncuestaNutricional`**
##### ❌ **Código incorrecto:**
`private String fechaAlta;`

##### 🔴 **Probelema:**
•`fechaAlta` se almacena como `String`, lo que impide realizar validaciones de fecha o comparaciones.
##### ✅ **Corrección:**
`private Date fechaAlta;`
`SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
try {
this.fechaAlta = formato.parse(fechaAlta);
} catch (ParseException e) {
System.out.println("Error: Formato de fecha incorrecto.");
}`


##### ✅  Ahora la fecha se almacena correctamente y se puede validar.

___

#### 4️⃣**Error en `GestorEncuesta.registrarAlimento()` - Manejo de `Optional`**
##### 📍 **Línea 7 - Clase `Persona`**
##### ❌ **Código incorrecto:**
` if (diaOptional.isPresent()) {
diaOptional.get().agregarAlimento(tipoIngesta, alimento);
} else {
System.out.println("Día no encontrado. Registre el día primero.");
}`

##### 🔴 **Probelema:**
•Se usa `diaOptional.get()` sin verificar si el `Optional` está presente, lo que puede causar una `NoSuchElementException` si está vacío.

##### ✅ **Corrección:**
`encuesta.getDias().stream()
.filter(d -> d.getNumero() == numeroDia)
.findFirst()
.ifPresentOrElse(
dia -> dia.agregarAlimento(tipoIngesta, alimento),
() -> System.out.println("Día no encontrado. Registre el día primero.")
);`
##### ✅ Evita errores y mejora la claridad del código.

___