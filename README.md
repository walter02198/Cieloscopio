# 🌦️Cieloscopio

Cieloscopio es una aplicación de consola desarrollada en Java que consume datos en tiempo real de la API de OpenWeatherMap. 
El proyecto fue diseñado aplicando principios de arquitectura limpia y buenas prácticas de programación.


## 🚀 Funcionalidades

Consulta de Clima en Tiempo Real: Obtención de temperatura, humedad y condiciones climáticas de cualquier ciudad del mundo.

Conversión de Unidades: Transforma automáticamente los datos técnicos de la API (Kelvin) a unidades métricas (Celsius) para el usuario final.

Timestamp de Consulta: Registro exacto de fecha y hora de cada petición mediante la API de fechas de Java.

## 🏗️ Arquitectura y Diseño

El proyecto sigue una Arquitectura en Capas, garantizando un código mantenible y escalable:

Capa de Infraestructura (Repository): Gestiona la comunicación HTTP con la API externa.

Capa de Datos (DTO): Implementación de Java Records y la librería GSON para el mapeo exacto del JSON anidado.

Capa de Negocio (Service): Contiene la lógica de transformación y procesamiento de la información.

Capa de Dominio (Model): Modelos de objetos puros que representan la entidad "Clima" de forma independiente a la fuente de datos.

Capa de Presentación (View): Interfaz de línea de comandos (CLI) para la interacción con el usuario.

## 🛠️ Tecnologías utilizadas


Java 17+ (Uso de Records para inmutabilidad).

GSON: Para la deserialización de JSON a objetos Java.

HttpClient: Para peticiones asíncronas a la API de OpenWeather.

SOLID: Aplicación de principios de diseño orientado a objetos.
