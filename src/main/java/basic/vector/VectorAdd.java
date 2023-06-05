package basic.vector;

import base.Calculable;
import base.Operator;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;

public class VectorAdd implements Operator {
    @Override
    public Calculable op(ArrayList<Calculable> values) {
        HashMap<String, BigDecimal> tempVector = new HashMap<>();
        tempVector.put("x", new BigDecimal(0));
        tempVector.put("y", new BigDecimal(0));

        for(var value: values){
            if(!(value instanceof VectorValue)){
                return null;
            }
            @SuppressWarnings("unchecked")
            HashMap<String, BigDecimal> checkVector = (HashMap<String, BigDecimal>) value.get();
            if(checkVector.size() != tempVector.size()){
                return null;
            }
            if(checkVector.get("x") == null || checkVector.get("y") == null){
                return null;
            }
            tempVector.put("x", tempVector.get("x").add(checkVector.get("x")));
            tempVector.put("y", tempVector.get("y").add(checkVector.get("y")));
        }

        return new VectorValue(tempVector);
    }
}
