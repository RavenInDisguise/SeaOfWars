# English - Inglés
# SeaOfWars 🦭
Sea of Wars game for the Object Oriented Programming course at Tecnológico de Costa Rica. II Semester, 2020.

# Game mode 🎮
1. You must run the **MainServer.java** file from the **Server** folder.
2. **MainCliente.java** should be run depending on the number of players who want to play.
3. Nicknames must be entered.
4. You must write the "CREARPERSONAJE" command and enter the requested values in the console.
5. Once everyone has done this with their three characters, the command "LISTO" is written.
6. You can play by typing "ATTACK" and entering the requested values in the console.



## Basic project instructions:
* It is a fight between 2, 3, 4, 5, 6 civilizations. Each with an army of 3 fighters. Each fighter represents a % of the people or civilization, between the 3 they add up to 100%.
* The battle takes place on consoles, each with a command control on a different computer (Sockets).
* The king controls the console, starts by connecting to the server and selecting the name of his civilization.
* Later he selects his warriors, configures them and gives the indication that he is ready for battle.
* When everyone is ready, he starts the game, in random order. Attacking one turn each at a time.
* Attacks is by selecting a fighter, a fighter's attack. Or, selecting one of the special attacks.

### Fighters:
* There is a list of fighters with different characteristics.
* The king selects 3 fighters from this list, which he will send to the final battle.
* When selecting the 3 you must determine how much percentage of the civilization each one will represent, for a total of 100%. The town is a matrix of 20x30 squares, that is, 600 squares will be the civilization, that quantity must be distributed among the representativeness of the 3 chosen fighters.
* A fighter has 3 characteristics that determine his power: strength, endurance, self-healing
* Each fighter belongs to a particular group too, which gives him pros and cons during the fight, but mainly, determines his attack modes.

### Selection of fighters:
3 fighters are created, for which it must be indicated:
1. Name.
2. Image (all the same size, theme and appearance).
3. Percentage that represents humanity.
4. Strike group: select 1 of the 6 possible ones.
5. Assign power, endurance, self-healing. For these values you have 3 100%, 3 75% and 3 50%, you must place one of those percentages in each characteristic. For example, you can assign a fighter 100 power, 100 stamina, 100 self-healing, or any combination that distributes those 9 values among the 3 characteristics of each player.

### Civilization - Map:
* Civilization is a 20x600 matrix, where each fighter represents a percentage of it.
* If all the squares of a fighter are destroyed, this fighter dies. If a fighter recovers, he squares as well.
* A civilization dies when all its fighters die, all its squares are destroyed.

### Attacks:
Release the Kraken:
* Tentacles: allows to place on the board the appearance of 3 tentacles that destroy what is in the radius of 1 square around.
* Kraken Breath: a square is selected where the Kraken blows its breath in one direction: up, down, right, left. The breath destroys between 1 and 8 squares in that direction.
* Release the Kraken: the Kraken appears at a point on the map and destroys everything in a radius of 1,2,3,4,5,6,7,8,9 squares.

Poseidon Trident:
* Three lines: select 3 points on the map. At each point destroy whatever is 1 to 4 squares to the right, left, up, down (random)
* Three numbers: send 3 different numbers between 0 and 9 to the opponent. The latter must write 3 different numbers between 0 and 9, if he hits at least one of the 3 of the trident sent, he will explode the number of boxes that the multiplication of the Trident numbers.
* Control the Kraken: if it is attacked with the Kraken, it will return that attack to the enemy that attacked it.

Fish Telepathy:
* Shoal: Create between 100 and 300 small fish that randomly attack the opponent's squares. Each fish damages 33% of the square.
* Shark attack: sharks attack the 4 corners of the map. From each of the corners a radius of between 1 and 10 squares.
* Pulp: between 20 and 50 octopuses are generated, each one takes out 8 tentacles in random squares. If at least 4 tentacles of any octopus touch the same square, it is destroyed. That is, each tentacle damages the square it touches by 25%.

