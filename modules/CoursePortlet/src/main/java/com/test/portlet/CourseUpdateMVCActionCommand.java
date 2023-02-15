package com.test.portlet;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.test.constants.coursePortletKeys;
import com.test.service.CourseService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;


@Component(
        immediate = true,
        property = {

                "javax.portlet.name=" + coursePortletKeys.COURSE,  //el portlet al que pertenece
                "mvc.command.name=/course/update" ,//el nombre de esta action
        },
        service = MVCActionCommand.class
)
public class CourseUpdateMVCActionCommand implements MVCActionCommand {
    @Reference
    private CourseService _courseService;
    @Override
    public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException {
        try {
            long courseId=ParamUtil.getLong(actionRequest, "courseId"); //obtenemos el ID del curso

            String name = ParamUtil.getString(actionRequest, "name"); //obtenemos el campo "name". Pero este es localizado, por lo que lo obtendremos así.
            String description=ParamUtil.getString(actionRequest, "description"); //El campo description, y es de manera simple texto.

            ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY); //Con este atributo podemos obtener información como el site donde se encuentra el portlet y el usuario.
            long groupId=themeDisplay.getScopeGroupId(); //el id del site para registrarlo
            ServiceContext serviceContext;
            serviceContext = ServiceContextFactory.getInstance(actionRequest); //creamos el contexto del servicio
            if (courseId==0) //si no tiene nada, entonces es NUEVO..
                _courseService.addCourse(groupId, name, description, serviceContext); //creamos el registro en la base de datos
            else //sino...
                _courseService.updateCourse(courseId, name, description, serviceContext); //... actualizamos el registro
            return true; //devuelve true porque terminó bien
        } catch (PortalException e) {
            _log.error(e);
        }
        return false; //devuelve false si termina mal
    }
    private static final Log _log= LogFactoryUtil.getLog(CourseUpdateMVCActionCommand.class);
}