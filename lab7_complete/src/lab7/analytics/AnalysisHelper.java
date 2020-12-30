/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab7.analytics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lab7.entities.Comment;
import lab7.entities.User;
import lab7.entities.Post;
/**
 *
 * @author harshalneelkamal
 */
public class AnalysisHelper {
    // find user with Most Likes
    //  key: UserId ; Value: sum of likes from all comments
    public void userWithMostLikes() {
        Map<Integer, Integer> userLikesCount = new HashMap<>();
        Map<Integer, User> users = DataStore.getInstance().getUsers();
    
        for (User user : users.values()) {
            for (Comment c : user.getComments()) {
                int likes = 0;
                if (userLikesCount.containsKey(user.getId())) {
                    likes = userLikesCount.get(user.getId());
                }
                likes += c.getLikes();
                userLikesCount.put(user.getId(), likes);
            }
        }
        int max = 0;
        int maxId = 0;
        for (int id : userLikesCount.keySet()) {
            if (userLikesCount.get(id) > max) {
                max = userLikesCount.get(id);
                maxId = id;
            }
        }
        System.out.println("User with most likes: " + max + "\n" 
            + users.get(maxId));
    }
    
    // find 5 comments which have the most likes
    public void getFiveMostLikedComment() {
        Map<Integer, Comment> comments = DataStore.getInstance().getComments();
        List<Comment> commentList = new ArrayList<>(comments.values());
        
        Collections.sort(commentList, new Comparator<Comment>() {
            @Override 
            public int compare(Comment o1, Comment o2) {
                return o2.getLikes() - o1.getLikes();
            }
        });
        
        System.out.println("5 most likes comments: ");
        for (int i = 0; i < commentList.size() && i < 5; i++) {
            System.out.println(commentList.get(i));
        }
    }
    
    //1
    public void findAverageLikesPerComment()
    {
        int sum=0;
        Map<Integer,Comment> comments=DataStore.getInstance().getComments();
        List<Comment> commentList=new ArrayList<>(comments.values());
        
        for(Comment c:commentList)
        {
            int likes=c.getLikes();
            sum+=likes;
        }
        double aver=sum/(double)commentList.size();
        System.out.println("Average number of likes per comment: "+aver);
    }
    
    //2
    public void getPostWithMostLikes()
    {
        Map<Integer, Post> posts=DataStore.getInstance().getPosts();
        
        int max=0;
        int maxPostID=0;
        for(Post p:posts.values())
        {
            int likes=0;
            for(Comment c:p.getComments())
            {
                likes+=c.getLikes();
            }
            if(likes>max)
            {
                max=likes;
                maxPostID=p.getPostId();
            }
        }
        System.out.println("Post with most liked comments: "+max+" likes\n   "+posts.get(maxPostID));
    }
    //3
    public void getPostWithMostComments()
    {
        Map<Integer, Post> posts=DataStore.getInstance().getPosts();
        int max=0;
        int maxPostID=0;
        for(Post p:posts.values())
        {
            int commentNum=p.getComments().size();
            if(commentNum>max)
            {
                max=commentNum;
                maxPostID=p.getPostId();
            }
        }
        System.out.println("Post with most comments: "+max+" comments\n   "+posts.get(maxPostID));
    }
//4 
    public void getFiveMostInactiveUserByPostsCount()
    {
        Map<Integer, User> users = DataStore.getInstance().getUsers();

        List<User> userList=new ArrayList<User>(users.values());
        
        Collections.sort(userList, new Comparator<User>() {
            @Override 
            public int compare(User u1, User u2) {
                return u1.getPosts().size()-u2.getPosts().size();
            }
        });
        
        System.out.println("Top 5 inactive users based on total posts number: ");
        for (int i = 0; i < userList.size() && i < 5; i++) {
            System.out.println("   Top "+i+":Post number:"+userList.get(i).getPosts().size()+" "+userList.get(i));
        }
    }
    
   //5
    public void getFiveMostInactiveUserByCommentsCreated()
    {
        Map<Integer, User> users = DataStore.getInstance().getUsers();
 
        List<User> userList=new ArrayList<User>(users.values());
        
        Collections.sort(userList, new Comparator<User>() {
            @Override 
            public int compare(User u1, User u2) {
                return u1.getComments().size()-u2.getComments().size();
            }
        });
        
        System.out.println("Top 5 inactive users based on total comments they created: ");
        for (int i = 0; i < userList.size() && i < 5; i++) {
            System.out.println("   Top "+i+":comment number:"+userList.get(i).getComments().size()+" "+userList.get(i));
        }
    } 
    //6
    public void getFiveMostInactiveUserOverall()
    {
        Map<Integer, User> users = DataStore.getInstance().getUsers();
        List<User> userList=new ArrayList<User>(users.values());
        
        Collections.sort(userList, new Comparator<User>() {
            @Override 
            public int compare(User u1, User u2) {
                int o1=getOverall(u1);
                int o2=getOverall(u2);
                return o1-o2;
            }
        });
        
        System.out.println("Top 5 inactive users overall (sum of comments, posts and likes): ");
        for (int i = 0; i < userList.size() && i < 5; i++) {
            System.out.println("   Top "+i+":overall number:"+getOverall(userList.get(i))+" "+userList.get(i));
        }
    }
    
//7
    public void getFiveMostProactiveUserOverall(){
        Map<Integer, User> users = DataStore.getInstance().getUsers();

        List<User> userList=new ArrayList<User>(users.values());
        
        Collections.sort(userList, new Comparator<User>() {
            @Override 
            public int compare(User u1, User u2) {
                int o1=getOverall(u1);
                int o2=getOverall(u2);
                return o2-o1;
            }
        });
        
        System.out.println("Top 5 proactive users overall (sum of comments, posts and likes): ");
        for (int i = 0; i < userList.size() && i < 5; i++) {
            System.out.println("   Top "+i+":overall number:"+getOverall(userList.get(i))+" "+userList.get(i));
        }
    }
        private int getOverall(User u){
           int o=u.getComments().size()+u.getPosts().size();
           for(Comment c:u.getComments()){
            o+=c.getLikes();
            }
        
 return o;

}


}