Undersea Fire:
* Volcano raising: a volcano is generated in a square and it will grow
between a radius of 1 to 10 squares. Destroy the squares where he grew up. The volcano remains in those boxes for future attacks.
* Volcano explosion: you must select a volcano that you previously created. The volcano will erupt, sending stones equivalent to 10 times the size of the volcano's cells. Each stone damages 20% of the square where it falls.
* Thermal rush: 
overheating of the water is generated around a radius of 5 squares of the volcano. The heating will be between 5 and 6 seconds, each second is equal to a percentage of the radius of the damage volcano, that is, if the volcano has 5 damage, every second that passes will damage the squares by 5%


### Character characteristics:
* Health:
-Instead of attacking, the fighter heals his squares not dead, but partially wounded.
-Health will be 50%, 75% or 100%, depending on the value of the player's property.
* Attack:
Instead of attacking, the fighter will increase his next attack (next turn he attacks with the fighter) by 50%, 75%, or 100%, depending on the player's property value.
*   Endurance:
-Instead of attacking, the fighter protects his squares not dead, but partially wounded.
-The protection will be for an attack, and the impact of the opposing attack will be only 50%, 75% or 100%, depending on the value of the player's property.


### Console:
* Space to type the commands and obtain response messages for the command, success or error.
* Always show the data of the 3 fighters.
* Show the complete civilization and its state, the 600 squares. In addition, being able to consult the status of each of the 600 squares:% of life, if it is occupied by a volcano or whirlpool, who annihilated it, all the attacks received, health, shields, etc. A log for each box.
* Show a log of everything that has happened both done and received.
* Show the detail of the last attack received or executed: box by box what was the impact.
* EVERYTHING must be done through console commands.

![imagen](https://user-images.githubusercontent.com/64928283/147999087-c438755d-5e14-4699-97b9-3c648190cdc3.png)

### Commands:
All actions must be performed through console commands. You are free to determine the values of each command.
* CREATE CHARACTER: is to create 1 of 3 characters with the requested characteristics.
* READY: indicate that everything has been selected and is ready for the fight.
* ATTACK: select a character and attack with it, with any power that it has. Select the enemy you want to attack. It is also possible to attack with power, resistance or health.
* JUMPER: does not attack when it is his turn, he skips his turn.
* MESSAGE: send message.
* MESSAGE-PLAYER NAME: send message to a particular enemy.
* GIVE UP: lose the game.
* CONSULTARCELDA: given a cell, its status is shown: life, status, and the chronological list of all attacks received.
* LOG: shows a detail of ALL the events that have happened: repeated attacks, executed attacks.
* FEATURE: gives how many attacks have been made and what is the success rate, how many hit, how many not.
* CHECKENEMY: the enemy's status is shown: percentage of life, dead cells of the total.
* Show occupied cells: shows on the map the cells occupied by volcanoes, eddies.
* PERCENTAGE CELLS: shows the life of each cell on the map.
* PINTARVIVAS: shows on the map the cells that are alive in one color, in another the dead ones. 

# ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


# Spanish - Español 
# SeaOfWars 🦭
Juego de Sea of Wars para el curso de Programacion Orientada a Objetos del Tecnológico de Costa Rica. II Semestre, 2020.

# Modo de juego 🎮
1. Se debe correr el archivo **MainServer.java** de la carpeta **Servidor**.
2. Se debe correr MainCliente.java según la cantidad de jugadores que deseen jugar.
3. Se deben ingresar los nicknames.
4. Se debe escribir el comando CREARPERSONAJE e ingresar los valores solicitados en consola.
5. Una vez todos han hecho esto con sus tres personajes, se escribe el comando "LISTO".
6. Puede jugar escribiendo ATTACK e ingresar los valores solicitados en consola.



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
* LOG: muestra un detalle de TODOS los eventos que han sucedido: ataques recididos, atauqes ejecutados.
* CARACTERISTICA: da cuántos ataques se han realizado y cuál es el porcentaje de éxito, cuántos atinaron, cuántos no.
* CONSULTARENEMIGO: se muestra el estado del enemigo: porcentaje de vida, casillas de muertas del total.
* Mostrar celdas ocupadas: muestra en el mapa las celdas ocupadas por volcanes, remolinos.
* PORCENTAJECELDAS: muestra en el mapa la vida de cada celda.
* PINTARVIVAS: muestra en el mapa las celdas que están vivas de un color, de otro las muertas.



