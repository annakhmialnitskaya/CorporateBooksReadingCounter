package com.htp.library.dao;

import com.htp.library.domain.Entity;

public interface EntityDao {

	void create(Entity entity) throws LibraryDaoException;

	Entity getById(int id) throws LibraryDaoException;

	void update(Entity entity) throws LibraryDaoException;

	void deleteById(int id) throws LibraryDaoException;
}
