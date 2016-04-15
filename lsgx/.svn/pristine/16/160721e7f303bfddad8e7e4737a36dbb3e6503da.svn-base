package com.lsgx.admin.controller.user;

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
import com.lsgx.admin.model.Area;
import com.lsgx.admin.model.vo.AreaVO;
import com.lsgx.admin.service.AreaService;
import com.lsgx.admin.util.ActionUtil;
import com.lsgx.admin.util.JsonUtil;
import com.lsgx.admin.util.StringUtil;

@Controller
@RequestMapping("/area")
public class AreaController extends BaseController
{
    @Autowired
    private AreaService areaService;
    
    /**
     * 列表查询
     * @param vo
     * @param model
     * @return
     */
    @RequestMapping(value = "/areaList")
    @ActionLog(content = "查询地区列表")
    public String select(AreaVO vo, ModelMap model)
    {
        
        List<Area> list = areaService.select(vo);
        
        PageInfo<Area> page = new PageInfo<Area>(list);
        
        model.put("list", list);
        model.put("page", page);
        model.put("area", vo);
        return "area/area_list";
    }
    
    @RequestMapping(value = "/initSave")
    public String initSave(ModelMap model)
    {
        return "area/area_add";
    }

    @RequestMapping(value = "/save")
    @ActionLog(content = "增加地区")
    @ResponseBody
    public String save(AreaForm areaForm, ModelMap model)
    {
        Area area = new Area();
        String areaName = "";
        String areaCode = "";
        String upperCode = "";

        if (StringUtil.isNotEmpty(areaForm.getCountyCode()))
        {
            areaCode = areaForm.getCountyCode();
            if (StringUtil.isNotEmpty(areaForm.getCountyName()))
            {
                areaName = areaForm.getProcinceName() + "-" + areaForm.getCityName() + "-" + areaForm.getCountyName();
            }
            if (StringUtil.isNotEmpty(areaForm.getCityCode()))
            {
                upperCode = areaForm.getCityCode();
            }
        }
        else if (StringUtil.isNotEmpty(areaForm.getCityCode()))
        {
            areaCode = areaForm.getCityCode();
            if (StringUtil.isNotEmpty(areaForm.getCityName()))
            {
                areaName = areaForm.getProcinceName() + "-" + areaForm.getCityName();
            }
            if (StringUtil.isNotEmpty(areaForm.getProvinceCode()))
            {
                upperCode = areaForm.getProvinceCode();
            }
        }
        else
        {
            if (StringUtil.isNotEmpty(areaForm.getProvinceCode()))
            {
                areaCode = areaForm.getProvinceCode();
            }
            if (StringUtil.isNotEmpty(areaForm.getProcinceName()))
            {
                areaName = areaForm.getProcinceName();
            }
        }
        
        area.setAreaCode(areaCode);
        area.setAreaName(areaName);
        area.setUpperCode(upperCode);
        List<Area> list = areaService.queryByParam(area);
        area.setState(101);
        if (list != null && list.size() > 0)
        {
            return super.responseFaild("area_list", " 添加失败，地区已存在", "closeCurrent");
        }
        areaService.save(area);
        return responseSuccess("area_list", "增加地区", "closeCurrent");
    }

    @RequestMapping(value = "/initUpdate")
    public String initSave(@RequestParam("id") int id,ModelMap model)
    {
        Area area = areaService.queryById(id);
        model.put("area", area);
        return "area/area_update";
    }

    @RequestMapping(value = "/update")
    @ActionLog(content = "修改地区")
    @ResponseBody
    public String update(Area area, ModelMap model)
    {
        if (area != null)
        {
            areaService.update(area);
            saveLogDetail("修改地区ID:" + area.getId());
            return JsonUtil.toJSONString(ActionUtil.getAjaxToMap("200", "success", "area_list", "", "", ""));
        }
        else
        {
            return JsonUtil.toJSONString(ActionUtil.getAjaxToMap("300", "error", "area_list", "", "", ""));
        }
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    @ActionLog(content = "删除地区")
    public String delete(@RequestParam("id")
    int id, ModelMap model)
    {
        saveLogDetail("删除地区id：" + id);
        areaService.delete(id);
        return JsonUtil.toJSONString(ActionUtil.getAjaxToMap("200", "delete menu success", "area_list", "", "", ""));
    }
}
