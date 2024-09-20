
import sep_19.AccessModifiers;

public class OtherPackageExample extends AccessModifiers {
    public OtherPackageExample(String name, String branch, String secret) {
        super(name, branch, secret);
    }

    public void displayAll() {
        displayName();
        displayBranch();
        // displayDefault(); // This line would cause a compile error (default method)
        // displaySecret(); // This line would cause a compile error (private method)
    }

    public static void main(String[] args) {
        OtherPackageExample obj = new OtherPackageExample("John", "CSE", "treasure");
        obj.displayAll();
    }
}
