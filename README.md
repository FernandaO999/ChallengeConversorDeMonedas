# ChallengeConversorDeMonedas
Conversor de monedas en Java que utiliza una API de tasas de cambio en tiempo real. Proyecto del desafío Alura + Oracle ONE.
# 🪙 Conversor de Monedas — Java Challenge (Alura + Oracle ONE)

## 📖 Descripción
Este proyecto es un **Conversor de Monedas** desarrollado en **Java 17**, como parte del desafío propuesto por **Alura + Oracle ONE**.  
Permite convertir valores entre diferentes monedas en tiempo real, utilizando la **API pública de ExchangeRate-API**.

Durante el desarrollo se trabajó con:
- Consumo de una **API REST** mediante `HttpClient` y `HttpRequest`.
- Procesamiento y lectura de datos **JSON** con la librería `Gson`.
- Interacción con el usuario a través de consola utilizando `Scanner`.
- Estructura modular y limpia del código para mantener la claridad y escalabilidad.

---

## ⚙️ Tecnologías utilizadas
- **Java JDK 17**
- **Gson 2.10.1** (para manipular JSON)
- **ExchangeRate API** → [https://www.exchangerate-api.com/](https://www.exchangerate-api.com/)
- **Visual Studio Code** como entorno de desarrollo

---

## 🧩 Estructura del proyecto
lad.com.alura.conversormoneda
│
├── ConversorApp.java # Clase principal: menú e interacción con el usuario
└── lib/ # Carpeta que contiene gson-2.10.1.jar

---

## 💻 Funcionalidades principales
1. Mostrar un menú de opciones al usuario para elegir tipo de conversión.  
2. Solicitar la **moneda base**, la **moneda destino** y el **monto a convertir**.  
3. Realizar una petición HTTP a la API de tasas de cambio.  
4. Analizar la respuesta JSON para extraer la tasa (`conversion_rate`).  
5. Calcular y mostrar el resultado de la conversión.  

---

## 📡 Ejemplo de uso
Conversor de Monedas 💱
Moneda base (ej: USD): CLP
Moneda destino (ej: USD): USD
La tasa de cambio es: 0.0011
Monto a convertir: 10000
Resultado: 11.0 USD

---

## 🌍 Monedas soportadas
El conversor funciona con **cualquier código ISO** válido de moneda, pero se recomienda probar con los siguientes:

| Código | Moneda               |
|:-------|:---------------------|
| USD    | Dólar estadounidense |
| CLP    | Peso chileno         |
| ARS    | Peso argentino       |
| BRL    | Real brasileño       |
| BOB    | Boliviano boliviano  |
| COP    | Peso colombiano      |

---

## 🔑 Clave de API
Para que el proyecto funcione correctamente:
1. Crea una cuenta gratuita en [ExchangeRate-API](https://www.exchangerate-api.com/).
2. Copia tu **API Key personal**.
3. Sustituye la clave dentro del método:
   ```java
   String apiKey = "TU_API_KEY_AQUI";
🧠 Aprendizajes

Durante este desafío se aprendió a:

Configurar el entorno Java y agregar bibliotecas externas.

Realizar solicitudes HTTP con HttpClient.

Parsear respuestas JSON con Gson (JsonParser, JsonObject).

Implementar un flujo de interacción con el usuario usando Scanner.

Modularizar funciones para cálculos y conexión a API.

🚀 Mejoras futuras

Implementar una interfaz gráfica (GUI) con JavaFX o Swing.

Guardar el historial de conversiones en un archivo o base de datos.

Añadir detección automática de errores de conexión y validación de entrada.

👩‍💻 Autor

Fernanda Olivares
Desarrolladora en formación — Programa Oracle Next Education (ONE)
📆 2025
