package flow3.model.dao;

import flow3.model.entity.TTaskInst;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TTaskInstMapper {

	/**
     * 查询所有记录
     *
     * @return 返回集合，没有返回空List
     */
	List<TTaskInst> listAll();


	/**
     * 根据主键查询
     *
     * @param id 主键
     * @return 返回记录，没有返回null
     */
	TTaskInst getById(Integer id);
	
	/**
     * 新增，插入所有字段
     *
     * @param tTaskInst 新增的记录
     * @return 返回影响行数
     */
	int insert(TTaskInst tTaskInst);
	
	/**
     * 新增，忽略null字段
     *
     * @param tTaskInst 新增的记录
     * @return 返回影响行数
     */
	int insertIgnoreNull(TTaskInst tTaskInst);
	
	/**
     * 修改，修改所有字段
     *
     * @param tTaskInst 修改的记录
     * @return 返回影响行数
     */
	int update(TTaskInst tTaskInst);
	
	/**
     * 修改，忽略null字段
     *
     * @param tTaskInst 修改的记录
     * @return 返回影响行数
     */
	int updateIgnoreNull(TTaskInst tTaskInst);
	
	/**
     * 删除记录
     *
     * @param tTaskInst 待删除的记录
     * @return 返回影响行数
     */
	int delete(TTaskInst tTaskInst);
	
}