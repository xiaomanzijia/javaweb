package com.lsgx.admin.controller.system;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.lsgx.admin.annotation.ActionLog;
import com.lsgx.admin.controller.BaseController;
import com.lsgx.admin.model.Category;
import com.lsgx.admin.model.Config;
import com.lsgx.admin.model.FrontUser;
import com.lsgx.admin.model.vo.CategoryVO;
import com.lsgx.admin.model.vo.ConfigQueryVO;
import com.lsgx.admin.model.vo.UserQueryVO;
import com.lsgx.admin.service.CategoryService;
import com.lsgx.admin.service.ConfigService;
import com.sun.org.apache.xalan.internal.xsltc.util.IntegerArray;

@Controller
@RequestMapping(value="/category")
public class CategoryController extends BaseController{
	
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private ConfigService configService;
	
	/**
	 * 获取类目列表
	 * @param categoryVO
	 */
	@RequestMapping(value="/categoryList")
	public String showCategory(CategoryVO categoryVO,ModelMap model){
		
		List<Category> categories = categoryService.queryByParam(categoryVO);
		PageInfo<Category> page = new PageInfo<Category>(categories);
		List<Category> categories2 = new ArrayList<Category>();
		for(Category category :categories){
			if(category.getModel().length()>20){
				category.setModelShort(category.getModel().substring(0, 20)+"...");
			}else{
				category.setModelShort(category.getModel());
			}
			categories2.add(category);
		}
		model.put("categorys", categories2);
		model.put("page", page);
		model.put("parm",categoryVO);
		return "category/category_list";
	}
	
	/**
	 * 获取添加类目页面
	 */
	@RequestMapping(value="/categoryAdd",method=RequestMethod.GET)
	public String categoryAdd(){
		return "category/category_add";
	}
	
	/**
	 * 保存添加类目
	 */
	@RequestMapping(value="/saveCategory")
	@ResponseBody
	@ActionLog(content="保存类目")
	public String saveCategory(CategoryVO categoryVO,ModelMap model){
		saveLogDetail("保存类目"+categoryVO.toString());
		if(categoryVO != null && categoryVO.getConfigIds()!=null){
			categoryVO.setNeeddata(categoryVO.getConfigIds());
			categoryService.save(categoryVO);
		}
		return responseSuccess("categoryList", "save category success", "closeCurrent");
		
	}
	
	/**
	 * 删除类目
	 */
	@RequestMapping(value="/deleteCategory")
	@ResponseBody
	@ActionLog(content="删除类目")
	public String deleteCategory(@RequestParam("id") int id,ModelMap model){
		Category category = categoryService.selectById(id);
		saveLogDetail("删除类目"+category.toString());
		categoryService.delete(id);
		return responseSuccess("categoryList", "delete category success", "");
	}
	
	@RequestMapping(value="/editCategory")
	public String editCategory(@RequestParam("id") int id,ModelMap model){
		Category category = categoryService.selectById(id);
		model.put("category", category);
		return "category/category_edit";
	}
	
	/**
	 * 保存修改类目
	 */
	@RequestMapping(value="/categoryEdit")
	@ResponseBody
	@ActionLog(content="修改类目")
	public String categoryEdit(CategoryVO categoryVO,ModelMap model){
		saveLogDetail("修改类目"+categoryVO.toString());
		if(categoryVO.getConfigIds()!=null){
			categoryVO.setNeeddata(categoryVO.getConfigIds());
			categoryService.update(categoryVO);
		}
		return responseSuccess("categoryList", "edit category success", "closeCurrent");
		
	}
	
	@RequestMapping(value = "/bringBacklist")
    @ActionLog(content = "查找带回所需资料列表")
    public String bringBacklist(@RequestParam("configIds") String configIds,ConfigQueryVO configVO, ModelMap model)
    {
		configVO.setRegular("类目");
        List<Config> list = configService.queryByParam(configVO);
        
        PageInfo<Config> page = new PageInfo<Config>(list);
        String[] config_ids = configIds.split(","); 
        int[] config_IDs = new int[config_ids.length];
        for(int i=0;i<config_ids.length;i++){
        	if(config_ids[i]!=""){
        		config_IDs[i]=Integer.parseInt(config_ids[i]);
        	}
        }
        model.put("list", list);
        model.put("page", page);
        model.put("config", configVO);
        model.put("configIds", config_IDs);
        return "category/bringback_list";
    }
	
	

}
