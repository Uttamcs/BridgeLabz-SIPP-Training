public class Circle {
    double radius;
    
    public Circle(double radius) {
        this.radius = radius;
    }
    
    public double calculateArea() {
        return 3.14159 * radius * radius;
    }
    
    public double calculateCircumference() {
        return 2 * 3.14159 * radius;
    }
    
    public void displayDetails() {
        System.out.println("Radius: " + radius);
        System.out.println("Area: " + calculateArea());
        System.out.println("Circumference: " + calculateCircumference());
    }
    
    public static void main(String[] args) {
        Circle c1 = new Circle(5.0);
        Circle c2 = new Circle(10.0);
        
        c1.displayDetails();
        System.out.println();
        c2.displayDetails();
    }
}