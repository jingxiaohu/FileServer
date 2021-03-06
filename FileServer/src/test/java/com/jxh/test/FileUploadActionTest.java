package com.jxh.test;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.jxh.constant.MyConstant;

/**
 * 文件上传
 * @author jingxiaohu
 *
 */
public class FileUploadActionTest extends BaseActionTest{
	
	@Test  
    public void fileupload() {  
		String url  = BaseUrl + "/fileupload.php";
		int dtype = 0;
        Map<String, String> maps = new HashMap<String, String>();  
    	Integer width = 100; //宽 像素
    	Integer height = 200; //高 像素
    	String folder_name="avatar";//项目模块 例如 头像 avatar
    	Integer act_type = 0;//图片文件处理类型  0:指定像素大小  1：进行缩放
    	String sign = getSignature(MyConstant.SYSTEM_KEY, dtype);
    	maps.put("sign", sign);
        
    	
    	maps.put("folder_name", folder_name);  
    	maps.put("act_type", act_type+"");  
        maps.put("width", width+"");  
        maps.put("height", height+"");  
        
        
        List<File> fileLists = new ArrayList<File>();  
        File  file = new File("D://temp//lience.png");
        System.out.println(file.isFile());
        System.out.println(file.exists());
        if(file.exists() && file.isFile()){
        	fileLists.add(file); 
        }
         
        String responseContent = HttpClientUtil.getInstance()  
                .sendHttpPost(url, maps, fileLists,"file");  
        System.out.println("reponse content:" + responseContent);  
    }  
  
}
