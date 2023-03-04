package compiler;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class BasicLexerParserTest {

    private final String fileName = "test/prova.fool";
    private FOOLLexer lexer;
    private FOOLParser parser;


    @BeforeEach
    void setUp() throws Exception {
        final CharStream chars = CharStreams.fromFileName(fileName);
        lexer = new FOOLLexer(chars);
        final CommonTokenStream tokens = new CommonTokenStream(lexer);
        parser = new FOOLParser(tokens);
    }


    @Test
    void testZeroLexicalErrors() {
        parser.prog();
        assertEquals(0, lexer.lexicalErrors);
    }

    @Test
    void testZeroSyntaxErrors() {
        parser.prog();
        assertEquals(0, parser.getNumberOfSyntaxErrors());
    }

}
