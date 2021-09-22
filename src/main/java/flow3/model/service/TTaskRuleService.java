package flow3.model.service;

import flow3.model.dao.TTaskRuleMapper;
import flow3.model.entity.TTaskRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TTaskRuleService {

    @Autowired
    private TTaskRuleMapper tTaskRuleMapper;

    /**
     * 查询所有记录
     *
     * @return 返回集合，没有返回空List
     */
    public List<TTaskRule> listAll() {
    	return tTaskRuleMapper.listAll();
    }


    /**
     * 根据TaskId查询
     *
     * @param taskId 主键
     * @return 返回记录，没有返回null
     */
    public List<TTaskRule> getByTaskId(Integer taskId) {
        return tTaskRuleMapper.getByTaskId(taskId);
    }


    /**
     * 根据主键查询
     *
     * @param id 主键
     * @return 返回记录，没有返回null
     */
    public TTaskRule getById(Integer id) {
    	return tTaskRuleMapper.getById(id);
    }


    /**
     * 新增，插入所有字段
     *
     * @param tTaskRule 新增的记录
     * @return 返回影响行数
     */
    public int insert(TTaskRule tTaskRule) {
    	return tTaskRuleMapper.insert(tTaskRule);
    }
	
    /**
     * 新增，忽略null字段
     *
     * @param tTaskRule 新增的记录
     * @return 返回影响行数
     */
    public int insertIgnoreNull(TTaskRule tTaskRule) {
    	return tTaskRuleMapper.insertIgnoreNull(tTaskRule);
    }
	
    /**
     * 修改，修改所有字段
     *
     * @param tTaskRule 修改的记录
     * @return 返回影响行数
     */
    public int update(TTaskRule tTaskRule) {
    	return tTaskRuleMapper.update(tTaskRule);
    }
	
    /**
     * 修改，忽略null字段
     *
     * @param tTaskRule 修改的记录
     * @return 返回影响行数
     */
    public int updateIgnoreNull(TTaskRule tTaskRule) {
    	return tTaskRuleMapper.updateIgnoreNull(tTaskRule);
    }
	
    /**
     * 删除记录
     *
     * @param tTaskRule 待删除的记录
     * @return 返回影响行数
     */
    public int delete(TTaskRule tTaskRule) {
    	return tTaskRuleMapper.delete(tTaskRule);
    }
	
}