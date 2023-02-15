package com.test.portlet;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.test.constants.ConstantsCommands;
import com.test.constants.coursePortletKeys;
import com.test.model.Course;
import com.test.service.CourseService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.*;


@Component(
        immediate = true,
        property = {
                "javax.portlet.name=" + coursePortletKeys.COURSE, //el mismo nombre del portlet
                "mvc.command.name="+ ConstantsCommands.DELETE_COURSE
        },
        service = MVCActionCommand.class                    //servicio de tipo MVCActionCommand
)
public class CourseDeleteRenderCommand implements MVCActionCommand {
    @Reference
    private CourseService _courseService;
    private static final Log _log= LogFactoryUtil.getLog(CourseUpdateMVCActionCommand.class);

    @Override
    public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException {
        long courseId = ParamUtil.getLong(actionRequest, "courseId"); //obtenemos el parámetro numérico
        try {
            Course courseDelete=_courseService.fetchCourse(courseId);
            _courseService.deleteCourse(courseDelete);
            return true;
        } catch (Exception e) {
            _log.error(e.getMessage(), e);
        }
        return false;
    }
}
