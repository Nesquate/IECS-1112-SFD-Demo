package base;

import java.util.ArrayList;

public interface Operator {
    Calculable op(ArrayList<Calculable> values);
    String toString();
}
