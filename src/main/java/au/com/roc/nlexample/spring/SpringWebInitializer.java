package au.com.roc.nlexample.spring;

import javax.servlet.Filter;

import org.springframework.web.filter.HttpPutFormContentFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Configure the dispatcher servlet
 * 
 * @author Roc 29/04/2016
 */
public class SpringWebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer
{
    @Override
    protected Class<?>[] getRootConfigClasses()
    {
        return new Class[] {  };
    }

    @Override
    protected Class<?>[] getServletConfigClasses()
    {
        return new Class<?>[] { SpringMVCConfig.class, SpringJPAConfig.class };
    }

    @Override
    protected Filter[] getServletFilters()
    {
        return new Filter[] { new HttpPutFormContentFilter() };
    }

    @Override
    protected String[] getServletMappings()
    {
        return new String[] { "/" };
    }
}
