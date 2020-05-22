package com.example.zookeeper.zklock;

public class Lock {

    private String lockId;

    private boolean active;

    private String path;

    public Lock(String lockId, String path) {
        this.lockId = lockId;
        this.path = path;
    }

    public String getLockId() {
        return lockId;
    }

    public void setLockId(String lockId) {
        this.lockId = lockId;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
