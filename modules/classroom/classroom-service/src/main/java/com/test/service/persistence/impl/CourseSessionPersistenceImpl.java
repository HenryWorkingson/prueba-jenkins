/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.test.service.persistence.impl;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.ProxyUtil;

import com.test.exception.NoSuchCourseSessionException;
import com.test.model.CourseSession;
import com.test.model.CourseSessionTable;
import com.test.model.impl.CourseSessionImpl;
import com.test.model.impl.CourseSessionModelImpl;
import com.test.service.persistence.CourseSessionPersistence;
import com.test.service.persistence.CourseSessionUtil;
import com.test.service.persistence.impl.constants.vcPersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the course session service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = {CourseSessionPersistence.class, BasePersistence.class})
public class CourseSessionPersistenceImpl
	extends BasePersistenceImpl<CourseSession>
	implements CourseSessionPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>CourseSessionUtil</code> to access the course session persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		CourseSessionImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByCourseId;
	private FinderPath _finderPathWithoutPaginationFindByCourseId;
	private FinderPath _finderPathCountByCourseId;

	/**
	 * Returns all the course sessions where courseId = &#63;.
	 *
	 * @param courseId the course ID
	 * @return the matching course sessions
	 */
	@Override
	public List<CourseSession> findByCourseId(long courseId) {
		return findByCourseId(
			courseId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the course sessions where courseId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CourseSessionModelImpl</code>.
	 * </p>
	 *
	 * @param courseId the course ID
	 * @param start the lower bound of the range of course sessions
	 * @param end the upper bound of the range of course sessions (not inclusive)
	 * @return the range of matching course sessions
	 */
	@Override
	public List<CourseSession> findByCourseId(
		long courseId, int start, int end) {

		return findByCourseId(courseId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the course sessions where courseId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CourseSessionModelImpl</code>.
	 * </p>
	 *
	 * @param courseId the course ID
	 * @param start the lower bound of the range of course sessions
	 * @param end the upper bound of the range of course sessions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching course sessions
	 */
	@Override
	public List<CourseSession> findByCourseId(
		long courseId, int start, int end,
		OrderByComparator<CourseSession> orderByComparator) {

		return findByCourseId(courseId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the course sessions where courseId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CourseSessionModelImpl</code>.
	 * </p>
	 *
	 * @param courseId the course ID
	 * @param start the lower bound of the range of course sessions
	 * @param end the upper bound of the range of course sessions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching course sessions
	 */
	@Override
	public List<CourseSession> findByCourseId(
		long courseId, int start, int end,
		OrderByComparator<CourseSession> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByCourseId;
				finderArgs = new Object[] {courseId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByCourseId;
			finderArgs = new Object[] {courseId, start, end, orderByComparator};
		}

		List<CourseSession> list = null;

		if (useFinderCache) {
			list = (List<CourseSession>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (CourseSession courseSession : list) {
					if (courseId != courseSession.getCourseId()) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_COURSESESSION_WHERE);

			sb.append(_FINDER_COLUMN_COURSEID_COURSEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(CourseSessionModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(courseId);

				list = (List<CourseSession>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first course session in the ordered set where courseId = &#63;.
	 *
	 * @param courseId the course ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching course session
	 * @throws NoSuchCourseSessionException if a matching course session could not be found
	 */
	@Override
	public CourseSession findByCourseId_First(
			long courseId, OrderByComparator<CourseSession> orderByComparator)
		throws NoSuchCourseSessionException {

		CourseSession courseSession = fetchByCourseId_First(
			courseId, orderByComparator);

		if (courseSession != null) {
			return courseSession;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("courseId=");
		sb.append(courseId);

		sb.append("}");

		throw new NoSuchCourseSessionException(sb.toString());
	}

	/**
	 * Returns the first course session in the ordered set where courseId = &#63;.
	 *
	 * @param courseId the course ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching course session, or <code>null</code> if a matching course session could not be found
	 */
	@Override
	public CourseSession fetchByCourseId_First(
		long courseId, OrderByComparator<CourseSession> orderByComparator) {

		List<CourseSession> list = findByCourseId(
			courseId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last course session in the ordered set where courseId = &#63;.
	 *
	 * @param courseId the course ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching course session
	 * @throws NoSuchCourseSessionException if a matching course session could not be found
	 */
	@Override
	public CourseSession findByCourseId_Last(
			long courseId, OrderByComparator<CourseSession> orderByComparator)
		throws NoSuchCourseSessionException {

		CourseSession courseSession = fetchByCourseId_Last(
			courseId, orderByComparator);

		if (courseSession != null) {
			return courseSession;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("courseId=");
		sb.append(courseId);

		sb.append("}");

		throw new NoSuchCourseSessionException(sb.toString());
	}

	/**
	 * Returns the last course session in the ordered set where courseId = &#63;.
	 *
	 * @param courseId the course ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching course session, or <code>null</code> if a matching course session could not be found
	 */
	@Override
	public CourseSession fetchByCourseId_Last(
		long courseId, OrderByComparator<CourseSession> orderByComparator) {

		int count = countByCourseId(courseId);

		if (count == 0) {
			return null;
		}

		List<CourseSession> list = findByCourseId(
			courseId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the course sessions before and after the current course session in the ordered set where courseId = &#63;.
	 *
	 * @param courseSessionId the primary key of the current course session
	 * @param courseId the course ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next course session
	 * @throws NoSuchCourseSessionException if a course session with the primary key could not be found
	 */
	@Override
	public CourseSession[] findByCourseId_PrevAndNext(
			long courseSessionId, long courseId,
			OrderByComparator<CourseSession> orderByComparator)
		throws NoSuchCourseSessionException {

		CourseSession courseSession = findByPrimaryKey(courseSessionId);

		Session session = null;

		try {
			session = openSession();

			CourseSession[] array = new CourseSessionImpl[3];

			array[0] = getByCourseId_PrevAndNext(
				session, courseSession, courseId, orderByComparator, true);

			array[1] = courseSession;

			array[2] = getByCourseId_PrevAndNext(
				session, courseSession, courseId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected CourseSession getByCourseId_PrevAndNext(
		Session session, CourseSession courseSession, long courseId,
		OrderByComparator<CourseSession> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_COURSESESSION_WHERE);

		sb.append(_FINDER_COLUMN_COURSEID_COURSEID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(CourseSessionModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(courseId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						courseSession)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<CourseSession> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the course sessions where courseId = &#63; from the database.
	 *
	 * @param courseId the course ID
	 */
	@Override
	public void removeByCourseId(long courseId) {
		for (CourseSession courseSession :
				findByCourseId(
					courseId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(courseSession);
		}
	}

	/**
	 * Returns the number of course sessions where courseId = &#63;.
	 *
	 * @param courseId the course ID
	 * @return the number of matching course sessions
	 */
	@Override
	public int countByCourseId(long courseId) {
		FinderPath finderPath = _finderPathCountByCourseId;

		Object[] finderArgs = new Object[] {courseId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_COURSESESSION_WHERE);

			sb.append(_FINDER_COLUMN_COURSEID_COURSEID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(courseId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_COURSEID_COURSEID_2 =
		"courseSession.courseId = ?";

	public CourseSessionPersistenceImpl() {
		setModelClass(CourseSession.class);

		setModelImplClass(CourseSessionImpl.class);
		setModelPKClass(long.class);

		setTable(CourseSessionTable.INSTANCE);
	}

	/**
	 * Caches the course session in the entity cache if it is enabled.
	 *
	 * @param courseSession the course session
	 */
	@Override
	public void cacheResult(CourseSession courseSession) {
		entityCache.putResult(
			CourseSessionImpl.class, courseSession.getPrimaryKey(),
			courseSession);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the course sessions in the entity cache if it is enabled.
	 *
	 * @param courseSessions the course sessions
	 */
	@Override
	public void cacheResult(List<CourseSession> courseSessions) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (courseSessions.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (CourseSession courseSession : courseSessions) {
			if (entityCache.getResult(
					CourseSessionImpl.class, courseSession.getPrimaryKey()) ==
						null) {

				cacheResult(courseSession);
			}
		}
	}

	/**
	 * Clears the cache for all course sessions.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(CourseSessionImpl.class);

		finderCache.clearCache(CourseSessionImpl.class);
	}

	/**
	 * Clears the cache for the course session.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CourseSession courseSession) {
		entityCache.removeResult(CourseSessionImpl.class, courseSession);
	}

	@Override
	public void clearCache(List<CourseSession> courseSessions) {
		for (CourseSession courseSession : courseSessions) {
			entityCache.removeResult(CourseSessionImpl.class, courseSession);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(CourseSessionImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(CourseSessionImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new course session with the primary key. Does not add the course session to the database.
	 *
	 * @param courseSessionId the primary key for the new course session
	 * @return the new course session
	 */
	@Override
	public CourseSession create(long courseSessionId) {
		CourseSession courseSession = new CourseSessionImpl();

		courseSession.setNew(true);
		courseSession.setPrimaryKey(courseSessionId);

		courseSession.setCompanyId(CompanyThreadLocal.getCompanyId());

		return courseSession;
	}

	/**
	 * Removes the course session with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param courseSessionId the primary key of the course session
	 * @return the course session that was removed
	 * @throws NoSuchCourseSessionException if a course session with the primary key could not be found
	 */
	@Override
	public CourseSession remove(long courseSessionId)
		throws NoSuchCourseSessionException {

		return remove((Serializable)courseSessionId);
	}

	/**
	 * Removes the course session with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the course session
	 * @return the course session that was removed
	 * @throws NoSuchCourseSessionException if a course session with the primary key could not be found
	 */
	@Override
	public CourseSession remove(Serializable primaryKey)
		throws NoSuchCourseSessionException {

		Session session = null;

		try {
			session = openSession();

			CourseSession courseSession = (CourseSession)session.get(
				CourseSessionImpl.class, primaryKey);

			if (courseSession == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCourseSessionException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(courseSession);
		}
		catch (NoSuchCourseSessionException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected CourseSession removeImpl(CourseSession courseSession) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(courseSession)) {
				courseSession = (CourseSession)session.get(
					CourseSessionImpl.class, courseSession.getPrimaryKeyObj());
			}

			if (courseSession != null) {
				session.delete(courseSession);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (courseSession != null) {
			clearCache(courseSession);
		}

		return courseSession;
	}

	@Override
	public CourseSession updateImpl(CourseSession courseSession) {
		boolean isNew = courseSession.isNew();

		if (!(courseSession instanceof CourseSessionModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(courseSession.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					courseSession);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in courseSession proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom CourseSession implementation " +
					courseSession.getClass());
		}

		CourseSessionModelImpl courseSessionModelImpl =
			(CourseSessionModelImpl)courseSession;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (courseSession.getCreateDate() == null)) {
			if (serviceContext == null) {
				courseSession.setCreateDate(date);
			}
			else {
				courseSession.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!courseSessionModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				courseSession.setModifiedDate(date);
			}
			else {
				courseSession.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(courseSession);
			}
			else {
				courseSession = (CourseSession)session.merge(courseSession);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			CourseSessionImpl.class, courseSessionModelImpl, false, true);

		if (isNew) {
			courseSession.setNew(false);
		}

		courseSession.resetOriginalValues();

		return courseSession;
	}

	/**
	 * Returns the course session with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the course session
	 * @return the course session
	 * @throws NoSuchCourseSessionException if a course session with the primary key could not be found
	 */
	@Override
	public CourseSession findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCourseSessionException {

		CourseSession courseSession = fetchByPrimaryKey(primaryKey);

		if (courseSession == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCourseSessionException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return courseSession;
	}

	/**
	 * Returns the course session with the primary key or throws a <code>NoSuchCourseSessionException</code> if it could not be found.
	 *
	 * @param courseSessionId the primary key of the course session
	 * @return the course session
	 * @throws NoSuchCourseSessionException if a course session with the primary key could not be found
	 */
	@Override
	public CourseSession findByPrimaryKey(long courseSessionId)
		throws NoSuchCourseSessionException {

		return findByPrimaryKey((Serializable)courseSessionId);
	}

	/**
	 * Returns the course session with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param courseSessionId the primary key of the course session
	 * @return the course session, or <code>null</code> if a course session with the primary key could not be found
	 */
	@Override
	public CourseSession fetchByPrimaryKey(long courseSessionId) {
		return fetchByPrimaryKey((Serializable)courseSessionId);
	}

	/**
	 * Returns all the course sessions.
	 *
	 * @return the course sessions
	 */
	@Override
	public List<CourseSession> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the course sessions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CourseSessionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of course sessions
	 * @param end the upper bound of the range of course sessions (not inclusive)
	 * @return the range of course sessions
	 */
	@Override
	public List<CourseSession> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the course sessions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CourseSessionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of course sessions
	 * @param end the upper bound of the range of course sessions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of course sessions
	 */
	@Override
	public List<CourseSession> findAll(
		int start, int end,
		OrderByComparator<CourseSession> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the course sessions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CourseSessionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of course sessions
	 * @param end the upper bound of the range of course sessions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of course sessions
	 */
	@Override
	public List<CourseSession> findAll(
		int start, int end, OrderByComparator<CourseSession> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<CourseSession> list = null;

		if (useFinderCache) {
			list = (List<CourseSession>)finderCache.getResult(
				finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_COURSESESSION);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_COURSESESSION;

				sql = sql.concat(CourseSessionModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<CourseSession>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the course sessions from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (CourseSession courseSession : findAll()) {
			remove(courseSession);
		}
	}

	/**
	 * Returns the number of course sessions.
	 *
	 * @return the number of course sessions
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_COURSESESSION);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "courseSessionId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_COURSESESSION;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return CourseSessionModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the course session persistence.
	 */
	@Activate
	public void activate() {
		_valueObjectFinderCacheListThreshold = GetterUtil.getInteger(
			PropsUtil.get(PropsKeys.VALUE_OBJECT_FINDER_CACHE_LIST_THRESHOLD));

		_finderPathWithPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathWithPaginationFindByCourseId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCourseId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"courseId"}, true);

		_finderPathWithoutPaginationFindByCourseId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCourseId",
			new String[] {Long.class.getName()}, new String[] {"courseId"},
			true);

		_finderPathCountByCourseId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCourseId",
			new String[] {Long.class.getName()}, new String[] {"courseId"},
			false);

		_setCourseSessionUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setCourseSessionUtilPersistence(null);

		entityCache.removeCache(CourseSessionImpl.class.getName());
	}

	private void _setCourseSessionUtilPersistence(
		CourseSessionPersistence courseSessionPersistence) {

		try {
			Field field = CourseSessionUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, courseSessionPersistence);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Override
	@Reference(
		target = vcPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = vcPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = vcPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_COURSESESSION =
		"SELECT courseSession FROM CourseSession courseSession";

	private static final String _SQL_SELECT_COURSESESSION_WHERE =
		"SELECT courseSession FROM CourseSession courseSession WHERE ";

	private static final String _SQL_COUNT_COURSESESSION =
		"SELECT COUNT(courseSession) FROM CourseSession courseSession";

	private static final String _SQL_COUNT_COURSESESSION_WHERE =
		"SELECT COUNT(courseSession) FROM CourseSession courseSession WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "courseSession.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No CourseSession exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No CourseSession exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		CourseSessionPersistenceImpl.class);

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private CourseSessionModelArgumentsResolver
		_courseSessionModelArgumentsResolver;

}