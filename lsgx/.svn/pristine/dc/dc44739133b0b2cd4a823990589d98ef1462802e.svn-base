package com.lsgx.admin.controller.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.lsgx.admin.annotation.ActionLog;
import com.lsgx.admin.controller.BaseController;
import com.lsgx.admin.model.UserCard;
import com.lsgx.admin.model.vo.UserCardVO;
import com.lsgx.admin.service.UserCardService;

@Controller
@RequestMapping("/usercard")
public class UserCardController extends BaseController
{
    @Autowired
    private UserCardService userCardService;
    
    /**
     * 获取用户银行卡列表
     * @param vo
     * @param model
     * @return
     */
    @RequestMapping(value = "/userCardList")
    @ActionLog(content = "查询用户银行卡列表")
    public String userCardList(UserCardVO vo, ModelMap model)
    {
        List<UserCard> list = userCardService.findByCondition(vo);
        
        PageInfo<UserCard> page = new PageInfo<UserCard>(list);
        
        model.put("list", list);
        model.put("page", page);
        model.put("userCard", vo);
        return "user/usercard_list";
    }
    
    /**
     * 获取修改信息页面
     * @param userCardVO
     * @param model
     */
    @RequestMapping(value="/userCardEdit")
    public String userCardEdit(UserCardVO userCardVO,ModelMap model){
    	UserCard userCard = userCardService.queryById(userCardVO.getId());
    	model.put("userCard", userCard);
    	return "user/userCard_edit";
    }
    
    /**
     * 提交修改好的信息
     * @param userCard
     * @param model
     */
    @RequestMapping(value="/saveUserCardEdit")
    @ResponseBody
    @ActionLog(content="修改用户银行卡信息")
    public String saveUserCardEdit(UserCard userCard,ModelMap model){
    	saveLogDetail("修改用户银行卡信息"+userCard.toString());
    	userCardService.updateUserCard(userCard);
    	return responseSuccess("userCard_list", "edit userCard success", "closeCurrent");
    }
    
    /**
     * 删除用户银行卡信息
     * @param userCardVO
     * @param model
     */
    @RequestMapping(value="/deleteUserCard")
    @ResponseBody
    @ActionLog(content="删除用户银行卡信息")
    public String deleteUserCard(UserCardVO userCardVO,ModelMap model){
    	UserCard userCard = userCardService.queryById(userCardVO.getId());
    	saveLogDetail("删除用户银行卡信息"+userCard.toString());
    	userCardService.delete(userCardVO.getId());
    	return responseSuccess("userCard_list", "delete userCard success", "");
    }
    /**
     * 查看每个用户的银行卡使用记录
     * @param userCardVO
     * @param model
     */
    @RequestMapping(value="/queryUserCardRecord")
    public String queryUserCardRecord(UserCardVO userCardVO,ModelMap model){
    	List<UserCard> list = userCardService.findByCondition(userCardVO);
        
        PageInfo<UserCard> page = new PageInfo<UserCard>(list);
        
        model.put("list", list);
        model.put("page", page);
        model.put("userCard", userCardVO);
    	return "user/userCard_record";
    }
}
