package com.lsgx.admin.controller.system;

import com.github.pagehelper.PageInfo;
import com.lsgx.admin.annotation.Anonymous;
import com.lsgx.admin.controller.BaseController;
import com.lsgx.admin.model.Testname;
import com.lsgx.admin.model.Usertest;
import com.lsgx.admin.model.vo.NameTestVO;
import com.lsgx.admin.model.vo.UserTestVO;
import com.lsgx.admin.service.BFileService;
import com.lsgx.admin.service.ConfigService;
import com.lsgx.admin.service.TestNameService;
import com.lsgx.admin.service.UserTestService;
import org.junit.rules.TestName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 *  测试匿名controller
 * @author dell
 */
@Controller
@Anonymous
public class NameTestController2 extends BaseController{


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
	@RequestMapping(value = "/action/NameTestListyu.do")
    public String nameTestlist(NameTestVO vo,
			ModelMap model){
		//调用sql查询方法
        List<Testname> userList = testNameService.queryUserTestList(vo);
        PageInfo<Testname> page = new PageInfo<Testname>(userList);
		model.put("page", page);
        model.put("userList", userList);
        model.put("userTest", vo);
        saveLogDetail(null);
		return "ActionUser/testname";

	}



}
