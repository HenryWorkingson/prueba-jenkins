package com.test.portlet;

import com.google.gson.Gson;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.test.constants.coursePortletKeys;
import com.test.model.Course;
import com.test.service.CourseService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import java.io.IOException;
import java.io.PrintWriter;


@Component(
        immediate = true,
        property = {
                "javax.portlet.name=" + coursePortletKeys.COURSE,
                "mvc.command.name=cambiarCurso"
        },
        service = MVCResourceCommand.class)
public class ResultCommad implements MVCResourceCommand {

    private static final Log _log= LogFactoryUtil.getLog(CourseUpdateMVCActionCommand.class);
    @Reference
    private CourseService _courseService;
    @Override
    public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws PortletException {
        Course course=_courseService.fetchCourse(2);
        Boolean cierto=false;
        PrintWriter out = null;
        try {
            out = resourceResponse.getWriter();
            out.write(new Gson().toJson(course));
            //out.write(new Gson().toJson(cierto));
            out.flush();
        } catch (IOException e) {
            _log.error("Error al escribir el listado de productos, ", e);
        }
        _log.debug("Fin Ajax Prueba");
        return false;
    }
}
