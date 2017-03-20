package com.jxh.file;

import com.jxh.constant.MyConstant;

/**
 * 项目文件保存文件夹管理
 * @author jingxiaohu
 *
 */
public enum FileSaveFolder {
	/**
	 * 头像
	 */
	avatar("avatar",MyConstant.USER_AVATAR,MyConstant.AVATAR_WIDTH,MyConstant.AVATAR_HIGHT),
	
	/**
	 * 行驶证
	 */
	lience("lience",MyConstant.USER_LIENCE,MyConstant.LIENCE_WIDTH,MyConstant.LIENCE_HIGHT);
	
	
	
	private  String savefolder_name;
	private  String savefolder;
	private  int width;
	private  int height;
	
	private FileSaveFolder(String savefolder_name,String savefolder,int width,int height){
		this.savefolder_name =  savefolder_name;
		this.savefolder = savefolder;
		this.width = width;
		this.height = height;
	}
	
	
	public String getSavefolder_name() {
		return savefolder_name;
	}


	public void setSavefolder_name(String savefolder_name) {
		this.savefolder_name = savefolder_name;
	}


	public String getSavefolder() {
		return savefolder;
	}
	public void setSavefolder(String savefolder) {
		this.savefolder = savefolder;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	
	
	
}
