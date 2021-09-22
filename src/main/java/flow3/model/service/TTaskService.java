package flow3.model.service;

import flow3.model.dao.TTaskMapper;
import flow3.model.entity.TTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TTaskService {

    @Autowired
    private TTaskMapper tTaskMapper;

    /**
     * 查询所有记录
     *
     * @return 返回集合，没有返回空List
     */
    public List<TTask> listAll() {
    	return tTaskMapper.listAll();
    }


    /**
     * 根据主键查询
     *
     * @param id 主键
     * @return 返回记录，没有返回null
     */
    public TTask getById(Integer id) {
    	return tTaskMapper.getById(id);
    }
	
    /**
     * 新增，插入所有字段
     *
     * @param tTask 新增的记录
     * @return 返回影响行数
     */
    public int insert(TTask tTask) {
    	return tTaskMapper.insert(tTask);
    }
	
    /**
     * 新增，忽略null字段
     *
     * @param tTask 新增的记录
     * @return 返回影响行数
     */
    public int insertIgnoreNull(TTask tTask) {
    	return tTaskMapper.insertIgnoreNull(tTask);
    }
	
    /**
     * 修改，修改所有字段
     *
     * @param tTask 修改的记录
     * @return 返回影响行数
     */
    public int update(TTask tTask) {
    	return tTaskMapper.update(tTask);
    }
	
    /**
     * 修改，忽略null字段
     *
     * @param tTask 修改的记录
     * @return 返回影响行数
     */
    public int updateIgnoreNull(TTask tTask) {
    	return tTaskMapper.updateIgnoreNull(tTask);
    }
	
    /**
     * 删除记录
     *
     * @param tTask 待删除的记录
     * @return 返回影响行数
     */
    public int delete(TTask tTask) {
    	return tTaskMapper.delete(tTask);
    }
	
}