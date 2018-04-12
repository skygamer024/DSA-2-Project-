# Mazr

*Maze Generation* using randomised [Prim's Algorithm](https://en.wikipedia.org/wiki/Prim%27s_algorithm). 
Done as a part for the course ES 301.

## Group Members

> (sorted alphabetically)

- Anmol Gautam ([@tarptaeya](https://github.com/tarptaeya)) 16110016
- Meet Panchal
- Shivansh Chaudhary ([@skygamer024](https://github.com/skygamer024)) 16110147

## About

> From wikipedia
> A maize is a path or collection of paths, typically from an entrance to a
> goal

The aim of our project is to 
- Construct a random maze using *Randomised Prims Algorithm*
- Solve the constructed maze using *Breadth First Search*

## Pseudocode

[Randomised Prims]
- Start with a grid
- Take a random cell, add it to the grid and its walls into some collection, say `COLL`
- while `COLL` is not empty:
 - Take a random wall from the collection &amp; if only one of the two cells that the wall divides is visited then,
  - Make all wall a passage  and mark the unvisited cell as part of maze
  - Add the neighborig walls of the cell to `COLL`
 - Remove the wall from `COLL`
