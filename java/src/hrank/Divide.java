package hrank;
public class Divide implements Operable {
    @Override
    public long operate(long lhs, long rhs) {
        return rhs / lhs;
    }
}
