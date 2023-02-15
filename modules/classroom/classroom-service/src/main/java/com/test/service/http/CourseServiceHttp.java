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

package com.test.service.http;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.HttpPrincipal;
import com.liferay.portal.kernel.service.http.TunnelUtil;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

import com.test.service.CourseServiceUtil;

/**
 * Provides the HTTP utility for the
 * <code>CourseServiceUtil</code> service
 * utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it requires an additional
 * <code>HttpPrincipal</code> parameter.
 *
 * <p>
 * The benefits of using the HTTP utility is that it is fast and allows for
 * tunneling without the cost of serializing to text. The drawback is that it
 * only works with Java.
 * </p>
 *
 * <p>
 * Set the property <b>tunnel.servlet.hosts.allowed</b> in portal.properties to
 * configure security.
 * </p>
 *
 * <p>
 * The HTTP utility is only generated for remote services.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class CourseServiceHttp {

	public static com.test.model.Course addCourse(
			HttpPrincipal httpPrincipal, long groupId, String name,
			String description,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				CourseServiceUtil.class, "addCourse",
				_addCourseParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, groupId, name, description, serviceContext);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.test.model.Course)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.test.model.Course updateCourse(
			HttpPrincipal httpPrincipal, long courseId, String name,
			String description,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				CourseServiceUtil.class, "updateCourse",
				_updateCourseParameterTypes1);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, courseId, name, description, serviceContext);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.test.model.Course)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List<com.test.model.Course> findByGroupId(
		HttpPrincipal httpPrincipal, long groupId) {

		try {
			MethodKey methodKey = new MethodKey(
				CourseServiceUtil.class, "findByGroupId",
				_findByGroupIdParameterTypes2);

			MethodHandler methodHandler = new MethodHandler(methodKey, groupId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List<com.test.model.Course>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List<com.test.model.Course> findByUserId(
		HttpPrincipal httpPrincipal, long userId) {

		try {
			MethodKey methodKey = new MethodKey(
				CourseServiceUtil.class, "findByUserId",
				_findByUserIdParameterTypes3);

			MethodHandler methodHandler = new MethodHandler(methodKey, userId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List<com.test.model.Course>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List<com.test.model.Course> findByUserId(
		HttpPrincipal httpPrincipal, long userId, int start, int end) {

		try {
			MethodKey methodKey = new MethodKey(
				CourseServiceUtil.class, "findByUserId",
				_findByUserIdParameterTypes4);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, userId, start, end);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List<com.test.model.Course>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static int countByUserId(HttpPrincipal httpPrincipal, long userId) {
		try {
			MethodKey methodKey = new MethodKey(
				CourseServiceUtil.class, "countByUserId",
				_countByUserIdParameterTypes5);

			MethodHandler methodHandler = new MethodHandler(methodKey, userId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return ((Integer)returnObj).intValue();
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List<com.test.model.Course> findByGroupId(
		HttpPrincipal httpPrincipal, long groupId, int start, int end) {

		try {
			MethodKey methodKey = new MethodKey(
				CourseServiceUtil.class, "findByGroupId",
				_findByGroupIdParameterTypes6);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, groupId, start, end);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List<com.test.model.Course>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static int countByGroupId(
		HttpPrincipal httpPrincipal, long groupId) {

		try {
			MethodKey methodKey = new MethodKey(
				CourseServiceUtil.class, "countByGroupId",
				_countByGroupIdParameterTypes7);

			MethodHandler methodHandler = new MethodHandler(methodKey, groupId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return ((Integer)returnObj).intValue();
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List<com.test.model.Course> findByU_G(
		HttpPrincipal httpPrincipal, long userId, long groupId) {

		try {
			MethodKey methodKey = new MethodKey(
				CourseServiceUtil.class, "findByU_G",
				_findByU_GParameterTypes8);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, userId, groupId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List<com.test.model.Course>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List<com.test.model.Course> findByU_G(
		HttpPrincipal httpPrincipal, long userId, long groupId, int start,
		int end) {

		try {
			MethodKey methodKey = new MethodKey(
				CourseServiceUtil.class, "findByU_G",
				_findByU_GParameterTypes9);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, userId, groupId, start, end);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List<com.test.model.Course>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static int countByU_G(
		HttpPrincipal httpPrincipal, long userId, long groupId) {

		try {
			MethodKey methodKey = new MethodKey(
				CourseServiceUtil.class, "countByU_G",
				_countByU_GParameterTypes10);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, userId, groupId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return ((Integer)returnObj).intValue();
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List<com.test.model.Course> findByKeywords(
		HttpPrincipal httpPrincipal, long groupId, String keywords, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.test.model.Course>
			orderByComparator) {

		try {
			MethodKey methodKey = new MethodKey(
				CourseServiceUtil.class, "findByKeywords",
				_findByKeywordsParameterTypes11);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, groupId, keywords, start, end, orderByComparator);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List<com.test.model.Course>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.test.model.Course deleteCourse(
			HttpPrincipal httpPrincipal, com.test.model.Course course)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				CourseServiceUtil.class, "deleteCourse",
				_deleteCourseParameterTypes12);

			MethodHandler methodHandler = new MethodHandler(methodKey, course);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.test.model.Course)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.test.model.Course fetchCourse(
		HttpPrincipal httpPrincipal, long courseId) {

		try {
			MethodKey methodKey = new MethodKey(
				CourseServiceUtil.class, "fetchCourse",
				_fetchCourseParameterTypes13);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, courseId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.test.model.Course)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List<com.test.model.Course> getAllCourses(
		HttpPrincipal httpPrincipal) {

		try {
			MethodKey methodKey = new MethodKey(
				CourseServiceUtil.class, "getAllCourses",
				_getAllCoursesParameterTypes14);

			MethodHandler methodHandler = new MethodHandler(methodKey);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List<com.test.model.Course>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(CourseServiceHttp.class);

	private static final Class<?>[] _addCourseParameterTypes0 = new Class[] {
		long.class, String.class, String.class,
		com.liferay.portal.kernel.service.ServiceContext.class
	};
	private static final Class<?>[] _updateCourseParameterTypes1 = new Class[] {
		long.class, String.class, String.class,
		com.liferay.portal.kernel.service.ServiceContext.class
	};
	private static final Class<?>[] _findByGroupIdParameterTypes2 =
		new Class[] {long.class};
	private static final Class<?>[] _findByUserIdParameterTypes3 = new Class[] {
		long.class
	};
	private static final Class<?>[] _findByUserIdParameterTypes4 = new Class[] {
		long.class, int.class, int.class
	};
	private static final Class<?>[] _countByUserIdParameterTypes5 =
		new Class[] {long.class};
	private static final Class<?>[] _findByGroupIdParameterTypes6 =
		new Class[] {long.class, int.class, int.class};
	private static final Class<?>[] _countByGroupIdParameterTypes7 =
		new Class[] {long.class};
	private static final Class<?>[] _findByU_GParameterTypes8 = new Class[] {
		long.class, long.class
	};
	private static final Class<?>[] _findByU_GParameterTypes9 = new Class[] {
		long.class, long.class, int.class, int.class
	};
	private static final Class<?>[] _countByU_GParameterTypes10 = new Class[] {
		long.class, long.class
	};
	private static final Class<?>[] _findByKeywordsParameterTypes11 =
		new Class[] {
			long.class, String.class, int.class, int.class,
			com.liferay.portal.kernel.util.OrderByComparator.class
		};
	private static final Class<?>[] _deleteCourseParameterTypes12 =
		new Class[] {com.test.model.Course.class};
	private static final Class<?>[] _fetchCourseParameterTypes13 = new Class[] {
		long.class
	};
	private static final Class<?>[] _getAllCoursesParameterTypes14 =
		new Class[] {};

}