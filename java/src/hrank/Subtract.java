package hrank;
public class Subtract implements Operable{
    @Override
    public long operate(long lhs, long rhs) {
        return rhs - lhs;
    }
}
