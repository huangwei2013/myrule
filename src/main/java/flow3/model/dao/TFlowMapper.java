package flow3.model.dao;

import flow3.model.entity.TFlow;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TFlowMapper {

	/**
     * 查询所有记录
     *
     * @return 返回集合，没有返回空List
     */
	List<TFlow> listAll();


	/**
     * 根据主键查询
     *
     * @param id 主键
     * @return 返回记录，没有返回null
     */
	TFlow getById(Integer id);
	
	/**
     * 新增，插入所有字段
     *
     * @param tFlow 新增的记录
     * @return 返回影响行数
     */
	int insert(TFlow tFlow);
	
	/**
     * 新增，忽略null字段
     *
     * @param tFlow 新增的记录
     * @return 返回影响行数
     */
	int insertIgnoreNull(TFlow tFlow);
	
	/**
     * 修改，修改所有字段
     *
     * @param tFlow 修改的记录
     * @return 返回影响行数
     */
	int update(TFlow tFlow);
	
	/**
     * 修改，忽略null字段
     *
     * @param tFlow 修改的记录
     * @return 返回影响行数
     */
	int updateIgnoreNull(TFlow tFlow);
	
	/**
     * 删除记录
     *
     * @param tFlow 待删除的记录
     * @return 返回影响行数
     */
	int delete(TFlow tFlow);
	
}