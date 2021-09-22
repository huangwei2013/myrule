package flow3.model.dao;

import flow3.model.entity.TTask;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TTaskMapper {

	/**
     * 查询所有记录
     *
     * @return 返回集合，没有返回空List
     */
	List<TTask> listAll();


	/**
     * 根据主键查询
     *
     * @param id 主键
     * @return 返回记录，没有返回null
     */
	TTask getById(Integer id);
	
	/**
     * 新增，插入所有字段
     *
     * @param tTask 新增的记录
     * @return 返回影响行数
     */
	int insert(TTask tTask);
	
	/**
     * 新增，忽略null字段
     *
     * @param tTask 新增的记录
     * @return 返回影响行数
     */
	int insertIgnoreNull(TTask tTask);
	
	/**
     * 修改，修改所有字段
     *
     * @param tTask 修改的记录
     * @return 返回影响行数
     */
	int update(TTask tTask);
	
	/**
     * 修改，忽略null字段
     *
     * @param tTask 修改的记录
     * @return 返回影响行数
     */
	int updateIgnoreNull(TTask tTask);
	
	/**
     * 删除记录
     *
     * @param tTask 待删除的记录
     * @return 返回影响行数
     */
	int delete(TTask tTask);
	
}