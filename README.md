# SeaOfWars 🦭
Juego de Sea of Wars para el curso de Programacion Orientada a Objetos del Tecnológico de Costa Rica. II Semestre, 2020.

# Modo de juego 🎮
1. Se debe correr el archivo **MainServer.java** de la carpeta **Servidor**.
2. Se debe correr MainCliente.java según la cantidad de jugadores que deseen jugar.
3. Se deben ingresar los nicknames.
4. Se debe escribir el comando CREARPERSONAJE e ingresar los valores solicitados en consola.
5. Una vez todos han hecho esto con sus tres personajes, se escribe el comando "LISTO".
6. Puede jugar escribiendo ATTACK y e ingresar los valores solicitados en consola.



## Instrucciones básicas del proyecto:
* Es una pelea entre 2, 3, 4, 5, 6 civilizaciones. Cada una con un ejército de 3 peleadores. Cada peleador representa un % del pueblo o civilización, entre los 3 suman el 100%.
* La batalla se da en las consolas, cada una con un control de mando en una computadora diferente (Sockets).
* El rey controla la consola, inicia conectándose al servidor y seleccionando el nombre de su civilización.
* Posteriormente selecciona sus guerreros, los configura y da la indicación que está listo para la batalla.
* Cuando todos estén listos, inicia la partida, en orden aleatorio. Atacando un turno cada uno a la vez.
* Los ataques es seleccionando un luchador, un ataque del luchador. O bien, seleccionando alguno de los ataques especiales.

### Luchadores:
* Hay una lista de luchadores con diferentes características.
* El rey selecciona entre esta lista 3 peleadores, los cuales enviará a la batalla final.
* Al seleccionar los 3 debe determinar cuánto porcentaje de la civilización representará cada uno, para un total del 100%. El pueblo es una matriz de 20x30 casillas, es decir, 600 casillas será la civilización, esa cantidad debe repartirse entre la representatividad de los 3 luchadores escogidos.
* Un luchador tiene 3 características que determinan su poder: fuerza, resistencia, auto-sanidad
* Cada luchador pertenece a un grupo particular también, que le da pros y contras durante la lucha, pero principalmente, determina sus modos de ataque.

### Selección de luchadores:
Se crean 3 luchadores, para lo cual debe indicarse:
1. Nombre.
2. Imagen (todas del mismo tamaño, tema y apariencia).
3. Porcentaje que representa de la humanidad.
4. Grupo de ataque: seleccionar 1 de los 6 posibles.
5. Asignar poder, resistencia, autosanidad. Para estos valores tiene 3 100%, 3 75% y 3 50%, debe colocar en cada característica uno de esos porcentajes. Por ejemplo, puede asignar a un luchador 100 poder, 100 resistencia, 100 autosanidad o cualquier combinación que reparta esos 9 valores entre las 3 características de cada jugador.

### La civilización - Mapa:
* La civilización es una matriz de 20x600, donde cada luchador representa un porcentaje del mismo.
* Si se destruyen todas las casillas de un luchador, este muere. Si un luchador se recupera, sus casillas también.
* Una civilización muere cuando todos susluchadores mueren, todas sus casillas son destruidas.

### Ataques:
Release the Kraken:
* Tentáculos: permite colocar en eltablero la aparción de 3 tentáculos que destruyen lo que esté en el radio de 1 casilla alrededor.
* Kraken Breath: se selecciona una casilla donde el Kraken lanza su aliento hacia una dirección: arriba, abajo, derecha, izquierda. El aliento destruye entre 1 y 8 casillas en esa dirección.
* Release the Kraken: el Kraken aparece en un punto del mapa y destruye todo en un radio de 1,2,3,4,5,6,7,8,9 casillas.

Poseidon Trident:
* Three lines: selecciona 3 puntos en el mapa. En cada punto destruye lo que esté de 1 a 4 casillas a la derecha, izquierda, arriba, abajo (aleatorio)
* Three numbers: envía 3 números distintos entre 0 y 9 al contrincante. Este último debe escribir 3 números distintos entre 0 y 9, si atina al menos uno de los 3 del tridente enviado, explotará la cantidad de casillas que de la multiplicación de los números del Tridente.
* Control the Kraken: si es atacado con el Kraken, retornará ese ataque al enemigo que lo atacó.

