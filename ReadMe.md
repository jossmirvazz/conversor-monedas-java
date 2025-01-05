# Conversor de Monedas en Java

![Estado del Proyecto](https://img.shields.io/badge/STATUS-En%20Desarrollo-green)

## Índice

- [Descripción del Proyecto](#descripción-del-proyecto)
- [Características](#características)
- [Demostración](#demostración)
- [Tecnologías Utilizadas](#tecnologías-utilizadas)
- [Instalación y Ejecución](#instalación-y-ejecución)
- [Uso](#uso)
- [Historial de Versiones](#historial-de-versiones)
- [Contribuciones](#contribuciones)
- [Licencia](#licencia)
- [Autor](#autor)

## Descripción del Proyecto

El **Conversor de Monedas en Java** es una aplicación de consola que permite convertir montos entre distintas monedas utilizando datos actualizados de la API [Exchange Rate API](https://app.exchangerate-api.com/). Además, cuenta con un Easter egg que se activa al ingresar "jossmirvaz" en ciertas entradas.

### Monedas soportadas:
- USD - Dólar estadounidense
- ARS - Peso argentino
- BOB - Boliviano boliviano
- BRL - Real brasileño
- CLP - Peso chileno
- COP - Peso colombiano

## Características

- **Consulta de Tasas de Cambio:** Visualiza tasas actualizadas.
- **Conversión entre Monedas:** Convierte montos entre las monedas soportadas.
- **Historial de Conversiones:** Registra las conversiones realizadas.
- **Easter Egg:** Un mensaje especial al ingresar "jossmirvaz".
- **Interfaz Intuitiva:** Menú interactivo para facilitar su uso.

## Demostración

### Ejemplo de Ejecución

plaintext
===== Menú Principal =====
1. Consultar tasas de cambio
2. Convertir monedas
3. Mostrar historial de conversiones
5. Salir
   Selecciona una opción: 2
   ===== Monedas Soportadas =====
   USD - Dólar estadounidense
   ARS - Peso argentino
   BOB - Boliviano boliviano
   BRL - Real brasileño
   CLP - Peso chileno
   COP - Peso colombiano
   Ingresa la moneda de origen (código): brl
   Ingresa la moneda de destino (código): usd
   Ingresa el monto a convertir (BRL): 3000
   3000.00 BRL son 487.25 USD


## Tecnologías Utilizadas

- **Java 17:** Lenguaje de programación principal.
- **Gson:** Biblioteca para manejar JSON.
- **HttpClient:** Realiza las solicitudes HTTP.
- **Exchange Rate API:** Proveedor de tasas de cambio.

## Instalación y Ejecución

### Requisitos

- [Java 17](https://www.oracle.com/java/technologies/javase-jdk17-downloads.html) instalado.
- [IntelliJ IDEA](https://www.jetbrains.com/idea/) u otro IDE compatible.

### Pasos

1. **Clonar el repositorio:**

bash
git clone https://github.com/tu_usuario/conversor-monedas-java.git

2. **Configurar la clave de API:**
    - Obtén tu clave en [Exchange Rate API](https://app.exchangerate-api.com/).
    - Reemplaza API_KEY en la clase correspondiente.
3. **Agregar Gson:**
    - Descarga desde [Maven Repository](https://mvnrepository.com/artifact/com.google.code.gson/gson).
4. **Ejecutar la aplicación:**
    - Corre la clase Main desde tu IDE.

## Uso

1. Selecciona una opción del menú principal.
2. Sigue las instrucciones para consultar tasas, convertir monedas o ver el historial.
3. **Easter Egg:** Ingresa "jossmirvaz" para desbloquear un mensaje especial.

## Historial de Versiones

- **v1.0.0:** Versión inicial con funcionalidades básicas.

## Contribuciones

¡Las contribuciones son bienvenidas! Por favor, sigue los siguientes pasos:

1. Haz un fork del repositorio.
2. Crea una nueva rama (git checkout -b feature/nueva-funcionalidad).
3. Realiza tus cambios y haz commit (git commit -m 'Agrega nueva funcionalidad').
4. Sube tus cambios (git push origin feature/nueva-funcionalidad).
5. Abre un Pull Request.

## Licencia

Este proyecto está bajo la Licencia MIT. Consulta el archivo [LICENSE](LICENSE) para más detalles.

## Autor

- **Jossmirvaz**  
  [GitHub](https://github.com/jossmirvazz)  
  [LinkedIn](https://www.linkedin.com/in/josemirvaz/)
