# Infix to Postfix and Prefix Converter

This project provides a Java implementation for converting infix expressions to their equivalent postfix and prefix forms. It includes the core conversion logic, pseudo-code for understanding the algorithms, and a visual flowchart of the conversion process.

## Table of Contents
- [Features](#features)
- [Getting Started](#getting-started)
  - [Prerequisites](#prerequisites)
  - [Compilation and Execution](#compilation-and-execution)
- [Algorithm Overview](#algorithm-overview)
  - [Infix to Postfix](#infix-to-postfix)
  - [Infix to Prefix](#infix-to-prefix)
- [Pseudo-code](#pseudo-code)
- [Workflow Flowchart](#workflow-flowchart)
- [Project Structure](#project-structure)
- [Contributing](#contributing)
- [License](#license)

## Features
- Converts infix expressions to postfix expressions.
- Converts infix expressions to prefix expressions.
- Handles basic arithmetic operators (`+`, `-`, `*`, `/`, `^`).
- Supports parentheses for grouping.

## Getting Started

### Prerequisites
- Java Development Kit (JDK) 8 or higher.

### Compilation and Execution

1.  **Navigate to the project directory:**
    ```bash
    cd /home/ubuntu/expression-converter
    ```

2.  **Compile the Java source code:**
    ```bash
    javac src/main/java/com/converter/ExpressionConverter.java
    ```

3.  **Run the compiled program:**
    ```bash
    java -cp src/main/java com.converter.ExpressionConverter
    ```

    The `main` method in `ExpressionConverter.java` contains example infix expressions and prints their postfix and prefix equivalents.

## Algorithm Overview

### Infix to Postfix
The conversion from infix to postfix expression is typically achieved using a stack-based algorithm. The general steps are:
1.  Initialize an empty stack for operators and an empty string/list for the postfix expression.
2.  Scan the infix expression from left to right.
3.  If an operand is encountered, append it to the postfix expression.
4.  If a left parenthesis `(` is encountered, push it onto the stack.
5.  If a right parenthesis `)` is encountered, pop operators from the stack and append them to the postfix expression until a left parenthesis is encountered. Discard both parentheses.
6.  If an operator is encountered, pop operators from the stack and append them to the postfix expression as long as the stack is not empty, the top of the stack is not a left parenthesis, and the precedence of the scanned operator is less than or equal to the precedence of the operator at the top of the stack. Then, push the scanned operator onto the stack.
7.  After scanning the entire infix expression, pop any remaining operators from the stack and append them to the postfix expression.

### Infix to Prefix
Converting an infix expression to a prefix expression can be done by modifying the infix to postfix algorithm:
1.  Reverse the infix expression.
2.  Swap all `(` with `)` and `)` with `(` in the reversed expression.
3.  Convert the modified infix expression to postfix using the standard infix to postfix algorithm.
4.  Reverse the resulting postfix expression to get the prefix expression.

## Pseudo-code
For a detailed step-by-step breakdown of the algorithms, refer to the [Pseudo-code document](docs/PseudoCode.md).

## Workflow Flowchart
The following flowchart illustrates the overall workflow for converting infix expressions.

![Workflow Flowchart](docs/flowchart.png)

## Project Structure
```
expression-converter/
├──ExpressionConverter.java
├── docs/
│   ├── PseudoCode.md
│   └── flowchart.mmd
│   └── flowchart.png
└── README.md
```

## Contributing
Feel free to fork this repository, submit pull requests, or open issues for any improvements or bug fixes.

## License
This project is licensed under the MIT License - see the LICENSE file for details (if applicable).
