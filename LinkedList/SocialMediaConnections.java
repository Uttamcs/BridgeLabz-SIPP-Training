package LinkedList;

class Friend {
    int friendId;
    Friend next;

    public Friend(int friendId) {
        this.friendId = friendId;
        this.next = null;
    }
}

class User {
    int userId;
    String name;
    int age;
    Friend friendsHead;
    User next;

    public User(int userId, String name, int age) {
        this.userId = userId;
        this.name = name;
        this.age = age;
        this.friendsHead = null;
        this.next = null;
    }
}

class SocialMediaConnections {
    private User head;

    public void addUser(int userId, String name, int age) {
        User newUser = new User(userId, name, age);
        if (head == null) {
            head = newUser;
        } else {
            User current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newUser;
        }
    }

    public void addFriendConnection(int userId1, int userId2) {
        User user1 = findUser(userId1);
        User user2 = findUser(userId2);
        if (user1 != null && user2 != null) {
            addFriendToUser(user1, userId2);
            addFriendToUser(user2, userId1);
        }
    }

    private void addFriendToUser(User user, int friendId) {
        Friend newFriend = new Friend(friendId);
        if (user.friendsHead == null) {
            user.friendsHead = newFriend;
        } else {
            Friend current = user.friendsHead;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newFriend;
        }
    }

    public void removeFriendConnection(int userId1, int userId2) {
        User user1 = findUser(userId1);
        User user2 = findUser(userId2);
        if (user1 != null && user2 != null) {
            removeFriendFromUser(user1, userId2);
            removeFriendFromUser(user2, userId1);
        }
    }

    private void removeFriendFromUser(User user, int friendId) {
        if (user.friendsHead == null) return;
        if (user.friendsHead.friendId == friendId) {
            user.friendsHead = user.friendsHead.next;
            return;
        }
        Friend current = user.friendsHead;
        while (current.next != null && current.next.friendId != friendId) {
            current = current.next;
        }
        if (current.next != null) {
            current.next = current.next.next;
        }
    }

    public void findMutualFriends(int userId1, int userId2) {
        User user1 = findUser(userId1);
        User user2 = findUser(userId2);
        if (user1 == null || user2 == null) return;

        System.out.print("Mutual friends between " + user1.name + " and " + user2.name + ": ");
        Friend friend1 = user1.friendsHead;
        while (friend1 != null) {
            Friend friend2 = user2.friendsHead;
            while (friend2 != null) {
                if (friend1.friendId == friend2.friendId) {
                    User mutualFriend = findUser(friend1.friendId);
                    if (mutualFriend != null) {
                        System.out.print(mutualFriend.name + " ");
                    }
                }
                friend2 = friend2.next;
            }
            friend1 = friend1.next;
        }
        System.out.println();
    }

    public void displayUserFriends(int userId) {
        User user = findUser(userId);
        if (user == null) return;
        
        System.out.print(user.name + "'s friends: ");
        Friend current = user.friendsHead;
        while (current != null) {
            User friend = findUser(current.friendId);
            if (friend != null) {
                System.out.print(friend.name + " ");
            }
            current = current.next;
        }
        System.out.println();
    }

    public int countFriends(int userId) {
        User user = findUser(userId);
        if (user == null) return 0;
        
        int count = 0;
        Friend current = user.friendsHead;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    private User findUser(int userId) {
        User current = head;
        while (current != null) {
            if (current.userId == userId) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public static void main(String[] args) {
        SocialMediaConnections social = new SocialMediaConnections();
        
        social.addUser(1, "Alice", 25);
        social.addUser(2, "Bob", 30);
        social.addUser(3, "Charlie", 28);
        social.addUser(4, "Diana", 26);
        
        social.addFriendConnection(1, 2);
        social.addFriendConnection(1, 3);
        social.addFriendConnection(2, 3);
        social.addFriendConnection(2, 4);
        
        social.displayUserFriends(1);
        social.displayUserFriends(2);
        
        System.out.println("Alice has " + social.countFriends(1) + " friends");
        
        social.findMutualFriends(1, 2);
    }
}