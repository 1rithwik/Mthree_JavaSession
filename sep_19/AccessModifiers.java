package sep_19;

public class AccessModifiers {
    public String name;
    protected String branch;
    private String secret;

    public AccessModifiers(String name, String branch, String secret) {
        this.name = name;
        this.branch = branch;
        this.secret = secret;
    }

    public void displayName() { // Public method
        System.out.println("Name: " + name);
    }

    protected void displayBranch() { // Protected method
        System.out.println("Branch: " + branch);
    }

    void displayDefault() { // Default (package-private) method
        System.out.println("Default method: Accessed within the same package.");
    }

    private void displaySecret() { // Private method
        System.out.println("Secret: " + secret);
    }

    public static void main(String[] args) {
        AccessModifiers a = new AccessModifiers("rithwik", "CSE", "treasure");
        a.displaySecret(); // private method
        a.displayBranch(); // protected method
        a.displayDefault(); // default method
        a.displayName(); // public method
    }
}
