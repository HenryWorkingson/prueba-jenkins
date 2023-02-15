package com.test.portlet;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.test.constants.ConstantsCommands;
import com.test.constants.coursePortletKeys;
import com.test.model.Course;
import com.test.service.CourseService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;


//...
@Component(
        immediate = true,
        property = {
                "javax.portlet.name=" + coursePortletKeys.COURSE, //el mismo nombre del portlet
                "mvc.command.name="+ ConstantsCommands.EDIT_COURSE
        },
        service = MVCRenderCommand.class                          //servicio de tipo MVCRenderCommand
)

public class CourseEditRenderCommand implements MVCRenderCommand {

    @Reference
    private CourseService _courseService;

    public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
        long courseId = ParamUtil.getLong(renderRequest, "courseId"); //obtenemos el parámetro numérico
        if (courseId > 0) { //si se envió, debería ser mayor a 0
            Course course = _courseService.fetchCourse(courseId); //buscamos el objeto en la base de datos
            renderRequest.setAttribute("course", course); //lo guardamos en un atributo. OJO con el nombre
        }
        return "/edit.jsp"; //aquí se devuelve la página
    }
}
