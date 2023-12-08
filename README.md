# CLI_Paint
Simple console based drawing program.

# Getting Started
To run this application: 

Prerequisites - have Java Runtime installed
1. Clone this repository
2. Open project root in terminal
3. Run "./gradlew run"

# Usage
All x and y coordinates are 1 indexed.

Available commands:
1. C {width} {height}

Creates new canvas of size width x height


2. L {x1} {y1} {x2} {y2} 

Creates only horizontal or vertical non-directional lines, where (x1, y1) is one end of the line and (x2, y2) is second end of the line


3. R {x1} {y1} {x2} {y2}


Creates hollow rectangle where with vertexes defined as:
(x1, y1), (x1, y2), (x2, y1), (x2, y2)


4. B {x} {y} {color}

Fills with color area around (x,y) point as far as filled cell is empty

5. Q 

Quits the program


# Running Tests

Tests are checking functional part of program - drawing elements of canvas.
To run the tests:

1. Open project root in terminal
2. Run "./gradlew test"

