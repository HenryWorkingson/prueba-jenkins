package com.test.portlet;


import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;
import com.test.constants.coursePortletKeys;
import com.test.model.Course;
import com.test.service.CourseService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.util.List;

@Component(
        immediate = true,
        property = {
                "javax.portlet.name=" + coursePortletKeys.COURSE,  //pertenece al portlet
                "mvc.command.name=/" //va a ser llamado desde la raiz
        },
        service = MVCRenderCommand.class //será un Render
)
public class CourseListMVCRenderCommand implements MVCRenderCommand {
    @Reference
    private CourseService _courseService; //referencia al service layer
    @Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
        //ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY); //para conocer el id del site...
        //long groupId=themeDisplay.getScopeGroupId(); // el id del site donde se encuentra el portlet
        List<Course> courses = _courseService.getAllCourses(); //buscamos todos los registros del site
        renderRequest.setAttribute("courses", courses ); //lo guardamos en un atributo
        return null; //que continue el flujo normal.
    }
    private static final Log _log= LogFactoryUtil.getLog(CourseListMVCRenderCommand.class);


}