Fish Telepathy:
* Cardumen: Crea entre 100 y 300 peces pequeños que atacan aleatoriamente casillas del contrincante. Cada pez daña un 33% de la casilla.
* Shark attack: los tiburones atacan las 4 esquinas del mapa. Desde cada una de las esquinas un radio de entre 1 y 10 casillas.
* Pulp: se generan entre 20 y 50 pulpos, cada uno saca 8 tentáculos en casillas aleatorias. Si al menos 4 tentáculos de cualesquiera pulpos tocan la misma casilla, se destruye. Es decir, cada tentáculo daña un 25% la casilla que toca.

Undersea Fire:
* Volcano raising: se genera un volcán en una casilla y este crecerá
entre un radio de 1 a 10 casillas. Destruye las casillas donde creció. El volcán queda en esas casillas para futuros ataques.
* Volcano explosion: debe seleccionar un volcán que creó previamente. El volcán hará erupción, enviado piedras equivalente a 10 veces el tamaño en celdas del volcán. Cada piedra daña un 20% de la casilla donde cae.
* Termal rush: se genera un sobrecalentamiento del agua alrededor de un radio de 5 casillas del volcán. El calentamiento será entre 5 y 6 segundos, cada segundo equivale a porcentaje del radio del volcán de daño, es decir, si el volcán tiene 5 de daño, cada segundo que pasa dañará las casillas en 5%


### Características del personaje:
* Sanidad:     
-En lugar de atacar, el luchador sana sus casillas no muertas, sino parcialmente heridas.     
-La sanidad será a un 50%, 75% o 100%, según el valor de la propiedad del jugador. 
* Ataque:
En lugar de atacar, el luchador aumentará su siguiente ataque (siguiente turno que ataque con el luchador) en el 50%, 75% o 100%, según el valor de la propiedad del jugador.
*   Resistencia:        
-En lugar de atacar, el luchador protege sus casillas no muertas, sino parcialmente heridas.         
-La protección será por un ataque, y el impacto del ataque contrario será solo del 50%, 75% o 100%, según el valor de la propiedad del jugador.


### Consola:
* Espacio para digitar los comandos y obtener mensajes de repsuesta del comando, éxito o error.
* Mostrar siempre los datos de los 3 luchadores.
* Mostrar la civilización completa y con su estado, las 600 casillas. Además, poder consultar el estado de cada una de las 600 casillas: % de vida, si está ocupada por volcan o remolino, quién la aniquiló, todos los ataques recibidos, sanidad, escudos, etc. Una bitácora de cada casilla.
* Mostrar una bitácora de todo lo que ha sucedido tanto hecho como recibido.
* Mostrar el detalle del último ataque recibido o ejecutado: casilla por casilla cuàl fue el impacto.
* TODO debe ser realizado medio comandos de la consola.
![imagen](https://user-images.githubusercontent.com/64928283/147999087-c438755d-5e14-4699-97b9-3c648190cdc3.png)

### Comandos:
Todas las acciones deben ser realizadas mediante comandos de la consola. Es libre de determinar los valores de cada comando.
* CREARPERSONAJE: es crear 1 de 3 personajes con las características solicitadas.
* LISTO: indicar que se seleccionó todo y se está listo para la lucha.
* ATTACK: seleccionar un personaje y atacar con este, con algún poder de los que tenga. Seleccionar al enemigo que se desea atacar. También es posible atacar con poder, resistencia o sanidad.
* SALTARTURNO: no ataca cuando le toca, salta su turno.
* MENSAJE: enviar mensaje.      
* MENSAJE-NOMBRE JUGADOR: enviar mensaje a un enemigo particular.
* RENDIRSE: perder el juego.
* CONSULTARCELDA: dada una celda se muestra el estado de esta: vida, estado, y la lista cronológica de todos los ataques recibidos.
* : muestra un detalle de TODOS los eventos que han sucedido: ataques recididos, atauqes ejecutados.
* CARACTERISTICA: da cuántos ataques se han realizado y cuál es el porcentaje de éxito, cuántos atinaron, cuántos no.
* Consultar enemigo: se muestra el estado del enemigo: porcentaje de vida, casillas de muertas del total.
* Mostrar celdas ocupadas: muestra en el mapa las celdas ocupadas por volcanes, remolinos.
* Mostrar porcentajes de celdas: muestra en el mapa la vida de cada celda.
* Pintar vivas: muestra en el mapa las celdas que están vivas de un color, de otro las muertas.

https://img.shields.io/github/stars/RavenInDisguise/SeaOfWars.git?logoColor=yellow&style=for-the-badge
https://img.shields.io/github/forks/RavenInDisguise/SeaOfWars.git?style=for-the-badge


