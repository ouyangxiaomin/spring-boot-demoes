package com.mark.demo.security.repository;

import java.util.List;

import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.mark.demo.security.entity.Menu;

/*
*hxp(hxpwangyi@126.com)
*2017年10月7日
*
*/
public interface MenuRepository extends PagingAndSortingRepository<Menu, Integer> {
	@Query("select * from menu where pid=-1")
	List<Menu> getMenuTopLever();
	@Query("select * from menu where pid=0?")
	List<Menu> getMenuChildren(int pid);
	@Query("update menu set menuName=?0.menuName,menuDesc=?0.menuDesc,link=?0.link where id=?0.id")
	void updateMenu(Menu menu);
}
