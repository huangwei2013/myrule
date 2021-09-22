package flow3.model.dao;

import java.util.List;

import flow3.model.entity.TFlowTask;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TFlowTaskMapper {

	/**
     * 查询所有记录
     *
     * @return 返回集合，没有返回空List
     */
	List<TFlowTask> listAll();


	/**
     * 根据主键查询
     *
     * @param id 主键
     * @return 返回记录，没有返回null
     */
	List<TFlowTask> getByFlowId(Integer flowId);
	
	/**
     * 新增，插入所有字段
     *
     * @param tFlowTask 新增的记录
     * @return 返回影响行数
     */
	int insert(TFlowTask tFlowTask);
	
	/**
     * 新增，忽略null字段
     *
     * @param tFlowTask 新增的记录
     * @return 返回影响行数
     */
	int insertIgnoreNull(TFlowTask tFlowTask);
	
	/**
     * 修改，修改所有字段
     *
     * @param tFlowTask 修改的记录
     * @return 返回影响行数
     */
	int update(TFlowTask tFlowTask);
	
	/**
     * 修改，忽略null字段
     *
     * @param tFlowTask 修改的记录
     * @return 返回影响行数
     */
	int updateIgnoreNull(TFlowTask tFlowTask);
	
	/**
     * 删除记录
     *
     * @param tFlowTask 待删除的记录
     * @return 返回影响行数
     */
	int delete(TFlowTask tFlowTask);
	
}