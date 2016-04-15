package com.lsgx.admin.controller.system;

import com.github.pagehelper.PageInfo;
import com.lsgx.admin.annotation.ActionLog;
import com.lsgx.admin.annotation.Anonymous;
import com.lsgx.admin.controller.BaseController;
import com.lsgx.admin.model.BFile;
import com.lsgx.admin.model.Config;
import com.lsgx.admin.model.Usertest;
import com.lsgx.admin.model.vo.UserTestVO;
import com.lsgx.admin.service.BFileService;
import com.lsgx.admin.service.ConfigService;
import com.lsgx.admin.service.UserTestService;
import com.lsgx.admin.util.ActionUtil;
import com.lsgx.admin.util.ImageTool;
import com.lsgx.admin.util.JsonUtil;
import com.lsgx.admin.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *  测试匿名controller
 * @author dell
 */
@Controller
@Anonymous
public class H5ImgUploadController extends BaseController{
	


    @Autowired
    private ConfigService configService;

    @Autowired
    private BFileService bFileService;



	/**
	 *  用户列表信息查询  post
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/h5img/h5img.do")
    public String userTestList(UserTestVO vo,
			ModelMap model){

		return "h5img/h5img";
		
	}

    /**
     * 上传图片 控制在500KB以内，最多可上传10张图片
     */
    @RequestMapping(value = "/h5img/uploadImgAjax")
    @ActionLog(content = "上传图片")
    @ResponseBody
    public String uploadImgAjax(HttpServletRequest request,Usertest usertest, @RequestParam("imagefile") MultipartFile file, ModelMap model)
    {
        System.out.println("进入action/uploadImgAjax！");
//        if(usertest!=null&&usertest.getId()!=null&&file!=null){
//            System.out.println("进入action/uploadImgAjax！获得usertest.id"+usertest.getId());
//            // 得到上传服务器的路径
            Config config = new Config();
            config.setConfigKey("fileBasicURL");
            String fileBasicURL = configService.queryByParam(config).get(0).getConfigValue();
            if(StringUtil.isEmpty(fileBasicURL)){
                return JsonUtil.toJSONString(ActionUtil.getAjaxToMap("300", "faild for fileBasicURL is null", "manage_img", "", "closeCurrent", ""));
            }
//            String realPath = request.getSession().getServletContext().getRealPath("/upload/picture/parkProgramDetail/");//项目绝对路径
            String realPath = fileBasicURL + "/upload/picture/parkProgramDetail/";
           System.out.println("获得文件名："+file.getOriginalFilename());
           System.out.println("realPath："+realPath);
//            if (ImageTool.isImageAllowType(file.getOriginalFilename()))//刷选格式
//            {
                if (file.getSize() > 2 * 1024 * 1024)//文件大小2M
                {
                    return JsonUtil.toJSONString(ActionUtil.getAjaxToMap("300", "faild for fileSize big than 500KB", "manage_img", "", "closeCurrent", ""));
                }
                else
                {
                    String newFileName = ImageTool.upload(file, realPath);//图片上传--返回上传成功后图片的新名字（包括后缀）
                    System.out.println("newFileName = " + newFileName);
                    if(StringUtil.isNotEmpty(newFileName)){//不为空代表上传成功
                        BFile bFile = new BFile();
                        bFile.setCategory("parkProgramDetail");
                        bFile.setFileType("picture");
                        bFile.setUrl("parkProgramDetail/" + newFileName);
                        int result = bFileService.save(bFile);
                        System.out.println("插入的Bfile id = " + bFile.getId());
                      /*  if (result > 0) {
                            usertest.setBfileId(bFile.getId());
                            userTestService.userEditBfileId(usertest);
                            // model.put("userTest", usertest);

                        }*/
                        return JsonUtil.toJSONString(getAjaxToMap("200", String.valueOf(file.getSize())));
                    }
                }
//            }else{
//                return JsonUtil.toJSONString(ActionUtil.getAjaxToMap("300", "faild for errorType", "usertestEdit", "", "closeCurrent", ""));
//            }
            return JsonUtil.toJSONString(getAjaxToMap("200", "44"));
//        }else{
//            return JsonUtil.toJSONString(ActionUtil.getAjaxToMap("300", "faild for error", "usertestEdit", "", "closeCurrent", ""));
//        }
    }

    public static Map<String, Object> getAjaxToMap(String path, String size)
    {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("path", path);
        map.put("size", size);
        return map;
    }
	


	
}
