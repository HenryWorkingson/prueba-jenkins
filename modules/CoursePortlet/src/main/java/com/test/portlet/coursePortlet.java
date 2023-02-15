package com.test.portlet;

import com.liferay.portal.kernel.util.PortalUtil;
import com.test.constants.coursePortletKeys;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.test.model.Course;
import com.test.service.CourseLocalServiceUtil;
import org.osgi.service.component.annotations.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author yzhu
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=course",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + coursePortletKeys.COURSE,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class coursePortlet extends MVCPortlet {



	@Override
	public void doView(RenderRequest request, RenderResponse response)
			throws IOException, PortletException {
		List<Course> misCursos =  CourseLocalServiceUtil.getCourses(0,100);
		List<Long> misCourseId = new ArrayList<>();
		for(Course c: misCursos){
			misCourseId.add(c.getCourseId());
		}
		request.setAttribute("misCourseId", misCourseId.toString());

		super.doView(request, response);
	}

	@Override
	public void doPrint(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		super.doPrint(renderRequest, renderResponse);
	}
}

