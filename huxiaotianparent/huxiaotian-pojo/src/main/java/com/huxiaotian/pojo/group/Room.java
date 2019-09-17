package com.huxiaotian.pojo.group;

import com.huxiaotian.pojo.HxtRoom;
import com.huxiaotian.pojo.HxtUser;

import java.io.Serializable;

public class Room implements Serializable {

    private HxtRoom hxtRoom;

    private HxtUser hxtUser;

    public HxtRoom getHxtRoom() {
        return hxtRoom;
    }

    public void setHxtRoom(HxtRoom hxtRoom) {
        this.hxtRoom = hxtRoom;
    }

    public HxtUser getHxtUser() {
        return hxtUser;
    }

    public void setHxtUser(HxtUser hxtUser) {
        this.hxtUser = hxtUser;
    }
}
