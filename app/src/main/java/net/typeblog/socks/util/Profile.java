package net.typeblog.socks.util;

import android.content.Context;
import android.content.SharedPreferences;

public class Profile {
	private Context mContext;
	private SharedPreferences mPref;
	private String mName;
	private String mPrefix;
	
	Profile(Context context, SharedPreferences pref, String name) {
		mContext = context;
		mPref = pref;
		mName = name;
		mPrefix = prefPrefix(name);
	}
	
	public String getName() {
		return mName;
	}
	
	public String getServer() {
		return mPref.getString(key("server"), "127.0.0.1");
	}
	
	public void setServer(String server) {
		mPref.edit().putString(key("server"), server).commit();
	}
	
	public int getPort() {
		return mPref.getInt(key("port"), 1080);
	}
	
	public void setPort(int port) {
		mPref.edit().putInt(key("port"), port).commit();
	}
	
	public boolean isUserPw() {
		return mPref.getBoolean(key("userpw"), false);
	}
	
	public void setIsUserpw(boolean is) {
		mPref.edit().putBoolean(key("userpw"), is).commit();
	}
	
	public String getUsername() {
		return mPref.getString(key("username"), "");
	}
	
	public void setUsername(String username) {
		mPref.edit().putString(key("username"), username).commit();
	}
	
	public String getPassword() {
		return mPref.getString(key("password"), "");
	}
	
	public void setPassword(String password) {
		mPref.edit().putString(key("password"), password).commit();
	}
	
	void delete() {
		mPref.edit()
			.remove(key("server"))
			.remove(key("port"))
			.remove(key("userpw"))
			.remove(key("username"))
			.remove(key("password"))
			.commit();
	}
	
	private String key(String k) {
		return mPrefix + k;
	}
	
	private static String prefPrefix(String name) {
		return name.replace("_", "__").replace(" ", "_");
	}
}