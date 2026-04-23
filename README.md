# Lexical Analyzer

A Java-based lexical analyzer (lexer/tokenizer) with a graphical user interface built using Swing. This tool breaks down source code into tokens and displays them in an easy-to-read table format.

## Features

- **Multi-line input support**: Analyze code with multiple lines
- **Token categorization**: Identifies keywords, identifiers, constants, operators, punctuation, and more
- **Visual representation**: Displays results in a sortable table with lexeme, type, position, and line number
- **Real-time analysis**: Interactive GUI for instant feedback
- **Floating-point number support**: Correctly tokenizes decimal numbers

## Token Types

The analyzer recognizes the following token categories:

| Token Type | Description | Examples |
|------------|-------------|----------|
| `KEYWORD` | Reserved words | `if`, `else`, `while`, `for`, `int`, `float`, `return` |
| `IDENTIFIER` | Variable/function names | `myVar`, `calculateSum`, `x1` |
| `CONSTANT` | Numeric literals | `42`, `3.14`, `0.5` |
| `ARITHMETIC_OPERATOR` | Math operators | `+`, `-`, `*`, `/`, `%`, `^` |
| `RELATIONAL_OPERATOR` | Comparison operators | `>`, `<`, `=` |
| `LOGICAL_OPERATOR` | Boolean operators | `&`, `|`, `!` |
| `PUNCTUATION` | Delimiters & separators | `;`, `,`, `.`, `:`, `(`, `)`, `{`, `}`, `[`, `]` |
| `SPECIAL_SYMBOL` | Special characters | `@`, `#`, `$`, `_` |
| `STRING_DELIMITER` | Quote marks | `"`, `'` |
| `UNKNOWN` | Unrecognized characters | Any other character |

## Project Structure
```
TokensTable/
├── Lexer.java           # Core lexical analysis engine
├── Tokens.java          # Token data structure
├── TokenType.java       # Enum for token categories
├── TokenTableGUI.java   # Swing-based user interface
└── main.java            # Application entry point
```
---