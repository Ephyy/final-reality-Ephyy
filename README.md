Final Reality
=============

![http://creativecommons.org/licenses/by/4.0/](https://i.creativecommons.org/l/by/4.0/88x31.png)

This work is licensed under a 
[Creative Commons Attribution 4.0 International License](http://creativecommons.org/licenses/by/4.0/)

Context
-------

This project's goal is to create a (simplified) clone of _Final Fantasy_'s combat, a game developed
by [_Square Enix_](https://www.square-enix.com)
Broadly speaking for the combat the player has a group of characters to control and a group of 
enemies controlled by the computer.

---

## Project Classes
Actualmente el proyecto consiste en dos grandes entidades, los personajes y las armas.

### Characters

Este juego esta formado por varios tipos de personajes, pero principalmente hay dos, los personajes
controlados por el jugador (PlayerCharacters) y unidades enemigas Enemy.

#### PlayerCharacters
 
Es la clase que representa a los personajes del jugador y con las cuales el usuario puede
interactuar, pudiendo equiparse armas, atacar, defenderse, etc. Estos personajes son:

- Knight
- Engineer
- Thief
- Black Mage
- White Mage

#### Weapons

Existe una diversidad de armas que pueden ser utilizadas, pero dependiendo de la clase del personaje
puede ser usada o no como se muestra en la siguiente tabla:

|            | Sword | Axe | Knife | Staff | Bow |
|:----------:|:-----:|-----|-------|-------|-----|
| Knight     |   *   |  *  |   *   |       |     |
| Engineer   |       |  *  |       |       |  *  |
| Thief      |   *   |     |   *   |       |  *  |
| Black Mage |       |     |   *   |   *   |     |
| White Mage |       |     |       |   *   |     |

Donde los puntos señalan las armas que el personaje puede portar. Cabe mencionar que los enemigos 
no pueden usarlas.

### Design patterns

#### Clases abstractas e interfaces

Como los distintos tipos de unidades enemigas y los personajes del jugador  tienen comportamientos y atributos muy
similares, como lo es, tener hp, atk, def, poder atacar, defenderse y más, se agrupo todo este 
comportamiento generico en una clase abstracta *AbstractCharacter*  y su interfaz *ICharacter* que engloba todo 
el concepto de lo que es un personaje dentro del juego.

Las distintas clases de personajes del jugador necesitan agrupar el comportamiento de portar un arma
por lo que también se agruparon las clases respectivas de las clases en *AbstractPlayerCharacter* y
en una interfaz principal *IPlayerCharacter* y otras dos secundarias, *Common*
y *Mage*, debido a que los magos también engloban una característica en común ligada a la magia, pudiendo
lanzar hechizos, tener mana, entre otras cosas, comportamiento que se modela en *AbstractMage*

De igual forma esto aplica para las armas del juego que a pesar de ser armas diferentes, no quita la
esencia de ser un arma, por lo que cada clase que representan los diferentes
tipos de armas heredan de *AbstractWeapon* ,que implementa la interfaz *IWeapon*, agrupando todas las
características propias de lo que es un arma dentro del juego.

## Supuestos Tarea1
- Se considera que los Thief pueden usar Knife
- En esta tarea se considera que los personajes tiene un "tipo" pero esto sera
modificado en la tarea 2 debido a que cada clase sabe que tipo es (DD cof cof).
- Se interpreta que del enunciado los personajes siempre tienen un arma, no existe el estar
desarmado, por lo que un personaje no tiene arma nula (por ahora, se sigue analizando) 
por lo que al crearlos si o si se deben colocar con un arma.

## Getting Started

### Prerequisites

- Java
- Gradle
- IntelliJ (preferentemente)

### Installing

Crear una copia de un repositorio local ejecutando:
```
$ git clone https://github.com/CC3002-Metodologias/final-reality-Ephyy.git
```

Y luego abrir el proyecto en su IDE (de preferencia en IntelliJ)

## Running the tests

Para correr todos los tests del proyecto se debe ejecutar la carpeta.
```
...\src\test
```

## Deployment
Por ahora el proyecto no tiene una forma de ser ejecutado debido a que solo está conformado por
los modelos y funcionalidades que seran utilizadas en las próximas entregas pero todo se encuentra
testeado.

## Built With

* Gradle

## Authors

- **Vicente Ardiles Silva** - [Ephyy](https://github.com/Ephyy)
- **Ignacio Slater Muñoz** - [islaterm](https://github.com/islaterm)
