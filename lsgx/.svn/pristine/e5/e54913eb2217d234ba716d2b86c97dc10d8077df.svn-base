package com.lsgx.admin.controller.bfile;

import java.util.ArrayList;
import java.util.List;

import com.github.pagehelper.PageInfo;
import com.lsgx.admin.annotation.ActionLog;
import com.lsgx.admin.constants.SystemConstants;
import com.lsgx.admin.model.Config;
import com.lsgx.admin.model.Usertest;
import com.lsgx.admin.model.vo.BFileVO;
import com.lsgx.admin.model.vo.UserTestVO;
import com.lsgx.admin.service.ConfigService;
import com.lsgx.admin.util.ActionUtil;
import com.lsgx.admin.util.ImageTool;
import com.lsgx.admin.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.lsgx.admin.controller.BaseController;
import com.lsgx.admin.model.BFile;
import com.lsgx.admin.service.BFileService;
import com.lsgx.admin.util.StringUtil;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/bfile")
public class BFileController extends BaseController
{
    @Autowired
    private BFileService bFileService;

    @Autowired
    private ConfigService configService;



    /**
     *  用户列表信息查询  post
     * @param model
     * @return
     */
    @RequestMapping(value = "/queryList.do")
    @ActionLog(content = "查询图片文件列表")
    public String queryList(BFileVO vo,
                               ModelMap model){
        //调用sql查询方法
        List<BFile> bFileList = bFileService.queryBFileList(vo);
        PageInfo<BFile> page = new PageInfo<BFile>(bFileList);

        for (int i = 0; i < bFileList.size(); i++) {
            BFile bFile = bFileList.get(i);
            bFile.setUrl(SystemConstants.Img_real_path+bFile.getUrl());
        }
        model.put("page", page);
        model.put("bfileList", bFileList);
        model.put("bfilevo", vo);
        return "bfile/bfile_list";

    }

    /**
     *  用户列表信息查询  post
     * @param model
     * @return
     */
    @RequestMapping(value = "/addBfile.do",method =  RequestMethod.GET)
    @ActionLog(content = "添加图片")
    public String addBFile(BFileVO vo,
                               ModelMap model){

        return "bfile/bfile_upload";

    }



    /**
     * 上传图片 控制在500KB以内，最多可上传10张图片
     */
    @RequestMapping(value = "/uploadImgAjax")
    @ActionLog(content = "上传图片")
    @ResponseBody
    public String uploadImgAjax(HttpServletRequest request,@RequestParam("file") MultipartFile file, ModelMap model)
    {
            String description=request.getParameter("description");
        System.out.println("进入bfile/uploadImgAjax！"+description);
        // 得到上传服务器的路径
            Config config = new Config();
            config.setConfigKey("fileBasicURL");
            String fileBasicURL = configService.queryByParam(config).get(0).getConfigValue();
            if(StringUtil.isEmpty(fileBasicURL)){
                return JsonUtil.toJSONString(ActionUtil.getAjaxToMap("300", "faild for fileBasicURL is null", "manage_img", "", "closeCurrent", ""));
            }
//            String realPath = request.getSession().getServletContext().getRealPath("/upload/picture/parkProgramDetail/");//项目绝对路径
            String realPath = fileBasicURL + "/upload/picture/parkProgramDetail/";
            if (ImageTool.isImageAllowType(file.getOriginalFilename()))//刷选格式
            {
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
                        bFile.setUrl( newFileName);
                        bFile.setDescription(description);
                        int result = bFileService.save(bFile);
                        System.out.println("插入的Bfile id = " + bFile.getId());

                    }
                }
            }else{
                return JsonUtil.toJSONString(ActionUtil.getAjaxToMap("300", "faild for errorType", "usertestEdit", "", "closeCurrent", ""));
            }
            return JsonUtil.toJSONString(ActionUtil.getAjaxToMap("200", "upload success!", "image_manager", "", "closeCurrent", ""));

    }


    /**
     * 删除新闻
     */
    @RequestMapping(value="/delete",method=RequestMethod.POST)
    @ResponseBody
    @ActionLog(content="删除图片")
    public String newsDelete(@RequestParam("id") int id,ModelMap model){
         bFileService.delete(id);
        return JsonUtil.toJSONString(ActionUtil.getAjaxToMap("200", "delete success", "image_manager", "", "", ""));
    }


    //-------------------------------------------------------



    
    @RequestMapping(value = "/showDetail")
    public String showDetail(@RequestParam("id") int id, ModelMap model)
    {
        String realPath = "http://res.17xs.org/picture/";
        BFile bFile = bFileService.queryById(id);
        if (bFile != null)
        {
            bFile.setUrl(realPath + bFile.getUrl());
        }
        model.put("bFile", bFile);
        return "bfile/bfile_detail";
    }
    
    /**
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/showList")
    public String showList(@RequestParam("ids") String ids, ModelMap model)
    {
        String realPath = "http://res.17xs.org/picture/";
        String[] image_ids = ids.split("\\,");
        List<BFile> imgList = new ArrayList<BFile>();
        for (String image_id : image_ids)
        {
            if (StringUtil.isNotEmpty(image_id))
            {
                BFile bFile = bFileService.queryById(Integer.parseInt(image_id));
                if (bFile != null)
                {
                    bFile.setUrl(realPath + bFile.getUrl());
                    imgList.add(bFile);
                }
            }
        }
        model.put("imgList", imgList);
        return "bfile/bfile_list";
    }

    /**
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/showList")
    public String bfileList(@RequestParam("ids") String ids, ModelMap model)
    {
        String realPath = "http://res.17xs.org/picture/";
        String[] image_ids = ids.split("\\,");
        List<BFile> imgList = new ArrayList<BFile>();
        for (String image_id : image_ids)
        {
            if (StringUtil.isNotEmpty(image_id))
            {
                BFile bFile = bFileService.queryById(Integer.parseInt(image_id));
                if (bFile != null)
                {
                    bFile.setUrl(realPath + bFile.getUrl());
                    imgList.add(bFile);
                }
            }
        }
        model.put("imgList", imgList);
        return "bfile/bfile_list";
    }
}
