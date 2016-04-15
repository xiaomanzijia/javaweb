package com.lsgx.admin.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lsgx.admin.mapper.ActionUserMapper;
import com.lsgx.admin.mapper.UsertestMapper;
import com.lsgx.admin.model.ActionUser;
import com.lsgx.admin.model.Usertest;
import com.lsgx.admin.model.UsertestExample;
import com.lsgx.admin.model.vo.ActionUserVO;
import com.lsgx.admin.model.vo.UserTestVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.List;


/**
 *  用户登录服务层 service
 * @author dell
 */
@Service("userTestService")
public class UserTestService {
	
	@Autowired
	private UsertestMapper usertestMapper;
	
	/**
	 * 查找UserTest
	 * @param userName 登录名
	 * @return
	 */
	public List<Usertest> queryUserTest(String userName){

        UsertestExample ue=new UsertestExample();
        ue.createCriteria().andUsernameLike(userName);
		return usertestMapper.selectByExample(ue);
	}

    /**
     * 用户信息修改保存
     * @param u
     */
    public void userEditOk(Usertest u){
        usertestMapper.userEditOk(u);
    }

    /**
     * 用户信息修改bfileID
     * @param u
     */
    public void userEditBfileId(Usertest u){
        usertestMapper.userEditBfileId(u);
    }

	/**
	 * 通过id查询
	 * @param id
	 */
	public Usertest queryById(int id){
		return usertestMapper.selectByPrimaryKey(id);
	}

    public   int deleteByPrimaryKey(Integer id){
        return usertestMapper.deleteByPrimaryKey(id);
    }
	
	/**
	 * 用户列表查询
	 * @return 用户列表信息
	 */
    public List<Usertest> queryUserTestList(UserTestVO vo)
    {
        PageHelper.startPage(vo.getPageNum(), vo.getNumPerPage());
        return usertestMapper.queryUserTestList(vo);
	}

	/**
	 * 用户列表总数查询
	 * @return 用户列表总条数
	 */
	public int queryUserTestListCount(Page<Usertest> page){
		return usertestMapper.queryUserTestListCount(page);
	}

	/**
	 * 用户信息添加
	 * @param u
	 */
    @Transactional
	public void saveUsertest(Usertest u){
//        try {
            usertestMapper.insert(u);
           // Usertest usertest=new Usertest();
//        usertest.setUsername(null);
//        usertest.setAddress("nullddd");
//            usertestMapper.insert(usertest);

//        } catch (Exception e) {
//
//                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
//                //就是这一句了，加上之后，如果doDbStuff2()抛了异常,                                                                                       //doDbStuff1()是会回滚的
//
//
//        }
    }

    @Transactional
	public void saveUsertestError(Usertest u)  {
//        try {
            usertestMapper.insert(u);
           // Usertest usertest=new Usertest();
//        usertest.setUsername(null);
//        usertest.setAddress("nullddd");
//            usertestMapper.insert(usertest);
           throw new RuntimeException("for test");
//        } catch (Exception e) {
//
//                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
//                //就是这一句了，加上之后，如果doDbStuff2()抛了异常,                                                                                       //doDbStuff1()是会回滚的
//
//
//        }
    }


    @Transactional
    public void saveUsertestExceptionError(Usertest u) throws Exception {
//        try {
        usertestMapper.insert(u);
        // Usertest usertest=new Usertest();
//        usertest.setUsername(null);
//        usertest.setAddress("nullddd");
//            usertestMapper.insert(usertest);
        throw new Exception("for test");
//        } catch (Exception e) {
//
//                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
//                //就是这一句了，加上之后，如果doDbStuff2()抛了异常,                                                                                       //doDbStuff1()是会回滚的
//
//
//        }
    }
    @Transactional
    public void saveErrorTransactionalUserTest(Usertest u)  {
        try {
            saveUsertest(u);
            saveUsertestError(u);
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
    }
    @Transactional
    public void saveErrorTransactionalUserTestWithException(Usertest u)  {
        try {
            saveUsertest(u);
            saveUsertestExceptionError(u);
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
    }
    @Transactional
    public void saveErrorTransactionalUserTest2(Usertest u) throws Exception {

            saveUsertest(u);

            saveUsertestError(u);

    }
//
//	/**
//	 * 用户信息修改
//	 * @param id
//	 * @return ActionUser
//	 */
//	public ActionUser userEdit(int id){
//		return actionUserMapper.userEdit(id);
//	}
//
//	/**
//	 * 用户信息修改保存
//	 * @param u
//	 */
//	public void userEditOk(ActionUser u){
//		actionUserMapper.userEditOk(u);
//	}
//
//	/**
//	 * 用户信息删除
//	 * @param id
//	 */
//	public void userDelete(int id){
//		actionUserMapper.userDelete(id);
//	}
//
//	/**
//	 * 分配用户查询
//	 * @return
//	 */
//	public List<ActionUser> selectRoleUserList(int createname){
//		return actionUserMapper.selectRoleUserList(createname);
//	}
//
//	/**
//	 * 用户初始化密码
//	 * @param u
//	 */
//	public void userInit(ActionUser u){
//		actionUserMapper.userInit(u);
//	}
//
//	/**
//	 * 用户修改状态
//	 * @param u
//	 */
//	public void userStatus(ActionUser u){
//        if (u.getStatus() == 100)
//        {
//            u.setStatus(101);
//        }
//        else if (u.getStatus() == 101)
//        {
//            u.setStatus(100);
//		}
//		actionUserMapper.userStatus(u);
//	}
//

}
