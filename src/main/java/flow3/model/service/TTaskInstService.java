package flow3.model.service;

import flow3.model.dao.TTaskInstMapper;
import flow3.model.entity.TTaskInst;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TTaskInstService {

    @Autowired
    private TTaskInstMapper tTaskInstMapper;

    /**
     * 查询所有记录
     *
     * @return 返回集合，没有返回空List
     */
    public List<TTaskInst> listAll() {
    	return tTaskInstMapper.listAll();
    }


    /**
     * 根据主键查询
     *
     * @param id 主键
     * @return 返回记录，没有返回null
     */
    public TTaskInst getById(Integer id) {
    	return tTaskInstMapper.getById(id);
    }


    /**
     * 根据主键查询
     *
     * @param flowInstId flowInst的ID
     * @return 返回记录，没有返回null
     */
    public List<TTaskInst> getByFlowInstId(Integer flowInstId) {
        return tTaskInstMapper.getByFlowInstId(flowInstId);
    }


    /**
     * 新增，插入所有字段
     *
     * @param tTaskInst 新增的记录
     * @return 返回影响行数
     */
    public int insert(TTaskInst tTaskInst) {
    	return tTaskInstMapper.insert(tTaskInst);
    }
	
    /**
     * 新增，忽略null字段
     *
     * @param tTaskInst 新增的记录
     * @return 返回影响行数
     */
    public int insertIgnoreNull(TTaskInst tTaskInst) {
    	return tTaskInstMapper.insertIgnoreNull(tTaskInst);
    }
	
    /**
     * 修改，修改所有字段
     *
     * @param tTaskInst 修改的记录
     * @return 返回影响行数
     */
    public int update(TTaskInst tTaskInst) {
    	return tTaskInstMapper.update(tTaskInst);
    }
	
    /**
     * 修改，忽略null字段
     *
     * @param tTaskInst 修改的记录
     * @return 返回影响行数
     */
    public int updateIgnoreNull(TTaskInst tTaskInst) {
    	return tTaskInstMapper.updateIgnoreNull(tTaskInst);
    }
	
    /**
     * 删除记录
     *
     * @param tTaskInst 待删除的记录
     * @return 返回影响行数
     */
    public int delete(TTaskInst tTaskInst) {
    	return tTaskInstMapper.delete(tTaskInst);
    }
	
}