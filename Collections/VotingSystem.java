package Collections;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class VotingSystem {
    private Map<String, Integer> votes = new HashMap<>();
    private Map<String, Integer> votesInOrder = new LinkedHashMap<>();
    
    public void castVote(String candidate) {
        // Update in HashMap
        votes.put(candidate, votes.getOrDefault(candidate, 0) + 1);
        
        // Update in LinkedHashMap
        votesInOrder.put(candidate, votesInOrder.getOrDefault(candidate, 0) + 1);
    }
    
    public Map<String, Integer> getResults() {
        return votes;
    }
    
    public Map<String, Integer> getResultsInVotingOrder() {
        return votesInOrder;
    }
    
    public Map<String, Integer> getSortedResults() {
        TreeMap<String, Integer> sortedVotes = new TreeMap<>(votes);
        return sortedVotes;
    }
    
    public Map<Integer, String> getResultsSortedByVoteCount() {
        Map<Integer, String> voteCountMap = new TreeMap<>((a, b) -> b - a);
        
        for (Map.Entry<String, Integer> entry : votes.entrySet()) {
            voteCountMap.put(entry.getValue(), entry.getKey());
        }
        
        return voteCountMap;
    }
    
    public static void main(String[] args) {
        VotingSystem votingSystem = new VotingSystem();
        
        votingSystem.castVote("Candidate A");
        votingSystem.castVote("Candidate B");
        votingSystem.castVote("Candidate A");
        votingSystem.castVote("Candidate C");
        votingSystem.castVote("Candidate B");
        votingSystem.castVote("Candidate A");
        
        System.out.println("Voting Results:");
        System.out.println(votingSystem.getResults());
        
        System.out.println("\nResults in Voting Order:");
        System.out.println(votingSystem.getResultsInVotingOrder());
        
        System.out.println("\nResults Sorted by Candidate Name:");
        System.out.println(votingSystem.getSortedResults());
        
        System.out.println("\nResults Sorted by Vote Count (Descending):");
        System.out.println(votingSystem.getResultsSortedByVoteCount());
    }
}