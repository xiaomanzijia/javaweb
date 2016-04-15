package com.lsgx.admin.controller.system;

import com.github.pagehelper.PageInfo;
import com.lsgx.admin.annotation.ActionLog;
import com.lsgx.admin.annotation.Anonymous;
import com.lsgx.admin.constants.SystemConstants;
import com.lsgx.admin.controller.BaseController;
import com.lsgx.admin.model.ActionUser;
import com.lsgx.admin.model.BFile;
import com.lsgx.admin.model.Config;
import com.lsgx.admin.model.Testname;
import com.lsgx.admin.model.Usertest;
import com.lsgx.admin.model.vo.BFileVO;
import com.lsgx.admin.model.vo.NameTestVO;
import com.lsgx.admin.model.vo.UserTestVO;
import com.lsgx.admin.service.BFileService;
import com.lsgx.admin.service.ConfigService;
import com.lsgx.admin.service.TestNameService;
import com.lsgx.admin.service.UserTestService;
import com.lsgx.admin.util.ActionUtil;
import com.lsgx.admin.util.ImageTool;
import com.lsgx.admin.util.JsonUtil;
import com.lsgx.admin.util.StringUtil;
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
import java.util.List;

/**
 *  测试匿名controller
 * @author dell
 */
@Controller
@Anonymous
public class UserestController2 extends BaseController{
	
	@Autowired
	private UserTestService userTestService;

    @Autowired
    private TestNameService testNameService;


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
	@RequestMapping(value = "/action/userTestList2.do")
    public String userTestList(UserTestVO vo,
			ModelMap model){
		//调用sql查询方法
        List<Usertest> userList = userTestService.queryUserTestList(vo);
        PageInfo<Usertest> page = new PageInfo<Usertest>(userList);
		model.put("page", page);
        model.put("userList", userList);
        model.put("userTest", vo);
        saveLogDetail(null);
		return "ActionUser/userTestList2";

	}



}
