package hrank;
import java.util.HashMap;
import java.util.Stack;
import java.util.regex.Pattern;

public class ReversePolishNotationCalculator {
    HashMap<String, Operable> operators = new HashMap<String, Operable>();
    String[] tokens;
    private Stack<Long> stack = new Stack<Long>();

    ReversePolishNotationCalculator() {
        initPrimitiveOperations();
    }

    private void initPrimitiveOperations() {
        register("+", new Add());
        register("-", new Subtract());
        register("*", new Multiply());
        register("/", new Divide());
    }

    public void register(String operator, Operable o) {
        operators.put(operator, o);
    }

    public long eval(String s) {
        tokens = s.split(" ");
        for (int i=0; i<tokens.length; i++) {
            if (Pattern.compile("\\d").matcher(tokens[i]).matches()) {
                stack.push(Long.parseLong(tokens[i]));
            } else {
                Operable o = operators.get(tokens[i]);
                if (o != null) {
                    stack.push(o.operate(stack.pop(), stack.pop()));
                }
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        ReversePolishNotationCalculator rpn = new ReversePolishNotationCalculator();
        System.out.println(rpn.eval("5 4 + 8 - 6 * 3 /"));
    }
}
