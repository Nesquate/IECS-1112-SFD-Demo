package basic.vector;

import base.Calculable;

import java.math.BigDecimal;
import java.util.HashMap;

public class VectorValue implements Calculable {
    private HashMap<String, BigDecimal> vector;

    public VectorValue(HashMap<String, BigDecimal> vector) {
        this.vector = vector;
    }

    @Override
    public Object get() {
        return vector;
    }

    @Override
    public String toString() {
        return vector.get("x").toString() + "," + vector.get("y").toString();
    }
}
