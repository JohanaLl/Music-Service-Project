# Music-service-Project

Music service consume un servicio de música de Spotify. 
Está implementado con dos patrones de diseño: 

#### Abstract factory: Se encarga de crear los objetos (Song, Album, Artist). Su responsabilidad es convertir los datos JSON en objetos usables para el sistema
#### Strategy: Define como usar los datos y usar el factory
Esta implementación facilita añadir nuevos servicios sin modificar el código existente (Open/Closed Principle), mantiene el código limpio y organizado al centralizar la creación de objetos.

 ![image](https://github.com/user-attachments/assets/2ac07c5b-5096-4b4f-a031-ac4f8f23f80b)

Este proyecto se ejecuta desde la clase principal Solution
