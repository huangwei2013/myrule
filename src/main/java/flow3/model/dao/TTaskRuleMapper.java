package flow3.model.dao;

import flow3.model.entity.TTaskRule;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TTaskRuleMapper {

	/**
     * 查询所有记录
     *
     * @return 返回集合，没有返回空List
     */
	List<TTaskRule> listAll();

	/**
	 * 根据taskId查询
	 *
	 * @param taskId 主键
	 * @return 返回记录，没有返回null
	 */
	List<TTaskRule> getByTaskId(Integer taskId);

	/**
     * 根据主键查询
     *
     * @param id 主键
     * @return 返回记录，没有返回null
     */
	TTaskRule getById(Integer id);
	
	/**
     * 新增，插入所有字段
     *
     * @param tTaskRule 新增的记录
     * @return 返回影响行数
     */
	int insert(TTaskRule tTaskRule);
	
	/**
     * 新增，忽略null字段
     *
     * @param tTaskRule 新增的记录
     * @return 返回影响行数
     */
	int insertIgnoreNull(TTaskRule tTaskRule);
	
	/**
     * 修改，修改所有字段
     *
     * @param tTaskRule 修改的记录
     * @return 返回影响行数
     */
	int update(TTaskRule tTaskRule);
	
	/**
     * 修改，忽略null字段
     *
     * @param tTaskRule 修改的记录
     * @return 返回影响行数
     */
	int updateIgnoreNull(TTaskRule tTaskRule);
	
	/**
     * 删除记录
     *
     * @param tTaskRule 待删除的记录
     * @return 返回影响行数
     */
	int delete(TTaskRule tTaskRule);
	
}