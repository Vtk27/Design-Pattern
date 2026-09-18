package com.example.designpattern.SplitWise.Models;

import java.util.HashSet;
import java.util.UUID;

public class Group {
    private final String id;
    private final String groupName;
    private HashSet<User> members;

    public Group(String name, HashSet<User> members){
        this.id = UUID.randomUUID().toString();
        this.groupName = name;
        this.members = members;
    }

    public String getId() {
        return id;
    }

    public String getGroupName() {
        return groupName;
    }

    public HashSet<User> getMembers() {
        return members;
    }

    
}
