package com.lsgx.admin.controller.system;

import com.github.pagehelper.PageInfo;
import com.lsgx.admin.annotation.ActionLog;
import com.lsgx.admin.annotation.Anonymous;
import com.lsgx.admin.constants.SystemConstants;
import com.lsgx.admin.controller.BaseController;
import com.lsgx.admin.model.*;
import com.lsgx.admin.model.vo.ActionUserVO;
import com.lsgx.admin.model.vo.BFileVO;
import com.lsgx.admin.model.vo.UserTestVO;
import com.lsgx.admin.service.*;
import com.lsgx.admin.util.*;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.List;

/**
 *  Usertest的测试控制器
 * @author dell
 */
@Controller
@Anonymous
public class UserestController extends BaseController{
	
	@Autowired
	private UserTestService userTestService;

    @Autowired
    private ConfigService configService;

    @Autowired
    private BFileService bFileService;

	
	//返回用户列表页面
    private static String usertestList = "ActionUser/userTestList";
	
    private static String actionUserAdd = "ActionUser/userTestAdd";
	
    private static String actionUserEdit = "ActionUser/userTestEdit";
    
    private static String actionUserDetail = "ActionUser/actionUserDetail";
	
	//角色用户关联页面
    private static String actionUserRole = "ActionUser/actionUserRole";
	
    private static String ACTION_USER_LIST = "system/action_uesr_list";


	/**
	 *  用户列表信息查询  post
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/action/userTestList.do", method = RequestMethod.POST)
    @ActionLog(content = "查询测试用户usetest列表")
    public String userTestList(UserTestVO vo,
			ModelMap model){
		//调用sql查询方法
        List<Usertest> userList = userTestService.queryUserTestList(vo);
        PageInfo<Usertest> page = new PageInfo<Usertest>(userList);
		model.put("page", page);
        model.put("userList", userList);
        model.put("userTest", vo);
        saveLogDetail(null);
		return usertestList;
		
	}
	
	/**
	 *  用户列表信息查询  get
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/action/userTestList.do", method = RequestMethod.GET)
    public String userTestListget(UserTestVO vo,
			ModelMap model){
        return userTestList(vo, model);
	}

    /**
     *  添加用户 get
     * @param req
     * @param resp
     * @param model
     * @return
     */
    @RequestMapping(value = "/action/userTestAdd.do", method = RequestMethod.GET)
    public String userTestAddget(HttpServletRequest req, HttpServletResponse resp,
                                   ModelMap model){
        return actionUserAdd;
    }

    /**
     *  添加用户 post
     * @param req
     * @param model
     * @return
     */
    @RequestMapping(value = "/action/userTestAdd.do", method = RequestMethod.POST)
    @ResponseBody
    @ActionLog(content = "添加用户")
    public String actionUserAddpost(Usertest usertest, HttpServletRequest req,
                                    ModelMap model) {

        List<Usertest> users = userTestService.queryUserTest(usertest.getUsername());
        if(users != null&&users.size()>0){
            return JsonUtil.toJSONString(ActionUtil.getAjaxToMap("300", "this adminUser is existed", "", "", "", ""));
        }
        userTestService.saveUsertest(usertest);

        return JsonUtil.toJSONString(ActionUtil.getAjaxToMap("200", "add success", "userTestList", "", "closeCurrent", ""));
    }

    /**
     *  跳转修改页面
     * @param req
     * @param model
     * @return
     */
    @RequestMapping(value = "/action/userTestEditGET.do")
    public String actionUserEditGET(ActionUser actionUser, HttpServletRequest req,
                                    ModelMap model) {
        if (actionUser != null && actionUser.getId() != null)
        {
            Usertest user = userTestService.queryById(actionUser.getId());
//            if(user.getBfileId()!=null){
//               BFile file= bFileService.queryById(user.getBfileId());
//                if (file!=null) {
//                    BFileVO fileVO=new BFileVO();
//
//                    try {
//                        BeanUtils.copyProperties(fileVO,file);
//                    } catch (IllegalAccessException e) {
//                        e.printStackTrace();
//                    } catch (InvocationTargetException e) {
//                        e.printStackTrace();
//                    }
//                    fileVO.setImg_path(SystemConstants.Img_real_path+fileVO.getUrl());
//                    model.put("fileVO", fileVO);
//                }
//            }
            model.put("userTest", user);

        }
        return actionUserEdit;

    }

