package by.itechart.testtask.config;

/*@Configuration*/
/*@EnableWebMvc*/
public class WebConfig /*implements WebMvcConfigurer*/ {
    /*@Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.viewResolver(internalResourceViewResolver());
    }*/
    /*@Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //registry.addViewController("/login").setViewName("login");
        registry.addViewController("/").setViewName("welcome");
        registry.addViewController("/welcome").setViewName("welcome");
        //registry.addViewController("/admin/home").setViewName("adminhome");
        //registry.addViewController("/accessDenied").setViewName("403");
    }*/

    /*@Bean
    public InternalResourceViewResolver internalResourceViewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("templates/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }*/
}
