package com.lsgx.admin.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.lsgx.admin.exception.BaseException;
import com.lsgx.admin.mapper.UserCardMapper;
import com.lsgx.admin.model.UserCard;
import com.lsgx.admin.model.vo.UserCardVO;
import com.lsgx.admin.util.ResultCode;

@Service
public class UserCardService
{
    protected Logger logger = Logger.getLogger(getClass());

    @Autowired
    private UserCardMapper userCardMapper;
    
    public List<UserCard> findByCondition(UserCardVO vo)
    {
        PageHelper.startPage(vo.getPageNum(), vo.getNumPerPage());
        
        return userCardMapper.queryByParam(vo);
    }
    
    public void saveUserCard(UserCard userCard)
        throws BaseException
    {
        try
        {
            UserCard card = new UserCard();
            if (userCard.getUserId() != null)
            {
                card.setUserId(userCard.getUserId());
            }
            List<UserCard> list = userCardMapper.queryByParam(card);
            if (list != null && list.size() >= 3)
            {
                throw new BaseException(ResultCode.tooManyCard);
            }
            card = new UserCard();
            card = userCardMapper.queryUserCardByCard(userCard.getCard(), userCard.getUserId());
            if (card != null)
            {
                throw new BaseException(ResultCode.hasBingding);
            }
            userCard.setUseState(100);
            userCard.setIsSelected(1);
            userCardMapper.save(userCard);
        }
        catch (BaseException e)
        {
            logger.error(e);
            throw e;
        }
        catch (Exception e)
        {
            logger.error(e);
            throw new BaseException(ResultCode.Error);
        }
    }
    /**
     * 更新
     */
    public int updateUserCard(UserCard userCard)
    {
        return userCardMapper.update(userCard);
    }
    
   /**
    * 通过卡号查询
    */
    public UserCard selectByCard(String card,Integer userId){
    	Map<String, Object> map = new HashMap<String,Object>();
    	map.put("card", card);
    	map.put("userId", userId);
    	return userCardMapper.selectByCard(map);
    }
    
    /**
     * 通过id查询
     */
    public UserCard queryById(Integer id){
    	return userCardMapper.queryById(id);
    }
    
    /**
     * 通过id删除
     */
    public int delete(Integer id){
    	return userCardMapper.delete(id);
    }
}
