package com.jxh.mvc.controller.fileupload.param;

import org.springframework.web.multipart.MultipartFile;

import com.jxh.mvc.controller.param.BaseParam;
/**
 * 文件上传
 * @author jingxiaohu
 *
 */
public class Param_uploadFile extends BaseParam{
	//文件
	public  MultipartFile file;
    //提交过来的file的名字
	public String fileName;
    //提交过来的file的MIME类型
	public String fileType;
	//项目模块 例如 头像 avatar
	public String folder_name;
	//图片文件处理类型  0:指定像素大小  1：进行缩放
	public int act_type;
	
 
	
	
	
	
	
	
	
	
	
	public int getAct_type() {
		return act_type;
	}
	public void setAct_type(int act_type) {
		this.act_type = act_type;
	}
	public String getFolder_name() {
		return folder_name;
	}
	public void setFolder_name(String folder_name) {
		this.folder_name = folder_name;
	}
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFileType() {
		return fileType;
	}
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}	
	
	
	
	
	
	
}
