# RentACar
Plantilla inicial para la aplicación de alquiler de coches

Vamos a desarrollar una  aplicación de Renting para una pequeña empresa.
Nos hemos reunido el cliente y hemos recogido estos requisitos:

• Los clientes pueden alquilar los coches vía web o en la oficina física.  
• Los clientes van a tener un id y un nombre.  
• Los coches van a tener una matrícula además de un modelo. A cada modelo se
  le aplicará un precio por día distinto.  
• Cada oficina tendrá una dirección y un cargo extra.  
• Quiere que únicamente los alquileres vía web puedan dejar el coche en una
    oficina distinta a la de origen. En la que se le aplicará el cargo extra.

![image](https://user-images.githubusercontent.com/127649698/224941468-3a55bdf0-eec4-4349-8890-2a28bc53a200.png)

Queremos utilizar metodologías ágiles y además seguiremos la práctica TDD para desarrollar este software, de tal manera que,
inicialmente se crearán los test de una clase y se desarrollará todas las funcionalidades de la misma.

Necesitamos un diagrama de casos de uso que cubra las funcionalidades mínimas para que los clientes puedan alquilar.

Además partimos de un desarrollo inicial que cubre todas las funcionalidades CRUD de la clase cliente. Falta por implementar alquilarCoche, ya que de momento, la única clase existente en el proyecto es Cliente. Siguiendo con la arquitectura propuesta y basándonos en TDD, desarrollar todas las funcionalidades obtenidas en los casos de uso.


