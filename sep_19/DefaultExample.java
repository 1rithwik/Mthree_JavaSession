package sep_19;

public class DefaultExample {
    public void show() {
        AccessModifiers d = new AccessModifiers("rithwik", "CSE", "treasure");
        d.displayDefault();
        d.displayName();
        d.displayBranch();
        // main.displaySecret(); // This line would cause a compile error (private
        // method)
    }

    public static void main(String[] args) {
        DefaultExample d = new DefaultExample();
        d.show();
    }
}
