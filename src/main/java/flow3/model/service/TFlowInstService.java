package flow3.model.service;

import flow3.model.dao.TFlowInstMapper;
import flow3.model.entity.TFlowInst;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TFlowInstService {

    @Autowired
    private TFlowInstMapper tFlowInstMapper;

    /**
     * 查询所有记录
     *
     * @return 返回集合，没有返回空List
     */
    public List<TFlowInst> listAll() {
    	return tFlowInstMapper.listAll();
    }


    /**
     * 根据主键查询
     *
     * @param id 主键
     * @return 返回记录，没有返回null
     */
    public TFlowInst getById(Integer id) {
    	return tFlowInstMapper.getById(id);
    }
	
    /**
     * 新增，插入所有字段
     *
     * @param tFlowInst 新增的记录
     * @return 返回影响行数
     */
    public int insert(TFlowInst tFlowInst) {
    	return tFlowInstMapper.insert(tFlowInst);
    }
	
    /**
     * 新增，忽略null字段
     *
     * @param tFlowInst 新增的记录
     * @return 返回影响行数
     */
    public int insertIgnoreNull(TFlowInst tFlowInst) {
    	return tFlowInstMapper.insertIgnoreNull(tFlowInst);
    }
	
    /**
     * 修改，修改所有字段
     *
     * @param tFlowInst 修改的记录
     * @return 返回影响行数
     */
    public int update(TFlowInst tFlowInst) {
    	return tFlowInstMapper.update(tFlowInst);
    }
	
    /**
     * 修改，忽略null字段
     *
     * @param tFlowInst 修改的记录
     * @return 返回影响行数
     */
    public int updateIgnoreNull(TFlowInst tFlowInst) {
    	return tFlowInstMapper.updateIgnoreNull(tFlowInst);
    }
	
    /**
     * 删除记录
     *
     * @param tFlowInst 待删除的记录
     * @return 返回影响行数
     */
    public int delete(TFlowInst tFlowInst) {
    	return tFlowInstMapper.delete(tFlowInst);
    }
	
}