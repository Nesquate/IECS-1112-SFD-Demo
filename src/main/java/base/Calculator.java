package base;

import java.util.ArrayList;

public final class Calculator {
    private Operator op;
    private Calculator cal;
    private ArrayList<Calculable> values;

    public Calculator(Operator op, ArrayList<Calculable> values) {
        this.op = op;
        this.values = values;
    }

    public Calculator(Operator op, Calculator cal, ArrayList<Calculable> values) {
        this(op, values);
        this.cal = cal;
    }

    public Calculable start() {
        switch (check()) {
            case CAL_AND_VALUES -> {
                return cal();
            }
            case VALUES_ONLY -> {
                return op();
            }
            default -> {
                return null;
            }
        }
    }

    private Calculable op() {
        return op.op(values);
    }

    private Calculable cal() {
        Calculable tempResult = cal.start();
        values.add(tempResult);
        return op();
    }

    private State check() {
        if (values != null && cal != null) {
            return State.CAL_AND_VALUES;
        } else if (values != null) {
            return State.VALUES_ONLY;
        } else {
            return State.FAIL_CHECK;
        }
    }
}
