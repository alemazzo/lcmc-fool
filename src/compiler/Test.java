package compiler;

import compiler.lib.FOOL;
import compiler.lib.exc.IncompleteException;
import compiler.lib.exc.TypeException;
import compiler.lib.node.Node;
import compiler.lib.node.TypeNode;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import svm.ExecuteVM;
import svm.SVMLexer;
import svm.SVMParser;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class Test {
    public static void main(String[] args) throws Exception {

        String fileName = "test/quicksort.fool";

        CharStream chars = CharStreams.fromFileName(fileName);
        FOOLLexer lexer = new FOOLLexer(chars);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        FOOLParser parser = new FOOLParser(tokens);

        System.out.println("Generating ST via lexer and parser.");
        ParseTree st = parser.prog();
        System.out.println("You had " + lexer.lexicalErrors + " lexical errors and " +
                parser.getNumberOfSyntaxErrors() + " syntax errors.\n");

        System.out.println("Generating AST.");
        ASTGenerationSTVisitor visitor = new ASTGenerationSTVisitor(); // use true to visualize the ST
        Node ast = visitor.visit(st);
        System.out.println();

        System.out.println("Enriching AST via symbol table.");
        SymbolTableASTVisitor symtableVisitor = new SymbolTableASTVisitor();
        symtableVisitor.visit(ast);
        System.out.println("You had " + symtableVisitor.symbolTableErrors + " symbol table errors.\n");

        System.out.println("Visualizing Enriched AST.");
        new PrintEASTVisitor().visit(ast);
        System.out.println();

        System.out.println("Checking Types.");
        try {
            TypeCheckEASTVisitor typeCheckVisitor = new TypeCheckEASTVisitor();
            TypeNode mainType = typeCheckVisitor.visit(ast);
            System.out.print("Type of main program expression is: ");
            new PrintEASTVisitor().visit(mainType);
        } catch (IncompleteException e) {
            System.out.println("Could not determine main program expression type due to errors detected before type checking.");
        } catch (TypeException e) {
            System.out.println("Type checking error in main program expression: " + e.text);
        }
        System.out.println("You had " + FOOL.typeErrors + " type checking errors.\n");

        int frontEndErrors = lexer.lexicalErrors + parser.getNumberOfSyntaxErrors() + symtableVisitor.symbolTableErrors + FOOL.typeErrors;
        System.out.println("You had a total of " + frontEndErrors + " front-end errors.\n");

        if (frontEndErrors > 0) System.exit(1);

        System.out.println("Generating code.");
        String code = new CodeGenerationASTVisitor().visit(ast);
        BufferedWriter out = new BufferedWriter(new FileWriter(fileName + ".asm"));
        out.write(code);
        out.close();
        System.out.println();

        System.out.println("Assembling generated code.");
        CharStream charsASM = CharStreams.fromFileName(fileName + ".asm");
        SVMLexer lexerASM = new SVMLexer(charsASM);
        CommonTokenStream tokensASM = new CommonTokenStream(lexerASM);
        SVMParser parserASM = new SVMParser(tokensASM);

        parserASM.assembly();

        // needed only for debug
        System.out.println("You had: " + lexerASM.lexicalErrors + " lexical errors and " + parserASM.getNumberOfSyntaxErrors() + " syntax errors.\n");
        if (lexerASM.lexicalErrors + parserASM.getNumberOfSyntaxErrors() > 0) System.exit(1);

        System.out.println("Running generated code via Stack Virtual Machine.");
        ExecuteVM vm = new ExecuteVM(parserASM.code);
        vm.cpu();

    }
}

