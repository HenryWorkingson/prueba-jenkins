package com.cofares.test.portlet;

import com.cofares.test.constants.BookPortletKeys;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import java.io.IOException;

/**
 * @author yzhu
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=Book",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + BookPortletKeys.BOOK,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class BookPortlet extends MVCPortlet {
	private static final Log LOG= LogFactoryUtil.getLog(BookPortlet.class);

	@Override
	public void destroy() {
		super.destroy();
		LOG.debug("debug()");
	}

	@Override
	public void init() throws PortletException {
		super.init();
		LOG.debug("init()");
	}

	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		LOG.debug("init()");
		renderRequest.setAttribute("message","Hola a todos");
		super.render(renderRequest, renderResponse);

	}
}