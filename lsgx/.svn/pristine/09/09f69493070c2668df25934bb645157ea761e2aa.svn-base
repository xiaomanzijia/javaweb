package com.lsgx.admin.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.lsgx.admin.model.ActionFunction;
import com.lsgx.admin.model.ActionUser;
import com.lsgx.admin.service.ActionFunctionService;

@Controller
public class MainController extends BaseController
{
    @Autowired
    private ActionFunctionService actionFunctionService;
    
    public String listMenu(ActionUser user)
    {
        StringBuffer menu = new StringBuffer();//总菜单的html代码容器
        //AccordionMenu sysApp = new AccordionMenu("","");//滑动菜单项html代码容器

        List<ActionFunction> af = actionFunctionService.indexList(user);

        List<ActionFunction> actionList = new ArrayList<ActionFunction>();
        for (ActionFunction tmp : af)
        {
            if (tmp.getParentFun() == 0)
            {
                actionList.add(tmp);
            }
            for (ActionFunction tmpp : af)
            {
                if (tmp.getId() == tmpp.getParentFun())
                {
                    if (tmp.getActionFunctionlist() == null)
                    {
                        tmp.setActionFunctionlist(new ArrayList<ActionFunction>());
                    }
                    tmp.getActionFunctionlist().add(tmpp);
                }
            }
        }
        menu.append(this.getRoleStr(actionList, new StringBuffer()));
        return menu.toString();
        
        //        List<ActionFunction> actionList = new ArrayList<ActionFunction>();
        //        List<ActionFunction> sbList = new ArrayList<ActionFunction>();
        //        ActionFunction af1 = new ActionFunction();
        //        af1.setFunName("管理");
        //        af1.setParentFun(0);
        //        af1.setId(1);
        //        af1.setActionFunctionlist(sbList);
        //        
        //        ActionFunction af2 = new ActionFunction();
        //        af.setFunName("管理");
        //        af.setParentFun(0);
        //        af.setId(1);
        //        af.setActionFunctionlist(sbList);
        //        
        //        ActionFunction af22 = new ActionFunction();
        //        af2.setFunName("爱心团");
        //        af2.setParentFun(1);
        //        af2.setId(2);
        //        sbList.add(af2);
        //
        //        actionList.add(af);

        //        return this.getRoleStr(actionList, new StringBuffer());
    }

    public String getRoleStr(List<ActionFunction> actionList, StringBuffer sb)
    {
        for (ActionFunction tmp : actionList)
        {
            String actionName = tmp.getFunName();
            if (tmp.getParentFun() == 0)
            {
                sb.append("<div class=\"accordionHeader\"><h2><span>Folder</span>");
                sb.append(actionName);
                sb.append("</h2></div><div class=\"accordionContent\"><ul class=\"tree treeFolder\">");

                if (tmp.getActionFunctionlist() != null)
                {
                    this.getRoleStr(tmp.getActionFunctionlist(), sb);
                }

                sb.append("</ul></div>");
            }
            else
            {
                String target = tmp.getTarget();
                if (StringUtils.isEmpty(target))
                {
                    sb.append("<li><a>").append(actionName).append("</a>");
                }
                else
                {
                    sb.append("<li><a target=\"");
                    sb.append(target).append("\" href=\"");
                    sb.append(tmp.getAction());
                    sb.append("\" ");

                    String rel = tmp.getRel();
                    if (!StringUtils.isEmpty(rel))
                    {
                        sb.append("rel=\"").append(rel).append("\" ");
                    }

                    sb.append(" >").append(actionName).append("</a>");
                }

                if (tmp.getActionFunctionlist() != null)
                {
                    sb.append("<ul>");
                    this.getRoleStr(tmp.getActionFunctionlist(), sb);
                    sb.append("</ul>");
                }
            }
        }
        return sb.toString();
    }
    
    /**
     * 处理菜单显示
     * @param actionList
     * @param sb
     * @return
    //	 */
    //	public String getRoleStr(List<ActionFunction> actionList, StringBuffer sb) {
    //		for (ActionFunction tmp : actionList) {
    //			// 判断是否是母类ID为0 如果是 则为最上级版块
    //			String actionName = tmp.getFunName();
    //			if (tmp.getParentFun() == 0) {
    //				sb.append("<div class=\"accordionHeader\"><h2><span>Folder</span>")
    //						.append(actionName)
    //						.append("</h2></div><div class=\"accordionContent\"><ul class=\"tree treeFolder\">");
    //				if (tmp.getActionFunctionlist() != null) {
    //					this.getRoleStr(tmp.getActionFunctionlist(), sb);
    //				}
    //				sb.append("</ul></div>");
    //			} else {
    //				String target = tmp.getTarget();
    //				if (StringUtils.isEmpty(target)) {
    //					sb.append("<li><a>").append(actionName).append("</a>");
    //				} else {
    //					sb.append("<li><a target=\"").append(target).append("\" href=\"").append(tmp.getAction()).append("\" ");
    //					String rel = tmp.getRel();
    //					if (!StringUtils.isEmpty(rel)) {
    //						sb.append("rel=\"").append(rel).append("\" ");
    //					}
    //					sb.append(" >").append(actionName).append("</a>");
    //				}
    //				if (tmp.getActionFunctionlist() != null) {
    //					sb.append("<ul>");
    //					this.getRoleStr(tmp.getActionFunctionlist(), sb);
    //					sb.append("</ul>");
    //				}
    //			}
    //		}
    //		return sb.toString();
    //	}
    /**
     * 获取用户角色菜单按钮权限
     * @param action
     * @return
     */
    public List<ActionFunction> getUserActionFunctionList(ActionUser user)
    {
        //获取角色菜单权限
        List<ActionFunction> funList = actionFunctionService.functionUserList(user);
        return funList;
    }
}
