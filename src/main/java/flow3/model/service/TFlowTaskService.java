package flow3.model.service;


import flow3.model.dao.TFlowTaskMapper;
import flow3.model.entity.TFlowTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TFlowTaskService {

    @Autowired
    private TFlowTaskMapper tFlowTaskMapper;

    /**
     * 查询所有记录
     *
     * @return 返回集合，没有返回空List
     */
    public List<TFlowTask> listAll() {
    	return tFlowTaskMapper.listAll();
    }


    /**
     * 根据主键查询
     *
     * @param id 主键
     * @return 返回记录，没有返回null
     */
    public List<TFlowTask> getByFlowId(Integer flowId) {
    	return tFlowTaskMapper.getByFlowId(flowId);
    }
	
    /**
     * 新增，插入所有字段
     *
     * @param tFlowTask 新增的记录
     * @return 返回影响行数
     */
    public int insert(TFlowTask tFlowTask) {
    	return tFlowTaskMapper.insert(tFlowTask);
    }
	
    /**
     * 新增，忽略null字段
     *
     * @param tFlowTask 新增的记录
     * @return 返回影响行数
     */
    public int insertIgnoreNull(TFlowTask tFlowTask) {
    	return tFlowTaskMapper.insertIgnoreNull(tFlowTask);
    }
	
    /**
     * 修改，修改所有字段
     *
     * @param tFlowTask 修改的记录
     * @return 返回影响行数
     */
    public int update(TFlowTask tFlowTask) {
    	return tFlowTaskMapper.update(tFlowTask);
    }
	
    /**
     * 修改，忽略null字段
     *
     * @param tFlowTask 修改的记录
     * @return 返回影响行数
     */
    public int updateIgnoreNull(TFlowTask tFlowTask) {
    	return tFlowTaskMapper.updateIgnoreNull(tFlowTask);
    }
	
    /**
     * 删除记录
     *
     * @param tFlowTask 待删除的记录
     * @return 返回影响行数
     */
    public int delete(TFlowTask tFlowTask) {
    	return tFlowTaskMapper.delete(tFlowTask);
    }
	
}