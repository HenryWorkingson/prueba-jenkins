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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link CourseService}.
 *
 * @author Brian Wing Shun Chan
 * @see CourseService
 * @generated
 */
public class CourseServiceWrapper
	implements CourseService, ServiceWrapper<CourseService> {

	public CourseServiceWrapper() {
		this(null);
	}

	public CourseServiceWrapper(CourseService courseService) {
		_courseService = courseService;
	}

	@Override
	public com.test.model.Course addCourse(
			long groupId, String name, String description,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _courseService.addCourse(
			groupId, name, description, serviceContext);
	}

	@Override
	public int countByGroupId(long groupId) {
		return _courseService.countByGroupId(groupId);
	}

	@Override
	public int countByU_G(long userId, long groupId) {
		return _courseService.countByU_G(userId, groupId);
	}

	@Override
	public int countByUserId(long userId) {
		return _courseService.countByUserId(userId);
	}

	@Override
	public com.test.model.Course deleteCourse(com.test.model.Course course)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _courseService.deleteCourse(course);
	}

	@Override
	public com.test.model.Course fetchCourse(long courseId) {
		return _courseService.fetchCourse(courseId);
	}

	@Override
	public java.util.List<com.test.model.Course> findByGroupId(long groupId) {
		return _courseService.findByGroupId(groupId);
	}

	@Override
	public java.util.List<com.test.model.Course> findByGroupId(
		long groupId, int start, int end) {

		return _courseService.findByGroupId(groupId, start, end);
	}

	@Override
	public java.util.List<com.test.model.Course> findByKeywords(
		long groupId, String keywords, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.test.model.Course>
			orderByComparator) {

		return _courseService.findByKeywords(
			groupId, keywords, start, end, orderByComparator);
	}

	@Override
	public java.util.List<com.test.model.Course> findByU_G(
		long userId, long groupId) {

		return _courseService.findByU_G(userId, groupId);
	}

	@Override
	public java.util.List<com.test.model.Course> findByU_G(
		long userId, long groupId, int start, int end) {

		return _courseService.findByU_G(userId, groupId, start, end);
	}

	@Override
	public java.util.List<com.test.model.Course> findByUserId(long userId) {
		return _courseService.findByUserId(userId);
	}

	@Override
	public java.util.List<com.test.model.Course> findByUserId(
		long userId, int start, int end) {

		return _courseService.findByUserId(userId, start, end);
	}

	@Override
	public java.util.List<com.test.model.Course> getAllCourses() {
		return _courseService.getAllCourses();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _courseService.getOSGiServiceIdentifier();
	}

	@Override
	public com.test.model.Course updateCourse(
			long courseId, String name, String description,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _courseService.updateCourse(
			courseId, name, description, serviceContext);
	}

	@Override
	public CourseService getWrappedService() {
		return _courseService;
	}

	@Override
	public void setWrappedService(CourseService courseService) {
		_courseService = courseService;
	}

	private CourseService _courseService;

}