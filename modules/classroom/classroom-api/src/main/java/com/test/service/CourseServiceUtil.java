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

package com.test.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.test.model.Course;

import java.util.List;

/**
 * Provides the remote service utility for Course. This utility wraps
 * <code>com.test.service.impl.CourseServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see CourseService
 * @generated
 */
public class CourseServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.test.service.impl.CourseServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static Course addCourse(
			long groupId, String name, String description,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().addCourse(
			groupId, name, description, serviceContext);
	}

	public static int countByGroupId(long groupId) {
		return getService().countByGroupId(groupId);
	}

	public static int countByU_G(long userId, long groupId) {
		return getService().countByU_G(userId, groupId);
	}

	public static int countByUserId(long userId) {
		return getService().countByUserId(userId);
	}

	public static Course deleteCourse(Course course) throws PortalException {
		return getService().deleteCourse(course);
	}

	public static Course fetchCourse(long courseId) {
		return getService().fetchCourse(courseId);
	}

	public static List<Course> findByGroupId(long groupId) {
		return getService().findByGroupId(groupId);
	}

	public static List<Course> findByGroupId(long groupId, int start, int end) {
		return getService().findByGroupId(groupId, start, end);
	}

	public static List<Course> findByKeywords(
		long groupId, String keywords, int start, int end,
		OrderByComparator<Course> orderByComparator) {

		return getService().findByKeywords(
			groupId, keywords, start, end, orderByComparator);
	}

	public static List<Course> findByU_G(long userId, long groupId) {
		return getService().findByU_G(userId, groupId);
	}

	public static List<Course> findByU_G(
		long userId, long groupId, int start, int end) {

		return getService().findByU_G(userId, groupId, start, end);
	}

	public static List<Course> findByUserId(long userId) {
		return getService().findByUserId(userId);
	}

	public static List<Course> findByUserId(long userId, int start, int end) {
		return getService().findByUserId(userId, start, end);
	}

	public static List<Course> getAllCourses() {
		return getService().getAllCourses();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static Course updateCourse(
			long courseId, String name, String description,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().updateCourse(
			courseId, name, description, serviceContext);
	}

	public static CourseService getService() {
		return _service;
	}

	private static volatile CourseService _service;

}