package main.sep_18;

public class Operations {

    private static void demonstrateBasicLogicalOperations() {
        boolean t = true;
        boolean f = false;

        System.out.println("1. Basic Logical Operations:");
        System.out.println("   AND: true && true = " + (t && t));
        System.out.println("   AND: true && false = " + (t && f));
        System.out.println("   AND: false && true = " + (f && t));
        System.out.println("   AND: false && false = " + (f && f));
        System.out.println("   OR: true || true = " + (t || t));
        System.out.println("   OR: true || false = " + (t || f));
        System.out.println("   OR: false || true = " + (f || t));
        System.out.println("   OR: false || false = " + (f || f));
        System.out.println("   NOT: !true = " + (!t));
        System.out.println("   NOT: !false = " + (!f));
    }

    private static void demonstrateShortCircuitEvaluation() {
        boolean f = false;
        boolean t = true;
        System.out.println("\n2. Short-circuit Evaluation:");
        System.out.println("   false && (1/0 > 0) = " + (f && (1 / 0 > 0))); // as the first condition is false then the
                                                                             // second condition will not be evaluated
        System.out.println("   true || (1/0 > 0) = " + (t || (1 / 0 > 0))); // as the first condition is true then the
                                                                            // second condition will not be evaluated
    }

    private static void demonstrateOperatorPrecedence() {
        boolean t = true;
        boolean f = false;

        System.out.println("\n3. Operator Precedence:");
        System.out.println("   true || false && false = " + (true || false && false)); // && has higher precedence
        System.out.println("   (true || false) && false = " + ((t || f) && f)); // Parentheses change precedence
    }

    private static void demonstrateCombiningWithComparisonOperators() {
        int x = 5, y = 10;
        System.out.println("\n4. Combining with Comparison Operators:");
        System.out.println("   (x < y) && (y > 0) = " + ((x < y) && (y > 0)));
        System.out.println("   (x > y) || (y < 20) = " + ((x > y) || (y < 20)));
    }

    private static void demonstrateComplexConditions() {
        boolean a = true, b = false, c = true;
        System.out.println("\n5. Complex Conditions:");
        System.out.println("   (a && b) || (a && c) = " + ((a && b) || (a && c)));
        System.out.println("   a && (b || c) = " + (a && (b || c)));
        System.out.println("   !a || (b && !c) = " + (!a || (b && !c)));
    }

    private static void demonstrateBitwiseVsLogicalOperators() {
        boolean t = true;
        boolean f = false;

        System.out.println("\n6. Bitwise vs. Logical Operators:");
        System.out.println("   true & false = " + (t & f)); // Bitwise AND
        System.out.println("   true | false = " + (t | f)); // Bitwise OR
        System.out.println("   true ^ false = " + (t ^ f)); // Bitwise XOR
    }

    private static void demonstrateShortCircuitVsNonShortCircuit() {
        boolean f = false;
        System.out.println("\n7. Short-circuit vs. Non-short-circuit:");
        int i = 0;
        boolean result1 = (f && (++i > 0)); // i is not incremented
        boolean result2 = (f & (++i > 0)); // i is incremented
        System.out.println("   Short-circuit AND result: " + result1 + ", i = " + i);
        System.out.println("   Non-short-circuit AND result: " + result2 + ", i = " + i);
    }

    private static void demonstrateLogicalOperatorsWithNonBooleanOperands() {
        System.out.println("\n8. Logical Operators with Non-boolean Operands:");
        System.out.println("   (1 < 2) && (3 < 4) = " + ((1 < 2) && (3 < 4)));
        System.out.println("   ('a' < 'b') || ('c' > 'd') = " + (('a' < 'b') || ('c' > 'd')));
    }

    private static void demonstrateLogicalOperatorsInControlStructures() {
        boolean t = true;
        boolean f = false;

        System.out.println("\n9. Logical Operators in Control Structures:");
        if (t && !f) {
            System.out.println("   This will be printed.");
        }

        int j = 0;
        while (j < 3 && t) {
            System.out.println("   j = " + j);
            j++;
        }
    }

    private static void demonstrateLogicalOperatorsWithNullChecks() {
        System.out.println("\n11. Logical Operators with Null Checks:");
        String str = null;
        System.out.println("   (str != null) && (str.length() > 0) = " + ((str != null) && (str.length() > 0))); // Safe
    }

    private static void conditionalOperator() {
        System.out.println("\n12. Conditional Operator:");
        int a = 5, b = 10;
        int max = (a > b) ? a : b;
        System.out.println("   The maximum of " + a + " and " + b + " is " + max);
    }

    private static void instanceofOperator() {
        System.out.println("\n13. Instanceof Operator:");
        String str = "Hello";
        System.out.println("   str instanceof String = " + (str instanceof String));
    }

    public static void main(String[] args) {
        demonstrateBasicLogicalOperations();
        demonstrateShortCircuitEvaluation();
        demonstrateOperatorPrecedence();
        demonstrateCombiningWithComparisonOperators();
        demonstrateComplexConditions();
        demonstrateBitwiseVsLogicalOperators();
        demonstrateShortCircuitVsNonShortCircuit();
        demonstrateLogicalOperatorsWithNonBooleanOperands();
        demonstrateLogicalOperatorsInControlStructures();
        demonstrateLogicalOperatorsWithNullChecks();
        conditionalOperator();
        instanceofOperator();
        Operations obj1 = new Operations();
        Operations obj2 = null;
        System.out.println("obj1 instanceof Operator: " + (obj1 instanceof Operations));
        System.out.println("obj2 instanceof Operator: " + (obj2 instanceof Operations));
    }
}
