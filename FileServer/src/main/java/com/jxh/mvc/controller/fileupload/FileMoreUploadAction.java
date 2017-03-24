package com.jxh.mvc.controller.fileupload;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.jxh.bean.ReturnDataNew;
import com.jxh.constant.MyConstant;
import com.jxh.file.FileSaveFolder;
import com.jxh.file.ImgUtil;
import com.jxh.mvc.controller.BaseV1Controller;
import com.jxh.mvc.controller.fileupload.param.Param_uploadMoreFile;
import com.jxh.util.RequestUtil;

/**
 * 多文件上传
 * @author jingxiaohu
 *
 */
@Controller
public class FileMoreUploadAction extends BaseV1Controller{

    @RequestMapping(value="/fileupload_more",method=RequestMethod.POST)
    @ResponseBody
    public String fileupload_more(HttpServletRequest request,HttpServletResponse response,Param_uploadMoreFile param) {
    	       ReturnDataNew returnData = null;
    	       try {
				   returnData = new ReturnDataNew();
				   //检查是否是合法请求
					String ip = getIpAddr(request);
					if(ip.startsWith("192.168") || ip.startsWith("127.0")){  
						ip  =  null;
					}
					 //参数检查
					 if(param == null){ 
						 //参数传递错误 
						 returnData.setReturnData(errorcode_param, "参数传递错误", "");
						 sendResp(returnData,response);
						 return null;
					 }
					 //检查是否进行了参数签名认证
					 if(!param.checkRequest()){
						 returnData.setReturnData(errorcode_param, "没有进行参数签名认证", "");
						 sendResp(returnData,response);
						 return null;
					 }
					 //对封装的参数对象中的属性进行 非空等规则验证
					if(RequestUtil.checkObjectBlank(param.getFolder_name())){
						returnData.setReturnData(errorcode_param, " folder_name is null", null);
						sendResp(returnData,response);
						return null;
					}
					 
					if(RequestUtil.checkObjectBlank(param.getFiles())){
						returnData.setReturnData(errorcode_param, " files is null", null);
						sendResp(returnData,response);
						return null;
					}
					String sign_str = getSignature(MyConstant.SYSTEM_KEY, param.dtype);
					if(!param.sign.equalsIgnoreCase(sign_str)){
						log.error("sign="+param.sign+"  sign_str="+sign_str);
						returnData.setReturnData(errorcode_param, " sign is not right", null);
						sendResp(returnData,response);
						return null;
					}
					/**
					 * 这里处理文件的读取存取等
					 */
					if(param.getWidth() == null && param.getHeight() == null){
						if(param.getFolder_name().equalsIgnoreCase(FileSaveFolder.avatar.getSavefolder_name())){
							//头像
							param.setWidth(FileSaveFolder.avatar.getWidth());
							param.setWidth(FileSaveFolder.avatar.getHeight());
						}else if(param.getFolder_name().equalsIgnoreCase(FileSaveFolder.lience.getSavefolder_name())){
							//行驶证
							param.setWidth(FileSaveFolder.lience.getWidth());
							param.setWidth(FileSaveFolder.lience.getHeight());
						}else{
							returnData.setReturnData(errorcode_param, "非法目录请求", "");
							sendResp(returnData,response);
							return null;
						}
					}
					
					/**
					 * 这里处理文件相关属性
					 */
					List<MultipartFile> files = param.getFiles(); 
					if(files == null || files.size() == 0){
						returnData.setReturnData(errorcode_param, " files is null", null);
						sendResp(returnData,response);
						return null;
					}
					
					/**
					 * 遍历文件列表
					 */
					List<String> file_url_list = new ArrayList<String>();
					
					for (MultipartFile file : files) {
						String fileName = null;
						if(file != null){
							fileName = file.getOriginalFilename();
							param.setFileName(fileName);
							param.setFileType(fileName.substring(fileName.lastIndexOf(".")+1, fileName.length()));
						}
						
						if(param.getWidth() != null && param.getHeight() != null){
							String filename =  null;
							String folder_name = param.getFolder_name() == null?"":param.getFolder_name();
							String tosavePath = MyConstant.BASE_DIR+File.separator+folder_name;
							if(param.getAct_type() == 0){
								//指定像素设置
								 filename = ImgUtil.ImgSize(tosavePath, file.getInputStream(), param.getWidth(), param.getHeight(), param.getFileType());
							}else{
								//比例缩放
								 filename = ImgUtil.ImgSize(tosavePath, file.getInputStream(), param.getWidth(), param.getHeight(), param.getFileType());
							}
							
							String fileurl = MyConstant.BASE_URL+folder_name+returnFileSeparatorUrl()+filename;
							file_url_list.add(fileurl);
						}
					}
					
					
					if(file_url_list != null && file_url_list.size() > 0){
						returnData.setReturnData(errorcode_success, "files is upload success", file_url_list);
						sendResp(returnData,response);
						return null;
					}
					
					
					returnData.setReturnData(errorcode_param, "file is upload fail", "");
					sendResp(returnData,response);
					return null;
			} catch (Throwable e) {
				// TODO Auto-generated catch block
				log.error("FileUploadAction->FileMoreUploadAction is error ", e);
				returnData.setReturnData(errorcode_param, "files is upload fail", "");
			}
    	    sendResp(returnData,response);
    	    return null;
       }
    
}
