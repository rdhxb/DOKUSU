# Sudoku — Rules

## The board

The playground is a **9x9 grid**, divided into nine **3x3 boxes**:

```
+-------+-------+-------+
| 5 3 . | . 7 . | . . . |
| 6 . . | 1 9 5 | . . . |
| . 9 8 | . . . | . 6 . |
+-------+-------+-------+
| 8 . . | . 6 . | . . 3 |
| 4 . . | 8 . 3 | . . 1 |
| 7 . . | . 2 . | . . 6 |
+-------+-------+-------+
| . 6 . | . . . | 2 8 . |
| . . . | 4 1 9 | . . 5 |
| . . . | . 8 . | . 7 9 |
+-------+-------+-------+
```

Some cells are filled in at the start (the *givens*) and cannot be changed.
Every empty cell must be filled with a digit from **1 to 9**.

## The three rules

A digit may not repeat:

1. **Row** — each of the 9 rows contains the digits 1-9 exactly once.
2. **Column** — each of the 9 columns contains the digits 1-9 exactly once.
3. **Box** — each of the nine 3x3 boxes contains the digits 1-9 exactly once.

So every row, column and box holds all nine digits, with no duplicates and no
gaps.

## The goal

Fill the whole grid without breaking any of the three rules above.
A correct puzzle has exactly one solution, and it can always be found by logic
alone — guessing is never required.
