package Generics;

import java.util.ArrayList;
import java.util.List;

abstract class JobRole {
    private String title;
    private List<String> requiredSkills;
    
    public JobRole(String title, List<String> requiredSkills) {
        this.title = title;
        this.requiredSkills = requiredSkills;
    }
    
    public String getTitle() { return title; }
    public List<String> getRequiredSkills() { return requiredSkills; }
    
    public abstract int getMinimumYearsExperience();
}

class SoftwareEngineer extends JobRole {
    public SoftwareEngineer() {
        super("Software Engineer", List.of("Java", "Python", "SQL", "Git"));
    }
    
    @Override
    public int getMinimumYearsExperience() {
        return 2;
    }
}

class DataScientist extends JobRole {
    public DataScientist() {
        super("Data Scientist", List.of("Python", "R", "Machine Learning", "Statistics"));
    }
    
    @Override
    public int getMinimumYearsExperience() {
        return 3;
    }
}

class ProductManager extends JobRole {
    public ProductManager() {
        super("Product Manager", List.of("Agile", "Product Development", "User Research", "Roadmapping"));
    }
    
    @Override
    public int getMinimumYearsExperience() {
        return 4;
    }
}

class Resume<T extends JobRole> {
    private String candidateName;
    private List<String> skills;
    private int yearsOfExperience;
    private T targetRole;
    
    public Resume(String candidateName, List<String> skills, int yearsOfExperience, T targetRole) {
        this.candidateName = candidateName;
        this.skills = skills;
        this.yearsOfExperience = yearsOfExperience;
        this.targetRole = targetRole;
    }
    
    public String getCandidateName() { return candidateName; }
    public List<String> getSkills() { return skills; }
    public int getYearsOfExperience() { return yearsOfExperience; }
    public T getTargetRole() { return targetRole; }
    
    @Override
    public String toString() {
        return "Resume [candidate=" + candidateName + ", role=" + targetRole.getTitle() + 
               ", experience=" + yearsOfExperience + " years, skills=" + skills + "]";
    }
}

class AIScreener {
    public static <T extends JobRole> boolean isQualified(Resume<T> resume) {
        T role = resume.getTargetRole();
        List<String> requiredSkills = role.getRequiredSkills();
        int minimumExperience = role.getMinimumYearsExperience();
        
        boolean hasRequiredExperience = resume.getYearsOfExperience() >= minimumExperience;
        
        int matchedSkills = 0;
        for (String skill : requiredSkills) {
            if (resume.getSkills().contains(skill)) {
                matchedSkills++;
            }
        }
        
        double skillMatchPercentage = (double) matchedSkills / requiredSkills.size();
        return hasRequiredExperience && skillMatchPercentage >= 0.7;
    }
    
    public static void screenResumes(List<? extends Resume<?>> resumes) {
        System.out.println("Screening Results:");
        for (Resume<?> resume : resumes) {
            boolean qualified = isQualified(resume);
            System.out.println(resume.getCandidateName() + " for " + 
                               resume.getTargetRole().getTitle() + ": " + 
                               (qualified ? "Qualified" : "Not Qualified"));
        }
    }
}

public class ResumeScreeningSystem {
    public static void main(String[] args) {
        List<Resume<?>> resumes = new ArrayList<>();
        
        Resume<SoftwareEngineer> resume1 = new Resume<>(
            "John Doe", 
            List.of("Java", "Python", "SQL", "JavaScript", "Git"), 
            3, 
            new SoftwareEngineer()
        );
        
        Resume<DataScientist> resume2 = new Resume<>(
            "Jane Smith", 
            List.of("Python", "R", "SQL", "Statistics"), 
            2, 
            new DataScientist()
        );
        
        Resume<ProductManager> resume3 = new Resume<>(
            "Bob Johnson", 
            List.of("Agile", "Product Development", "User Research", "Communication"), 
            5, 
            new ProductManager()
        );
        
        resumes.add(resume1);
        resumes.add(resume2);
        resumes.add(resume3);
        
        AIScreener.screenResumes(resumes);
    }
}