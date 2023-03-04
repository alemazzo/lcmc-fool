package svm;

public class ExecuteVM {

    public static final int CODESIZE = 10000;
    public static final int MEMSIZE = 10000;

    private final int[] code;
    private final int[] memory = new int[MEMSIZE];

    private int ip = 0;
    private int sp = MEMSIZE;

    private int hp = 0;
    private int fp = MEMSIZE;
    private int ra;
    private int tm;

    public ExecuteVM(int[] code) {
        this.code = code;
    }

    public void cpu() {
        while (true) {
            int bytecode = code[ip++]; // fetch
            int v1, v2;
            int address;
            switch (bytecode) {
                case SVMParser.PUSH -> push(code[ip++]);
                case SVMParser.POP -> pop();
                case SVMParser.ADD -> {
                    v1 = pop();
                    v2 = pop();
                    push(v2 + v1);
                }
                case SVMParser.MULT -> {
                    v1 = pop();
                    v2 = pop();
                    push(v2 * v1);
                }
                case SVMParser.DIV -> {
                    v1 = pop();
                    v2 = pop();
                    push(v2 / v1);
                }
                case SVMParser.SUB -> {
                    v1 = pop();
                    v2 = pop();
                    push(v2 - v1);
                }
                case SVMParser.STOREW -> {
                    address = pop();
                    memory[address] = pop();
                }
                case SVMParser.LOADW -> push(memory[pop()]);
                case SVMParser.BRANCH -> {
                    address = code[ip];
                    ip = address;
                }
                case SVMParser.BRANCHEQ -> {
                    address = code[ip++];
                    v1 = pop();
                    v2 = pop();
                    if (v2 == v1) ip = address;
                }
                case SVMParser.BRANCHLESSEQ -> {
                    address = code[ip++];
                    v1 = pop();
                    v2 = pop();
                    if (v2 <= v1) ip = address;
                }
                case SVMParser.JS -> {
                    address = pop();
                    ra = ip;
                    ip = address;
                }
                case SVMParser.STORERA -> ra = pop();
                case SVMParser.LOADRA -> push(ra);
                case SVMParser.STORETM -> tm = pop();
                case SVMParser.LOADTM -> push(tm);
                case SVMParser.LOADFP -> push(fp);
                case SVMParser.STOREFP -> fp = pop();
                case SVMParser.COPYFP -> fp = sp;
                case SVMParser.STOREHP -> hp = pop();
                case SVMParser.LOADHP -> push(hp);
                case SVMParser.PRINT -> System.out.println((sp < MEMSIZE) ? memory[sp] : "Empty stack!");
                case SVMParser.HALT -> {
                    return;
                }
            }
        }
    }

    private int pop() {
        return memory[sp++];
    }

    private void push(int v) {
        memory[--sp] = v;
    }

}