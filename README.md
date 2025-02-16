# Music-service-Project

### Primera parte

**Objetivo:** Consumir APIs de servicios de musica, en este caso consume un servicio de música de Spotify. 

**Branch:** main

**Java versión:** JDK 8

**Patrones de diesño implementados:** Abstract factory y Strategy 

**Abstract factory:** Se encarga de crear los objetos (Song, Album, Artist). Su responsabilidad es convertir los datos JSON en objetos usables para el sistema

**Strategy:** Define como usar los datos y usar el factory

Esta implementación facilita añadir nuevos servicios sin modificar el código existente (Open/Closed Principle), mantiene el código limpio y organizado al centralizar la creación de objetos.

 ![image](https://github.com/user-attachments/assets/2ac07c5b-5096-4b4f-a031-ac4f8f23f80b)

### Segunda parte

**Objetivo:** Actualizar el servicio de musica a la versión 23 de java, mantieniendo el mismo core, pero actualizando los features de java utilizados

**Branch:** vjava23

**Java versión:** JDK 23

#### Nuevas features:

> Se reemplazan las interfaces de acceso a objetos (Song, Album, Artist) por records, esto hace el código más conciso e inmutable.
> 
> Se implementa el uso de Pattern Matching.
> 
> Se implementa el uso de programación funcional con Streams.
> 
> Se implementa el uso de String Templates y var para la declaración de variables locales.


![image](https://github.com/user-attachments/assets/d2b541c4-b388-4017-89e0-59d873e220f9)

