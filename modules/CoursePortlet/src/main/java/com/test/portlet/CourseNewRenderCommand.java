package com.test.portlet;


import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.test.constants.ConstantsCommands;
import com.test.constants.coursePortletKeys;
import org.osgi.service.component.annotations.Component;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

@Component(
        immediate = true,
        property = {
                "javax.portlet.name=" + coursePortletKeys.COURSE, //el mismo nombre del portlet
                "mvc.command.name="+ ConstantsCommands.NEW_COURSE
        },
        service = MVCRenderCommand.class                          //servicio de tipo MVCRenderCommand
)
public class CourseNewRenderCommand implements MVCRenderCommand {

    public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
        return "/new.jsp"; //aquí se devuelve la página
    }
}
