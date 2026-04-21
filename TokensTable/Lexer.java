package TokensTable.TokensTable;
import javax.swing.JFrame;
import javax.swing.JTable;
import java.util.*;

public class Lexer{

    private List<Tokens> tokens;
    private static final Set <String> KEYWORDS = Set.of(
        "if", "else", "while", "for", "int", "float", "return"
    );

    private static final Set<Character> ARITHMETIC_OPS = Set.of(
        '+', '-', '*', '/'
    );

    private static final Set<Character> RELATIONAL_OPS = Set.of(
        '>', '<', '='
    );
    private static final Set<Character> PUNCTUATION = Set.of(
        ';', ',', '(', ')', '{', '}'
    );

    public Lexer(){
        tokens = new ArrayList<>();

    }

    public List <Tokens> analyze(String input){
        tokens.clear();

        String[] lines = input.split("\n");

        for(int lineNum = 0; lineNum < lines.length; lineNum ++){
            analyzeLine(lines [lineNum], lineNum + 1);

        }
        return tokens;
    } 

    private void analyzeLine(String line, int lineNumber){
        int i = 0;

        while (i < line.length()){
            char c = line.charAt(i);

            // condition to skip spaces
            if (Character.isWhiteSpace(c)){
                i ++; 
                continue;
            }

            int start = i;
            
        }
    }
}
