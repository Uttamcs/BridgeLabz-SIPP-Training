package Generics;

import java.util.ArrayList;
import java.util.List;

interface MealPlan {
    String getDietType();
    boolean isValidForAllergies(List<String> allergies);
}

class VegetarianMeal implements MealPlan {
    public String getDietType() {
        return "Vegetarian";
    }
    
    public boolean isValidForAllergies(List<String> allergies) {
        return !allergies.contains("soy") && !allergies.contains("dairy");
    }
}

class VeganMeal implements MealPlan {
    public String getDietType() {
        return "Vegan";
    }
    
    public boolean isValidForAllergies(List<String> allergies) {
        return !allergies.contains("soy") && !allergies.contains("nuts");
    }
}

class KetoMeal implements MealPlan {
    public String getDietType() {
        return "Keto";
    }
    
    public boolean isValidForAllergies(List<String> allergies) {
        return !allergies.contains("dairy") && !allergies.contains("eggs");
    }
}

class HighProteinMeal implements MealPlan {
    public String getDietType() {
        return "High-Protein";
    }
    
    public boolean isValidForAllergies(List<String> allergies) {
        return !allergies.contains("eggs") && !allergies.contains("fish");
    }
}

class Meal<T extends MealPlan> {
    private String name;
    private List<String> ingredients;
    private T mealPlan;
    
    public Meal(String name, List<String> ingredients, T mealPlan) {
        this.name = name;
        this.ingredients = ingredients;
        this.mealPlan = mealPlan;
    }
    
    public String getName() { return name; }
    public List<String> getIngredients() { return ingredients; }
    public T getMealPlan() { return mealPlan; }
    
    public String toString() {
        return "Meal [name=" + name + ", diet=" + mealPlan.getDietType() + 
               ", ingredients=" + ingredients + "]";
    }
}

class MealPlanner {
    public static <T extends MealPlan> boolean validateMeal(Meal<T> meal, List<String> allergies) {
        return meal.getMealPlan().isValidForAllergies(allergies);
    }
    
    public static <T extends MealPlan> List<Meal<T>> generatePersonalizedPlan(
            List<Meal<T>> availableMeals, List<String> allergies) {
        List<Meal<T>> personalizedPlan = new ArrayList<>();
        
        for (Meal<T> meal : availableMeals) {
            if (validateMeal(meal, allergies)) {
                personalizedPlan.add(meal);
            }
        }
        
        return personalizedPlan;
    }
}

public class MealPlanGenerator {
    public static void main(String[] args) {
        List<String> userAllergies = List.of("fish");
        
        List<Meal<VegetarianMeal>> vegetarianMeals = new ArrayList<>();
        vegetarianMeals.add(new Meal<>("Vegetable Curry", 
                List.of("rice", "vegetables", "curry sauce"), new VegetarianMeal()));
        vegetarianMeals.add(new Meal<>("Cheese Pasta", 
                List.of("pasta", "cheese", "tomato sauce"), new VegetarianMeal()));
        
        List<Meal<KetoMeal>> ketoMeals = new ArrayList<>();
        ketoMeals.add(new Meal<>("Keto Breakfast", 
                List.of("eggs", "avocado", "bacon"), new KetoMeal()));
        ketoMeals.add(new Meal<>("Keto Lunch", 
                List.of("chicken", "cheese", "spinach"), new KetoMeal()));
        
        System.out.println("Personalized Vegetarian Meal Plan:");
        List<Meal<VegetarianMeal>> personalizedVegetarianPlan = 
                MealPlanner.generatePersonalizedPlan(vegetarianMeals, userAllergies);
        for (Meal<VegetarianMeal> meal : personalizedVegetarianPlan) {
            System.out.println(meal);
        }
        
        System.out.println("\nPersonalized Keto Meal Plan:");
        List<Meal<KetoMeal>> personalizedKetoPlan = 
                MealPlanner.generatePersonalizedPlan(ketoMeals, userAllergies);
        for (Meal<KetoMeal> meal : personalizedKetoPlan) {
            System.out.println(meal);
        }
    }
}