package basic.decimal;

import base.Calculable;
import base.Operator;

import java.math.BigDecimal;
import java.util.ArrayList;

public class DecimalAdd implements Operator {
    @Override
    public Calculable op(ArrayList<Calculable> values) {
        BigDecimal temp = new BigDecimal(0);
        for(var value: values){
            if(!(value instanceof DecimalValue)){
                return null;
            }
            temp = temp.add((BigDecimal) value.get());
        }

        return new DecimalValue(temp);
    }
}
