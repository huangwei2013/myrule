package flow3.model.service;

import flow3.model.dao.TFlowMapper;
import flow3.model.entity.TFlow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TFlowService {

    @Autowired
    TFlowMapper tFlowMapper;

    /**
     * 查询所有记录
     *
     * @return 返回集合，没有返回空List
     */
    public List<TFlow> listAll() {
    	return tFlowMapper.listAll();
    }


    /**
     * 根据主键查询
     *
     * @param id 主键
     * @return 返回记录，没有返回null
     */
    public TFlow getById(Integer id) {
    	return tFlowMapper.getById(id);
    }
	
    /**
     * 新增，插入所有字段
     *
     * @param tFlow 新增的记录
     * @return 返回影响行数
     */
    public int insert(TFlow tFlow) {
    	return tFlowMapper.insert(tFlow);
    }
	
    /**
     * 新增，忽略null字段
     *
     * @param tFlow 新增的记录
     * @return 返回影响行数
     */
    public int insertIgnoreNull(TFlow tFlow) {
    	return tFlowMapper.insertIgnoreNull(tFlow);
    }
	
    /**
     * 修改，修改所有字段
     *
     * @param tFlow 修改的记录
     * @return 返回影响行数
     */
    public int update(TFlow tFlow) {
    	return tFlowMapper.update(tFlow);
    }
	
    /**
     * 修改，忽略null字段
     *
     * @param tFlow 修改的记录
     * @return 返回影响行数
     */
    public int updateIgnoreNull(TFlow tFlow) {
    	return tFlowMapper.updateIgnoreNull(tFlow);
    }
	
    /**
     * 删除记录
     *
     * @param tFlow 待删除的记录
     * @return 返回影响行数
     */
    public int delete(TFlow tFlow) {
    	return tFlowMapper.delete(tFlow);
    }
	
}