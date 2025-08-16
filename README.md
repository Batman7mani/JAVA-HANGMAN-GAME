# Hangman (Java CLI)

A lightweight, terminal-based Hangman game written in **pure Java**. It picks a random word from a local text file and renders classic ASCII art for each wrong guess.

---

## Features

* Random word selection from `write.txt` (one word per line)
* Case-insensitive guessing
* 6-stage ASCII hangman display
* Attempt counter and win/lose detection
* Robust file reading via try-with-resources
* Graceful handling of empty/invalid word lists

> **Java version**: Uses text blocks and switch expressions; target **Java 17+** (LTS).

---

## Project Structure

```
📁 hangman-java
├── Main.java        # Entry point
└── write.txt        # Word list (one word per line)
```

### Example `write.txt`

```
pokemon
java
hangman
developer
cybersecurity
```

Blank lines are ignored. Words can be uppercase or mixed case; the game normalizes internally.

---

## Getting Started

### Prerequisites

* Java **17 or newer** installed and on your PATH (`java -version`)

### Build & Run (terminal)

```bash
# Compile
javac Main.java

# Run
java Main
```

### Run in VS Code

1. Open the folder in VS Code.
2. Ensure the Java Extension Pack is installed.
3. Open `Main.java` and click **Run**.

### Run in IntelliJ IDEA

1. Open the project folder.
2. Create a **New Project from Existing Sources** (if prompted).
3. Mark `Main.java` as a source file and click **Run**.

---

## Gameplay

1. On launch, the game loads words from `write.txt`.
2. A random word is selected and hidden with underscores.
3. You guess one **letter** at a time. Input is case-insensitive.
4. Each wrong guess advances the ASCII hangman. You have **6 attempts**.
5. The game ends when you reveal all letters (win) or reach 6 wrong guesses (lose).

> Tip: Keep multi-word phrases out of `write.txt`. Use single words without spaces or punctuation for best results.

---

## Configuration

* **Word list path**: Currently hard-coded as `write.txt` (same directory). Change the `filepath` string in `Main.java` if needed.
* **Attempts**: Fixed at 6. To change, update the `while (wrong < 6)` condition and the `Hangman(int wrong)` stages accordingly.

---

## Error Handling & Troubleshooting

* **File not found / access issues**
  Ensure `write.txt` exists in the same directory as `Main.java` (or adjust `filepath`).

* **Empty word list**
  If `write.txt` has no valid lines, the program exits with a helpful message. Add at least one word.

* **UnsupportedClassVersionError**
  Compile/run with Java **17+**. Update your JDK if you see class version errors.

---

## Sample Session

```
***************************
WELCOME TO THE HANGMAN GAME
***************************


WORD : _ _ _ _ _ _ _
Attempts left: 6
Enter a letter: o
Correct guess!

 O

WORD : _ o _ e _ o _
Attempts left: 6
Enter a letter: z
Wrong guess!
...
```

---

## Implementation Notes

* File I/O uses `BufferedReader` + try-with-resources.
* Lines are trimmed and empty lines skipped.
* Selected word is normalized to lowercase; player input is lowered before comparison.
* ASCII art is produced by a `switch` on wrong-attempt count using Java text blocks.

---

## Extending the Game (Ideas)

* Track and display **already guessed letters** (ignore repeats without penalty).
* **Difficulty modes** (vary attempts or word lengths).
* **Category-based** word lists (e.g., animals, movies) and menu selection.
* **Input validation** (reject non-letters, full-word guess option).
* **Unit tests** for core logic (e.g., updating `wordStatus`).
* Colorized output for terminals that support ANSI.

---

