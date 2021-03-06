package flow3.model.dao;

import flow3.model.entity.TFlowInst;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TFlowInstMapper {

	/**
     * 查询所有记录
     *
     * @return 返回集合，没有返回空List
     */
	List<TFlowInst> listAll();


	/**
     * 根据主键查询
     *
     * @param id 主键
     * @return 返回记录，没有返回null
     */
	TFlowInst getById(Integer id);
	
	/**
     * 新增，插入所有字段
     *
     * @param tFlowInst 新增的记录
     * @return 返回影响行数
     */
	int insert(TFlowInst tFlowInst);
	
	/**
     * 新增，忽略null字段
     *
     * @param tFlowInst 新增的记录
     * @return 返回影响行数
     */
	int insertIgnoreNull(TFlowInst tFlowInst);
	
	/**
     * 修改，修改所有字段
     *
     * @param tFlowInst 修改的记录
     * @return 返回影响行数
     */
	int update(TFlowInst tFlowInst);
	
	/**
     * 修改，忽略null字段
     *
     * @param tFlowInst 修改的记录
     * @return 返回影响行数
     */
	int updateIgnoreNull(TFlowInst tFlowInst);
	
	/**
     * 删除记录
     *
     * @param tFlowInst 待删除的记录
     * @return 返回影响行数
     */
	int delete(TFlowInst tFlowInst);
	
}