package com.lsgx.admin.controller;

import com.alipay.config.AlipayConfig;
import com.alipay.util.AlipayNotify;
import com.alipay.util.AlipaySubmit;
import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.lsgx.admin.annotation.Anonymous;
import com.lsgx.admin.constants.SystemConstants;
import com.lsgx.admin.model.AlipayTrade;
import com.lsgx.admin.model.AlipayTradeExample;
import com.lsgx.admin.model.Article;
import com.lsgx.admin.model.vo.AlipayTradeVO;
import com.lsgx.admin.model.vo.ArticleVO;
import com.lsgx.admin.model.vo.NewsVO;
import com.lsgx.admin.service.AlipayTradeService;
import com.lsgx.admin.service.ArticleService;
import com.lsgx.admin.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.util.*;

/**
 * 支付宝申请接口
 */

@Controller
@Anonymous
public class AlipayController extends BaseController
{

    @Autowired
    private AlipayTradeService alipayTradeService;
    /**
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/Alipay.do",method = RequestMethod.POST,produces = "application/json")
    public String index(HttpServletRequest request,HttpServletResponse response,ModelMap model) throws Exception{
        String result = "";
        Date date = new Date();
        // 支付类型
        // 必填，不能修改
        String payment_type = "1";
        // 服务器异步通知页面路径
        // 需http://格式的完整路径，不能加?id=123这类自定义参数
        String notify_url = "http://"+ SystemConstants.HOST+"/async.do";
        // 页面跳转同步通知页面路径
        // 需http://格式的完整路径，不能加?id=123这类自定义参数，不能写成http://localhost/
        String return_url = "http://"+SystemConstants.HOST+"/return_url.do";
        // 商户订单号.
        // 商户网站订单系统中唯一订单号，必填
        //String out_trade_no = date.getTime() + "";
        // 订单名称
        // 必填
        String subject = "绿色环保爱心捐赠";
        // 防钓鱼时间戳
        // 若要使用请调用类文件submit中的query_timestamp函数
        String anti_phishing_key = "";
        // 客户端的IP地址
        // 非局域网的外网IP地址，如：221.0.0.1
        String exter_invoke_ip = "";


        String total_fee = ServletRequestUtils.getStringParameter(request, "amount","");
        String type = ServletRequestUtils.getStringParameter(request, "type","");

        String body = ServletRequestUtils.getStringParameter(request, "body","test");
        //商品展示地址
        String show_url = ServletRequestUtils.getStringParameter(request, "show_url", "http://www.elve.cn");
        //需以http://开头的完整路径，例如：http://www.xxx.com/myorder.html




        Map<String, String> sParaTemp = new HashMap<String, String>();
        sParaTemp.put("service", "create_direct_pay_by_user");//接口服务----即时到账
        sParaTemp.put("partner", AlipayConfig.partner);//支付宝PID
        sParaTemp.put("_input_charset", AlipayConfig.input_charset);//统一编码
        sParaTemp.put("payment_type", payment_type);//支付类型
        sParaTemp.put("notify_url", notify_url);//异步通知页面
        sParaTemp.put("return_url", return_url);//页面跳转同步通知页面
        sParaTemp.put("seller_email", AlipayConfig.seller_email);//卖家支付宝账号
        String trade_no = date.getTime() + payment_type;
        sParaTemp.put("out_trade_no", trade_no);//商品订单编号
        sParaTemp.put("subject", subject);//商品名称
        sParaTemp.put("total_fee", total_fee);//价格
//        sParaTemp.put("body", body);
//        sParaTemp.put("show_url", show_url);
        sParaTemp.put("anti_phishing_key", anti_phishing_key);
        sParaTemp.put("exter_invoke_ip", exter_invoke_ip);


        double val = 0;
        try {//这里做一个金额的校验
            val = Double.parseDouble(total_fee);
        } catch (NumberFormatException e) {
            model.put("msg", "捐助金额无效");
            model.put("amount",total_fee);
            return "/web/index";
        }

        AlipayTrade at=new AlipayTrade();
        at.setAmount(BigDecimal.valueOf(val));
        at.setCreatetime(new Date());
        at.setDtype(type);
        at.setTradeno(trade_no);
        at.setState("start");

        //建立请求
        try {
            String sHtmlText = AlipaySubmit.buildRequest(sParaTemp, "post", "确认");
            Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
            String s = gson.toJson(sHtmlText);
            model.addAttribute("sHtmlText", s);
            request.setAttribute("sHtmlText", s);
            result = "{\"success\":true,\"msg\":\"跳转成功\"}";
            alipayTradeService.insert(at);
            StringUtil.writeToWeb(sHtmlText, "html", response);

            return null;
        } catch (Exception e) {
            if(logger.isDebugEnabled()){
                logger.debug("AlipayController支付错误");
            }
            result = "{\"success\":false,\"msg\":\"跳转失败，请稍候再试！\"}";
            at.setState("starterror");
            alipayTradeService.insert(at);
            StringUtil.writeToWeb(result, "html", response);

            return null;
        }



    }


    /**
     * 同步通知的页面的Controller
     * @param request
     * @param response
     * @return
     * @author lyj
     */
    @RequestMapping(value="/return_url.do")
    public String Return_url(HttpServletRequest request,HttpServletResponse response){
        Map<String,String> params = new HashMap<String,String>();
        Map requestParams = request.getParameterMap();
        for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext();) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i]: valueStr + values[i] + ",";
            }
            params.put(name, valueStr);
        }
        String tradeNo = request.getParameter("out_trade_no");
        String tradeStatus = request.getParameter("trade_status");
        //String notifyId = request.getParameter("notify_id");
        if(AlipayNotify.verify(params)){//验证成功
            if(tradeStatus.equals("TRADE_FINISHED") || tradeStatus.equals("TRADE_SUCCESS")) {
                //要写的逻辑。自己按自己的要求写
                logger.error("ok.......");
                System.out.println(">>>>>充值成功" + tradeNo);
                AlipayTradeExample ate=new AlipayTradeExample();
                ate.createCriteria().andTradenoEqualTo(tradeNo);
                List<AlipayTrade> list=   alipayTradeService.selectByExample(ate);
                System.out.println("list.size() = " + list.size());
                if(list.size()>0){
                    AlipayTrade at=list.get(0);
                    at.setState("TRADE_SUCCESS");
                    at.setUpdatetime(new Date());
                    alipayTradeService.updateByPrimaryKeySelective(at);
                }
            }
            return "web/success";
        }else{//验证失败
            return "web/fail";
        }
    }
    /**
     * 异步通知付款状态的Controller
     * @param request
     * @param response
     * @return
     * @author lyj
     */
    @RequestMapping(value="/async.do")
    public String async(HttpServletRequest request,
                        HttpServletResponse response){
        Map<String,String> params = new HashMap<String,String>();
        Map requestParams = request.getParameterMap();
        for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext();) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i]: valueStr + values[i] + ",";
            }
            params.put(name, valueStr);
        }
        String tradeNo = request.getParameter("out_trade_no");
        String tradeStatus = request.getParameter("trade_status");
        //String notifyId = request.getParameter("notify_id");
        if(AlipayNotify.verify(params)){//验证成功
            if(tradeStatus.equals("TRADE_FINISHED") || tradeStatus.equals("TRADE_SUCCESS")) {
                //要写的逻辑。自己按自己的要求写
                logger.error("ok.......");
                System.out.println(">>>>>充值成功" + tradeNo);
                AlipayTradeExample ate=new AlipayTradeExample();
                ate.createCriteria().andTradenoEqualTo(tradeNo);
                List<AlipayTrade> list=   alipayTradeService.selectByExample(ate);
                System.out.println("list.size() = " + list.size());
                if(list.size()>0){
                    AlipayTrade at=list.get(0);
                    at.setState("TRADE_SUCCESS");
                    at.setUpdatetime(new Date());
                    alipayTradeService.updateByPrimaryKeySelective(at);
                }
            }
            return "web/success";
        }else{//验证失败
            return "web/fail";
        }

    }

    /**
     * 捐款交易记录查询
     */
    @RequestMapping("/alipaytradelist")
    public String alipayorderlist(AlipayTradeVO tradeVO,ModelMap model){
        List<AlipayTradeVO> tradeList = alipayTradeService.queryAlipayTradeListVo(tradeVO);
        PageInfo<AlipayTradeVO> page = new PageInfo<AlipayTradeVO>(tradeList);
        model.put("page", page);
        model.put("trade", tradeList);
        return "/alipay/alipay_list";
    }
}