    /**
     * 用户信息修改保存
     * @param actionUser
     * @param model
     * @return
     */
    @RequestMapping(value = "/action/userTestEdit.do")
    @ResponseBody
    @ActionLog(content = "修改用户usertest")
    public String actionUserEditPost(Usertest actionUser,
                                     ModelMap model){
        StringBuffer sb = new StringBuffer();
        Usertest user = userTestService.queryById(actionUser.getId());
//        actionUser.setCreatename(user.getCreatename());
//        actionUser.setCreatetime(user.getCreatetime());
//        actionUser.setDepartment(user.getDepartment());
//        actionUser.setPassword(user.getPassword());
//        actionUser.setStatus(user.getStatus());

        sb.append("修改前：").append(user.toString());
        sb.append("\n修改后：").append(actionUser.toString());
        saveLogDetail(sb.toString());
        userTestService.userEditOk(actionUser);
        return JsonUtil.toJSONString(ActionUtil.getAjaxToMap("200", "edit success", "userTestList", "", "closeCurrent", ""));

    }


    /**
     * 用户信息删除
     * @param req
     * @param resp
     * @param model
     * @return
     */
    @RequestMapping(value = "/action/userTestDelete.do", method = RequestMethod.POST)
    @ResponseBody
    @ActionLog(content = "删除usertest")
    public String actionUserDeletePost(HttpServletRequest req, HttpServletResponse resp,
                                       ModelMap model){
        String id = req.getParameter("id");
        Usertest user = userTestService.queryById(Integer.parseInt(id));
        saveLogDetail("删除usertest：" + user.toString());
        //删除用户信息
        userTestService.deleteByPrimaryKey(Integer.parseInt(id));

        return JsonUtil.toJSONString(ActionUtil.getAjaxToMap("200", "delete success", "userTestList", "", "forward", "/action/userTestList.do"));
    }

    /**
     * 上传图片弹出框
     */
    @RequestMapping(value = "/action/usertestUploadImg.do")
    public String uploadImg(Usertest usertest, ModelMap model)
    {
        if (usertest.getId() != null)
        {
            usertest = userTestService.queryById(usertest.getId());
        }
        model.put("usertest", usertest);
        return "ActionUser/usertestUploadImg";

    }
    /**
     * 上传图片 控制在500KB以内，最多可上传10张图片
     */
    @RequestMapping(value = "/action/uploadImgAjax")
    @ActionLog(content = "上传图片")
    @ResponseBody
    public String uploadImgAjax(HttpServletRequest request,Usertest usertest, @RequestParam("file") MultipartFile file, ModelMap model)
    {
        System.out.println("进入action/uploadImgAjax！");
        if(usertest!=null&&usertest.getId()!=null&&file!=null){
            System.out.println("进入action/uploadImgAjax！获得usertest.id"+usertest.getId());
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
                        bFile.setUrl("parkProgramDetail/" + newFileName);
                        int result = bFileService.save(bFile);
                        System.out.println("插入的Bfile id = " + bFile.getId());
                        if (result > 0) {
                            //usertest.setBfileId(bFile.getId());
                            userTestService.userEditBfileId(usertest);
                           // model.put("userTest", usertest);

                        }
                    }
                }
            }else{
                return JsonUtil.toJSONString(ActionUtil.getAjaxToMap("300", "faild for errorType", "usertestEdit", "", "closeCurrent", ""));
            }
            return JsonUtil.toJSONString(ActionUtil.getAjaxToMap("200", "upload success", "usertestEdit", "", "closeCurrent", ""));
        }else{
            return JsonUtil.toJSONString(ActionUtil.getAjaxToMap("300", "faild for error", "usertestEdit", "", "closeCurrent", ""));
        }
    }

	
}
