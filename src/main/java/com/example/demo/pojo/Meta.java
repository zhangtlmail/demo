/**
 * 
 */
package com.example.demo.pojo;

import java.io.Serializable;

/**
 * @author zhangtl
 * @Time 2020年3月23日
 */
public class Meta implements Serializable{
	private Boolean keepAlive;
	private Boolean requireAuth;
	public Boolean getKeepAlive() {
        return keepAlive;
    }

    public void setKeepAlive(Boolean keepAlive) {
        this.keepAlive = keepAlive;
    }

    public Boolean getRequireAuth() {
        return requireAuth;
    }

    public void setRequireAuth(Boolean requireAuth) {
        this.requireAuth = requireAuth;
    }
}
