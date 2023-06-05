package basic.decimal;

import base.Calculable;
import base.Operator;

import java.math.BigDecimal;
import java.util.ArrayList;

public class DecimalMultiply implements Operator {
    @Override
    public Calculable op(ArrayList<Calculable> values) {
        BigDecimal temp = null;
        for(var value: values){
            if(!(value instanceof DecimalValue)){
                return null;
            }
            if(temp == null){
                temp = (BigDecimal) value.get();
                continue;
            }
            temp = temp.multiply((BigDecimal) value.get());
        }

        return new DecimalValue(temp);
    }
}
