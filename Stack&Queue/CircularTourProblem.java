package StackQueue;

class PetrolPump {
    int petrol;
    int distance;
    
    public PetrolPump(int petrol, int distance) {
        this.petrol = petrol;
        this.distance = distance;
    }
}

class CircularTourProblem {
    
    public static int findStartingPoint(PetrolPump[] pumps) {
        int n = pumps.length;
        int start = 0;
        int end = 1;
        int currentPetrol = pumps[start].petrol - pumps[start].distance;
        
        while (end != start || currentPetrol < 0) {
            while (currentPetrol < 0 && start != end) {
                currentPetrol -= pumps[start].petrol - pumps[start].distance;
                start = (start + 1) % n;
                
                if (start == 0) {
                    return -1;
                }
            }
            
            currentPetrol += pumps[end].petrol - pumps[end].distance;
            end = (end + 1) % n;
        }
        
        return start;
    }
    
    public static void main(String[] args) {
        PetrolPump[] pumps = {
            new PetrolPump(6, 4),
            new PetrolPump(3, 6),
            new PetrolPump(7, 3)
        };
        
        int start = findStartingPoint(pumps);
        
        if (start == -1) {
            System.out.println("No solution exists");
        } else {
            System.out.println("Start the tour from petrol pump " + start);
        }
        
        System.out.println("Petrol pumps:");
        for (int i = 0; i < pumps.length; i++) {
            System.out.println("Pump " + i + ": Petrol=" + pumps[i].petrol + ", Distance=" + pumps[i].distance);
        }
    }
}