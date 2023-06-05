package basic.decimal;

import base.Calculable;

import java.math.BigDecimal;

public class DecimalValue implements Calculable {
    private BigDecimal value;

    public DecimalValue(BigDecimal value) {
        this.value = value;
    }

    @Override
    public Object get() {
        return value;
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
