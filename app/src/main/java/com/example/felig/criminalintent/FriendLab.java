package com.example.felig.criminalintent;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by felig on 2/14/2018.
 */

public class FriendLab {
    private static FriendLab sFriendLab;
    private List<Friend> mFriends;

    public static FriendLab get(Context context) {
        if (sFriendLab == null){
            sFriendLab = new FriendLab(context);
        }
        return sFriendLab;
    }


    private FriendLab(Context context){
        mFriends  = new ArrayList<>();
    }

    public void addFriend(Friend c){
        mFriends.add(c);
    }

    public List<Friend> getFriends(){
        return mFriends;
    }

    public Friend getFriend(UUID id){
        for (Friend friend : mFriends) {
            if (friend.getId().equals(id)){
                return friend;
            }
        }
        return null;
    }

    public Friend getFriendByName(String name){
        for (Friend friend : mFriends) {
            if (friend.getName().equals(name)){
                return friend;
            }
        }
        return null;
    }
}
