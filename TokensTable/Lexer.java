package TokensTable.TokensTable;
import javax.swing.JFrame;
import javax.swing.JTable;
import java.util.*;

public class Lexer {

    private List<Tokens> tokens;

    private static final Set<String> KEYWORDS = Set.of("if", "else", "while", "for", "int", "float", "return");
    private static final Set<Character> ARITHMETIC_OPS = Set.of('+', '-', '*', '/', '%', '^');
    private static final Set<Character> RELATIONAL_OPS = Set.of('>', '<', '=');
    private static final Set<Character> LOGICAL_OPS = Set.of('&', '|', '!' );
    private static final Set<Character> PUNCTUATION = Set.of(';', ',', '.', ':', '(', ')', '{', '}', '[', ']');
    private static final Set<Character> SPECIAL_SYMBOLS = Set.of('@', '#', '$', '_');
    private static final Set<Character> STRING_DELIMITERS = Set.of('"', '\'');

    public Lexer() {
        tokens = new ArrayList<>();
    }

    public List<Tokens> analyze(String input) {
        tokens.clear();

        String[] lines = input.split("\n");

        for (int lineNum = 0; lineNum < lines.length; lineNum++) {
            analyzeLine(lines[lineNum], lineNum + 1);
        }

        return tokens;
    }

    private void analyzeLine(String line, int lineNumber) {
        int i = 0;

        while (i < line.length()) {
            char c = line.charAt(i);

            // Skip spaces
            if (Character.isWhitespace(c)) {
                i++;
                continue;
            }

            int start = i;

            // identifiers keywords 
            if (Character.isLetter(c)) {
                StringBuilder sb = new StringBuilder();

                while (i < line.length() &&
                       Character.isLetterOrDigit(line.charAt(i))) {
                    sb.append(line.charAt(i));
                    i++;
                }

                String word = sb.toString();

                if (KEYWORDS.contains(word)) {
                    addToken(word, TokenType.KEYWORD, start, lineNumber);
                } else {
                    addToken(word, TokenType.IDENTIFIER, start, lineNumber);
                }
            }

            // Numbers 
            else if (Character.isDigit(c)) {
                StringBuilder sb = new StringBuilder();
                boolean hasDot = false;

                while (i < line.length()){
                    char current = line.charAt(i);

                    if (Character.isDigit(current)){
                        sb.append(current);
                    }

                    else if(current == '.' && ! hasDot){
                        sb.append(current);
                        hasDot= true;
                    }
                    else {
                        break;
                    }
                    i++;
                }

                addToken(sb.toString(), TokenType.CONSTANT, start, lineNumber);
            }

             else if (STRING_DELIMITERS.contains(c)) {
                addToken(String.valueOf(c), TokenType.STRING_DELIMITER, start, lineNumber);
                i++;
            }

            else if (ARITHMETIC_OPS.contains(c)) {
                addToken(String.valueOf(c), TokenType.ARITHMETIC_OPERATOR, start, lineNumber);
                i++;
            }

            else if (RELATIONAL_OPS.contains(c)) {
                addToken(String.valueOf(c), TokenType.RELATIONAL_OPERATOR, start, lineNumber);
                i++;
            }

            else if (LOGICAL_OPS.contains(c)) {
                addToken(String.valueOf(c), TokenType.LOGICAL_OPERATOR, start, lineNumber);
                i++;
            }

            else if (PUNCTUATION.contains(c)) {
                addToken(String.valueOf(c), TokenType.PUNCTUATION, start, lineNumber);
                i++;
            }

            else if (SPECIAL_SYMBOLS.contains(c)) {
                addToken(String.valueOf(c), TokenType.SPECIAL_SYMBOL, start, lineNumber);
                i++;
        }

            else {
                addToken(String.valueOf(c), TokenType.UNKNOWN, start, lineNumber);
                i++;
            }
        }
    }

    private void addToken(String lexeme, TokenType type, int pos, int line) {
        tokens.add(new Tokens(lexeme, type, pos, line));
    }
}