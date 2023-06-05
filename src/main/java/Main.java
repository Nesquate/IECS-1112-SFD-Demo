import base.Calculable;
import base.Calculator;
import basic.decimal.DecimalAdd;
import basic.decimal.DecimalMultiply;
import basic.decimal.DecimalValue;
import basic.vector.VectorAdd;
import basic.vector.VectorValue;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        demoForDecimal();
        demoForVector();
    }

    private static void demoForDecimal(){
        // Testing
        DecimalValue decimal1 = new DecimalValue(new BigDecimal("123"));
        DecimalValue decimal2 = new DecimalValue(new BigDecimal("2"));

        ArrayList<Calculable> decimalValueArrayList = new ArrayList<>();
        decimalValueArrayList.add(decimal1);
        decimalValueArrayList.add(decimal2);

        Calculator decimalCal1 = new Calculator(new DecimalAdd(), decimalValueArrayList);
        Calculator decimalCal2 = new Calculator(new DecimalMultiply(), decimalValueArrayList);
        Calculator decimalCal3 = new Calculator(new DecimalMultiply(), decimalCal1, decimalValueArrayList);

        showResult(decimalCal1.start());
        showResult(decimalCal2.start());
        showResult(decimalCal3.start());
    }

    private static void demoForVector(){
        HashMap<String, BigDecimal> vector1 = new HashMap<>();
        vector1.put("x", new BigDecimal(1));
        vector1.put("y", new BigDecimal(2));
        VectorValue vector1Wrap = new VectorValue(vector1);

        HashMap<String, BigDecimal> vector2 = new HashMap<>();
        vector2.put("x", new BigDecimal(1));
        vector2.put("y", new BigDecimal(2));
        VectorValue vector2Wrap = new VectorValue(vector2);

        ArrayList<Calculable> vectors = new ArrayList<>();
        vectors.add(vector1Wrap);
        vectors.add(vector2Wrap);

        Calculator calculator = new Calculator(new VectorAdd(), vectors);
        Calculable result = calculator.start();

        showResult(result);
    }

    private static void showResult(Calculable result){
        if(result != null){
            System.out.printf("Result: %s%n", result);
        } else {
            System.out.println("Result is null");
        }
    }
}
